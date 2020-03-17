package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GetStatus extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if(session != null) {
            Person p = (Person) session.getAttribute("user");
            String status = p.getCustomStatus();
            //response.setContentType("text/json");
            response.setContentType("text/plain");
            response.getWriter().write(status);

       }
        return "Controller?action=ChatPage";
    }
}
