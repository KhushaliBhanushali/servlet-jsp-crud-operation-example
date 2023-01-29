package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.JdbcConnection;

import model.Employee;

public class EmployeeDaoImpl implements EmployeeDAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public EmployeeDaoImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		super();
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	@Override
	public void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}

	@Override
	public void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	@Override
	public List<Employee> ListAllEmployee() throws SQLException {
		List<Employee> listEmployee = new ArrayList<>();
		String sql = "Select * from employees";
		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String department = resultSet.getString("department");
			String email = resultSet.getString("email");
			String city = resultSet.getString("city");
			Float salary = resultSet.getFloat("salary");

			Employee employee = new Employee(id, name, department, email, city, salary);
			listEmployee.add(employee);
		}
		resultSet.close();
		statement.close();
		disconnect();
		return listEmployee;
	}

	@Override
	public Employee getEmployeeById(int id) throws SQLException {
		Employee employee = new Employee();
		String sql = "Select * from employees where id=?";
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			String name = resultSet.getString("name");
			String department = resultSet.getString("department");
			String email = resultSet.getString("email");
			String city = resultSet.getString("city");
			Float salary = resultSet.getFloat("salary");

			employee = new Employee(id, name, department, email, city, salary);
		}
		resultSet.close();
		statement.close();
		disconnect();
		return employee;
	}

	@Override
	public boolean insertEmployee(Employee E1) throws SQLException {
		String sql = "Insert into employees (name,department,email,city,salary) values (?,?,?,?,?)";
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, E1.getName());
		statement.setString(2, E1.getDepartment());
		statement.setString(3, E1.getEmail());
		statement.setString(4, E1.getCity());
		statement.setFloat(5, E1.getSalary());

		boolean b = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return b;
	}

	@Override
	public boolean updateEmployee(Employee E1) throws SQLException {
		String sql = "Update Employees set name=?,department=?,email=?,city=?,salary=? where id=?";
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, E1.getName());
		statement.setString(2, E1.getDepartment());
		statement.setString(3, E1.getEmail());
		statement.setString(4, E1.getCity());
		statement.setFloat(5, E1.getSalary());
		statement.setInt(6, E1.getId());

		boolean b = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return b;
	}

	@Override
	public boolean deleteEmployee(int id) throws SQLException {
		String sql = "Delete from employees where id=?";
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);

		boolean b = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return b;
	}
}
