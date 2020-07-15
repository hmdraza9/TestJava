package javaConcepts;

import java.util.ArrayList;
import java.util.List;

class Product {
    private int id;
    private String name;
    private String description;

    public Product(int id, String name, String description) {
         super();
         this.id = id;
         this.name = name;
         this.description = description;
    }
    public int getId() {
         return id;
    }
    public void setId(int id) {
         this.id = id;
    }
    public String getName() {
         return name;
    }
    public void setName(String name) {
         this.name = name;
    }
    public String getDescription() {
         return description;
    }
    public void setDescription(String description) {
         this.description = description;
    }
    @Override
    public String toString() {
         return "Product [id=" + id + ", name=" + name + ", description=" + description + "]";
    }
}

class LineItem {
    private int id;
    private int quantity;
    private Product p;

    public LineItem(int id, int quantity, Product p) {
         super();
         this.id = id;
         this.quantity = quantity;
         this.p = p;
    }
    public int getId() {
         return id;
    }
    public void setId(int id) {
         this.id = id;
    }
    public int getQuantity() {
         return quantity;
    }
    public void setQuantity(int quantity) {
         this.quantity = quantity;
    }
    public Product getP() {
         return p;
    }
    public void setP(Product p) {
         this.p = p;
    }
    @Override
    public String toString() {
         return "LineItem [id=" + id + ", quantity=" + quantity + ", p=" + p + "]";
    }
}


class Order {
    private int id;
    private String name;
    private List<LineItem> lineItems;

    public Order(int id, String name) {
         super();
         this.id = id;
         this.name = name;
         this.lineItems = new ArrayList<LineItem>();
    }
    public int getId() {
         return id;
    }
    public void setId(int id) {
         this.id = id;
    }
    public String getName() {
         return name;
    }
    public void setName(String name) {
         this.name = name;
    }
 
    @Override
    public String toString() {
         return "Order [id=" + id + ", name=" + name + ", lineItems=" + lineItems + "]";
    }
 
    // Add line item to order
    public void addItem(int id, int quantity, Product p) {
         this.lineItems.add(new LineItem(id, quantity, p));
    }
 
    // Remove line item from order for given item id
    public void removeItemById(int itemId) {
         // TODO - Not implemented yet
    }
}

public class CompositionDemo {
    public static void main(String[] args) {
         // Create Products
         Product p1 = new Product(1, "Pen", "This is red pen");
         Product p2 = new Product(2, "Pencil", "This is pencil");
         Product p3 = new Product(3, "ColorBox", "This is color box");
        
         // Create Order and Add Line Items
         Order o = new Order(1, "ORD#1");
         o.addItem(1, 2, p1); // Ordered of 2 quantity for p1 product
         o.addItem(2, 1, p2); // Ordered of 1 quantity for p2 product
         o.addItem(3, 5, p3); // Ordered of 5 quantity for p3 product  
         // Print Order detail before deleting 
         System.out.println("Order ---");
         System.out.println(o);
         // Deleting order would also delete associated LineItems   
         o = null;  
    }
}