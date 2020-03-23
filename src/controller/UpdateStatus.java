package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateStatus extends ASyncHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String newStatus = (String) request.getParameter("status");
        //System.out.println(newStatus);
        HttpSession session = request.getSession();
        if(session != null) {
            Person p = (Person) session.getAttribute("user");
            p.setCustomStatus(newStatus);
            /*String status = this.toJSON(p.getCustomStatus());
            //response.setContentType("text/json");
            response.setContentType("text/json");
            response.getWriter().write(status);*/
        }
    }

    private String toJSON (String status) {
        StringBuffer json = new StringBuffer();

        json.append("{ \"status\" : \"");
        json.append(status);
        json.append("\"}");

        return json.toString();
    }
}
