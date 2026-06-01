package com.student.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/register")
public class StudentServlet extends HttpServlet {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/studentdb";

    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            Class.forName("org.postgresql.Driver");

            Connection con =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD
                    );

            String sql =
                    "INSERT INTO students(name,email,course) VALUES(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                out.println("<h2>Student Registered Successfully!</h2>");

            } else {

                out.println("<h2>Registration Failed!</h2>");
            }

            ps.close();
            con.close();

        } catch (Exception e) {

            out.println("<h2>Error : "
                    + e.getMessage()
                    + "</h2>");
        }
    }
}