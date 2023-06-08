package starter.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidatePasswordsQuestion implements Question<Boolean> {

    private String password;

    private String repeat_password;

    private String option;


    public ValidatePasswordsQuestion(String password, String repeat_password, String option) {
        this.password = password;
        this.repeat_password = repeat_password;
        this.option = option;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        if (option.equals("validatepassword")) {
            if (password.equals(repeat_password)) {
                return true;
            }else {
                return false;
            }
        }
        return true;
    }

    public static ValidatePasswordsQuestion ValidatePasswords(String password, String repeat_password, String option){
        return new ValidatePasswordsQuestion(password, repeat_password, option);
    }

}
