/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    /**
     * Support class to provide utility static methods.
     * @author josef
     * @class
     */
    class Pages {
        /**
         * Returns an HTMLFormElement, with form.method = "POST".
         * @return
         * @return {HTMLFormElement}
         */
        static getForm() {
            let form = document.createElement("form");
            form.method = "POST";
            return form;
        }
        /**
         * Returns an HTMLLabelElement
         * @param {string} labelContent String to set as text value.
         * @return
         * @return {HTMLLabelElement}
         */
        static getLabel(labelContent) {
            let label = document.createElement("label");
            label.className = "form-control-plaintext";
            $(label).text(labelContent);
            return label;
        }
        /**
         * Returns an HTMLTextAreaElement.
         * @param {string} name name to give to the HTMLTextAreElement.
         * @param {string} textAreaContent text to set as content.
         * @return
         * @return {HTMLTextAreaElement}
         */
        static getTextArea(name, textAreaContent) {
            let textArea = document.createElement("textarea");
            textArea.name = name;
            textArea.className = "form-control";
            textArea.placeholder = textAreaContent;
            return textArea;
        }
        /**
         * Returns a textBox (HTMLInputElement).
         * @param {string} name name to set to the HTMLInputElement.
         * @param {string} textBoxContent text to set as content.
         * @return
         * @return {HTMLInputElement}
         */
        static getTextBox(name, textBoxContent) {
            let textBox = document.createElement("input");
            textBox.type = "text";
            textBox.name = name;
            textBox.className = "form-control";
            textBox.placeholder = textBoxContent;
            return textBox;
        }
        /**
         * Returns a checkBox (HTMLInputElement).
         * @param {string} name name to set to the HTMLInputElement.
         * @param {string} checkBoxContent text to set as content.
         * @return
         * @return {HTMLInputElement}
         */
        static getCheckBox(name, checkBoxContent) {
            let checkBox = document.createElement("input");
            checkBox.type = "checkbox";
            checkBox.name = name;
            checkBox.className = "dl-horizontal";
            checkBox.setAttribute("style", "margin-right:10px; margin-left:10px");
            checkBox.value = checkBoxContent;
            return checkBox;
        }
        /**
         * Returns a radioObject (HTMLInputElement).
         * @param {string} name name to set to the HTMLInputElement
         * @param {string} radioContent text to set
         * @return
         * @return {HTMLInputElement}
         */
        static getRadio(name, radioContent) {
            let radio = document.createElement("input");
            radio.type = "radio";
            radio.name = name;
            radio.className = "dl-horizontal";
            radio.setAttribute("style", "margin-right:10px; margin-left:10px");
            radio.value = radioContent;
            return radio;
        }
        /**
         * Returns a selectElement (HTMLSelectElement).
         * @param {string} name name to set to the HTMLInputElement
         * @param {Array} selectContents array of Strings containing the select values.
         * @return
         * @return {HTMLSelectElement}
         */
        static getSelect(name, ...selectContents) {
            let select = document.createElement("select");
            select.name = name;
            select.className = "dl-horizontal";
            select.setAttribute("style", "margin-right:10px; margin-left:10px");
            for (let index121 = 0; index121 < selectContents.length; index121++) {
                let content = selectContents[index121];
                select.add(Pages.getOption(content));
            }
            return select;
        }
        /**
         * Returns an optionElement(HTMLOptionElement).
         * @param name name to set to the HTMLInputElement
         * @param {string} optionContent text to set
         * @return
         * @return {HTMLOptionElement}
         */
        static getOption(optionContent) {
            let option = document.createElement("option");
            option.text = optionContent;
            return option;
        }
        /**
         * Returns a textBox (HTMLInputElement).
         * @param {string} buttonContent string to set as button value
         * @return
         * @return {HTMLInputElement}
         */
        static getButton(buttonContent) {
            let button = document.createElement("input");
            button.type = "submit";
            button.className = "btn btn-primary";
            button.setAttribute("style", "margin-right:10px; margin-left:10px");
            button.value = buttonContent;
            return button;
        }
        /**
         * Returns the default homeButton (HTMLInputElement), with "Fabbrica Semantica" as value, in orange.
         * @param name name to set at the HTMLInputElement
         * @param textBoxContent text to set
         * @return
         * @return {HTMLInputElement}
         */
        static getHomeButton() {
            let button = Pages.getButton("Fabbrica Semantica");
            let style = button.getAttribute("style");
            button.setAttribute("style", style + "; float:right; background-color:#ff8400; border-color:#ff8400");
            return button;
        }
        /**
         * Given an array of HTMLElements, it adds them to an HTMLDivElement and returns it.
         * @param {Array} elements HTMLElements to be wrapped by the div element.
         * @return
         * @return {HTMLDivElement}
         */
        static getDiv(...elements) {
            let div = document.createElement("div");
            div.className = "form-group";
            for (let index122 = 0; index122 < elements.length; index122++) {
                let element = elements[index122];
                $(div).append(element);
            }
            return div;
        }
        /**
         * Given an HTMLFormElement and a collection of HTMLDivElements, it appends each div
         * in the form.
         * @param {HTMLFormElement} form
         * @param {HTMLDivElement[]} divs
         * @return
         */
        static buildPage(form, divs) {
            for (let index123 = 0; index123 < divs.length; index123++) {
                let div = divs[index123];
                $(form).append(div);
            }
            $(form).css("margin", "1.0% 2.0%");
            $("body").append(form);
        }
        /**
         * Checks whether the user with the current session has been logged in.
         */
        static checkSession() {
            $.get(fabbricaSemantica.Constants.SESSION_SERVLET, (result, a, ctx) => {
                if (((o1, o2) => { if (o1 && o1.equals) {
                    return o1.equals(o2);
                }
                else {
                    return o1 === o2;
                } })(result, "false"))
                    window.location.href = fabbricaSemantica.Constants.LOGOUT_SERVLET;
                return null;
            });
        }
    }
    fabbricaSemantica.Pages = Pages;
    Pages["__class"] = "fabbricaSemantica.Pages";
})(fabbricaSemantica || (fabbricaSemantica = {}));
