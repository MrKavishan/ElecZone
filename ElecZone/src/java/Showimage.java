import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Showimage")
public class Showimage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String url = "jdbc:mysql://localhost:3306/eleczone";
    private static final String username = "root";
    private static final String password = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");

        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT image FROM products WHERE id=?";
            st = connection.prepareStatement(sql);
            st.setString(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                Blob blob = rs.getBlob("image");
                byte[] imageBytes = blob.getBytes(1, (int) blob.length());

                response.setContentType("image/jpeg");

                OutputStream os = response.getOutputStream();
                os.write(imageBytes);
                os.flush();
                os.close();
            } else {
                response.setContentType("text/plain");
                response.getWriter().println("Image not found for product ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/plain");
            response.getWriter().println("Error retrieving image: " + e.getMessage());
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (st != null)
                    st.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
