package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.database.MyAnnotationDatabase;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

@WebServlet(name = "TaskMyAnnotationServlet", urlPatterns = "/myAnnotation.jsp")
public class TaskMyAnnotationServlet extends BaseServlet {
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
		String word = request.getParameter("wordArea");
		String example = request.getParameter("exampleArea");
		
		// scrive su database
		if (!example.equals(""))
		{
			MyAnnotationDatabase database = MyAnnotationDatabase.getDatabase();
			database.add(synsetID, word, example);
			database.close();
		}
		
		//TODO reinderizzare a un task a caso.
		response.sendRedirect(NEXT_SERVLET);
	}

}
