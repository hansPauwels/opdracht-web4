package controller;

import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class ASyncHandler {
    private PersonService personService;


    public void setModel (PersonService personService) {
        this.personService = personService;
    }

    public PersonService getPersonService() {
        return personService;
    }
    public abstract void handleRequest (HttpServletRequest request, HttpServletResponse response) throws IOException;
}
