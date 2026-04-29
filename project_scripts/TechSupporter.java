package oop_project;

import java.util.ArrayList;
import java.util.List;



public class TechSupporter extends User {
    
	private static final long serialVersionUID = 1L;
	private List<Order> orders = new ArrayList<>();

    public TechSupporter(String id, String name, String email, String password) {
        super(id, name, email, password);
        
    }
  
    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("Added order: " + order.getDescription());
    }

    public void resolveOrder(Order order) {
        if (orders.contains(order)) {
            order.setStatus(OrderStatus.RESOLVED);
            System.out.println("Order resolved: " + order.getDescription());
        } else {
            System.out.println("Order not found.");
        }
    }
    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public void displayRole() {
        System.out.println("Role: Tech Supporter");
    }
    public void performDuties() {
        System.out.println("Resolving technical issues");
    }
    

    
}
