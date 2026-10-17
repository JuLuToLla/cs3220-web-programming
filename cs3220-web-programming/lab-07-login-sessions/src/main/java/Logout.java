import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Logout", value = "/Logout")
public class Logout extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        // dont create sessions but find an existing one
        HttpSession session = request.getSession(false);
        // if session found destroy it
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("Login");
    }
}