package com.mehedi.myappunittest.picker

import android.annotation.SuppressLint
import android.content.Context

import android.os.Bundle


import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mehedi.myappunittest.databinding.BottomSheetDatePickerBinding
import java.text.DateFormatSymbols
import java.time.Year
import java.util.Calendar


class BottomSheetDatePicker(
    context: Context,
    private val datePickedListener: DatePickedListener? = null,
    numberOfYearToShow: Int = 100
) :
    BottomSheetDialog(context) {
    private lateinit var day: String
    private lateinit var month: String
    private lateinit var year: String
    private val cal = Calendar.getInstance()

      val yearDiff = (numberOfYearToShow / 2)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val datePickerBinding = BottomSheetDatePickerBinding.inflate(layoutInflater)
        setContentView(datePickerBinding.root)

        val currentYear = Year.now().value

        datePickerBinding.apply {
            dayPicker.apply {
                minValue = DAY_START
                maxValue = DAY_END
                value = cal[Calendar.DAY_OF_MONTH]
                day = value.toString()

                setOnValueChangedListener { _, _, _ ->
                    maxValue = getDaysInMonth(monthPicker.value, yearPicker.value)
                    day = value.toString()
                    updatePickedDate(datePickerBinding, day, month, year)
                }
            }

            monthPicker.apply {
                minValue = MONTH_START
                maxValue = MONTH_END
                value = cal[Calendar.MONTH]
                displayedValues = DateFormatSymbols().months
                month = displayedValues[cal[Calendar.MONTH] - 1]

                setOnValueChangedListener { _, _, _ ->
                    dayPicker.maxValue = getDaysInMonth(value, yearPicker.value)
                    month = displayedValues[value - 1]
                    updatePickedDate(datePickerBinding, day, month, year)
                }

            }


            yearPicker.apply {
                minValue = currentYear - getYearDiff(currentYear)
                maxValue = currentYear + yearDiff
                value = cal[Calendar.YEAR]
                year = value.toString()
                setOnValueChangedListener { _, _, _ ->
                    year = value.toString()
                    dayPicker.maxValue = getDaysInMonth(monthPicker.value, value)
                    updatePickedDate(datePickerBinding, day, month, year)
                }
            }
            updatePickedDate(datePickerBinding, day, month, year)

            setBtn.setOnClickListener {
                datePickedListener?.pickedDate(datePickerBinding.pickedDate.text.toString())
                dismiss()
            }

            cancelBtn.setOnClickListener {
                dismiss()
            }
        }

    }


    fun getYearDiff(value: Int): Int {

        return if (value % 2 != 0) {

            yearDiff - 1
        } else {
            yearDiff
        }

    }

    @SuppressLint("SetTextI18n")
    fun updatePickedDate(
        datePickerBinding: BottomSheetDatePickerBinding,
        day: String,
        month: String,
        year: String
    ) {
        datePickerBinding.pickedDate.text = "$day $month,$year"

    }


    fun getDaysInMonth(month: Int, year: Int): Int {
        if (month < 1 || month > 12) {
            throw IllegalArgumentException("Invalid month. Month should be between 1 and 12.")
        }

        val daysInMonth = when (month) {
            1, 3, 5, 7, 8, 10, 12 -> 31
            4, 6, 9, 11 -> 30
            2 -> if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) 29 else 28
            else -> throw IllegalArgumentException("Invalid month.")
        }

        return daysInMonth
    }

    fun interface DatePickedListener {
        fun pickedDate(date: String)

    }


}