package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.EventualConsequence;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.interactions.ValidateFieldEmailInteraction;
import starter.interactions.ValidateFieldPasswordInteraction;
import starter.interactions.ValidateFieldRepeatPasswordInteraction;
import starter.interactions.ValidateFieldUserNameInteraction;
import starter.questions.GeneralValidationsQuestion;
import starter.tasks.NavigateTo;
import starter.tasks.RegisterUserEmailTaks;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class UserRegisterDefinition {

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("Inicio app Ionix")
    public void inicioSesionEnLaAppLonix() {
        theActorCalled("Andres").attemptsTo(
                NavigateTo.login()
        );
    }

    @When("Ingreso nombre de usuario")
    public void ingresoLasCredencialesDeNuevoUsuario(DataTable credenciales) {
        System.out.println("datatable " + credenciales.row(1).get(0) + " " + credenciales.row(1).get(1));
        List<Map<String, String>> rows = credenciales.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            System.out.println("column " + columns.get("Usuario"));
        }

        theActorInTheSpotlight().attemptsTo(ValidateFieldUserNameInteraction.ValidateFieldUserName(credenciales.row(1).get(0), credenciales.row(1).get(1), credenciales.row(1).get(2), credenciales.row(1).get(3)));
        //theActorInTheSpotlight().attemptsTo(Login.withAdminUser(credenciales.row(1).get(0), credenciales.row(1).get(1)));

    }

    @Then("Debo de visualizar la validacion de username {string}")
    public void deboDeVisualizarLaValidacionDeUsername(String msg) {
        theActorInTheSpotlight().should(seeThat(GeneralValidationsQuestion.msgUsername(), equalTo(msg)));
    }


    @When("Ingreso las credenciales de nuevo usuario {string} clave {string} confirmacion clave {string} email {string}")
    public void ingresoLasCredencialesDeNuevoUsuarioUsuarioClaveClaveConfirmacionClaveConfirmacionClaveEmailEmail(String username, String pass, String r_pass, String email) {
        theActorInTheSpotlight().attemptsTo(ValidateFieldUserNameInteraction.ValidateFieldUserName(username, pass, r_pass, email));
    }

    @When("Ingreso usuario {string} clave {string} confirmacion clave {string} email {string}")
    public void ingresoUsuarioClaveConfirmacionClaveEmail(String username, String pass, String r_pass, String email) {
        theActorInTheSpotlight().attemptsTo(ValidateFieldUserNameInteraction.ValidateFieldUserName(username, pass, r_pass, email));
    }


    @When("Ingreso clave")
    public void ingresoClave(DataTable credenciales) {
        System.out.println("datatablepass " + credenciales.row(1).get(0) + " " + credenciales.row(1).get(1));
        theActorInTheSpotlight().attemptsTo(ValidateFieldPasswordInteraction.ValidateFieldPassword(credenciales.row(1).get(0), credenciales.row(1).get(1), credenciales.row(1).get(2), credenciales.row(1).get(3)));
    }

    @Then("Debo de visualizar la validacion de password {string}")
    public void deboDeVisualizarLaValidacionDePassword(String msg) {
        theActorInTheSpotlight().should(seeThat(GeneralValidationsQuestion.msgUsername(), equalTo(msg)));
    }


    @When("Ingreso repetir clave")
    public void ingresoRepetirClave(DataTable credenciales) {
        theActorInTheSpotlight().attemptsTo(ValidateFieldRepeatPasswordInteraction.ValidateFieldRepeatPassword(credenciales.row(1).get(0), credenciales.row(1).get(1), credenciales.row(1).get(2), credenciales.row(1).get(3)));
    }

    @Then("Debo de visualizar la validacion de repetir password {string}")
    public void deboDeVisualizarLaValidacionDeRepetirPassword(String msg) {
        theActorInTheSpotlight().should(seeThat(GeneralValidationsQuestion.msgUsername(), equalTo(msg)));
    }

    @When("Ingreso email")
    public void ingresoEmail(DataTable credenciales) {
        theActorInTheSpotlight().attemptsTo(ValidateFieldEmailInteraction.ValidateFieldEmail(credenciales.row(1).get(0), credenciales.row(1).get(1), credenciales.row(1).get(2), credenciales.row(1).get(3)));
    }

    @Then("Debo de visualizar la validacion de email {string}")
    public void deboDeVisualizarLaValidacionDeEmail(String msg) {
        theActorInTheSpotlight().should(seeThat(GeneralValidationsQuestion.msgUsername(), equalTo(msg)));
    }

    @Then("Debo de visualizar la validacion del poppup de email {string}")
    public void deboDeVisualizarLaValidacionDelPoppupDeEmail(String msg) {
        theActorInTheSpotlight().should(seeThat(GeneralValidationsQuestion.msgEmail(), equalTo(msg)));
    }

    @When("Elijo registrarme con email {string}")
    public void elijoRegistrarmeConEmail(String option) {
        theActorInTheSpotlight().attemptsTo(RegisterUserEmailTaks.RegisterUserEmail(option.toLowerCase()));

    }

    @Then("Debo de visualizar el mensaje de bienvenida {string}")
    public void deboDeVisualizarElMensajeDeBienvenida(String msg) {
        theActorInTheSpotlight().should(EventualConsequence.eventually(seeThat(GeneralValidationsQuestion.msgWelcome(), equalTo(msg))).waitingForNoLongerThan(40).seconds());
    }
}
