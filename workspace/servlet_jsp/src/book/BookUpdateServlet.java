package book;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BookUpdateServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request = BookUtil.setBundles(request);
		
		String isbn = request.getParameter("isbn");
		BookInfo bookinfo = new BookInfo();
		bookinfo.setIsbn(isbn);
		
		bookinfo = bookinfo.viewBookInfo();
		
		request.setAttribute("bookinfo", bookinfo);
		
	    getServletConfig().getServletContext().getRequestDispatcher
	    		("/jsp/book/update.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request = BookUtil.setBundles(request);
		
		String isbn      = request.getParameter("isbn");
		String title     = request.getParameter("title");
		String author    = request.getParameter("author");
		String price     = request.getParameter("price");
		String publish   = request.getParameter("publish");
		String published = request.getParameter("published");
		
		
		BookInfo bookinfo = new BookInfo();
		bookinfo.setIsbn(isbn);
		bookinfo.setTitle(title);
		bookinfo.setAuthor(author);
		bookinfo.setPrice(Integer.parseInt(price));
		bookinfo.setPublish(publish);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			bookinfo.setPublished(sdf.parse(published));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bookinfo.updateBookInfo();
		
		response.sendRedirect("BookList");
		
	}
}
