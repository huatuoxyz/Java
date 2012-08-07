package book.bean;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.sql.*;
import javax.naming.*;

public final class BookInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String isbn;
	private String title;
	private String author;
	private Integer price;
	private String publish;
	private Date published;
	
	public BookInfo() {
		isbn = null;
		title = null;
		author = null;
		price = null;
		publish = null;
		published = null;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Integer getPrice() {
		return price;
	}

	public String getPublish() {
		return publish;
	}

	public Date getPublished() {
		return published;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	public static ArrayList<BookInfo> getBookInfos() {
		ArrayList<BookInfo> objAry = new ArrayList<BookInfo>();
		Connection db = null;
		PreparedStatement objPs = null;
		ResultSet rs = null;
		try {
			DataSource ds = new BookInfo().getDataSource();
			db = ds.getConnection();
			objPs = db
					.prepareStatement("SELECT * FROM book_info ORDER BY published DESC");
			rs = objPs.executeQuery();
			while (rs.next()) {
				BookInfo objBok = new BookInfo();
				objBok.setIsbn(rs.getString("isbn"));
				objBok.setTitle(rs.getString("title"));
				objBok.setAuthor(rs.getString("author"));
				objBok.setPrice(rs.getInt("price"));
				objBok.setPublish(rs.getString("publish"));
				objBok.setPublished(rs.getDate("published"));
				objAry.add(objBok);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (objPs != null) {
					objPs.close();
				}
				if (db != null) {
					db.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return objAry;
	}

	public static BookInfo getBookInfo(String id) {
		Connection db = null;
		PreparedStatement objPs = null;
		ResultSet rs = null;
		BookInfo objBok = new BookInfo();
		try {
			DataSource ds = new BookInfo().getDataSource();
			db = ds.getConnection();
			objPs = db
					.prepareStatement("SELECT * FROM book_info WHERE isbn=?");
			objPs.setString(1, id);
			rs = objPs.executeQuery();
			if (rs.next()) {
				objBok.setIsbn(rs.getString("isbn"));
				objBok.setTitle(rs.getString("title"));
				objBok.setAuthor(rs.getString("author"));
				objBok.setPrice(rs.getInt("price"));
				objBok.setPublish(rs.getString("publish"));
				objBok.setPublished(rs.getDate("published"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (objPs != null) {
					objPs.close();
				}
				if (db != null) {
					db.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return objBok;
	}

	public void updateBookInfo() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.published);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		java.sql.Date d2 = new java.sql.Date(cal.getTimeInMillis());
		
		Connection db = null;
		PreparedStatement objPs1 = null;
		PreparedStatement objPs2 = null;
		try {
			DataSource ds = this.getDataSource();
			db = ds.getConnection();
			db.setAutoCommit(false);
			objPs1 = db
					.prepareStatement("SELECT * FROM book_info WHERE isbn=?");
			objPs1.setString(1, this.isbn);
			ResultSet rs = objPs1.executeQuery();
			if (rs.next()) {
				objPs2 = db
						.prepareStatement("UPDATE book_info SET title=?, author=?,price=?,publish=?,published=? WHERE isbn=?");
			} else {
				objPs2 = db
						.prepareStatement("INSERT INTO book_info(title, author,price,publish,published,isbn) VALUES(?,?,?,?,?,?)");
			}
			objPs2.setString(1, this.title);
			objPs2.setString(2, this.author);
			objPs2.setInt   (3, this.price);
			objPs2.setString(4, this.publish);
			objPs2.setDate  (5, d2);
			objPs2.setString(6, this.isbn);
			objPs2.executeUpdate();
			db.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				db.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (objPs1 != null) {
					objPs1.close();
				}
				if (objPs2 != null) {
					objPs2.close();
				}
				if (db != null) {
					db.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteBookInfo() {
		Connection db = null;
		PreparedStatement objPs1 = null;
		try {
			DataSource ds = this.getDataSource();
			db = ds.getConnection();
			db.setAutoCommit(false);
			objPs1 = db.prepareStatement("DELETE FROM book_info WHERE isbn=?");
			objPs1.setString(1, this.isbn);
			objPs1.execute();
			db.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				db.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (objPs1 != null) {
					objPs1.close();
				}
				if (db != null) {
					db.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private DataSource getDataSource(){
		DataSource ds=null;
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Struts");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return ds;
	}

}