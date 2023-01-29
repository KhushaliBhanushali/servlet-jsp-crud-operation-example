package DAO;

import java.sql.SQLException;
import java.util.List;

import model.Employee;

public interface EmployeeDAO {

	public void connect() throws SQLException;
	public void disconnect() throws SQLException;
	
	public List<Employee> ListAllEmployee() throws SQLException;
	public Employee getEmployeeById(int id) throws SQLException;

	public boolean insertEmployee(Employee E1) throws SQLException;
	public boolean updateEmployee(Employee E1) throws SQLException;
	public boolean deleteEmployee(int id) throws SQLException;
}
