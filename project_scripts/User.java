package oop_project;

import java.io.Serializable;
import java.util.Objects;


	public abstract class User implements Serializable {
	    
		private static final long serialVersionUID = 1L;
		private String id;
	    private String name;
	    private String email;
	    private String password;

	    public User(String id, String name, String email, String password) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.password = password;
	    }

	    public String getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getEmail() {
	        return email;
	    }
	    
	    public boolean checkPassword(String password) {
	        return this.password.equals(password);
	    }
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        User user = (User) o;
	        return id.equals(user.id);
	    }
	    public int hashCode() {
	        return Objects.hash(id);
	    }
	    public String toString() {
	        return "User{id='" + id + "', name='" + name + "', email='" + email + "'}";
	    }
	    protected Object clone() throws CloneNotSupportedException {
	        return super.clone();
	    }
	    
	    public abstract void displayRole();
	}

