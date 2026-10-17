package cs3220.servlet;

import cs3220.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/ListStudents", loadOnStartup = 1)
public class ListStudents extends HttpServlet
{
    @Override
    public void init() throws ServletException
    {
        List<Student> students = new ArrayList<>();

        int currentYear = Year.now().getValue();

        students.add(new Student(
                "Josh", 1, currentYear - 7,
                "Minnows", "10am", "9am"));

        students.add(new Student(
                "Eva", 1, currentYear - 6,
                "Minnows", "10am", "1pm"));

        students.add(new Student(
                "Lucy", 1, currentYear - 4,
                "Starfish", "1pm", "2pm"));

        students.add(new Student(
                "Matt", 2, currentYear - 8,
                "Dolphins", "9am", "2pm"));

        getServletContext().setAttribute("students", students);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");

        List<Student> students =
                (List<Student>) getServletContext().getAttribute("students");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Students</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 40px; }");
        out.println("table { border-collapse: collapse; }");
        out.println("th, td { border: 1px solid black; padding: 8px 14px; }");
        out.println("th { background-color: #eeeeee; }");
        out.println("</style>");
        out.println("</head>");

        out.println("<body>");
        out.println("<h1>Students</h1>");
        out.println("<table>");

        out.println("<tr>");
        out.println("<th>Name</th>");
        out.println("<th>Session</th>");
        out.println("<th>Age</th>");
        out.println("<th>Level</th>");
        out.println("<th>Time (1st Choice)</th>");
        out.println("<th>Time (2nd Choice)</th>");
        out.println("</tr>");

        for (Student student : students)
        {
            out.println("<tr>");
            out.println("<td>" + student.getName() + "</td>");
            out.println("<td>" + student.getSession() + "</td>");
            out.println("<td>" + student.getAge() + "</td>");
            out.println("<td>" + student.getLevel() + "</td>");
            out.println("<td>" + student.getFirstChoice() + "</td>");
            out.println("<td>" + student.getSecondChoice() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}