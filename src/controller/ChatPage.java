package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChatPage extends SyncHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return "chat.jsp";
    }
}
