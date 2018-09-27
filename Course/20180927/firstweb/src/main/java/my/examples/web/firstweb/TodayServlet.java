package my.examples.web.firstweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/today")
public class TodayServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        // 어느 브라우저에 응답할지는 WAS만 알고 있으므로, WAS가 가지고 있는 instances를 이용해야 함.
        PrintWriter out = response.getWriter();

        LocalDateTime today = LocalDateTime.now();
        out.println("today : " + today.toString());
        out.close();
    }
}
