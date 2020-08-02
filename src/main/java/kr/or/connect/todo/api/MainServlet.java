package kr.or.connect.todo.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.TodoDto;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
    	response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		TodoDao dao = new TodoDao();
		
		List<TodoDto>list = dao.getTodos();
		request.setAttribute("list",list);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/main.jsp");
	    requestDispatcher.forward(request, response);
	}
}
