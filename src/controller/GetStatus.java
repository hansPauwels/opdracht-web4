package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GetStatus extends ASyncHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if(session != null) {
            Person p = (Person) session.getAttribute("user");
            String status = super.toJSON(p.getCustomStatus());
            //response.setContentType("text/json");
            response.setContentType("text/json");
            response.getWriter().write(status);

       }
    }



}
