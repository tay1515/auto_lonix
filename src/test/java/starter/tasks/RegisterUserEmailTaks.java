package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.ui.UserRegisterUI;

public class RegisterUserEmailTaks implements Task {

    private final String option;

    public RegisterUserEmailTaks(String option) {
        this.option = option;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (option){
            case "no":
                actor.attemptsTo(
                        Click.on(UserRegisterUI.btn_poppup_confirm_email)
                );
                break;
            case "si":
                actor.attemptsTo(
                        Click.on(UserRegisterUI.btn_poppup_cancel_email)
                );
                break;
        }
    }

    public static Performable RegisterUserEmail(String option) {
        return new RegisterUserEmailTaks(option);
    }
}
