# language: en

Feature: Registrarme y darme de alta en el sitio

  Scenario: El usuario se registra y queda listo para ingresar
    Given que no existe el usuario maria@maria.com
    When intento registrarme como maria@maria.com
    Then me redirige a la vista login

  Scenario: El usuario no logra registrarse y puede reintentar
    Given que ya existe el usuario pedro@pedro.com
    When intento registrarme como pedro@pedro.com
    Then me redirige a la vista nuevo-usuario
      And muestra el mensaje 'El usuario ya existe'

  Rule: Solo puede registrarse si el usuario no existe

    Scenario: Si el usuario no existe en el sitio, se da de alta
      Given que no existe el usuario maria@maria.com
      When intento registrarme como maria@maria.com
      Then el usuario se crea

    Scenario: Si el usuario ya existe en el sitio, no se da de alta
      Given que ya existe el usuario pedro@pedro.com
      When intento registrarme como pedro@pedro.com
      Then el usuario NO se crea
        And muestra el mensaje 'El usuario ya existe'

  Rule: El usuario debe ser un email con formato válido

    Scenario: Si el formato de usuario es incorrecto no se da de alta
      Given
      When intento registrarme como pedro.com
      Then el usuario NO se crea
        And muestra el mensaje 'El formato del usuario no es una direccion de email válida'
