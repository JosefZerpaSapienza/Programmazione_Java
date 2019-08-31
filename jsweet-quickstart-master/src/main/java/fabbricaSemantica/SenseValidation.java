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

import static def.jquery.Globals.$;

import static fabbricaSemantica.Constants.HOME_URL;
import static fabbricaSemantica.Constants.NEXT_SERVLET;
import static fabbricaSemantica.Constants.EXAMPLE_SERVLET;
import static fabbricaSemantica.Constants.LOGOUT_SERVLET;

public class SenseValidation  
{	
	/**
	 * Address of the servlet that handles this page's data.
	 */
	public static final String TASK_SERVLET = "senseValidation.jsp";
	
	public static void main(String[] args) 
	{
		Pages.checkSession();
		
		// Get standard elements
		HTMLFormElement form = Pages.getForm();
		HTMLInputElement homeButton = Pages.getHomeButton();
		HTMLLabelElement titleLabel = Pages.getLabel("Check the definition.");
		HTMLLabelElement descriptionLabel = Pages.getLabel(
				"Given a word and a sentence in which it is used, state if the definition provided is correct.");
		HTMLLabelElement wordLabel = Pages.getLabel("");
		HTMLLabelElement sentenceLabel = Pages.getLabel("");
		HTMLLabelElement senseLabel = Pages.getLabel("");

		HTMLTextAreaElement synsetID = Pages.getTextArea("synsetID", "");
		HTMLTextAreaElement word = Pages.getTextArea("word", "");
		HTMLTextAreaElement sentence = Pages.getTextArea("sentence", "");
		HTMLTextAreaElement sense = Pages.getTextArea("sense", "");
		HTMLTextAreaElement correction = Pages.getTextArea("correction", "");
		
		HTMLInputElement correctButton = Pages.getButton("Correct");
		HTMLInputElement wrongButton = Pages.getButton("Wrong");
		HTMLInputElement skipButton = Pages.getButton("Skip");
		HTMLInputElement logoutButton = Pages.getButton("Logout");

		// Customize elements
		titleLabel.setAttribute("style", "font-weight:bold");
		wordLabel.setAttribute("style", "font-weight:bold");
		$(correctButton).css("float", "right");
		$(wrongButton).css("float", "right");
		$(logoutButton).css("float", "right");
		$(synsetID).css("display", "none");
		$(word).css("display", "none");
		$(sentence).css("display", "none");
		$(sense).css("display", "none");
		$(correction).css("display", "none");

		// add button functionalities
		homeButton.addEventListener(StringTypes.click, x -> {form.action = HOME_URL; return null;});
		correctButton.addEventListener(StringTypes.click, x -> {
			$(correction).val("correct");
			form.action = TASK_SERVLET; return null;});
		wrongButton.addEventListener(StringTypes.click, x -> {
			$(correction).val("wrong");
			form.action = TASK_SERVLET; return null;});
		skipButton.addEventListener(StringTypes.click, x -> {form.action = NEXT_SERVLET; return null;});
		logoutButton.addEventListener(StringTypes.click, x -> {form.action = LOGOUT_SERVLET; return null;});

		// retrieve new data.
		$.getJSON(EXAMPLE_SERVLET, "task=SENSE_VALIDATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String synsetId = json.$get("synsetID");
			String rWord = json.$get("word"); 
			String rSentence = json.$get("example");
			String rSense = json.$get("sense");
			$(synsetID).val(synsetId);
			$(word).val(rWord);
			$(sentence).val(rSentence);
			$(sense).val(rSense);
			$(wordLabel).text("Word: " + rWord);
			$(sentenceLabel).text("Sentence: " + rSentence);
			$(senseLabel).text("Sense: " + rSense);
				
			return null;
		});
		
		// Format elements into divs
		List<HTMLDivElement> divs = new LinkedList<>();
		divs.add(Pages.getDiv(homeButton, logoutButton, titleLabel, descriptionLabel));
		divs.add(Pages.getDiv(wordLabel));
		divs.add(Pages.getDiv(sentenceLabel));
		divs.add(Pages.getDiv(senseLabel));
		divs.add(Pages.getDiv(correctButton, wrongButton, skipButton));
		divs.add(Pages.getDiv(synsetID, word, sentence, sense, correction));
		
		// Load divs into form, and into page's body
		Pages.buildPage(form, divs);
	}
}
