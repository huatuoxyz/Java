package book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookViewServlet extends HttpServlet{
	
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
		("/jsp/book/view.jsp").forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
