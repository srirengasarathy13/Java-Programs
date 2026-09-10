
package Evaluation.ProductionOrderProcessingSystem;
import java.io.*;
import java.net.*;
import java.util.HashMap; 
import java.util.concurrent.*;
import java.lang.reflect.Method;

class Order implements Serializable{
    int id;
    String item;
    int qty;
    double price;

    Order(int id,String item,int qty,double price){
        this.id=id;
        this.item=item;
        this.qty=qty;
        this.price=price;
    }
}

class Result implements Serializable{
    int id;
    boolean success;
    double total;
    String message;

    Result(int id,boolean success,double total,String message){
        this.id=id;
        this.success=success;
        this.total=total;
        this.message=message;
    }
}

public class ProductionOrderProcessingSystem{
    static HashMap<String,Integer> stock=new HashMap<>();

    public static void main(String[] args){
        stock.put("TV",5);
        stock.put("Fridge",10);
        stock.put("Fan",15);

        Thread server=new Thread(new Server());
        server.start();

        try{
            Thread.sleep(1000);
        }catch(Exception e){}

        Order ord1=new Order(1,"TV",2,20000);
        Order ord2=new Order(2,"Fridge",1,9000);
        Order ord3=new Order(3,"Fan",20,1500);

        new Thread(new Client(ord1)).start();
        new Thread(new Client(ord2)).start();
        new Thread(new Client(ord3)).start();
    }

    static class Server implements Runnable{
        public void run(){
            try{
                ServerSocket ss=new ServerSocket(5000);
                ExecutorService executor=Executors.newFixedThreadPool(3);

                System.out.println("Server started");

                while(true){
                    Socket socket=ss.accept();
                    executor.execute(new ClientHandler(socket));
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    static class ClientHandler implements Runnable{
        Socket socket;

        ClientHandler(Socket socket){
            this.socket=socket;
        }

        public void run(){
            try{
                ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());

                Order order=(Order)in.readObject();

                Callable<Result> task=new Callable<Result>(){
                    public Result call(){
                        try{
                            Method method=ProductionOrderProcessingSystem.class
                                    .getDeclaredMethod("processOrder",Order.class);
                            return (Result)method.invoke(null,order);
                        }catch(Exception e){
                            return new Result(order.id,false,0,"Error");
                        }
                    }
                };

                Future<Result> future=Executors.newSingleThreadExecutor().submit(task);
                Result result=future.get();

                out.writeObject(result);
                out.flush();

                socket.close();
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    static Result processOrder(Order order){
        if(!stock.containsKey(order.item)){
            return new Result(order.id,false,0,"Item not found");
        }

        if(stock.get(order.item)<order.qty){
            return new Result(order.id,false,0,"Out of stock");
        }

        stock.put(order.item,stock.get(order.item)-order.qty);

        double total=order.qty*order.price;

        return new Result(order.id,true,total,"Order processed");
    }

    static class Client implements Runnable{
        Order order;

        Client(Order order){
            this.order=order;
        }

        public void run(){
            try{
                Socket socket=new Socket("localhost",5000);

                ObjectOutputStream out=
                    new ObjectOutputStream(socket.getOutputStream());

                ObjectInputStream in=
                    new ObjectInputStream(socket.getInputStream());

                out.writeObject(order);
                out.flush();

                Result result=(Result)in.readObject();

                System.out.println("Order "+result.id+ " : "+result.message+" | Total = Rs."+result.total);

                socket.close();
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}