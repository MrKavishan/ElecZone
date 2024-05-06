package mypackages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = (String) request.getSession().getAttribute("email");
        if(email == null) {
            response.sendRedirect("signin.jsp");
            return;
        }

        String jdbcUrl = "jdbc:mysql://localhost:3306/eleczonedb?useSSL=false";
        String dbUsername = "root";
        String dbPassword = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
                String sql = "SELECT * FROM customers WHERE email=?";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    statement.setString(1, email);
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            String username = resultSet.getString("username");
                            String mobile = resultSet.getString("mobile");
                            request.setAttribute("username", username);
                            request.setAttribute("mobile", mobile);
                            RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
                            dispatcher.forward(request, response);
                        } else {
                            response.getWriter().println("<h1>No profile found</h1>");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h1>Error occurred</h1>");
        }
    }
}
