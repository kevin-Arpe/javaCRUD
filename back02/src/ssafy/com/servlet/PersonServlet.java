package ssafy.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ssafy.com.person.dto.Person;
import ssafy.com.person.manager.PersonManager;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonManager personManager = PersonManager.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
			case "main":
				doMain(request, response);
				break;
			case "login":
				login(request, response);
				break;
			case "logout":
				logout(request, response);
				break;
			case "registForm":
				registForm(request, response);
				break;
			case "regist":
				regist(request, response);
				break;
			case "info":
				info(request, response);
				break;
			case "list":
				list(request, response);
				break;
			case "update":
				update(request, response);
				break;
			case "updateForm":
				updateForm(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
			default:
		}
	}
	
	protected void doMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("id");
		String userpw = request.getParameter("password");
		
		HttpSession session = request.getSession();
		session.setAttribute("username", userid);
		response.sendRedirect("main.jsp");
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		response.sendRedirect("main.jsp");
	}
	
	protected void registForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("type", "regist");
		request.getRequestDispatcher("regist.jsp").forward(request, response);
	}
	
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String msg = request.getParameter("msg");
		Person p = new Person(no, name, age, msg);
		personManager.add(p);
		response.sendRedirect("person?action=info&no="+no);
	}
	
	protected void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person p = personManager.getPerson(Integer.parseInt(request.getParameter("no")));
		request.setAttribute("person", p);
		request.getRequestDispatcher("info.jsp").forward(request, response);
	}
	
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person[] pList = personManager.getPersonList();
		request.setAttribute("pList", pList);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
	protected void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		Person p = personManager.getPerson(no);
		request.setAttribute("person", p);
		request.setAttribute("type", "update");
		request.getRequestDispatcher("regist.jsp").forward(request, response);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String msg = request.getParameter("msg");
		Person p = new Person(no, name, age, msg);
		
		personManager.add(p);
		response.sendRedirect("person?action=info&no="+no);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		personManager.delete(no);
		response.sendRedirect("person?action=list");
	}
}
