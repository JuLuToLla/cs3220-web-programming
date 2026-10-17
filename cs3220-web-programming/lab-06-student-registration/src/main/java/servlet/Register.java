package servlet;

import java.io.*;
import java.util.List;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Student;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>" +
                    "<body>");
        out.println("<h1>Register</h1>");
        // open form
        out.println("<form method='post'>");
        // sessions dropdown
        out.println("<label for='sessions'>Session:</label>");
        out.println("<select name='sessions' id='sessions'>");
        out.println("<option value='1'>Session 1</option>");
        out.println("<option value='2'>Session 2</option>");
        out.println("</select><br>");
        // name and birthyear section
        out.println("<label for='name'>Name:</label>");
        out.println("<input type='text' id='name' name='name'><br>");
        out.println("<label for='bYear'>Birth Year:</label>");
        out.println("<input type='text' id='bYear' name='bYear'><br>");
        // levels dropdown
        out.println("<label for='levels'>Level:</label>");
        out.println("<select name='levels' id='levels'>");
        out.println("<option value='Starfish'>Starfish</option>");
        out.println("<option value='Minnows'>Minnows</option>");
        out.println("<option value='Guppies'>Guppies</option>");
        out.println("<option value='Dolphins'>Dolphins</option>");
        out.println("</select>");
        // radio button for time 1
        out.println("<br>");
        out.println("Time (1st Choice):");
        out.println("<input type='radio' id='9am' name='pref_time1' value='9am'>");
        out.println("<label for='9am'>9am</label>");
        out.println("<input type='radio' id='10am' name='pref_time1' value='10am'>");
        out.println("<label for='10am'>10am</label>");
        out.println("<input type='radio' id='1pm' name='pref_time1' value='1pm'>");
        out.println("<label for='1pm'>1pm</label>");
        out.println("<input type='radio' id='2pm' name='pref_time1' value='2pm'>");
        out.println("<label for='2pm'>2pm</label>");
        // radio button for time 2
        out.println("<br>");
        out.println("Time (2nd Choice):");
        out.println("<input type='radio' id='9am2' name='pref_time2' value='9am'>");
        out.println("<label for='9am'>9am</label>");
        out.println("<input type='radio' id='10am2' name='pref_time2' value='10am'>");
        out.println("<label for='10am'>10am</label>");
        out.println("<input type='radio' id='1pm2' name='pref_time2' value='1pm'>");
        out.println("<label for='1pm'>1pm</label>");
        out.println("<input type='radio' id='2pm2' name='pref_time2' value='2pm'>");
        out.println("<label for='2pm'>2pm</label>");
        out.println("<br>");
        // register / submit button
        out.println("<button type='submit'>Register</button>");
        out.println("</form>");
        out.println("</body>" +
                    "</html>");
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        // variables to create a new student
        // you need name, session, birthyear, level, time1 and time2
        int session = Integer.parseInt(request.getParameter("sessions"));
        String name = request.getParameter("name");
        String birthYear = request.getParameter("bYear");
        String level = request.getParameter("levels");
        String timeOne = request.getParameter("pref_time1");
        String timeTwo = request.getParameter("pref_time2");

        // bring the list of students
        List<Student> students = (List<Student>) getServletContext().getAttribute("students");

        // add the new entry
        students.add(new Student(name, session, birthYear, level, timeOne, timeTwo));

        response.sendRedirect("ListStudents");
    }
}