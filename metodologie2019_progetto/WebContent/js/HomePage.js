/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    class HomePage {
        static main(args) {
            let form = fabbricaSemantica.Pages.getForm();
            let homeButton = fabbricaSemantica.Pages.getHomeButton();
            let titleLabel = fabbricaSemantica.Pages.getLabel("Home Page");
            let descriptionLabel = fabbricaSemantica.Pages.getLabel("Welcome at FabbricaSemantica!");
            let loginButton = fabbricaSemantica.Pages.getButton("Login");
            let signupButton = fabbricaSemantica.Pages.getButton("Sign-up");
            titleLabel.setAttribute("style", "font-weight:bold");
            loginButton.setAttribute("style", "float:right");
            form.action = fabbricaSemantica.Constants.LOGIN_URL;
            homeButton.addEventListener("click", ((form) => {
                return (x) => {
                    form.action = fabbricaSemantica.Constants.HOMEPAGE_URL;
                    return null;
                };
            })(form));
            signupButton.addEventListener("click", ((form) => {
                return (x) => {
                    form.action = fabbricaSemantica.Constants.SIGNUP_URL;
                    return null;
                };
            })(form));
            let divs = ([]);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(homeButton, titleLabel, descriptionLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(loginButton, signupButton)) > 0);
            fabbricaSemantica.Pages.buildPage(form, divs);
        }
    }
    fabbricaSemantica.HomePage = HomePage;
    HomePage["__class"] = "fabbricaSemantica.HomePage";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.HomePage.main(null);
