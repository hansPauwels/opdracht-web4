package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddFriend extends ASyncHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String friendName = request.getParameter("fName");
        HttpSession session = request.getSession();

        if(session != null) {
            Person p = (Person) session.getAttribute("user");
            if(getPersonService().getPersonByName(friendName) != null) {
                p.addFriend(getPersonService().getPersonByName(friendName));
            }
        }
    }
}
