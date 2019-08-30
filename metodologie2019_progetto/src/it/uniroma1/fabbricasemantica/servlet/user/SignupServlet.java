package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;
import it.uniroma1.fabbricasemantica.database.UserDatabase;
import it.uniroma1.fabbricasemantica.languages.AdditionalLanguage;
import it.uniroma1.fabbricasemantica.languages.MotherTongue;;

@WebServlet(name="SignupServlet", urlPatterns="/signup.jsp")
public class SignupServlet extends BaseServlet 
{
	private static final long serialVersionUID = 8484501789787L;
	/**
	 * URL to the signup page.
	 */
	private static final String SIGNUP_URL = "signup.html";

	@Override
	/** 
	 * Sign the user in and store the data.
	 */
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String errorMessage = "";
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		
		List<String> mother = new LinkedList<>();
		for (MotherTongue language : MotherTongue.values())
		{
			String value = request.getParameter(language.getName());
			if (value != null)
				mother.add(value);
		}
		
		List<String> additional = new LinkedList<>();
		for (AdditionalLanguage language : AdditionalLanguage.values())
		{
			String value = request.getParameter(language.getName());
			if (!value.equals(""))
				additional.add(language.toString() + " " + value);
		}
		
		UserDatabase users = UserDatabase.getDatabase();
		
		// empty fields.
		if (email.equals("") || password.equals(""))
		{
			errorMessage = "Please, fill every field.";
		}
		// password and confirm don't match.
		else if (!password.equals(confirmPassword))
		{
			errorMessage = "The entered password and the confirmation don't match. "
					+ "Please, check and try again.";
		}	
		// email already registered.
		else if (users.isPresent(email))
		{
			errorMessage = "The entered email has already been used. "
					+ "Please, log-in or use another email.";
		}
		// at least one mother tongue hasn't been selected.
		else if (mother.size() < 1)
		{
			errorMessage = "Please, select at least one mother tongue.";
		}
		// no errors
		else
		{
			// sign-up successful.
			users.add(email, password, mother, additional);
			users.close();
		}
		
		// any error: sign-up failed. Redirect user to sign-up page.
		//TODO: alert user with errorMessage
//		response.getWriter().write(errorMessage);
		if (errorMessage.equals(""))
			LoginServlet.login(request, response, email);
		else
			response.sendRedirect(SIGNUP_URL);
	}
}
