# language: en

Feature: Registrarme y darme de alta en el sitio

  Scenario: Si el usuario no existe en el sitio, el mismo se da de alta y se redirige al login
    Given que no existe el usuario maria@maria.com
    When ingreso a nuevo-usuario
      And ingreso el usuario maria@maria.com
      And ingreso la clave Prueba1234
      And intento registrarme
    Then el usuario se crea
      And me redirige a la vista login

  Scenario: Si el usuario ya existe en el sitio, el mismo NO se da de alta y vuelve a la vista de registro
    Given que ya existe el usuario pedro@pedro.com con clave Prueba1234
    When ingreso a nuevo-usuario
      And ingreso el usuario pedro@pedro.com
      And ingreso la clave Prueba1234
      And intento registrarme
    Then el usuario NO se crea
      And me redirige a la vista nuevo-usuario
      And muestra el mensaje 'El usuario ya existe'

  Scenario: Si el formato de usuario es incorrecto NO se da de alta y vuelve a la vista de registro
    Given
    When ingreso a nuevo-usuario
      And ingreso el usuario pedro.com
      And ingreso la clave Prueba1234
      And intento registrarme
    Then el usuario NO se crea
      And me redirige a la vista nuevo-usuario
      And muestra el mensaje 'El formato del usuario no es una direccion de email válida'

  Scenario: Si la clave no tiene al menos 1 caracter en mayúscula, el usuario NO se da de alta y vuelve a la vista de registro
    Given que no existe el usuario pedro@pedro.com
    When ingreso a nuevo-usuario
      And ingreso el usuario pedro@pedro.com
      And ingreso la clave prueba1234
      And intento registrarme
    Then el usuario NO se crea
      And me redirige a la vista nuevo-usuario
      And muestra el mensaje 'La clave debe tener al menos 1 caracter en mayúscula y 1 número'

  Scenario: Si la clave no tiene al menos 1 numero, el usuario NO se da de alta y vuelve a la vista de registro
    Given que no existe el usuario jorge@pedro.com
    When ingreso a nuevo-usuario
      And ingreso el usuario pedro@pedro.com
      And ingreso la clave Prueba
      And intento registrarme
    Then el usuario NO se crea
      And me redirige a la vista nuevo-usuario
      And muestra el mensaje 'La clave debe tener al menos 1 caracter en mayúscula y 1 número'