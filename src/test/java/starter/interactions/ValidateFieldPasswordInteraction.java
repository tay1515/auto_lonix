package starter.interactions;

import io.cucumber.java.DataTableType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.thucydides.core.annotations.Step;
import starter.ui.UserRegisterUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidateFieldPasswordInteraction implements Interaction {

    private final String username;
    private String password;
    private final String repeat_password;
    private final String email;

    public ValidateFieldPasswordInteraction(String username, String password, String repeatPassword, String email) {
        this.username = username;
        this.password = password;
        this.repeat_password = repeatPassword;
        this.email = email;
    }

    @Step("{0} Valida campo Repeat password")
    @Override
    public <T extends Actor> void performAs(T actor) {
        String newpass = "";
        if (password == null){
            password = newpass;
        }

        actor.attemptsTo(
                SendKeys.of(username).into(UserRegisterUI.username),
                SendKeys.of(password).into(UserRegisterUI.password),
                SendKeys.of(repeat_password).into(UserRegisterUI.repeat_password),
                SendKeys.of(email).into(UserRegisterUI.email),
                Click.on(UserRegisterUI.btn_login)
        );
    }

    public static ValidateFieldPasswordInteraction ValidateFieldPassword(String username, String password, String repeatPassword, String email) {
        return instrumented(ValidateFieldPasswordInteraction.class, username, password, repeatPassword, email);
    }

}
