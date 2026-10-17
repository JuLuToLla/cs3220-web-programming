import java.io.*;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {

    private List<User> users;

    @Override
    public void init() {
        users = new ArrayList<>();
        users.add(new User("John Doe", "jdoe", "abcd"));
        users.add(new User("Jane Doe", "janedoe", "1234"));
        users.add(new User("Bob Smith", "bsmith", "password"));
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        // html writer
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // retrieve error if user was not found
        String error = (String) request.getAttribute("error");
        if (error != null) {
            out.println(error);
        }
        // html
        out.println("<form method=\"POST\" action=\"Login\">");
        out.println("Username: <input type=\"text\" name=\"username\">");
        out.println("Password: <input type=\"password\" name=\"password\">");
        out.println("<input type=\"submit\" value=\"Login\">");
        out.println("</form>");
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        // get the username and password inputted
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // if user is not found
        boolean userFound = false;
        // enhanced for loop to search for user
        for(User user: users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                // if user matches user found
                userFound = true;
                // send info to session
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("Members");
                break;
            }
        }
        if(!userFound) {
            request.setAttribute("error", "Invalid username or password");
            doGet(request, response);
        }
    }

}