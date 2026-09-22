package Tests.Week2;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
class Order{
    int orderId;
    String customerName;
    String foodItem;
    int quantity;
    double orderAmount;
    
    public Order(int orderId, String customerName, String foodItem, int quantity, double orderAmount){
        this.orderId = orderId;
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.orderAmount = orderAmount;
    }
}

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Food Item: ");
        String foodItem = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Order Amount: ");
        double orderAmount = scanner.nextDouble();
        Order order1 = new Order(orderId, customerName, foodItem, quantity, orderAmount);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Callable<String> orderValidityCallable = () ->{
            if(order1.quantity>0 && order1.orderAmount>0){
                 return "Valid Order!";
            }else{
                return "Invalid Order!";
            }
        };

        Callable<String> billCallable = () ->{
            double totalBill = order1.quantity*order1.orderAmount;
            return "Total Bill Amount : Rs."+totalBill;
        };

        Callable<String> deliveryCallable = () ->{
            double deliveryAmount;
            if(order1.orderAmount*order1.quantity>=500){
                deliveryAmount = 0;
            }else{
                deliveryAmount = 50;
            }
            return "Delivery Charge : Rs."+deliveryAmount;
        };

        Callable<String> orderStatusCallable = () ->{
            return "Order is getting ready !";
        };
    Future<String> orderValidity = executorService.submit(orderValidityCallable);
    Future<String> billAmount = executorService.submit(billCallable);
    Future<String> deliveryAmount = executorService.submit(deliveryCallable);
    Future<String> orderStatus = executorService.submit(orderStatusCallable);

    try{
        System.out.println();
        System.out.println("----Food Ordering System----");
        System.out.println();
        System.out.println("Order Id : "+order1.orderId);
        System.out.println("Task Name : Order Validation");
        System.out.println("Thread Name : "+Thread.currentThread().getName());
        System.out.println("Processing Result : "+orderValidity.get());
        System.out.println();
        System.out.println("Order Id : "+order1.orderId);
        System.out.println("Task Name : Bill Calculation");
        System.out.println("Thread Name : "+Thread.currentThread().getName());
        System.out.println("Processing Result : "+billAmount.get());
        System.out.println();
        System.out.println("Order Id : "+order1.orderId);
        System.out.println("Task Name : Delivery Charge Calculation");
        System.out.println("Thread Name : "+Thread.currentThread().getName());
        System.out.println("Processing Result : "+deliveryAmount.get());
        System.out.println();
        System.out.println("Order Id : "+order1.orderId);
        System.out.println("Task Name : Order Status");
        System.out.println("Thread Name : "+Thread.currentThread().getName());
        System.out.println("Processing Result : "+orderStatus.get());
        System.out.println();

    }catch(InterruptedException e){
        System.out.println("Task was interrupted !");
    }catch(ExecutionException e){
        System.out.println("Error while processing...");
    }finally{
        executorService.shutdown();
        System.out.println("Executor Service has been Shut down!");
    }

    }
}
