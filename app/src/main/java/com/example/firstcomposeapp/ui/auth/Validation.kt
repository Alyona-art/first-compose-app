package com.example.firstcomposeapp.ui.auth

sealed class ValidationResult {
    object Valid : ValidationResult()
    data class Invalid(val reason: String) : ValidationResult()
}

fun validateLogin(login: String): ValidationResult {
    if (login.isNotEmpty() && login.any { it in 'A'..'Z' || it in 'a'..'z' }) {
        return ValidationResult.Invalid("Логин пользователя должен быть на кириллице")
    }
    if (login.isNotEmpty() && login != "Логин_Юзера") {
        return ValidationResult.Invalid("Неверный логин")
    }
    return ValidationResult.Valid
}

fun validatePassword(password: String): ValidationResult {
    if (password.isNotEmpty() && !password.any { it in 'A'..'Z' || it in 'a'..'z' }) {
        return ValidationResult.Invalid("Пароль должен содержать хотя бы одну латинскую букву")
    }
    if (password.isNotEmpty() && !password.any { it.isDigit() }) {
        return ValidationResult.Invalid("Пароль должен содержать хотя бы одну цифру")
    }
    if (password.isNotEmpty() && password.length < 6) {
        return ValidationResult.Invalid("Пароль должен содержать не менее 6 символов")
    }
    return ValidationResult.Valid
}