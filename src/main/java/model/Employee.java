package model;

public class Employee{
	protected int id;
	protected String name;
	protected String department;
	protected String email;
	protected String city;
	protected float salary;
	
	public Employee() {
		super();
	}

	public Employee(int id) {
		super();
		this.id = id;
	}

	public Employee(int id, String name, String department, String email, String city, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.email = email;
		this.city = city;
		this.salary = salary;
	}

	public Employee(String name, String department, String email, String city, float salary) {
		super();
		this.name = name;
		this.department = department;
		this.email = email;
		this.city = city;
		this.salary = salary;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
}