package kr.or.connect.todo.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;

@WebServlet("/update")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoTypeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		
		TodoDao dao = new TodoDao();
		
        int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type"); 
	    
	    if(type.equals("TODO")) {
	    	type = "DOING";
	        int updateCount=  dao.updateTodo(type,id);
	    }else if(type.equals("DOING")) {
	    	type = "DONE";
	        int updateCount=  dao.updateTodo(type,id);
	    }
	}
}
