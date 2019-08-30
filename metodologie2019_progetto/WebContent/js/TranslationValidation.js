/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    class TranslationValidation {
        static main(args) {
            fabbricaSemantica.Pages.checkSession();
            let form = fabbricaSemantica.Pages.getForm();
            let homeButton = fabbricaSemantica.Pages.getHomeButton();
            let titleLabel = fabbricaSemantica.Pages.getLabel("Pick the translation.");
            let descriptionLabel = fabbricaSemantica.Pages.getLabel("Select the best translation from the ones provided.");
            let wordLabel = fabbricaSemantica.Pages.getLabel("");
            let definitionLabel = fabbricaSemantica.Pages.getLabel("");
            let firstRadio = fabbricaSemantica.Pages.getRadio(TranslationValidation.RADIO_NAME, "");
            let firstLabel = fabbricaSemantica.Pages.getLabel("");
            let secondRadio = fabbricaSemantica.Pages.getRadio(TranslationValidation.RADIO_NAME, "");
            let secondLabel = fabbricaSemantica.Pages.getLabel("");
            let thirdRadio = fabbricaSemantica.Pages.getRadio(TranslationValidation.RADIO_NAME, "");
            let thirdLabel = fabbricaSemantica.Pages.getLabel("");
            let noRadio = fabbricaSemantica.Pages.getRadio(TranslationValidation.RADIO_NAME, TranslationValidation.NO_TRANSLATION);
            let noLabel = fabbricaSemantica.Pages.getLabel(TranslationValidation.NO_TRANSLATION);
            let synsetID = fabbricaSemantica.Pages.getTextArea("synsetID", "");
            let word = fabbricaSemantica.Pages.getTextArea("word", "");
            let submitButton = fabbricaSemantica.Pages.getButton("Submit");
            let skipButton = fabbricaSemantica.Pages.getButton("Skip");
            let logoutButton = fabbricaSemantica.Pages.getButton("Logout");
            titleLabel.setAttribute("style", "font-weight:bold");
            wordLabel.setAttribute("style", "font-weight:bold");
            $(submitButton).css("float", "right");
            $(logoutButton).css("float", "right");
            $(synsetID).css("display", "none");
            $(word).css("display", "none");
            firstLabel.className = "dl-horizontal";
            secondLabel.className = "dl-horizontal";
            thirdLabel.className = "dl-horizontal";
            noLabel.className = "dl-horizontal";
            homeButton.addEventListener("click", ((form) => {
                return (x) => {
                    form.action = fabbricaSemantica.Constants.HOME_URL;
                    return null;
                };
            })(form));
            submitButton.addEventListener("click", ((form) => {
                return (x) => {
                    form.action = TranslationValidation.ACTIVITY_SERVLET;
                    return null;
                };
            })(form));
            skipButton.addEventListener("click", ((form) => {
                return (x) => {
                    form.action = fabbricaSemantica.Constants.NEXT_SERVLET;
                    return null;
                };
            })(form));
            logoutButton.addEventListener("click", ((form) => {
                return (x) => {
                    form.action = fabbricaSemantica.Constants.LOGOUT_SERVLET;
                    return null;
                };
            })(form));
            $.getJSON(fabbricaSemantica.Constants.EXAMPLE_SERVLET, "task=TRANSLATION_VALIDATION", ((firstRadio, synsetID, definitionLabel, firstLabel, wordLabel, secondRadio, thirdLabel, word, secondLabel, thirdRadio) => {
                return (result, a, ctx) => {
                    let json = result;
                    let synsetId = (json["synsetID"]);
                    let rWord = (json["word"]);
                    let definition = (json["description"]);
                    let translations = (json["translations"]);
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
                    return null;
                };
            })(firstRadio, synsetID, definitionLabel, firstLabel, wordLabel, secondRadio, thirdLabel, word, secondLabel, thirdRadio));
            let divs = ([]);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(homeButton, logoutButton, titleLabel, descriptionLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(wordLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(definitionLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(firstRadio, firstLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(secondRadio, secondLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(thirdRadio, thirdLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(noRadio, noLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(submitButton, skipButton)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(synsetID, word)) > 0);
            fabbricaSemantica.Pages.buildPage(form, divs);
        }
    }
    /**
     * Address of the servlet that handles this page's data.
     */
    TranslationValidation.ACTIVITY_SERVLET = "translationValidation.jsp";
    /**
     * String representing the "none of the above" option.
     */
    TranslationValidation.NO_TRANSLATION = "<NONE>";
    /**
     * Name to set to the radio elements.
     */
    TranslationValidation.RADIO_NAME = "translationRadio";
    fabbricaSemantica.TranslationValidation = TranslationValidation;
    TranslationValidation["__class"] = "fabbricaSemantica.TranslationValidation";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.TranslationValidation.main(null);
