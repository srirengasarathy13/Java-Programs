package Tests.Week1;

import Tests.Week1.Product.ReserveProduct;

class Product{
    private int productId;
    private String productName;
    private int availableStock;
    public Product(int productId, String productName, int availableStock){
        this.productId = productId;
        this.productName = productName;
        this.availableStock = availableStock;
}
public int getProductId(){
    return productId;
}
public String getProductName(){
    return productName;
}
public int getAvailableStock(){
    return availableStock;
}

public synchronized void reserve(int quantity, String customerId){
    String threadname = Thread.currentThread().getName();
    System.out.println("Thread name : "+threadname);
    System.out.println("CustomerId : "+customerId+"\nProduct : "+productName+"\nQuantity : "+quantity);
    try{
        Thread.sleep(300);
    }catch(Exception e){
        Thread.currentThread().interrupt();
    }
    if(availableStock >= quantity){
        availableStock  =availableStock - quantity;
        System.out.println("Product Reservation Success!"+"\nCustomer : "+customerId+"\nQuantity Reserved : "+quantity+"\nRemaining : "+availableStock);
    }else{
        System.out.println("Product Reservation Failed!"+"\nCustomer : "+customerId+"\nRequested Quantity : "+quantity+"\nAvailable Stock : "+availableStock);
    }
}
static class ReserveProduct implements Runnable{
    private String customerId;
    private Product product;
    private int quantity;

    public ReserveProduct(String customerId, Product product, int quantity){
        this.customerId = customerId;
        this.product = product;
        this.quantity = quantity;
    }
    @Override 
    public void run(){
        product.reserve(quantity, customerId);
    }

}
}
public class InventoryManagement {
    public static void main(String[] args) {
        Product product1 = new Product(1,"TV", 10);
        Product product2 = new Product(2, "Mobile phones", 25);
        System.out.println("----Inventory System----");
        System.out.println();
        System.out.println("Product Id : "+product1.getProductId());
        System.out.println("Product Name :"+product1.getProductName());
        System.out.println("Available Stock : "+product1.getAvailableStock());
        System.out.println();
        System.out.println("Product Id : "+product2.getProductId());
        System.out.println("Product Name :"+product2.getProductName());
        System.out.println("Available Stock : "+product2.getAvailableStock());
        System.out.println();
        System.out.println("Product Reservation started...");
        System.out.println();
        ReserveProduct rp1 = new ReserveProduct("101", product1,6);
        ReserveProduct rp2 = new ReserveProduct("102", product2, 11);
        ReserveProduct rp3 = new ReserveProduct("103", product1, 5);
        ReserveProduct rp4 = new ReserveProduct("104", product2, 10);
        Thread th1 = new Thread(rp1,"Reserve Thread 1");
        Thread th2 = new Thread(rp2,"Reserve Thread 2");
        Thread th3 = new Thread(rp3,"Reserve Thread 3");
        Thread th4 = new Thread(rp4,"Reserve Thread 4");
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        try{ 
            th1.join();
            th2.join();
            th3.join();
            th4.join();
        }catch(Exception e){
            Thread.currentThread().interrupt();
        }
        System.out.println();
        System.out.println("---Final Stock Status----");
        System.out.println();
        System.out.println("Product Id : "+product1.getProductId());
        System.out.println("Product Name :"+product1.getProductName());
        System.out.println("Available Stock : "+product1.getAvailableStock());
        System.out.println();
        System.out.println("Product Id : "+product2.getProductId());
        System.out.println("Product Name :"+product2.getProductName());
        System.out.println("Available Stock : "+product2.getAvailableStock());



        

    }
}
