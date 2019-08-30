/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    class SenseAnnotation {
        static main(args) {
            fabbricaSemantica.Pages.checkSession();
            let form = fabbricaSemantica.Pages.getForm();
            let homeButton = fabbricaSemantica.Pages.getHomeButton();
            let titleLabel = fabbricaSemantica.Pages.getLabel("Define the sense.");
            let descriptionLabel = fabbricaSemantica.Pages.getLabel("Select the correct meaning of the given word, as used in the following sentence.");
            let wordLabel = fabbricaSemantica.Pages.getLabel("");
            let sentenceLabel = fabbricaSemantica.Pages.getLabel("");
            let firstRadio = fabbricaSemantica.Pages.getRadio(SenseAnnotation.RADIO_NAME, "");
            let firstLabel = fabbricaSemantica.Pages.getLabel("");
            let secondRadio = fabbricaSemantica.Pages.getRadio(SenseAnnotation.RADIO_NAME, "");
            let secondLabel = fabbricaSemantica.Pages.getLabel("");
            let thirdRadio = fabbricaSemantica.Pages.getRadio(SenseAnnotation.RADIO_NAME, "");
            let thirdLabel = fabbricaSemantica.Pages.getLabel("");
            let fourthRadio = fabbricaSemantica.Pages.getRadio(SenseAnnotation.RADIO_NAME, "");
            let fourthLabel = fabbricaSemantica.Pages.getLabel("");
            let synsetID = fabbricaSemantica.Pages.getTextArea("synsetID", "");
            let word = fabbricaSemantica.Pages.getTextArea("word", "");
            let sentence = fabbricaSemantica.Pages.getTextArea("sentence", "");
            let submitButton = fabbricaSemantica.Pages.getButton("Submit");
            let skipButton = fabbricaSemantica.Pages.getButton("Skip");
            let logoutButton = fabbricaSemantica.Pages.getButton("Logout");
            titleLabel.setAttribute("style", "font-weight:bold");
            wordLabel.setAttribute("style", "font-weight:bold");
            $(submitButton).css("float", "right");
            $(logoutButton).css("float", "right");
            $(synsetID).css("display", "none");
            $(word).css("display", "none");
            $(sentence).css("display", "none");
            firstLabel.className = "dl-horiziontal";
            secondLabel.className = "dl-horiziontal";
            thirdLabel.className = "dl-horiziontal";
            fourthLabel.className = "dl-horiziontal";
            homeButton.addEventListener("click", ((form) => {
                return (x) => {
                    form.action = fabbricaSemantica.Constants.HOME_URL;
                    return null;
                };
            })(form));
            submitButton.addEventListener("click", ((form) => {
                return (x) => {
                    form.action = SenseAnnotation.ACTIVITY_SERVLET;
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
            $.getJSON(fabbricaSemantica.Constants.EXAMPLE_SERVLET, "task=SENSE_ANNOTATION", ((sentence, firstRadio, synsetID, sentenceLabel, firstLabel, fourthLabel, wordLabel, secondRadio, thirdLabel, word, secondLabel, fourthRadio, thirdRadio) => {
                return (result, a, ctx) => {
                    let json = result;
                    let synsetId = (json["synsetID"]);
                    let rWord = (json["word"]);
                    let description = (json["description"]);
                    let senses = (json["senses"]);
                    let sensesID = (json["sensesID"]);
                    $(synsetID).val(synsetId);
                    $(word).val(rWord);
                    $(sentence).val(description);
                    $(wordLabel).text("Word: " + rWord);
                    $(sentenceLabel).text("Sentence: " + description);
                    $(firstLabel).text(senses[0]);
                    $(firstRadio).val(sensesID[0]);
                    $(secondLabel).text(senses[1]);
                    $(secondRadio).val(sensesID[1]);
                    $(thirdLabel).text(senses[2]);
                    $(thirdRadio).val(sensesID[2]);
                    $(fourthLabel).text(senses[3]);
                    $(fourthRadio).val(sensesID[3]);
                    return null;
                };
            })(sentence, firstRadio, synsetID, sentenceLabel, firstLabel, fourthLabel, wordLabel, secondRadio, thirdLabel, word, secondLabel, fourthRadio, thirdRadio));
            let divs = ([]);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(homeButton, logoutButton, titleLabel, descriptionLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(wordLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(sentenceLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(firstRadio, firstLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(secondRadio, secondLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(thirdRadio, thirdLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(fourthRadio, fourthLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(submitButton, skipButton)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(synsetID, word, sentence)) > 0);
            fabbricaSemantica.Pages.buildPage(form, divs);
        }
    }
    /**
     * Address of the servlet that handles this page's data.
     */
    SenseAnnotation.ACTIVITY_SERVLET = "senseAnnotation.jsp";
    /**
     * Name to set at the radio elements.
     */
    SenseAnnotation.RADIO_NAME = "sensesRadio";
    fabbricaSemantica.SenseAnnotation = SenseAnnotation;
    SenseAnnotation["__class"] = "fabbricaSemantica.SenseAnnotation";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.SenseAnnotation.main(null);
