package controller;

import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class SyncHandler extends RequestHandler{
    private PersonService personService;

    public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response) throws IOException;

    public PersonService getPersonService() {
        return personService;
    }

    public void setModel (PersonService personService) {
        this.personService = personService;
    }
}
