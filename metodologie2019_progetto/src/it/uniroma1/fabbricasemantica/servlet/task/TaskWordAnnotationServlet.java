package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.database.WordAnnotationDatabase;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

@WebServlet(name = "TaskWordAnnotationServlet", urlPatterns = "/wordAnnotation.jsp")
public class TaskWordAnnotationServlet extends BaseServlet 
{
	private static final long serialVersionUID = 1L;
	/**
	 * Servlet address to invoke next.
	 */
	private static final String NEXT_SERVLET = "nextTask.jsp";
	
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Estrae i dati
		String synsetID = request.getParameter("synsetID");
		String description = request.getParameter("description");
		String word = request.getParameter("wordArea");
		
		// scrive su database
		WordAnnotationDatabase database = WordAnnotationDatabase.getDatabase();
		database.add(synsetID, description, word);
		database.close();
		
		//TODO reinderizzare a un task a caso.
		response.sendRedirect(NEXT_SERVLET);
	}

}
