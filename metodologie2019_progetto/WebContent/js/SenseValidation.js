/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    class SenseValidation {
        static main(args) {
            fabbricaSemantica.Pages.checkSession();
            let form = fabbricaSemantica.Pages.getForm();
            let homeButton = fabbricaSemantica.Pages.getHomeButton();
            let titleLabel = fabbricaSemantica.Pages.getLabel("Check the definition.");
            let descriptionLabel = fabbricaSemantica.Pages.getLabel("Given a word and a sentence in which it is used, state if the definition provided is correct.");
            let wordLabel = fabbricaSemantica.Pages.getLabel("");
            let sentenceLabel = fabbricaSemantica.Pages.getLabel("");
            let senseLabel = fabbricaSemantica.Pages.getLabel("");
            let synsetID = fabbricaSemantica.Pages.getTextArea("synsetID", "");
            let word = fabbricaSemantica.Pages.getTextArea("word", "");
            let sentence = fabbricaSemantica.Pages.getTextArea("sentence", "");
            let sense = fabbricaSemantica.Pages.getTextArea("sense", "");
            let correction = fabbricaSemantica.Pages.getTextArea("correction", "");
            let correctButton = fabbricaSemantica.Pages.getButton("Correct");
            let wrongButton = fabbricaSemantica.Pages.getButton("Wrong");
            let skipButton = fabbricaSemantica.Pages.getButton("Skip");
            let logoutButton = fabbricaSemantica.Pages.getButton("Logout");
            titleLabel.setAttribute("style", "font-weight:bold");
            wordLabel.setAttribute("style", "font-weight:bold");
            $(correctButton).css("float", "right");
            $(wrongButton).css("float", "right");
            $(logoutButton).css("float", "right");
            $(synsetID).css("display", "none");
            $(word).css("display", "none");
            $(sentence).css("display", "none");
            $(sense).css("display", "none");
            $(correction).css("display", "none");
            homeButton.addEventListener("click", ((form) => {
                return (x) => {
                    form.action = fabbricaSemantica.Constants.HOME_URL;
                    return null;
                };
            })(form));
            correctButton.addEventListener("click", ((form, correction) => {
                return (x) => {
                    $(correction).val("correct");
                    form.action = SenseValidation.TASK_SERVLET;
                    return null;
                };
            })(form, correction));
            wrongButton.addEventListener("click", ((form, correction) => {
                return (x) => {
                    $(correction).val("wrong");
                    form.action = SenseValidation.TASK_SERVLET;
                    return null;
                };
            })(form, correction));
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
            $.getJSON(fabbricaSemantica.Constants.EXAMPLE_SERVLET, "task=SENSE_VALIDATION", ((sentence, wordLabel, synsetID, senseLabel, sense, word, sentenceLabel) => {
                return (result, a, ctx) => {
                    let json = result;
                    let synsetId = (json["synsetID"]);
                    let rWord = (json["word"]);
                    let rSentence = (json["example"]);
                    let rSense = (json["sense"]);
                    $(synsetID).val(synsetId);
                    $(word).val(rWord);
                    $(sentence).val(rSentence);
                    $(sense).val(rSense);
                    $(wordLabel).text("Word: " + rWord);
                    $(sentenceLabel).text("Sentence: " + rSentence);
                    $(senseLabel).text("Sense: " + rSense);
                    return null;
                };
            })(sentence, wordLabel, synsetID, senseLabel, sense, word, sentenceLabel));
            let divs = ([]);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(homeButton, logoutButton, titleLabel, descriptionLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(wordLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(sentenceLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(senseLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(correctButton, wrongButton, skipButton)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(synsetID, word, sentence, sense, correction)) > 0);
            fabbricaSemantica.Pages.buildPage(form, divs);
        }
    }
    /**
     * Address of the servlet that handles this page's data.
     */
    SenseValidation.TASK_SERVLET = "senseValidation.jsp";
    fabbricaSemantica.SenseValidation = SenseValidation;
    SenseValidation["__class"] = "fabbricaSemantica.SenseValidation";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.SenseValidation.main(null);
