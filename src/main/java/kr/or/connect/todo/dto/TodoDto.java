package kr.or.connect.todo.dto;

public class TodoDto {
	private Long id;
	private String name;
	private String regdate;
	private int sequence;
	private String title;
	private String type;
	
	public TodoDto() {}
	
	public TodoDto(Long id, String title, String name, int sequence, String type, String regdate) {
		super();
		
		this.id=id;
		this.name = name;
		this.regdate = regdate;
		this.sequence = sequence; 
		this.title = title; 
		this.type = type;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + " , title =" + title + ", name = " + name + 
				", sequence =" + sequence + " , type = "+ type + ", regdate =" + regdate;
	}
}
