package com.example.tipcalculator

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class MainActivityKtTest{

    @Test
    fun calculateTipSucess20Percent(){
        val result = calculateValueTip(100.0, 20.0)
        val expected = NumberFormat.getCurrencyInstance().format(20.0)

        assertEquals(result, expected)
    }
}