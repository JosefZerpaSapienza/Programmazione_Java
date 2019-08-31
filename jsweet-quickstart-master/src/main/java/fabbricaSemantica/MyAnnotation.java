package fabbricaSemantica;

import static def.jquery.Globals.$;
import static fabbricaSemantica.Constants.HOME_URL;
import static fabbricaSemantica.Constants.LOGOUT_SERVLET;
import static fabbricaSemantica.Constants.NEXT_SERVLET;
import static fabbricaSemantica.Constants.EXAMPLE_SERVLET;

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

public class MyAnnotation
{			
	/**
	 * Address of the servlet that handles this page's data.
	 */
	public static final String ACTIVITY_SERVLET = "myAnnotation.jsp";
	
	public static void main(String[] args) 
	{
		Pages.checkSession();
		
		// Get standard elements
		HTMLFormElement form = Pages.getForm();
		HTMLInputElement homeButton = Pages.getHomeButton();
		HTMLLabelElement titleLabel = Pages.getLabel("Provide an example.");
		HTMLLabelElement descriptionLabel = Pages.getLabel(
				"Provide an example sentence in which the given word is used with the given meaning.");
		
		HTMLLabelElement wordLabel = Pages.getLabel("");
		HTMLLabelElement definitionLabel = Pages.getLabel("");
		HTMLLabelElement exampleLabel = Pages.getLabel("Your sentence:");
		HTMLTextAreaElement exampleArea = Pages.getTextArea("exampleArea", "Enter an example...");

		HTMLTextAreaElement synsetID = Pages.getTextArea("synsetID", "");
		HTMLTextAreaElement word = Pages.getTextArea("word", "");
		HTMLInputElement submitButton = Pages.getButton("Submit");
		HTMLInputElement skipButton = Pages.getButton("Skip");
		HTMLInputElement logoutButton = Pages.getButton("Logout");

		// Customize elements
		titleLabel.setAttribute("style", "font-weight:bold");
		wordLabel.setAttribute("style", "font-weight:bold");
		$(submitButton).css("float", "right");
		$(logoutButton).css("float", "right");
		$(synsetID).css("display", "none");
		$(word).css("display", "none");

		// add button functionalities
		homeButton.addEventListener(StringTypes.click, x -> {form.action = HOME_URL; return null;});
		submitButton.addEventListener(StringTypes.click, x -> {form.action = ACTIVITY_SERVLET; return null;});
		skipButton.addEventListener(StringTypes.click, x -> {form.action = NEXT_SERVLET; return null;});
		logoutButton.addEventListener(StringTypes.click, x -> {form.action = LOGOUT_SERVLET; return null;});

		// retrieve new data.
		$.getJSON(EXAMPLE_SERVLET, "task=MY_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String synsetId = json.$get("synsetID");	
			String rWord = json.$get("word"); 
			String definition = json.$get("description");
			$(synsetID).val(synsetId);
			$(word).val(rWord);
			$(wordLabel).text("Word: " + rWord);
			$(definitionLabel).text("Meaning: " + definition);
			return null;
		});
		
		// Format elements into divs
		List<HTMLDivElement> divs = new LinkedList<>();
		divs.add(Pages.getDiv(homeButton, logoutButton, titleLabel, descriptionLabel));
		divs.add(Pages.getDiv(wordLabel));
		divs.add(Pages.getDiv(definitionLabel));
		divs.add(Pages.getDiv(exampleLabel));
		divs.add(Pages.getDiv(exampleArea));
		divs.add(Pages.getDiv(submitButton, skipButton));
		divs.add(Pages.getDiv(synsetID, word));
		
		// Load divs into form, and into page's body
		Pages.buildPage(form, divs);
	}
}
