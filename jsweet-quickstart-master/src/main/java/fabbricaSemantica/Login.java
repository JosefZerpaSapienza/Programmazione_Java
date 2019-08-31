package fabbricaSemantica;

import java.util.LinkedList;
import java.util.List;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import jsweet.util.StringTypes;
import static def.dom.Globals.window;

import static fabbricaSemantica.Constants.LOGIN_SERVLET;
import static fabbricaSemantica.Constants.SIGNUP_URL;
import static fabbricaSemantica.Constants.HOMEPAGE_URL;

public class Login 
{	
	public static void main(String[] args) 
	{
		// Get standard elements
		HTMLFormElement form = Pages.getForm();
		HTMLInputElement homeButton = Pages.getHomeButton();
		HTMLLabelElement titleLabel = Pages.getLabel("Login");
		HTMLLabelElement descriptionLabel = Pages.getLabel("Log in with your credentials.");
		HTMLLabelElement usernameLabel = Pages.getLabel("Username:");
		HTMLInputElement usernameBox = Pages.getTextBox("email", "Enter your username...");
		HTMLLabelElement passwordLabel = Pages.getLabel("Password:");
		HTMLInputElement passwordBox = Pages.getTextBox("password", "Enter your password...");
		HTMLInputElement loginButton = Pages.getButton("Login");
		HTMLInputElement signupButton = Pages.getButton("Go to Sign-up");

		// Customize elements
		titleLabel.setAttribute("style", "font-weight:bold");
		loginButton.setAttribute("style", "float:right");
		usernameBox.type = "email";
		passwordBox.type = "password";
//		errorMessage.setAttribute("style", "display:none");
		
		// add button functionalities
//		loginButton.addEventListener(StringTypes.click, x -> {
//			// set errorMessage textBox 
//			$.get(LOGIN_SERVLET, (Object result, String a, JQueryXHR ctx) -> {
//				$(errorMessage).text((String) result);
//				if (error.equals(""))
//					window.location.href = LOGIN_SERVLET;
//				return null;
//			});
//			String error = $(errorMessage).text();
//			alert(error);
//			return null; });
		loginButton.addEventListener(StringTypes.click, x -> { form.action = LOGIN_SERVLET; return null; });
		homeButton.addEventListener(StringTypes.click, x -> { form.action = HOMEPAGE_URL; return null;});
		signupButton.addEventListener(StringTypes.click, x -> { form.action = SIGNUP_URL; return null;});
		
		// prevent submitting by hitting enter
		window.onkeydown = event -> {
		    if(event.keyCode == 13)
		    	event.preventDefault();
		    return null;
		    };
		
		// Format elements into divs
		List<HTMLDivElement> divs = new LinkedList<>();
		divs.add(Pages.getDiv(homeButton, titleLabel, descriptionLabel));
		divs.add(Pages.getDiv(usernameLabel, usernameBox));
		divs.add(Pages.getDiv(passwordLabel, passwordBox));
		divs.add(Pages.getDiv(loginButton, signupButton));
		
		// Load divs into form, and into page's body
		Pages.buildPage(form, divs);
	}
}
