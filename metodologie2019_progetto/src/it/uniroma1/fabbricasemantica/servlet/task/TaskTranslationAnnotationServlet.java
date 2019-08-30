package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.database.TranslationAnnotationDatabase;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

@WebServlet(name = "TaskTranslationAnnotationServlet", urlPatterns = "/translationAnnotation.jsp")
public class TaskTranslationAnnotationServlet extends BaseServlet 
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
		String translation = request.getParameter("translationArea");
		
		// scrive su database
		TranslationAnnotationDatabase database = TranslationAnnotationDatabase.getDatabase();
		database.add(synsetID, word, translation);
		database.close();
		
		//TODO reinderizzare a un task a caso.
		response.sendRedirect(NEXT_SERVLET);
	}
}
