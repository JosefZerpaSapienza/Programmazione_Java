package fabbricaSemantica;

import static def.jquery.Globals.$;
import static def.dom.Globals.document;
import static def.dom.Globals.window;

import def.dom.HTMLElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLOptionElement;
import def.dom.HTMLSelectElement;
import def.dom.HTMLTextAreaElement;
import def.jquery.JQueryXHR;
import jsweet.util.StringTypes;

import java.util.Collection;

import static fabbricaSemantica.Constants.LOGOUT_SERVLET;
import static fabbricaSemantica.Constants.SESSION_SERVLET;

/**
 * Support class to provide utility static methods.
 * @author josef
 *
 */
public class Pages
{	
	/**
	 * Returns an HTMLFormElement, with form.method = "POST".
	 * @return
	 */
	static HTMLFormElement getForm()
	{
		HTMLFormElement form = document.createElement(StringTypes.form);
		form.method = "POST"; 
		
		return form;
	}
	
	/**
	 * Returns an HTMLLabelElement
	 * @param labelContent String to set as text value.
	 * @return
	 */
	static HTMLLabelElement getLabel(String labelContent)
	{
		HTMLLabelElement label = document.createElement(StringTypes.label);
		label.className =  "form-control-plaintext";
		$(label).text(labelContent);
		
		return label;
	}
	
	/**
	 * Returns an HTMLTextAreaElement.
	 * @param name name to give to the HTMLTextAreElement.
	 * @param textAreaContent text to set as content.
	 * @return
	 */
	static HTMLTextAreaElement getTextArea(String name, String textAreaContent)
	{
		HTMLTextAreaElement textArea = document.createElement(StringTypes.textarea);
		textArea.name = name; 
		textArea.className =  "form-control";
		textArea.placeholder = textAreaContent;
		
		return textArea;
	}
	
	/**
	 * Returns a textBox (HTMLInputElement).
	 * @param name name to set to the HTMLInputElement.
	 * @param textBoxContent text to set as content.
	 * @return
	 */
	static HTMLInputElement getTextBox(String name, String textBoxContent)
	{
		HTMLInputElement textBox = document.createElement(StringTypes.input);
		textBox.type = "text";
		textBox.name = name;
		textBox.className =  "form-control";
		textBox.placeholder = textBoxContent;
		
		return textBox;
	}
	
	/**
	 * Returns a checkBox (HTMLInputElement).
	 * @param name name to set to the HTMLInputElement.
	 * @param checkBoxContent text to set as content.
	 * @return
	 */
	static HTMLInputElement getCheckBox(String name, String checkBoxContent)
	{
		HTMLInputElement checkBox = document.createElement(StringTypes.input); 
		checkBox.type = "checkbox";
		checkBox.name = name;
		checkBox.className =  "dl-horizontal";
		checkBox.setAttribute("style", "margin-right:10px; margin-left:10px");
		checkBox.value= checkBoxContent;
		
		return checkBox;
	}

	
	/**
	 * Returns a radioObject (HTMLInputElement).
	 * @param name name to set to the HTMLInputElement
	 * @param radioContent text to set
	 * @return
	 */
	static HTMLInputElement getRadio(String name, String radioContent)
	{
		HTMLInputElement radio = document.createElement(StringTypes.input);
		radio.type = "radio";
		radio.name = name;
		radio.className =  "dl-horizontal";
		radio.setAttribute("style", "margin-right:10px; margin-left:10px");
		radio.value = radioContent;
		
		return radio;
	}		

	
	/**
	 * Returns a selectElement (HTMLSelectElement).
	 * @param name name to set to the HTMLInputElement
	 * @param selectContents array of Strings containing the select values.
	 * @return
	 */
	static HTMLSelectElement getSelect(String name, String... selectContents)
	{
		HTMLSelectElement select = document.createElement(StringTypes.select);
		select.name = name;
		select.className =  "dl-horizontal";
		select.setAttribute("style", "margin-right:10px; margin-left:10px");
		for (String content : selectContents)
			select.add(getOption(content));
		
		return select;
	}		

	
	/**
	 * Returns an optionElement(HTMLOptionElement).
	 * @param name name to set to the HTMLInputElement
	 * @param optionContent text to set
	 * @return
	 */
	static HTMLOptionElement getOption(String optionContent)
	{
		HTMLOptionElement option = document.createElement(StringTypes.option);
		option.text = optionContent;
		
		return option;
	}		
	
	/**
	 * Returns a textBox (HTMLInputElement).
	 * @param buttonContent string to set as button value
	 * @return
	 */
	static HTMLInputElement getButton(String buttonContent)
	{
		HTMLInputElement button = document.createElement(StringTypes.input);
		button.type = "submit";
		button.className =  "btn btn-primary";
		button.setAttribute("style", "margin-right:10px; margin-left:10px");
		button.value = buttonContent;
		
		return button;
	}
	
	/**
	 * Returns the default homeButton (HTMLInputElement), with "Fabbrica Semantica" as value, in orange.
	 * @param name name to set at the HTMLInputElement
	 * @param textBoxContent text to set
	 * @return
	 */
	static HTMLInputElement getHomeButton()
	{
		HTMLInputElement button = getButton("Fabbrica Semantica");
		String style = button.getAttribute("style");
		button.setAttribute("style", 
				style + "; " + "float:right; background-color:#ff8400; border-color:#ff8400");
		
		return button;
	}
	
	/**
	 * Given an array of HTMLElements, it adds them to an HTMLDivElement and returns it.
	 * @param elements HTMLElements to be wrapped by the div element.
	 * @return
	 */
	static HTMLDivElement getDiv(HTMLElement... elements)
	{
		HTMLDivElement div = document.createElement(StringTypes.div);
		div.className = "form-group";
		for (HTMLElement element : elements)
			$(div).append(element);
		
		return div;
	}
	
	/**
	 * Given an HTMLFormElement and a collection of HTMLDivElements, it appends each div 
	 * in the form.
	 * @param form
	 * @param divs
	 * @return
	 */
	static void buildPage(HTMLFormElement form, Collection<HTMLDivElement> divs)
	{
		// aggiunge i div alla form
		for (HTMLDivElement div : divs)
			$(form).append(div);
		
		// imposta i margini della pagina
		$(form).css("margin", "1.0% 2.0%");
		
		// aggiunge la form al corpo della pagina
		$("body").append(form);
	}
	
	/**
	 * Checks whether the user with the current session has been logged in.
	 */
	public static void checkSession()
	{
		// Check session
		$.get(SESSION_SERVLET, (Object result, String a, JQueryXHR ctx) -> 
		{
			if (((String)result).equals("false"))
				window.location.href = LOGOUT_SERVLET;
			return null;
		});
	}
}
