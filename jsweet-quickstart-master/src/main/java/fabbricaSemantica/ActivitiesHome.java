package fabbricaSemantica;

import java.util.LinkedList;
import java.util.List;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import jsweet.util.StringTypes;

import static def.jquery.Globals.$;
import static fabbricaSemantica.Constants.EXAMPLE_SERVLET;
import static fabbricaSemantica.Constants.HOME_URL;
import static fabbricaSemantica.Constants.NEXT_SERVLET;
import static fabbricaSemantica.Constants.LOGOUT_SERVLET;

public class ActivitiesHome
{	
	public static void main(String[] args) 
	{
		Pages.checkSession();
		
		// Get standard elements
		HTMLFormElement form = Pages.getForm();
		HTMLInputElement homeButton = Pages.getHomeButton();
		HTMLLabelElement descriptionLabel = Pages.getLabel("Start an activity.");
		HTMLInputElement startButton = Pages.getButton("Start");
		HTMLInputElement logoutButton = Pages.getButton("Logout");

		// Customize elements
		descriptionLabel.className = "";
		logoutButton.setAttribute("style", "float:right");

		// add button functionalities
		homeButton.addEventListener(StringTypes.click, x -> {form.action = HOME_URL; return null;});
		startButton.addEventListener(StringTypes.click, x -> {form.action = NEXT_SERVLET; return null;});
		logoutButton.addEventListener(StringTypes.click, x -> {form.action = LOGOUT_SERVLET; return null;});
		
		// Format elements into divs
		List<HTMLDivElement> divs = new LinkedList<>();
		divs.add(Pages.getDiv(homeButton, logoutButton, descriptionLabel));
		divs.add(Pages.getDiv(startButton));
		
		// Load divs into form, and into page's body
		Pages.buildPage(form, divs);

		// request data so as to make the servlet load WordNet.
		$.getJSON(EXAMPLE_SERVLET, "task=DEFINITION_ANNOTATION", 
				(Object result, String a, JQueryXHR ctx) -> { return null; });
	}
}
