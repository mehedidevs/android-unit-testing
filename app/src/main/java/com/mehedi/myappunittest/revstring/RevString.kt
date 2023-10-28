package com.mehedi.myappunittest.revstring

class RevString {


    fun reverseString(input: String): String {
        val chars = input.toCharArray()
        var i = 0
        var j = chars.size - 1

        while (i < j) {

            var temp = chars[i]
            chars[i] = chars[j]
            chars[j] = temp
            i++
            j--


        }
        return chars.joinToString("")


    }


}