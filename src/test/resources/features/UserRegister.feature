Feature: Registro de usuario

  @smoke
  Scenario: Registro exitoso con email y validaciones de campos.
    Given Inicio app Ionix
    When Ingreso nombre de usuario
      | Usuario  | Clave      | ConfirmacionClave | Email            |
      | pruebas@ | Automati1* | Automati1*        | pruebas@mail.com |
    Then Debo de visualizar la validacion de username "Username should not contain @"
    When Ingreso nombre de usuario
      | Usuario     | Clave      | ConfirmacionClave | Email            |
      | ionixtester | Automati1* | Automati1*        | pruebas@mail.com |
    Then Debo de visualizar la validacion de username "Username exist"
    When Ingreso clave
      | Usuario  | Clave | ConfirmacionClave | Email            |
      | nuevo123 |       | Automati1*        | pruebas@mail.com |
    Then Debo de visualizar la validacion de password "Password is required"
    When Ingreso clave
      | Usuario  | Clave   | ConfirmacionClave | Email            |
      | nuevo123 | automat | Automati1*        | pruebas@mail.com |
    Then Debo de visualizar la validacion de password "Password does not have the format"
    When Ingreso repetir clave
      | Usuario  | Clave      | ConfirmacionClave | Email            |
      | nuevo123 | Automati1* |                   | pruebas@mail.com |
    Then Debo de visualizar la validacion de repetir password "Repeat password is required"
    When Ingreso repetir clave
      | Usuario  | Clave      | ConfirmacionClave | Email            |
      | nuevo123 | Automati1* | repautomat        | pruebas@mail.com |
    Then Debo de visualizar la validacion de repetir password "Password does not have the format"
    When Ingreso email
      | Usuario  | Clave      | ConfirmacionClave | Email   |
      | nuevo123 | Automati1* | Automati1*        | pruebas |
    Then Debo de visualizar la validacion de email "Please enter a valid email"
    When Ingreso email
      | Usuario  | Clave      | ConfirmacionClave | Email |
      | nuevo123 | Automati1* | Automati1*        |       |
    Then Debo de visualizar la validacion del poppup de email "Your email is empty, we recommended since is needed for account recovery, do you want continue?"
    When Elijo registrarme con email "Si"
    When Ingreso email
      | Usuario | Clave      | ConfirmacionClave | Email           |
      | Automa  | Automati1* | Automati1*        | automa@mail.com |
    Then Debo de visualizar el mensaje de bienvenida "Welcome to ionix"

  Scenario: Registro exitoso sin email y validaciones de campos.
    Given Inicio app Ionix
    When Ingreso nombre de usuario
      | Usuario  | Clave      | ConfirmacionClave | Email            |
      | pruebas@ | Automati1* | Automati1*        | pruebas@mail.com |
    Then Debo de visualizar la validacion de username "Username should not contain @"
    When Ingreso nombre de usuario
      | Usuario     | Clave      | ConfirmacionClave | Email            |
      | ionixtester | Automati1* | Automati1*        | pruebas@mail.com |
    Then Debo de visualizar la validacion de username "Username exist"
    When Ingreso clave
      | Usuario  | Clave | ConfirmacionClave | Email            |
      | nuevo123 |       | Automati1*        | pruebas@mail.com |
    Then Debo de visualizar la validacion de password "Password is required"
    When Ingreso clave
      | Usuario  | Clave   | ConfirmacionClave | Email            |
      | nuevo123 | automat | Automati1*        | pruebas@mail.com |
    Then Debo de visualizar la validacion de password "Password does not have the format"
    When Ingreso repetir clave
      | Usuario  | Clave      | ConfirmacionClave | Email            |
      | nuevo123 | Automati1* |                   | pruebas@mail.com |
    Then Debo de visualizar la validacion de repetir password "Repeat password is required"
    When Ingreso repetir clave
      | Usuario  | Clave      | ConfirmacionClave | Email            |
      | nuevo123 | Automati1* | repautomat        | pruebas@mail.com |
    Then Debo de visualizar la validacion de repetir password "Password does not have the format"
    When Ingreso email
      | Usuario  | Clave      | ConfirmacionClave | Email   |
      | nuevo123 | Automati1* | Automati1*        | pruebas |
    Then Debo de visualizar la validacion de email "Please enter a valid email"
    When Ingreso email
      | Usuario  | Clave      | ConfirmacionClave | Email |
      | nuevo123 | Automati1* | Automati1*        |       |
    Then Debo de visualizar la validacion del poppup de email "Your email is empty, we recommended since is needed for account recovery, do you want continue?"
    When Elijo registrarme con email "No"
    Then Debo de visualizar el mensaje de bienvenida "Welcome to ionix"


  Scenario: Registro exitoso sin validaciones
    Given Inicio app Ionix
    When Ingreso nombre de usuario
      | Usuario    | Clave      | ConfirmacionClave | Email          |
      | Usuario123 | Automati1* | Automati1*        | autom@mail.com |