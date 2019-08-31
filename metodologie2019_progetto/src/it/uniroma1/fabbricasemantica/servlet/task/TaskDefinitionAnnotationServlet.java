package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.database.DefinitionAnnotationDatabase;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

@WebServlet(name = "TaskDefinitionAnnotationServlet", urlPatterns = "/definitionAnnotation.jsp")
public class TaskDefinitionAnnotationServlet extends BaseServlet 
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
		String word = request.getParameter("word");
		String definition = request.getParameter("definitionArea");
		
		// scrive su database
		if (!definition.equals(""))
		{
			DefinitionAnnotationDatabase database = DefinitionAnnotationDatabase.getDatabase();
			database.add(synsetID, word, definition);
			database.close();
		}
		
		// reinderizza a un task a caso.
		response.sendRedirect(NEXT_SERVLET);
	}

}
