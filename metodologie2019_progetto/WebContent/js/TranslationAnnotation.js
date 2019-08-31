/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    class TranslationAnnotation {
        static main(args) {
            fabbricaSemantica.Pages.checkSession();
            let form = fabbricaSemantica.Pages.getForm();
            let homeButton = fabbricaSemantica.Pages.getHomeButton();
            let titleLabel = fabbricaSemantica.Pages.getLabel("Translate the word.");
            let descriptionLabel = fabbricaSemantica.Pages.getLabel("Translate in your mother tongue the given word, with the specified definition in English.");
            let wordLabel = fabbricaSemantica.Pages.getLabel("");
            let definitionLabel = fabbricaSemantica.Pages.getLabel("");
            let translationLabel = fabbricaSemantica.Pages.getLabel("Your translation:");
            let translationArea = fabbricaSemantica.Pages.getTextBox("translationArea", "Enter your translation...");
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
            homeButton.addEventListener("click", ((form) => {
                return (x) => {
                    form.action = fabbricaSemantica.Constants.HOME_URL;
                    return null;
                };
            })(form));
            submitButton.addEventListener("click", ((form) => {
                return (x) => {
                    form.action = TranslationAnnotation.ACTIVITY_SERVLET;
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
            $.getJSON(fabbricaSemantica.Constants.EXAMPLE_SERVLET, "task=TRANSLATION_ANNOTATION", ((wordLabel, synsetID, word, definitionLabel) => {
                return (result, a, ctx) => {
                    let json = result;
                    let synsetId = (json["synsetID"]);
                    let rWord = (json["word"]);
                    let definition = (json["description"]);
                    $["synsetID"] = synsetId;
                    $(synsetID).val(synsetId);
                    $(word).val(rWord);
                    $(wordLabel).text("Word: " + rWord);
                    $(definitionLabel).text("Definition: " + definition);
                    return null;
                };
            })(wordLabel, synsetID, word, definitionLabel));
            window.onkeydown = (event) => {
                if (event.keyCode === 13)
                    event.preventDefault();
                return null;
            };
            let divs = ([]);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(homeButton, logoutButton, titleLabel, descriptionLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(wordLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(definitionLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(translationLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(translationArea)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(submitButton, skipButton)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(synsetID, word)) > 0);
            fabbricaSemantica.Pages.buildPage(form, divs);
        }
    }
    /**
     * Address of the servlet that handles this page's data.
     */
    TranslationAnnotation.ACTIVITY_SERVLET = "translationAnnotation.jsp";
    fabbricaSemantica.TranslationAnnotation = TranslationAnnotation;
    TranslationAnnotation["__class"] = "fabbricaSemantica.TranslationAnnotation";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.TranslationAnnotation.main(null);
