package com.mehedi.myappunittest.quotes

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.io.FileNotFoundException


class QuotesManagerTest {


    @Test(expected = FileNotFoundException::class)
    fun populateQuotesFromAssets_input_Invalid_file_name_Expected_FileNotFoundException() {
        val quotesManager = QuotesManager()

        val context = ApplicationProvider.getApplicationContext<Context>()
        quotesManager.populateQuotesFromAssets(context, "skdakd_quotes.json")


    }

    @Test(expected = JsonSyntaxException::class)
    fun populateQuotesFromAssets_input_malformed_json_file_expected_JsonSyntaxException() {
        val quotesManager = QuotesManager()

        val context = ApplicationProvider.getApplicationContext<Context>()
        quotesManager.populateQuotesFromAssets(context, "_mal.json")


    }

    @Test()
    fun populateQuotesFromAssets_read_quotes_size() {
        val quotesManager = QuotesManager()

        val context = ApplicationProvider.getApplicationContext<Context>()
        quotesManager.populateQuotesFromAssets(context, "quotes.json")


        assertEquals(16, quotesManager.quoteList.size)

    }


    @Test()
    fun populateQuotesFromAssets_next_quotes() {
        val quotesManager = QuotesManager()

        val context = ApplicationProvider.getApplicationContext<Context>()
        quotesManager.populateQuotesFromAssets(context, "quotes.json")
        quotesManager.populatesQuotes(
            arrayOf(
                Quote("1", "1 ds"),
                Quote("2", "2dd"),
                Quote("3", "3ewqe")
            )
        )

        val quote = quotesManager.getNextQuote()




        assertEquals("2", quote.author)

    }


    @Test()
    fun populateQuotesFromAssets_previous_quotes() {
        val quotesManager = QuotesManager()

        val context = ApplicationProvider.getApplicationContext<Context>()
        quotesManager.populateQuotesFromAssets(context, "quotes.json")
        quotesManager.populatesQuotes(
            arrayOf(
                Quote("1", "1 ds"),
                Quote("2", "2dd"),
                Quote("3", "3ewqe")
            )
        )

        val quote = quotesManager.getPreviousQuote()




        assertEquals("1", quote.author)

    }


}