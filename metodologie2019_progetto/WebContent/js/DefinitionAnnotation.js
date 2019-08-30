/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    class DefinitionAnnotation {
        static main(args) {
            fabbricaSemantica.Pages.checkSession();
            let form = fabbricaSemantica.Pages.getForm();
            let homeButton = fabbricaSemantica.Pages.getHomeButton();
            let titleLabel = fabbricaSemantica.Pages.getLabel("Define the word.");
            let descriptionLabel = fabbricaSemantica.Pages.getLabel("Give a definition, in your mother tongue, of the given word.\nTo disambiguate the term, a generalization is provided.");
            let wordLabel = fabbricaSemantica.Pages.getLabel("");
            let hypernymLabel = fabbricaSemantica.Pages.getLabel("");
            let definitionLabel = fabbricaSemantica.Pages.getLabel("Your definition:");
            let definitionArea = fabbricaSemantica.Pages.getTextArea("definitionArea", "Enter your definition...");
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
                    form.action = DefinitionAnnotation.ACTIVITY_SERVLET;
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
            $.getJSON(fabbricaSemantica.Constants.EXAMPLE_SERVLET, "task=DEFINITION_ANNOTATION", ((wordLabel, synsetID, word, hypernymLabel) => {
                return (result, a, ctx) => {
                    let json = result;
                    let synsetId = (json["synsetID"]);
                    let rWord = (json["word"]);
                    let hypernym = (json["hypernym"]);
                    $(synsetID).val(synsetId);
                    $(word).val(rWord);
                    $(wordLabel).text("Word: " + rWord);
                    $(hypernymLabel).text("Hypernym: " + hypernym);
                    return null;
                };
            })(wordLabel, synsetID, word, hypernymLabel));
            let divs = ([]);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(homeButton, logoutButton, titleLabel, descriptionLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(wordLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(hypernymLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(definitionLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(definitionArea)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(submitButton, skipButton)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(synsetID, word)) > 0);
            fabbricaSemantica.Pages.buildPage(form, divs);
        }
    }
    /**
     * Address of the servlet that handles this page's data.
     */
    DefinitionAnnotation.ACTIVITY_SERVLET = "definitionAnnotation.jsp";
    fabbricaSemantica.DefinitionAnnotation = DefinitionAnnotation;
    DefinitionAnnotation["__class"] = "fabbricaSemantica.DefinitionAnnotation";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.DefinitionAnnotation.main(null);
