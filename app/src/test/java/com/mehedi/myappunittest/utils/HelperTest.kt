package com.mehedi.myappunittest.utils

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test


class HelperTest {

    lateinit var helper: Helper
    @Before
    fun setUp(){

        helper= Helper()


    }


    @Test
    fun isPallindrome_input_hello_expectedFalse() {
        //Arrange


        //Act
        val result = helper.isPallindrome("hello")

        //Assert

        assertEquals(false, result)

    }


    @Test
    fun isPallindrome_input_level_expectedTrue() {
        //Arrange


        //Act
        val result = helper.isPallindrome("level")

        //Assert

        assertEquals(true, result)

    }
}