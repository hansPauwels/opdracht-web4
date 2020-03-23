package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PersonService;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonService model = new PersonService();
	private ControllerFactory controllerFactory = new ControllerFactory();
	private ASyncFactory aSyncFactory = new ASyncFactory();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);

	}

	/*private void processAsyncReq(HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		if(action != null) {
			ASyncHandler handler;
			try {
				handler = aSyncFactory.getController(action, model);
				handler.handleRequest(request, response);
			} catch (IOException e) {
				//TODO change this
				System.out.println(e.getMessage());
			}
		}
	}*/

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String destination = "index.jsp";
        if (action != null) {
        	RequestHandler handler;
        	ASyncHandler aHandler;
        	try {
        		handler = controllerFactory.getController(action, model);
        		if(handler != null) {
					destination = handler.handleRequest(request, response);
				} else if (handler == null) {
        			aHandler = aSyncFactory.getController(action, model);
        			aHandler.handleRequest(request, response);
        			destination = null;
				}

        	} 
        	catch (NotAuthorizedException exc) {
        		List<String> errors = new ArrayList<String>();
        		errors.add(exc.getMessage());
        		request.setAttribute("errors", errors);
        		//destination="index.jsp";
        	}
        }
        if(destination != null) {
			RequestDispatcher view = request.getRequestDispatcher(destination);
			view.forward(request, response);
		}

	}



}
