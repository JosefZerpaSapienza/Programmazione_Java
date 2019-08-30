/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    class SignUp {
        static ADDITIONAL_LANGUAGES_OPTIONS_$LI$() { if (SignUp.ADDITIONAL_LANGUAGES_OPTIONS == null)
            SignUp.ADDITIONAL_LANGUAGES_OPTIONS = ["", "A1", "A2", "B1", "B2", "C1", "C2"]; return SignUp.ADDITIONAL_LANGUAGES_OPTIONS; }
        ;
        static main(args) {
            let form = fabbricaSemantica.Pages.getForm();
            let homeButton = fabbricaSemantica.Pages.getHomeButton();
            let titleLabel = fabbricaSemantica.Pages.getLabel("Sign-Up");
            let descriptionLabel = fabbricaSemantica.Pages.getLabel("Sign up on FabbricaSemantica!");
            let emailLabel = fabbricaSemantica.Pages.getLabel("Email");
            let emailBox = fabbricaSemantica.Pages.getTextBox("email", "Enter your email...");
            let passwordLabel = fabbricaSemantica.Pages.getLabel("Password");
            let passwordBox = fabbricaSemantica.Pages.getTextBox("password", "Enter your password...");
            let confirmPasswordLabel = fabbricaSemantica.Pages.getLabel("Confirm Password");
            let confirmPasswordBox = fabbricaSemantica.Pages.getTextBox("confirmPassword", "Confirm your password...");
            let motherLabel = fabbricaSemantica.Pages.getLabel("Select your mother tongue.");
            let motherOptions = ([]);
            {
                let array125 = function () { let result = []; for (let val in fabbricaSemantica.MotherTongue) {
                    if (!isNaN(val)) {
                        result.push(parseInt(val, 10));
                    }
                } return result; }();
                for (let index124 = 0; index124 < array125.length; index124++) {
                    let language = array125[index124];
                    {
                        let checkBox = fabbricaSemantica.Pages.getCheckBox(fabbricaSemantica.MotherTongue["_$wrappers"][language].getName(), fabbricaSemantica.MotherTongue["_$wrappers"][language].getString());
                        let label = fabbricaSemantica.Pages.getLabel(fabbricaSemantica.MotherTongue["_$wrappers"][language].getString());
                        label.className = "dl-horizontal";
                        /* add */ (motherOptions.push(checkBox) > 0);
                        /* add */ (motherOptions.push(label) > 0);
                    }
                }
            }
            let additionalLabel = fabbricaSemantica.Pages.getLabel("Select any additional language you know.");
            let additionalOptions = ([]);
            {
                let array127 = function () { let result = []; for (let val in fabbricaSemantica.AdditionalLanguage) {
                    if (!isNaN(val)) {
                        result.push(parseInt(val, 10));
                    }
                } return result; }();
                for (let index126 = 0; index126 < array127.length; index126++) {
                    let language = array127[index126];
                    {
                        let label = fabbricaSemantica.Pages.getLabel(fabbricaSemantica.AdditionalLanguage["_$wrappers"][language].getString());
                        label.className = "dl-horizontal";
                        let select = fabbricaSemantica.Pages.getSelect.apply(null, [fabbricaSemantica.AdditionalLanguage["_$wrappers"][language].getName()].concat(SignUp.ADDITIONAL_LANGUAGES_OPTIONS_$LI$()));
                        /* add */ (additionalOptions.push(label) > 0);
                        /* add */ (additionalOptions.push(select) > 0);
                    }
                }
            }
            let signupButton = fabbricaSemantica.Pages.getButton("Sign-up");
            let loginButton = fabbricaSemantica.Pages.getButton("Go to Login");
            titleLabel.setAttribute("style", "font-weight:bold");
            signupButton.setAttribute("style", "float:right");
            emailBox.type = "email";
            passwordBox.type = "password";
            confirmPasswordBox.type = "password";
            homeButton.addEventListener("click", ((form) => {
                return (x) => {
                    form.action = fabbricaSemantica.Constants.HOMEPAGE_URL;
                    return null;
                };
            })(form));
            signupButton.addEventListener("click", ((form) => {
                return (x) => {
                    form.action = fabbricaSemantica.Constants.SIGNUP_SERVLET;
                    return null;
                };
            })(form));
            loginButton.addEventListener("click", ((form) => {
                return (x) => {
                    form.action = fabbricaSemantica.Constants.LOGIN_URL;
                    return null;
                };
            })(form));
            let divs = ([]);
            let d = fabbricaSemantica.Pages.getDiv(signupButton);
            d.setAttribute("style", "display:none");
            /* add */ (divs.push(d) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(homeButton, titleLabel, descriptionLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(emailLabel, emailBox)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(passwordLabel, passwordBox)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(confirmPasswordLabel, confirmPasswordBox)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(motherLabel)) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv.apply(null, /* toArray */ motherOptions.slice(0))) > 0);
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(additionalLabel)) > 0);
            let c = 0;
            let options = [null, null];
            for (let index128 = 0; index128 < additionalOptions.length; index128++) {
                let option = additionalOptions[index128];
                {
                    options[c % 2] = option;
                    if (c++ % 2 === 1)
                        (divs.push(fabbricaSemantica.Pages.getDiv.apply(null, options)) > 0);
                }
            }
            /* add */ (divs.push(fabbricaSemantica.Pages.getDiv(signupButton, loginButton)) > 0);
            fabbricaSemantica.Pages.buildPage(form, divs);
        }
    }
    fabbricaSemantica.SignUp = SignUp;
    SignUp["__class"] = "fabbricaSemantica.SignUp";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.SignUp.ADDITIONAL_LANGUAGES_OPTIONS_$LI$();
fabbricaSemantica.SignUp.main(null);
