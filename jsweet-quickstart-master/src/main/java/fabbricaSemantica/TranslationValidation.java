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

public class TranslationValidation 
{		
	/**
	 * Address of the servlet that handles this page's data.
	 */
	public static final String ACTIVITY_SERVLET= "translationValidation.jsp";
	/**
	 * String representing the "none of the above" option.
	 */
	public static final String NO_TRANSLATION = "<NONE>";
	/**
	 * Name to set to the radio elements.
	 */
	private static final String RADIO_NAME = "translationRadio";
	
	public static void main(String[] args) 
	{
		Pages.checkSession();
		
		// Get standard elements
		HTMLFormElement form = Pages.getForm();
		HTMLInputElement homeButton = Pages.getHomeButton();
		HTMLLabelElement titleLabel = Pages.getLabel("Pick the translation.");
		HTMLLabelElement descriptionLabel = Pages.getLabel(
				"Select the best translation from the ones provided.");
		HTMLLabelElement wordLabel = Pages.getLabel("");
		HTMLLabelElement definitionLabel = Pages.getLabel("");

		HTMLInputElement firstRadio = Pages.getRadio(RADIO_NAME, "");
		HTMLLabelElement firstLabel = Pages.getLabel("");
		HTMLInputElement secondRadio= Pages.getRadio(RADIO_NAME, "");
		HTMLLabelElement secondLabel = Pages.getLabel("");
		HTMLInputElement thirdRadio = Pages.getRadio(RADIO_NAME, "");
		HTMLLabelElement thirdLabel = Pages.getLabel("");
//		HTMLInputElement fourthRadio = Pages.getRadio(RADIO_NAME, "");
//		HTMLLabelElement fourthLabel = Pages.getLabel("");
		HTMLInputElement noRadio = Pages.getRadio(RADIO_NAME, NO_TRANSLATION);
		HTMLLabelElement noLabel = Pages.getLabel(NO_TRANSLATION);

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


		firstLabel.className = "dl-horizontal";
		secondLabel.className = "dl-horizontal";
		thirdLabel.className = "dl-horizontal";
//		fourthLabel.className = "dl-horizontal";
		noLabel.className = "dl-horizontal";

		homeButton.addEventListener(StringTypes.click, x -> {form.action = HOME_URL; return null;});
		submitButton.addEventListener(StringTypes.click, x -> {form.action = ACTIVITY_SERVLET; return null;});
		skipButton.addEventListener(StringTypes.click, x -> {form.action = NEXT_SERVLET; return null;});
		logoutButton.addEventListener(StringTypes.click, x -> {form.action = LOGOUT_SERVLET; return null;});

		// retrieve new data.
		$.getJSON(EXAMPLE_SERVLET, "task=TRANSLATION_VALIDATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String synsetId = json.$get("synsetID");
			String rWord = json.$get("word"); 
			String definition = json.$get("description");
			String[] translations = json.$get("translations");
			$(synsetID).val(synsetId);
			$(word).val(rWord);
			$(wordLabel).text("Word: " + rWord);
			$(definitionLabel).text("Definition: " + definition);
			$(firstLabel).text(translations[0]);
			$(firstRadio).val(translations[0]);
			$(secondLabel).text(translations[1]);
			$(secondRadio).val(translations[1]);
			$(thirdLabel).text(translations[2]);
			$(thirdRadio).val(translations[2]);
//			$(fourthLabel).text(translations[3]);
//			$(fourthRadio).val(translations[3]);
				
			return null;
		});	
		
		// Format elements into divs
		List<HTMLDivElement> divs = new LinkedList<>();
		divs.add(Pages.getDiv(homeButton, logoutButton, titleLabel, descriptionLabel));
		divs.add(Pages.getDiv(wordLabel));
		divs.add(Pages.getDiv(definitionLabel));
		divs.add(Pages.getDiv(firstRadio, firstLabel));
		divs.add(Pages.getDiv(secondRadio, secondLabel));
		divs.add(Pages.getDiv(thirdRadio, thirdLabel));
//		divs.add(Pages.getDiv(fourthRadio, fourthLabel));
		divs.add(Pages.getDiv(noRadio, noLabel));
		divs.add(Pages.getDiv(submitButton, skipButton));
		divs.add(Pages.getDiv(synsetID, word));
		
		// Load divs into form, and into page's body
		Pages.buildPage(form, divs);
	}
}

