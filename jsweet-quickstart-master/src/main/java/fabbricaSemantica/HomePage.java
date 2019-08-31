package fabbricaSemantica;

import java.util.LinkedList;
import java.util.List;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import jsweet.util.StringTypes;

import static fabbricaSemantica.Constants.LOGIN_URL;
import static fabbricaSemantica.Constants.SIGNUP_URL;
import static fabbricaSemantica.Constants.HOMEPAGE_URL;

public class HomePage
{	
	public static void main(String[] args) 
	{
		// Get standard elements
		HTMLFormElement form = Pages.getForm();
		HTMLInputElement homeButton = Pages.getHomeButton();
		HTMLLabelElement titleLabel = Pages.getLabel("Home Page");
		HTMLLabelElement descriptionLabel = Pages.getLabel("Welcome at FabbricaSemantica!");
		HTMLInputElement loginButton = Pages.getButton("Login");
		HTMLInputElement signupButton = Pages.getButton("Sign-up");

		// Customize elements
		titleLabel.setAttribute("style", "font-weight:bold");
		loginButton.setAttribute("style", "float:right");
		
		// add button functionalities
		form.action = LOGIN_URL;
		homeButton.addEventListener(StringTypes.click, x -> {form.action = HOMEPAGE_URL; return null;});
		signupButton.addEventListener(StringTypes.click, x -> {form.action = SIGNUP_URL; return null;});
		
		// Format elements into divs
		List<HTMLDivElement> divs = new LinkedList<>();
		divs.add(Pages.getDiv(homeButton, titleLabel, descriptionLabel));
		divs.add(Pages.getDiv(loginButton, signupButton));
		
		// Load divs into form, and into page's body
		Pages.buildPage(form, divs);
	}
}
