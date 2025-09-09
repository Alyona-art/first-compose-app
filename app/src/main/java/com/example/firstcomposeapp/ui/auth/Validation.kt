package com.example.firstcomposeapp.ui.auth

fun validateLogin(login: String): String? {
    if (login.isNotEmpty() && login.any { it in 'A'..'Z' || it in 'a'..'z' }) {
        return "Логин пользователя должен быть на кириллице"
    }
    if (login.isNotEmpty() && login != "Логин_Юзера") {
        return "Неверный логин"
    }
    return null
}

fun validatePassword(password: String): String? {
    if (password.isNotEmpty() && !password.any { it.isLetter() && it in 'A'..'Z' || it in 'a'..'z' }) {
        return "Пароль должен содержать хотя бы одну латинскую букву"
    }
    if (password.isNotEmpty() && !password.any { it.isDigit() }) {
        return "Пароль должен содержать хотя бы одну цифру"
    }
    if (password.isNotEmpty() && password.length < 6) {
        return "Пароль должен содержать не менее 6 символов"
    }
    return null
}