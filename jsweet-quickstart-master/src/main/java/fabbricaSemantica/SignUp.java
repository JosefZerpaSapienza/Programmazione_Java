package fabbricaSemantica;

import java.util.LinkedList;
import java.util.List;

import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLSelectElement;
import jsweet.util.StringTypes;

import static fabbricaSemantica.Constants.SIGNUP_SERVLET;
import static def.dom.Globals.window;
import static fabbricaSemantica.Constants.HOMEPAGE_URL;
import static fabbricaSemantica.Constants.LOGIN_URL;

public class SignUp 
{	
	private static final String[] ADDITIONAL_LANGUAGES_OPTIONS = 
			new String[] {"", "A1", "A2", "B1", "B2", "C1", "C2"};
	
	public static void main(String[] args) 
	{
		// Get standard elements
		HTMLFormElement form = Pages.getForm();
		HTMLInputElement homeButton = Pages.getHomeButton();
		HTMLLabelElement titleLabel = Pages.getLabel("Sign-Up");
		HTMLLabelElement descriptionLabel = Pages.getLabel("Sign up on FabbricaSemantica!");
		
		HTMLLabelElement emailLabel = Pages.getLabel("Email");
		HTMLInputElement emailBox = Pages.getTextBox("email", "Enter your email...");
		HTMLLabelElement passwordLabel = Pages.getLabel("Password");
		HTMLInputElement passwordBox = Pages.getTextBox("password", "Enter your password...");
		HTMLLabelElement confirmPasswordLabel = Pages.getLabel("Confirm Password");
		HTMLInputElement confirmPasswordBox = Pages.getTextBox("confirmPassword", "Confirm your password...");

		HTMLLabelElement motherLabel = Pages.getLabel("Select your mother tongue.");
		List<HTMLElement> motherOptions = new LinkedList<>();
		for (MotherTongue language : MotherTongue.values())
		{
			HTMLInputElement checkBox = Pages.getCheckBox(language.getName(), language.getString());
			HTMLLabelElement label = Pages.getLabel(language.getString());
			label.className = "dl-horizontal";
			motherOptions.add(checkBox);
			motherOptions.add(label);
		}
		
		HTMLLabelElement additionalLabel = Pages.getLabel("Select any additional language you know.");
		List<HTMLElement> additionalOptions = new LinkedList<>();
		for (AdditionalLanguage language : AdditionalLanguage.values())
		{
			HTMLLabelElement label = Pages.getLabel(language.getString());
			label.className = "dl-horizontal";
			HTMLSelectElement select = Pages.getSelect(language.getName(), ADDITIONAL_LANGUAGES_OPTIONS);
			additionalOptions.add(label);
			additionalOptions.add(select);
		}
		
		HTMLInputElement signupButton = Pages.getButton("Sign-up");
		HTMLInputElement loginButton = Pages.getButton("Go to Login");
		
		// Customize elements
		titleLabel.setAttribute("style", "font-weight:bold");
		signupButton.setAttribute("style", "float:right");
		emailBox.type = "email";
		passwordBox.type = "password";
		confirmPasswordBox.type = "password";

		// add button functionalities
		homeButton.addEventListener(StringTypes.click, x -> {form.action = HOMEPAGE_URL; return null;});
		signupButton.addEventListener(StringTypes.click, x -> {form.action = SIGNUP_SERVLET; return null;});
		loginButton.addEventListener(StringTypes.click, x -> {form.action = LOGIN_URL; return null;});

		// prevent submitting by hitting enter
		window.onkeydown = event -> {
		    if(event.keyCode == 13)
		    	event.preventDefault();
		    return null;
		    };
		    
		// Format elements into divs
		List<HTMLDivElement> divs = new LinkedList<>();
		HTMLDivElement d = Pages.getDiv(signupButton);
		d.setAttribute("style", "display:none");
		divs.add(d);
		divs.add(Pages.getDiv(homeButton, titleLabel, descriptionLabel));
		divs.add(Pages.getDiv(emailLabel, emailBox));
		divs.add(Pages.getDiv(passwordLabel, passwordBox));
		divs.add(Pages.getDiv(confirmPasswordLabel, confirmPasswordBox));

		divs.add(Pages.getDiv(motherLabel));
		divs.add(Pages.getDiv(motherOptions.toArray(new HTMLElement[motherOptions.size()])));
		
		divs.add(Pages.getDiv(additionalLabel));
		// add additional options in pairs: label-select.
		int c = 0;
		HTMLElement[] options = new HTMLElement[2];
		for (HTMLElement option : additionalOptions)
		{
			options[c % 2] = option;
			if (c++ % 2 == 1)
				divs.add(Pages.getDiv(options));				
		}
		
		divs.add(Pages.getDiv(signupButton, loginButton));		
		
		// Load divs into form, and into page's body
		Pages.buildPage(form, divs);
	}
}
