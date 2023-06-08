package starter.interactions;

import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidatePasswordsInteraction implements Interaction {

    Target password;

    Target repeat_password;

    private String option;

    public ValidatePasswordsInteraction(Target password, Target repeat_password, String option) {
        this.password = password;
        this.repeat_password = repeat_password;
        this.option = option;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        //WebElement pass = Serenity.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[2]"));
        if (option.equals("si")) {
            Assert.assertEquals("las claves no son iguales", password.resolveFor(actor).getText(), repeat_password.resolveFor(actor).getText());
        }

    }

    public static ValidatePasswordsInteraction ValidatePasswords(Target password, Target repeat_password, String option) {
        return instrumented(ValidatePasswordsInteraction.class, password, repeat_password, option);
    }

}
