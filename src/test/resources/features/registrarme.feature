# language: en

Feature: Registrarme y darme de alta en el sitio

  Scenario: El usuario se registra y queda listo para ingresar
    Given que no existe el usuario maria@maria.com
    When intento registrarme como maria@maria.com
    Then me encuentro en login

  Scenario: El usuario no logra registrarse y puede reintentar
    Given que ya existe el usuario pedro@pedro.com
    When intento registrarme como pedro@pedro.com
    Then me encuentro en nuevo-usuario
      And muestra el mensaje 'El usuario ya existe'

  Rule: Solo puede registrarse si el usuario no existe

    Scenario: Si el usuario no existe en el sitio, se da de alta
      Given que no existe el usuario maria@maria.com
      When intento registrarme como maria@maria.com
      Then el usuario se crea

    Scenario: Si el usuario ya existe en el sitio, no se da de alta
      Given que ya existe el usuario pedro@pedro.com
      When intento registrarme como pedro@pedro.com
      Then muestra el mensaje 'El usuario ya existe'

  Rule: El usuario debe ser un email con formato válido

    Scenario: Si el formato de usuario es incorrecto no se da de alta
      Given
      When intento registrarme como pedro.com
      Then el usuario no está registrado
        And muestra el mensaje 'El formato del usuario no es una direccion de email válida'

  Rule: La clave debe tener como mínimo 6 caracteres

    Scenario: Si la clave tiene menos de 6 caracteres, no se registra
      When intento registrarme con clave 1234
      Then el usuario no está registrado
      And  muestra el mensaje 'La clave debe tener como mínimo 6 caracteres'

  Rule: La clave debe contener al menos 1 caracter en mayúscula

   Scenario: Si la clave no tiene al menos 1 caracter en mayúscula, el usuario NO se da de alta y vuelve a la vista de registro
      When intento registrarme con clave prueba1234
      Then el usuario no está registrado
      And muestra el mensaje 'La clave debe tener al menos 1 caracter en mayúscula y 1 número'

  Rule: La clave debe contener al menos 1 número

   Scenario: Si la clave no tiene al menos 1 numero, el usuario NO se da de alta y vuelve a la vista de registro
      When intento registrarme con clave Prueba
      Then el usuario no está registrado
      And muestra el mensaje 'La clave debe tener al menos 1 caracter en mayúscula y 1 número'

   Scenario: Si la clave tiene 6 caracteres, al menos 1 caracter en mayúscula y al menos 1 numero, el usuario se da de alta y queda listo para ingresar
      When intento registrarme con clave Prueba1234
      Then me encuentro en login