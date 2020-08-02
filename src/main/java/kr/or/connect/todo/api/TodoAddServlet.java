package kr.or.connect.todo.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.TodoDto;

@WebServlet("/TodoAdd")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoAddServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	
		TodoDto todo = new TodoDto();
		todo.setName(request.getParameter("name"));
		todo.setSequence(Integer.parseInt(request.getParameter("sequence")));
		todo.setTitle(request.getParameter("title"));
		
		TodoDao dao = new TodoDao();
	    dao.addTodo(todo);
	    
		response.sendRedirect("./main");
	}
}
