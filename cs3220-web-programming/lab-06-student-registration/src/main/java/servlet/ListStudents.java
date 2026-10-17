package servlet;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Student;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/ListStudents", loadOnStartup = 1)
public class ListStudents extends HttpServlet {

    // Create the entries for the table
    public void init() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Josh", 1, "2019", "Minnows", "10am", "9am"));
        students.add(new Student("Eva", 1, "2018", "Minnows", "10am", "1pm"));
        students.add(new Student("Lucy", 1, "2022", "Starfish", "1pm", "2pm"));
        students.add(new Student("Matt", 2, "2018", "Dolphins", "9am", "2pm"));
        getServletContext().setAttribute("students",students);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        // get the students from the init
        List<Student> students = (List<Student>) getServletContext().getAttribute("students");

        // html
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>" +
                    "<body>");
        out.println("<h1>Students | <a href=Register>Register</a></h1>");
        out.println("<table border='1'>");
        out.println("<tr>" +
                "<th>Name</th>" +
                "<th>Session</th>" +
                "<th>Age</th>" +
                "<th>Level</th>" +
                "<th>Time (1st Choice)</th>" +
                "<th>Time (2nd Choice)</th>" +
                "</tr>");
        for(Student student : students) {
            out.println("<tr><td>" + student.getName() + "</td>" +
                    "<td>" + student.getSession() + "</td>" +
                    "<td>" + student.getAge() + "</td>" +
                    "<td>" + student.getLevel() + "</td>" +
                    "<td>" + student.getTimeOne() + "</td>" +
                    "<td>" + student.getTimeTwo() + "</td></tr>");
        }
        out.println("</table>");
        out.println("</body>" +
                    "</html>");
    }
}