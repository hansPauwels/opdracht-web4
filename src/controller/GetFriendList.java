package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class GetFriendList extends ASyncHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        if(session != null) {
            Person p = (Person) session.getAttribute("user");
            if (p != null) {
                ArrayList<Person> friends = p.getFriends();
                boolean first = true;
                StringBuilder json = new StringBuilder();
                json.append("[");
                for (Person pe : friends) {
                    if (first) {
                        first = false;
                    } else {
                        json.append(",\n\n");
                    }

                        json.append("{ \"name\" : \"");
                        json.append(pe.getFirstName());
                        json.append("\",\n \"status\" : \"");
                        json.append(pe.getCustomStatus());
                        json.append("\"\n}");
                    }
                json.append("]");
                response.setContentType("text/json");
                response.getWriter().write(json.toString());
            }
        }
    }
}
