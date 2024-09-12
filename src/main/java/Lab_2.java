import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Lab_2")
public class Lab_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Lab_2() {
		super();
	}

	// Handles HTTP GET request (displays the form)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("index.html");
	}

	// Handles HTTP POST request (processes form submission)
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve form data
		String socketType = request.getParameter("socketType");
		String quantityStr = request.getParameter("quantity");
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		// Set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Validate quantity
		int quantity = 0;
		try {
			quantity = Integer.parseInt(quantityStr);
			if (quantity < 1) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			out.println("<html>");
			out.println("<head><title>Error</title></head>");
			out.println("<body>");
			out.println("<h2 style='color: red;'>Invalid quantity. Please enter a valid number greater than 0.</h2>");
			out.println("</body>");
			out.println("</html>");
			return;
		}

		// Output the confirmation response
		out.println("<html>");
		out.println("<head><title>Quote Request Submitted</title></head>");
		out.println("<body style='font-family: Arial, sans-serif;'>");
		out.println("<h2 style='color: orange;'>Quote Request Submitted</h2>");
		out.println("<p>Thank you <br><br> <strong> Name = " + name + "</strong><br><br> Email =  <a href='mailto:"
				+ email + "'>" + email + "</a></p>");
		out.println("<p>Quantity = <strong>" + quantity + "</strong><br><br> Type =  <strong>" + socketType
				+ "</strong> sockets.</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
