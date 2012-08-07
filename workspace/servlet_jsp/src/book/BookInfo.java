package book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookInfo {
	DataSource ds;
	private String isbn;
	private String title;
	private String author;
	private int price;
	private String publish;
	private Date published;
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public Date getPublished() {
		return published;
	}
	public void setPublished(Date published) {
		this.published = published;
	}
	
	public ArrayList<BookInfo> getBookInfos() {
		ArrayList<BookInfo> objAry = new ArrayList<BookInfo>();

		Connection db = null;
		PreparedStatement objPs = null;
		ResultSet rs = null;
		
		try {
			DataSource ds = this.getDataSource();
			db = ds.getConnection();
			objPs = db.prepareStatement("SELECT * FROM book_info ORDER BY published DESC");
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
	
	public void createBookInfo() {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.published);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		java.sql.Date d2 = new java.sql.Date(cal.getTimeInMillis());

		
		Connection db = null;
		PreparedStatement objPs = null;
		
		try {
			DataSource ds = this.getDataSource();
			db = ds.getConnection();
			db.setAutoCommit(false);
			objPs = db.prepareStatement("insert into book_info values(?,?,?,?,?,?)");
			objPs.setString(1, this.isbn);
			objPs.setString(2, this.title);
			objPs.setString(3, this.author);
			objPs.setInt   (4, this.price);
			objPs.setString(5, this.publish);
			objPs.setDate  (6, d2);
			
			objPs.execute();
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
	}
	
	public void destroyBookInfo() {
		Connection db = null;
		PreparedStatement objPs = null;
		
		try {
			DataSource ds = this.getDataSource();
			db = ds.getConnection();
			db.setAutoCommit(false);
			objPs = db.prepareStatement("delete from book_info where isbn=?");
			objPs.setString(1, this.isbn);
			
			objPs.execute();
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
	}
	
	
	public BookInfo viewBookInfo() {
		
		Connection db = null;
		PreparedStatement objPs = null;
		ResultSet rs = null;
		
		BookInfo objBok = new BookInfo();
		try {
			DataSource ds = this.getDataSource();
			db = ds.getConnection();
			objPs = db.prepareStatement("SELECT * FROM book_info where isbn=?");
			objPs.setString(1, this.isbn);
			
			rs = objPs.executeQuery();
			rs.next();
			
			objBok.setIsbn(rs.getString("isbn"));
			objBok.setTitle(rs.getString("title"));
			objBok.setAuthor(rs.getString("author"));
			objBok.setPrice(rs.getInt("price"));
			objBok.setPublish(rs.getString("publish"));
			objBok.setPublished(rs.getDate("published"));
			
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
		
		//java.util.Date d = new java.util.Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.published);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		java.sql.Date d2 = new java.sql.Date(cal.getTimeInMillis());

		
		Connection db = null;
		PreparedStatement objPs = null;
		
		try {
			DataSource ds = this.getDataSource();
			db = ds.getConnection();
			db.setAutoCommit(false);
			objPs = db.prepareStatement("update book_info set title=?, author=?, price=?, publish=?, published=? where isbn=?");
			objPs.setString(1, this.title);
			objPs.setString(2, this.author);
			objPs.setInt   (3, this.price);
			objPs.setString(4, this.publish);
			objPs.setDate  (5, d2);
			objPs.setString(6, this.isbn);
			
			objPs.execute();
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
	}

	private DataSource getDataSource(){
		
		DataSource ds=null;
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/servlet");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return ds;
	}
}
