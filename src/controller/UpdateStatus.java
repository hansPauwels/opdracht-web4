package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateStatus extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String newStatus = (String) request.getParameter("status");
        System.out.println(newStatus);
        HttpSession session = request.getSession();
        if(session != null) {
            Person p = (Person) session.getAttribute("user");
            p.setCustomStatus(newStatus);
        }
        return "Controller?action=ChatPage";
    }
}
