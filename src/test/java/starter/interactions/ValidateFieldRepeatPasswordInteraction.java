package starter.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.thucydides.core.annotations.Step;
import starter.ui.UserRegisterUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidateFieldRepeatPasswordInteraction implements Interaction {

    private final String username;
    private final String password;
    private String repeat_password;
    private final String email;
    private final String option;

    public ValidateFieldRepeatPasswordInteraction(String username, String password, String repeatPassword, String email, String option) {
        this.username = username;
        this.password = password;
        this.repeat_password = repeatPassword;
        this.email = email;
        this.option = option;
    }

    @Step("{0} Valida campo Password")
    @Override
    public <T extends Actor> void performAs(T actor) {
        String newpass = "";
        if (repeat_password == null) {
            repeat_password = newpass;
        }

        actor.attemptsTo(
                SendKeys.of(username).into(UserRegisterUI.username),
                SendKeys.of(password).into(UserRegisterUI.password),
                SendKeys.of(repeat_password).into(UserRegisterUI.repeat_password),
                SendKeys.of(email).into(UserRegisterUI.email),
                ValidatePasswordsInteraction.ValidatePasswords(UserRegisterUI.password, UserRegisterUI.repeat_password, option.toLowerCase()),
                Click.on(UserRegisterUI.btn_login)
        );
    }

    public static ValidateFieldRepeatPasswordInteraction ValidateFieldRepeatPassword(String username, String password, String repeatPassword, String email, String option) {
        return instrumented(ValidateFieldRepeatPasswordInteraction.class, username, password, repeatPassword, email, option);
    }
}
