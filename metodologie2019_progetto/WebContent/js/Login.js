/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    class Login {
        static main(args) {
            let form = fabbricaSemantica.Pages.getForm();
            let homeButton = fabbricaSemantica.Pages.getHomeButton();
            let titleLabel = fabbricaSemantica.Pages.getLabel("Login");
            let descriptionLabel = fabbricaSemantica.Pages.getLabel("Log in with your credentials.");
            let usernameLabel = fabbricaSemantica.Pages.getLabel("Username:");
            let usernameBox = fabbricaSemantica.Pages.getTextBox("email", "Enter your username...");
            let passwordLabel = fabbricaSemantica.Pages.getLabel("Password:");
            let passwordBox = fabbricaSemantica.Pages.getTextBox("password", "Enter your password...");
            let loginButton = fabbricaSemantica.Pages.getButton("Login");
            let signupButton = fabbricaSemantica.Pages.getButton("Go to Sign-up");
            titleLabel.setAttribute("style", "font-weight:bold");
            loginButton.setAttribute("style", "float:right");
            usernameBox.type = "email";
            passwordBox.type = "password";
            loginButton.addEventListener("click", ((form) => {
                return (x) => {
                    form.action = fabbricaSemantica.Constants.LOGIN_SERVLET;
                    return null;
                };
            })(form));
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
            window.onkeydown = (event) => {
                if (event.keyCode === 13)
                    event.preventDefault();
                return null;
            };
            let divs = ([]);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(homeButton, titleLabel, descriptionLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(usernameLabel, usernameBox)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(passwordLabel, passwordBox)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(loginButton, signupButton)) > 0);
            fabbricaSemantica.Pages.buildPage(form, divs);
        }
    }
    fabbricaSemantica.Login = Login;
    Login["__class"] = "fabbricaSemantica.Login";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.Login.main(null);
