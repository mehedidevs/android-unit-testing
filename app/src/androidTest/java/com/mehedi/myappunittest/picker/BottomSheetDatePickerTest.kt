package com.mehedi.myappunittest.picker

import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.google.android.material.bottomsheet.BottomSheetDialog
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class BottomSheetDatePickerTest {

    lateinit var bottomSheetDatePicker: BottomSheetDatePicker


    @Before
    fun setUp() {
        getInstrumentation().runOnMainSync {

            val context = getInstrumentation().targetContext
            bottomSheetDatePicker = BottomSheetDatePicker(context, null, 50)

        }




    }

    @Test
    fun testGetDaysInMonthSingle() {
        val daysInJanuary = bottomSheetDatePicker.getDaysInMonth(1, 2023)
        assertEquals(31, daysInJanuary)
    }
    @Test
    fun testGetDaysInMonth() {
        // Test getDaysInMonth() for different months and leap years
        assertEquals(31, bottomSheetDatePicker.getDaysInMonth(1, 2023)) // January
        assertEquals(28, bottomSheetDatePicker.getDaysInMonth(2, 2023)) // February (non-leap year)
        assertEquals(29, bottomSheetDatePicker.getDaysInMonth(2, 2024)) // February (leap year)
        assertEquals(31, bottomSheetDatePicker.getDaysInMonth(3, 2023)) // March
        assertEquals(30, bottomSheetDatePicker.getDaysInMonth(4, 2023)) // April
        assertEquals(31, bottomSheetDatePicker.getDaysInMonth(5, 2023)) // May
        assertEquals(30, bottomSheetDatePicker.getDaysInMonth(6, 2023)) // June
        assertEquals(31, bottomSheetDatePicker.getDaysInMonth(7, 2023)) // July
        assertEquals(31, bottomSheetDatePicker.getDaysInMonth(8, 2023)) // August
        assertEquals(30, bottomSheetDatePicker.getDaysInMonth(9, 2023)) // September
        assertEquals(31, bottomSheetDatePicker.getDaysInMonth(10, 2023)) // October
        assertEquals(30, bottomSheetDatePicker.getDaysInMonth(11, 2023)) // November
        assertEquals(31, bottomSheetDatePicker.getDaysInMonth(12, 2023)) // December
    }

    @Test(expected = IllegalArgumentException::class)
    fun testGetDaysInMonth_InvalidMonth() {
        bottomSheetDatePicker.getDaysInMonth(120, 2020) // Invalid month
    }

    @Test
    fun testGetDaysInMonth_ValidMonth() {



            val daysInMonth = bottomSheetDatePicker.getDaysInMonth(2, 2021) // February in a leap year
            assertEquals(29, daysInMonth)




    }


    @Test
    fun testGetYearDiffForOddYear() {



        getInstrumentation().runOnMainSync {



            val yearDiff = bottomSheetDatePicker.getYearDiff(2021)


            assertEquals(25, yearDiff)


        }

    }

    @Test
    fun testGetYearDiffForEvenYear() {


        getInstrumentation().runOnMainSync {
            val context = getInstrumentation().targetContext

            bottomSheetDatePicker = BottomSheetDatePicker(context, null, 50)

            val yearDiff = bottomSheetDatePicker.getYearDiff(2023)
            var diff = bottomSheetDatePicker.yearDiff

            assertEquals(25, diff)


        }

    }


}