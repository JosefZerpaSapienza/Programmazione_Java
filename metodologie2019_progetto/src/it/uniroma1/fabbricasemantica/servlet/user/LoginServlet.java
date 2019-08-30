package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.database.UserDatabase;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

@WebServlet(name="LoginServlet", urlPatterns="/login.jsp")
public class LoginServlet extends BaseServlet 
{
	private static final long serialVersionUID = 8484501789787L;
	/**
	 * URL to the login page.
	 */
	private static final String LOGIN_URL = "login.html";

	@Override
	/**
	 * Log the user in.
	 */
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String errorMessage = "";
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// check empty fields.
		System.out.println(email == null);
		System.out.println(password == null);
		if (email.equals("") || password.equals("")) 
			errorMessage = "Please, fill every field.";
		
		else
			try (UserDatabase users = UserDatabase.getDatabase())
			{
				// check credentials.
				if (!users.checkCredentials(email, password))
					errorMessage = "Wrong credentials. Check them or sign-up.";
			}
		
		// login failed.
		// TODO: alert user of error
//		response.getWriter().write(errorMessage); 
		if (errorMessage.equals(""))
			// login succesful.
			login(request, response, email);
		else
			response.sendRedirect(LOGIN_URL);
	}
	
	static void login(HttpServletRequest request, HttpServletResponse response, String username) throws ServletException, IOException 
	{
		// imposta lo username nella sessione corrente.
		request.getSession().setAttribute("username", username);
		response.sendRedirect("home.html");
	}

}
