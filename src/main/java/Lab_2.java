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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.html");
    }

    // Handles HTTP POST request (processes form submission)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String socketType = request.getParameter("socketType");
        String quantity = request.getParameter("quantity");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Set response content type
        response.setContentType("index.html");
        PrintWriter out = response.getWriter();
        
        // Output the confirmation response
        out.println("<html><body>");
        out.println("<h2>Quote Request Submitted</h2>");
        out.println("<p>Thank you, " + name + " (" + email + "), for your request.</p>");
        out.println("<p>You have requested " + quantity + " units of " + socketType + " sockets.</p>");
        out.println("<p>We will contact you shortly with a quote.</p>");
        out.println("</body></html>");
    }
}
