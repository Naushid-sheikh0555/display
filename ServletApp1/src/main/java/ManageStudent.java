import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManageStudent extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            res.setContentType("text/html");
            PrintWriter out = res.getWriter();

            String sql = "SELECT * FROM student";
            Connection connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            out.println("<table border='1'>");
            out.println("    <tr>");
            out.println("        <th>ID</th>");
            out.println("        <th>Name</th>");
            out.println("        <th>Course</th>");
            out.println("        <th>Semester</th>");
            out.println("        <th>Division</th>");
            out.println("        <th colspan='2'>Action</th>");
            out.println("    </tr>");

            while (rs.next()) {
                out.println("    <tr>");
                out.println("        <td>" + rs.getInt(1) + "</td>");
                out.println("        <td>" + rs.getString("name") + "</td>");
                out.println("        <td>" + rs.getString(3) + "</td>");
                out.println("        <td>" + rs.getInt(4) + "</td>");
                out.println("        <td>" + rs.getString(5) + "</td>");
                out.println("        <td><a href='#'>Edit</a></td>");
                out.println("        <td><a href='#'>Delete</a></td>");
                out.println("    </tr>");
            }
            out.println("</table>");

        } catch (Exception e) {

        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            String name = req.getParameter("name");
            String course = req.getParameter("course");
            int semester = Integer.parseInt(req.getParameter("semester"));
            String division = req.getParameter("division");

            Connection connection = DbConnection.getConnection();
            String sql = "INSERT into student (name, course, semester, division) VALUES(?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, course);
            ps.setInt(3, semester);
            ps.setString(4, division);

            ps.executeUpdate();

            res.sendRedirect("/ServletApp1/index.jsp");

        } catch (Exception e) {

        }
    }
}
