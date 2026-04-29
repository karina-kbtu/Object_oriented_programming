package oop_project;



public abstract class Employee extends User {
    
	private static final long serialVersionUID = 1L;
	public Employee(String id, String name, String email,String password) {
        super(id, name, email,password);
    }
    public abstract void performDuties();
}
