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

    public ValidateFieldRepeatPasswordInteraction(String username, String password, String repeatPassword, String email) {
        this.username = username;
        this.password = password;
        this.repeat_password = repeatPassword;
        this.email = email;
    }

    @Step("{0} Valida campo Password")
    @Override
    public <T extends Actor> void performAs(T actor) {
        String newpass = "";
        if (repeat_password == null){
            repeat_password = newpass;
        }

        actor.attemptsTo(
                SendKeys.of(username).into(UserRegisterUI.username),
                SendKeys.of(password).into(UserRegisterUI.password),
                SendKeys.of(repeat_password).into(UserRegisterUI.repeat_password),
                SendKeys.of(email).into(UserRegisterUI.email),
                Click.on(UserRegisterUI.btn_login)
        );
    }

    public static ValidateFieldRepeatPasswordInteraction ValidateFieldRepeatPassword(String username, String password, String repeatPassword, String email) {
        return instrumented(ValidateFieldRepeatPasswordInteraction.class, username, password, repeatPassword, email);
    }
}
