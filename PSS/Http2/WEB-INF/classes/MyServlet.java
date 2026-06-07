import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyServlet extends HttpServlet {

    // GET Method
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>GET Method Executed</h2>");
        out.println("<p>Retrieving Data from Server</p>");
    }

    // POST Method
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        out.println("<h2>POST Method Executed</h2>");
        out.println("<p>Data Received: " + name + "</p>");
    }

    // PUT Method
    protected void doPut(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>PUT Method Executed</h2>");
        out.println("<p>Data Updated Successfully</p>");
    }

    // DELETE Method
    protected void doDelete(HttpServletRequest request,
                            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>DELETE Method Executed</h2>");
        out.println("<p>Data Deleted Successfully</p>");
    }
}