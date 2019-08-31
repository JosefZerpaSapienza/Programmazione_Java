package fabbricaSemantica;

import java.util.LinkedList;
import java.util.List;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLTextAreaElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import jsweet.util.StringTypes;

import static def.dom.Globals.window;
import static def.jquery.Globals.$;

import static fabbricaSemantica.Constants.HOME_URL;
import static fabbricaSemantica.Constants.NEXT_SERVLET;
import static fabbricaSemantica.Constants.EXAMPLE_SERVLET;
import static fabbricaSemantica.Constants.LOGOUT_SERVLET;

public class WordAnnotation
{	
	/**
	 * Address of the servlet that handles this page's data.
	 */
	public static final String ACTIVITY_SERVLET= "wordAnnotation.jsp";
	
	public static void main(String[] args) 
	{
		Pages.checkSession();
		
		// Get standard elements
		HTMLFormElement form = Pages.getForm();
		HTMLInputElement homeButton = Pages.getHomeButton();
		HTMLLabelElement titleLabel = Pages.getLabel("Guess the word.");
		HTMLLabelElement descriptionLabel = Pages.getLabel(
				"Provide the best word that fits the given definition.");
		HTMLLabelElement definitionLabel = Pages.getLabel("");
		HTMLInputElement wordBox = Pages.getTextBox("wordArea", "Enter the best fitting word...");

		HTMLTextAreaElement synsetID = Pages.getTextArea("synsetID", "");
		HTMLTextAreaElement description = Pages.getTextArea("description", "");
		
		HTMLInputElement submitButton = Pages.getButton("Submit");
		HTMLInputElement skipButton = Pages.getButton("Skip");
		HTMLInputElement logoutButton = Pages.getButton("Logout");

		// Customize elements
		titleLabel.setAttribute("style", "font-weight:bold");
		$(submitButton).css("float", "right");
		$(logoutButton).css("float", "right");
		$(synsetID).css("display", "none");
		$(description).css("display", "none");

		// add button functionalities
		homeButton.addEventListener(StringTypes.click, x -> {form.action = HOME_URL; return null;});
		submitButton.addEventListener(StringTypes.click, x -> {form.action = ACTIVITY_SERVLET; return null;});
		skipButton.addEventListener(StringTypes.click, x -> {form.action = NEXT_SERVLET; return null;});
		logoutButton.addEventListener(StringTypes.click, x -> {form.action = LOGOUT_SERVLET; return null;});

		// retrieve new data.
		$.getJSON(EXAMPLE_SERVLET, "task=WORD_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String synsetId = json.$get("synsetID");
			String definition = json.$get("description");
			$(synsetID).val(synsetId);
			$(description).val(definition);
			$(definitionLabel).text("Definition: " + definition);
				
			return null;
		});	

		// prevent submitting by hitting enter
		window.onkeydown = event -> {
		    if(event.keyCode == 13)
		    	event.preventDefault();
		    return null;
		    };
		    
		// Format elements into divs
		List<HTMLDivElement> divs = new LinkedList<>();
		divs.add(Pages.getDiv(homeButton, logoutButton, titleLabel, descriptionLabel));
		divs.add(Pages.getDiv(definitionLabel, wordBox));
		divs.add(Pages.getDiv(skipButton, submitButton));
		divs.add(Pages.getDiv(synsetID, description));
		
		// Load divs into form, and into page's body
		Pages.buildPage(form, divs);
	}
}
