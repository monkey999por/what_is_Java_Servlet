package setvlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.values.ChatValues;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String user_name, message;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		user_name = request.getParameter("user_name");
		message = request.getParameter("message");
		user_name = (user_name == null)  ? "unknown" : user_name;
		message = (message == null)  ? "" : message;
		
		ChatValues chatValues = new ChatValues(user_name, message);
		
		HttpSession mySession = request.getSession();
		mySession.setAttribute("chatValues", chatValues);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("respons.jsp");
		dispatcher.forward(request, response);
	}
}