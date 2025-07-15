import jakarta.servlet.http.*;
import java.io.*;

public class Servlet1 extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
           PrintWriter out = res.getWriter();
           res.setContentType("text/html");
           out.println("<h1>Hello World</h1>");
           out.println("<h1>Hello World</h1>");
           out.println("<h1>Hello World</h1>");
           out.println("<h1>Hello World</h1>");
           out.println("<h1>Hello World</h1>");
           out.println("<h1>Hello World</h1>");
           out.println("<h1>Hello World</h1>");
           out.println("<h1>Hello World</h1>");
           out.println("<h1>Hello World</h1>");
        } catch (Exception e) {

        }
    }
}
