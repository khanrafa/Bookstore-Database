package ca.sheridancollege.khanrafa.bean;

public class Book {
	
	private String title;
	private String author;
	private String status;
	
	public Book (){ }
	
	public void setTitle(String title) {this.title = title;}
	
	public void setAuthor(String author) {this.author = author;}
	
	public void setStatus(String status) {this.status = status; }
	
	public String getTitle() {return this.title;}	
	
	public String getAuthor() {return this.author;}
	
	public String getStatus() {return this.status;}

}
