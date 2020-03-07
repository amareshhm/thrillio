package com.thrillio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.thrillio.entities.Book;
import com.thrillio.entities.Bookmark;
import com.thrillio.entities.Movie;
import com.thrillio.entities.UserBookmark;
import com.thrillio.entities.WebLink;
import com.thrillio.store.DataStore;

public class BookmarkDao {

	public List<List<Bookmark>> getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {

		// DataStore.add(userBookmark);
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jid_thrillio?useSSL=false",
				"root", "test@123"); Statement stmt = conn.createStatement();) {
			if(userBookmark.getBookmark() instanceof Book)
			{
				saveUserBook(userBookmark,stmt);
			}
			else if(userBookmark.getBookmark() instanceof Movie)
			{
				saveUserMovie(userBookmark,stmt);
			}
			else
			{
				saveUserWebLink(userBookmark,stmt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void saveUserWebLink(UserBookmark userBookmark, Statement stmt) throws SQLException {
		String query = "insert into User_WebLink(user_id,weblink_id) values(" +userBookmark.getUser().getId()+ "," +userBookmark.getBookmark().getId() + ")";
		stmt.executeUpdate(query);
		
	}

	private void saveUserMovie(UserBookmark userBookmark, Statement stmt) throws SQLException {
		String query = "insert into User_Movie(user_id,movie_id) values(" +userBookmark.getUser().getId()+ "," +userBookmark.getBookmark().getId() + ")";
		stmt.executeUpdate(query);		
	}

	private void saveUserBook(UserBookmark userBookmark, Statement stmt) throws SQLException {
		
		String query = "insert into User_Book(user_id,book_id) values(" +userBookmark.getUser().getId()+ "," +userBookmark.getBookmark().getId() + ")";
		stmt.executeUpdate(query);
		
	}

	public void updateKidFriendlyStatus(Bookmark bookmark) {
		int kidFriendlyStatus = bookmark.getKidFriendlyStatus().ordinal();
		long userId = bookmark.getKidFriendlyMarkedBy().getId();
		
		String tableToUpdate = "Book";
		if(bookmark instanceof Movie) {
			tableToUpdate = "Movie";
		} else if(bookmark instanceof WebLink) {
			tableToUpdate = "WebLink";
		}
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jid_thrillio?useSSL=false","root","test@123");
				Statement stmt = conn.createStatement()){
				String query = "update "+ tableToUpdate + " set kid_friendly_status = "+ kidFriendlyStatus + ", kid_friendly_marked_by = "+ userId +" where id = "+ bookmark.getId();
				System.out.println("query (updateKidFriendlyStatus): "+ query);
				stmt.executeUpdate(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}
}
