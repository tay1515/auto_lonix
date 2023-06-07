package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import starter.ui.UserRegisterUI;

public class NavigateTo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(UserRegisterUI.registrer_page)
        );
    }

    public static Performable login(){
        return new NavigateTo();
    }

}
