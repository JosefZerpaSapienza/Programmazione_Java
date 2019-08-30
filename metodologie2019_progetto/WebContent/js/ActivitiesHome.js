/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    class ActivitiesHome {
        static main(args) {
            fabbricaSemantica.Pages.checkSession();
            let form = fabbricaSemantica.Pages.getForm();
            let homeButton = fabbricaSemantica.Pages.getHomeButton();
            let descriptionLabel = fabbricaSemantica.Pages.getLabel("Start an activity.");
            let startButton = fabbricaSemantica.Pages.getButton("Start");
            let logoutButton = fabbricaSemantica.Pages.getButton("Logout");
            descriptionLabel.className = "";
            logoutButton.setAttribute("style", "float:right");
            homeButton.addEventListener("click", ((form) => {
                return (x) => {
                    form.action = fabbricaSemantica.Constants.HOME_URL;
                    return null;
                };
            })(form));
            startButton.addEventListener("click", ((form) => {
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
            let divs = ([]);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(homeButton, logoutButton, descriptionLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(startButton)) > 0);
            fabbricaSemantica.Pages.buildPage(form, divs);
            $.getJSON(fabbricaSemantica.Constants.EXAMPLE_SERVLET, "task=DEFINITION_ANNOTATION", (result, a, ctx) => {
                return null;
            });
        }
    }
    fabbricaSemantica.ActivitiesHome = ActivitiesHome;
    ActivitiesHome["__class"] = "fabbricaSemantica.ActivitiesHome";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.ActivitiesHome.main(null);
