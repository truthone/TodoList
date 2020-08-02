package kr.or.connect.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.todo.dto.TodoDto;

public class TodoDao {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/connectdb?useUnicode=true&characterEncoding=utf8";
	private static final String DB_USER = "connectuser";
	private static final String DB_PASSWORD = "connect123!@#";

	public List<TodoDto> getTodos() {
		List<TodoDto> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT id, title, name, sequence, type, regdate FROM todo ORDER BY regdate ";
		
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					Long id = rs.getLong(1);
					String title = rs.getString("title");
					String name = rs.getString("name");
					int sequence = rs.getInt("sequence");
					String type = rs.getString("type");
					String str = rs.getString("regdate");
					String year = str.substring(0, 4);
					String month  = str.substring(5,7);
					String day = str.substring(8,10);
					String regdate = year + "." + month + "." + day;
					
					TodoDto todo = new TodoDto(id,title,name,sequence,type,regdate);
					list.add(todo); 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}	
	
	public int addTodo(TodoDto todo) {
		int insertCount = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "INSERT INTO todo(title, name, sequence) values(?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());

			insertCount = ps.executeUpdate();

		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return insertCount;
	}

	public int updateTodo(String type, int id) {
		int updateCount = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			
			conn = DriverManager.getConnection ( DB_URL, DB_USER, DB_PASSWORD );
			String sql = "update todo set type = ? where id = ?;";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			ps.setLong(2,  id);
			
			updateCount = ps.executeUpdate();

		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {}
			}
		}
		return updateCount;
	}
}
