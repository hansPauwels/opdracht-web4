package controller;

import domain.PersonService;

public class ASyncFactory {
    public ASyncHandler getController(String key, PersonService model) {
        return createHandler(key, model);
    }

    private ASyncHandler createHandler(String handlerName, PersonService model) {
        ASyncHandler handler = null;
        try {
            Class<?> handlerClass = Class.forName("controller."+ handlerName);
            Object handlerObject = handlerClass.newInstance();
            handler = (ASyncHandler) handlerObject;
            //handler.setModel(model);
        } catch (Exception e) {
            throw new RuntimeException("Deze pagina bestaat niet!!!!");
        }
        return handler;
    }
}
