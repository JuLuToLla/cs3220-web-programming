import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Members", value = "/Members")
public class Members extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        // we open a sessions only if there is one
        HttpSession session = request.getSession(false);
        // check for an existing session if none redirect to login
        if (session == null) {
            response.sendRedirect("Login");
            return;
        }
        // we search for user if its not null
        User user = (User) session.getAttribute("user");
        // if null redirect to login
        if (user == null) {
            response.sendRedirect("Login");
            return;
        }
        // start adter all the filters
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Welcome, " + user.getName() + "!</h1>");
        out.println("<a href=\"Logout\">Logout</a>");
    }

}