package com.mehedi.myappunittest.utils

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class HelperTestParameterized(val input: String, val expected: Boolean) {

    lateinit var helper: Helper

    @Before
    fun setUp() {
        //Arrange
        helper = Helper()
    }


    @Test
    fun isPallindrome() {

        //Act
        val result = helper.isPallindrome(input)

        //Assert

        assertEquals(expected, result)

    }


    companion object {


        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} is pallindrome -{1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("Hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true)
            )

        }


    }


}