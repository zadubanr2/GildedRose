package com.zaduban.gildedroses

import com.zaduban.gildedroses.GildedRose
import com.zaduban.gildedroses.Item
import junit.framework.Assert.assertEquals
import org.junit.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = arrayOf<Item>(Item("Sulfuras", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].quality)

    }

}


