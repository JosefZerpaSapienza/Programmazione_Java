/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    class MyAnnotation {
        static main(args) {
            fabbricaSemantica.Pages.checkSession();
            let form = fabbricaSemantica.Pages.getForm();
            let homeButton = fabbricaSemantica.Pages.getHomeButton();
            let titleLabel = fabbricaSemantica.Pages.getLabel("Provide an example.");
            let descriptionLabel = fabbricaSemantica.Pages.getLabel("Provide an example sentence in which the given word is used with the given meaning.");
            let wordLabel = fabbricaSemantica.Pages.getLabel("");
            let definitionLabel = fabbricaSemantica.Pages.getLabel("");
            let exampleLabel = fabbricaSemantica.Pages.getLabel("Your sentence:");
            let exampleArea = fabbricaSemantica.Pages.getTextArea("exampleArea", "Enter an example...");
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
                    form.action = MyAnnotation.ACTIVITY_SERVLET;
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
            $.getJSON(fabbricaSemantica.Constants.EXAMPLE_SERVLET, "task=MY_ANNOTATION", ((wordLabel, synsetID, word, definitionLabel) => {
                return (result, a, ctx) => {
                    let json = result;
                    let synsetId = (json["synsetID"]);
                    let rWord = (json["word"]);
                    let definition = (json["description"]);
                    $(synsetID).val(synsetId);
                    $(word).val(rWord);
                    $(wordLabel).text("Word: " + rWord);
                    $(definitionLabel).text("Meaning: " + definition);
                    return null;
                };
            })(wordLabel, synsetID, word, definitionLabel));
            let divs = ([]);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(homeButton, logoutButton, titleLabel, descriptionLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(wordLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(definitionLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(exampleLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(exampleArea)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(submitButton, skipButton)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(synsetID, word)) > 0);
            fabbricaSemantica.Pages.buildPage(form, divs);
        }
    }
    /**
     * Address of the servlet that handles this page's data.
     */
    MyAnnotation.ACTIVITY_SERVLET = "myAnnotation.jsp";
    fabbricaSemantica.MyAnnotation = MyAnnotation;
    MyAnnotation["__class"] = "fabbricaSemantica.MyAnnotation";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.MyAnnotation.main(null);
