package com.mehedi.myappunittest.revstring

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test


class RevStringTest {

    lateinit var revString: RevString

    @Before
    fun setUp() {

        revString = RevString()
    }

    @Test
    fun reverseString_input_blank_expected_blank() {

        var result = revString.reverseString("")

        assertEquals("", result)


    }

    @Test
    fun reverseString_input_hello_expected_olleh() {

        var result = revString.reverseString("hello")

        assertEquals("olleh", result)


    }

    @Test
    fun reverseString_input_a_expected_a() {

        var result = revString.reverseString("a")

        assertEquals("a", result)


    }
}