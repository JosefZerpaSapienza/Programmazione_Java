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
import static fabbricaSemantica.Constants.LOGOUT_SERVLET;
import static fabbricaSemantica.Constants.EXAMPLE_SERVLET;

public class SenseAnnotation
{			
	/**
	 * Address of the servlet that handles this page's data.
	 */
	public static final String ACTIVITY_SERVLET= "senseAnnotation.jsp";
	/**
	 * Name to set at the radio elements.
	 */
	private static final String RADIO_NAME = "sensesRadio";
	
	public static void main(String[] args) 
	{
		Pages.checkSession();
		
		// Get standard elements
		HTMLFormElement form = Pages.getForm();
		HTMLInputElement homeButton = Pages.getHomeButton();
		HTMLLabelElement titleLabel = Pages.getLabel("Define the sense.");
		HTMLLabelElement descriptionLabel = Pages.getLabel(
				"Select the correct meaning of the given word, as used in the following sentence.");
		HTMLLabelElement wordLabel = Pages.getLabel("");
		HTMLLabelElement sentenceLabel = Pages.getLabel("");

		HTMLInputElement firstRadio = Pages.getRadio(RADIO_NAME, "");
		HTMLLabelElement firstLabel = Pages.getLabel(""); 
		HTMLInputElement secondRadio= Pages.getRadio(RADIO_NAME, "");
		HTMLLabelElement secondLabel = Pages.getLabel("");
		HTMLInputElement thirdRadio = Pages.getRadio(RADIO_NAME, "");
		HTMLLabelElement thirdLabel = Pages.getLabel("");
		HTMLInputElement fourthRadio = Pages.getRadio(RADIO_NAME, "");
		HTMLLabelElement fourthLabel = Pages.getLabel("");

		HTMLTextAreaElement synsetID = Pages.getTextArea("synsetID", "");
		HTMLTextAreaElement word = Pages.getTextArea("word", "");
		HTMLTextAreaElement sentence = Pages.getTextArea("sentence", "");
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
		$(sentence).css("display", "none");

		firstLabel.className = "dl-horiziontal";
		secondLabel.className = "dl-horiziontal";
		thirdLabel.className = "dl-horiziontal";
		fourthLabel.className = "dl-horiziontal";

		// add button functionalities
		homeButton.addEventListener(StringTypes.click, x -> {form.action = HOME_URL; return null;});
		submitButton.addEventListener(StringTypes.click, x -> {form.action = ACTIVITY_SERVLET; return null;});
		skipButton.addEventListener(StringTypes.click, x -> {form.action = NEXT_SERVLET; return null;});
		logoutButton.addEventListener(StringTypes.click, x -> {form.action = LOGOUT_SERVLET; return null;});

		// retrieve new data.
		$.getJSON(EXAMPLE_SERVLET, "task=SENSE_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String synsetId = json.$get("synsetID");
			String rWord = json.$get("word"); 
			String description = json.$get("description");
			String[] senses = json.$get("senses");
			String[] sensesID = json.$get("sensesID");
			$(synsetID).val(synsetId);
			$(word).val(rWord);
			$(sentence).val(description);
			$(wordLabel).text("Word: " + rWord);
			$(sentenceLabel).text("Sentence: " + description);
			$(firstLabel).text(senses[0]);
			$(firstRadio).val(sensesID[0]);
			$(secondLabel).text(senses[1]);
			$(secondRadio).val(sensesID[1]);
			$(thirdLabel).text(senses[2]);
			$(thirdRadio).val(sensesID[2]);
			$(fourthLabel).text(senses[3]);
			$(fourthRadio).val(sensesID[3]);
				
			return null;
		});
		
		// Format elements into divs
		List<HTMLDivElement> divs = new LinkedList<>();
		divs.add(Pages.getDiv(homeButton, logoutButton, titleLabel, descriptionLabel));
		divs.add(Pages.getDiv(wordLabel));
		divs.add(Pages.getDiv(sentenceLabel));
		divs.add(Pages.getDiv(firstRadio, firstLabel));
		divs.add(Pages.getDiv(secondRadio, secondLabel));
		divs.add(Pages.getDiv(thirdRadio, thirdLabel));
		divs.add(Pages.getDiv(fourthRadio, fourthLabel));
		divs.add(Pages.getDiv(submitButton, skipButton));
		divs.add(Pages.getDiv(synsetID, word, sentence));
		
		// Load divs into form, and into page's body
		Pages.buildPage(form, divs);
	}
}

