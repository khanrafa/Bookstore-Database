package ca.sheridancollege.khanrafa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;



import ca.sheridancollege.khanrafa.bean.Book;

@Repository
public class BookDatabaseAccess {
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	public long addBook(Book book) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String insert="INSERT INTO book (title, author, status) " 	
					+ "VALUES  (:title, :author,  :status);";
		namedParameters.addValue("title", book.getTitle());
		namedParameters.addValue("author", book.getAuthor());
		namedParameters.addValue("status", book.getStatus());
		int rowsAffected = jdbc.update(insert, namedParameters);
		return rowsAffected;
		}
	public List<Book>  selectBooks() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM book";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Book>(Book.class));
	}
}
