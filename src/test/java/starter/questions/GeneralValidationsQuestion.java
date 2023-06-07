package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;
import starter.ui.HomeUI;
import starter.ui.UserRegisterUI;

public class GeneralValidationsQuestion {

    @Step("{0} Alerta de validacion campo username")
    public static Question<String> msgUsername(){
        return actor -> Text.of(UserRegisterUI.msg_username).answeredBy(actor).trim();
    }

    public static Question<String> msgPassword(){
        return actor -> Text.of(UserRegisterUI.msg_password).answeredBy(actor);
    }

    public static Question<String> msgEmail(){
        return actor -> Text.of(UserRegisterUI.msg_email).answeredBy(actor);
    }

    public static Question<String> msgWelcome(){
        return actor -> Text.of(HomeUI.lbl_welcome).answeredBy(actor);
    }
}
