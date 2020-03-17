package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class ASyncHandler {
    public abstract void handleRequest (HttpServletRequest request, HttpServletResponse response) throws IOException;
}
