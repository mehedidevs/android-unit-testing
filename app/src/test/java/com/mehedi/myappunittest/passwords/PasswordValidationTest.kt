package com.mehedi.myappunittest.passwords

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test


class PasswordValidationTest {

    lateinit var passwordValidation: PasswordValidation

    @Before
    fun setUp() {
        passwordValidation = PasswordValidation()
    }


    @Test
    fun validPasswordCheckTest_input_empty_expected_required() {

        val result = passwordValidation.validPassword("")

        assertEquals("Password is Required", result)


    }

    @Test
    fun validPasswordCheckTest_input_empty_expected_6required() {

        val result = passwordValidation.validPassword("12334")

        assertEquals("Password length more than 6 is Required", result)


    }


    @Test
    fun validPasswordCheckTest_input_empty_expected_below15required() {

        val result = passwordValidation.validPassword("11111111111111111")

        assertEquals("Password length les than 15 is Required", result)


    }



}