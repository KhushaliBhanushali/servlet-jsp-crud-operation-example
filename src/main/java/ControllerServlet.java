
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmployeeDaoImpl;
import model.Employee;

@WebServlet("/")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDaoImpl dao;

	@Override
	public void init() throws ServletException {
		String jdbcURL = "jdbc:mysql://localhost:3306/employee_db";
		String jdbcUsername = "root";
		String jdbcPassword = "";

		dao = new EmployeeDaoImpl(jdbcURL, jdbcUsername, jdbcPassword);
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertEmployee(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateEmployee(request, response);
				break;
			case "/delete":
				deleteEmployee(request, response);
				break;
			default:
				ListEmployees(request, response);
				break;
			}

		} catch (SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void ListEmployees(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<Employee> list = dao.ListAllEmployee();
		request.setAttribute("listEmployee", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee_list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Employee_entry.jsp");
		dispatcher.forward(request, response);
	}

	private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		Float salary = Float.parseFloat(request.getParameter("salary"));

		Employee newemployee = new Employee(name, department, email, city, salary);
		dao.insertEmployee(newemployee);
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee existingEmployee = dao.getEmployeeById(id);

		RequestDispatcher dispatcher = request.getRequestDispatcher("employee_edit.jsp");
		request.setAttribute("employee", existingEmployee);
		dispatcher.forward(request, response);
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		Float salary = Float.parseFloat(request.getParameter("salary"));

		Employee employee = new Employee(id, name, department, email, city, salary);
		dao.updateEmployee(employee);
		response.sendRedirect("list");
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		dao.deleteEmployee(id);
		response.sendRedirect("list");

	}
}
