package com.mehedi.myappunittest.passwords

class PasswordValidation {
    fun validPassword(input: String) = when {
        input.isNullOrBlank() -> {
            "Password is Required"
        }

        input.length < 6 -> {
            "Password length more than 6 is Required"
        }

        input.length > 15 -> {
            "Password length les than 15 is Required"
        }

        else -> {

            "valid"
        }
    }


}