package starter.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.thucydides.core.annotations.Step;
import starter.questions.GeneralValidationsQuestion;
import starter.questions.ValidatePasswordsQuestion;
import starter.ui.UserRegisterUI;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.Matchers.equalTo;

public class ValidateFieldUserNameInteraction implements Interaction {

    private final String username;
    private final String password;
    private final String repeat_password;
    private final String email;

    public ValidateFieldUserNameInteraction(String username, String password, String repeatPassword, String email) {
        this.username = username;
        this.password = password;
        this.repeat_password = repeatPassword;
        this.email = email;
    }

    @Step("{0} Valida campo Username")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SendKeys.of(username).into(UserRegisterUI.username),
                SendKeys.of(password).into(UserRegisterUI.password),
                SendKeys.of(repeat_password).into(UserRegisterUI.repeat_password),
                SendKeys.of(email).into(UserRegisterUI.email),
                Click.on(UserRegisterUI.btn_login)
        );

    }

    public static ValidateFieldUserNameInteraction ValidateFieldUserName(String username, String password, String repeatPassword, String email) {
        return instrumented(ValidateFieldUserNameInteraction.class, username, password, repeatPassword, email);
    }
}
