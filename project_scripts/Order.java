package oop_project;

public class Order {

	    private String description;
	    private OrderStatus status;

	    public Order(String description) {
	        this.description = description;
	        this.status = OrderStatus.NEW;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setStatus(OrderStatus status) {
	        this.status = status;
	    }
	    public OrderStatus getStatus() {
	        return status;
	    }
	    public String toString() {
	        return "Order{" +
	                "description='" + description + '\'' +
	                ", status=" + status +
	                '}';
	    }
	

}
