package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.database.SenseAnnotationDatabase;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;


@WebServlet(name = "TaskSenseAnnotationServlet", urlPatterns = "/senseAnnotation.jsp")
public class TaskSenseAnnotationServlet extends BaseServlet 
{
	private static final long serialVersionUID = 1L;
	/**
	 * Servlet address to invoke next.
	 */
	private static final String NEXT_SERVLET = "nextTask.jsp";
	/**
	 * Name given to the HTMLInputElement radio.
	 */
	private static final String RADIO_NAME = "sensesRadio";
	
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Estrae i dati
		String synsetID = request.getParameter("synsetID");
		String word = request.getParameter("word");
		String sentence = request.getParameter("sentence");
		String sense = request.getParameter(RADIO_NAME);
		
		// scrive su database
		if (sense != null)
		{
			SenseAnnotationDatabase database = SenseAnnotationDatabase.getDatabase();
			database.add(synsetID, word, sentence, sense);
			database.close();
		}
		
		// reinderizza a un task a caso.
		response.sendRedirect(NEXT_SERVLET);
	}

}
