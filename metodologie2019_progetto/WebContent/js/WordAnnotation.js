/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    class WordAnnotation {
        static main(args) {
            fabbricaSemantica.Pages.checkSession();
            let form = fabbricaSemantica.Pages.getForm();
            let homeButton = fabbricaSemantica.Pages.getHomeButton();
            let titleLabel = fabbricaSemantica.Pages.getLabel("Guess the word.");
            let descriptionLabel = fabbricaSemantica.Pages.getLabel("Provide the best word that fits the given definition.");
            let definitionLabel = fabbricaSemantica.Pages.getLabel("");
            let wordBox = fabbricaSemantica.Pages.getTextBox("wordArea", "Enter the best fitting word...");
            let synsetID = fabbricaSemantica.Pages.getTextArea("synsetID", "");
            let description = fabbricaSemantica.Pages.getTextArea("description", "");
            let submitButton = fabbricaSemantica.Pages.getButton("Submit");
            let skipButton = fabbricaSemantica.Pages.getButton("Skip");
            let logoutButton = fabbricaSemantica.Pages.getButton("Logout");
            titleLabel.setAttribute("style", "font-weight:bold");
            $(submitButton).css("float", "right");
            $(logoutButton).css("float", "right");
            $(synsetID).css("display", "none");
            $(description).css("display", "none");
            homeButton.addEventListener("click", ((form) => {
                return (x) => {
                    form.action = fabbricaSemantica.Constants.HOME_URL;
                    return null;
                };
            })(form));
            submitButton.addEventListener("click", ((form) => {
                return (x) => {
                    form.action = WordAnnotation.ACTIVITY_SERVLET;
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
            $.getJSON(fabbricaSemantica.Constants.EXAMPLE_SERVLET, "task=WORD_ANNOTATION", ((synsetID, description, definitionLabel) => {
                return (result, a, ctx) => {
                    let json = result;
                    let synsetId = (json["synsetID"]);
                    let definition = (json["description"]);
                    $(synsetID).val(synsetId);
                    $(description).val(definition);
                    $(definitionLabel).text("Definition: " + definition);
                    return null;
                };
            })(synsetID, description, definitionLabel));
            let divs = ([]);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(homeButton, logoutButton, titleLabel, descriptionLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(definitionLabel, wordBox)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(skipButton, submitButton)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(synsetID, description)) > 0);
            fabbricaSemantica.Pages.buildPage(form, divs);
        }
    }
    /**
     * Address of the servlet that handles this page's data.
     */
    WordAnnotation.ACTIVITY_SERVLET = "wordAnnotation.jsp";
    fabbricaSemantica.WordAnnotation = WordAnnotation;
    WordAnnotation["__class"] = "fabbricaSemantica.WordAnnotation";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.WordAnnotation.main(null);
