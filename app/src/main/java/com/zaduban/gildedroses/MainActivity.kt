package com.zaduban.gildedroses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var items = arrayOf(
        Item("+5 Dexterity Vest", 10, 20), //
        Item("Aged Brie", 2, 0), //
        Item("Elixir of the Mongoose", 5, 7), //
        Item("Sulfuras, Hand of Ragnaros", 0, 80), //
        Item("Sulfuras, Hand of Ragnaros", -1, 80),
        Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        // this conjured item does not work properly yet
        Item("Conjured Mana Cake", 3, 6))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberPicker : NumberPicker = findViewById(R.id.number_picker)
        numberPicker.maxValue = 10
        numberPicker.minValue = 1

        val runButton : Button = findViewById(R.id.run_button)
        val outputText : TextView = findViewById(R.id.output)

        runButton.setOnClickListener {
            var app = GildedRose(items)
            Log.d("ITEMS", items.toString())
            outputText.text = output(app, numberPicker.value)
            items = arrayOf(
                Item("+5 Dexterity Vest", 10, 20), //
                Item("Aged Brie", 2, 0), //
                Item("Elixir of the Mongoose", 5, 7), //
                Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                Item("Sulfuras, Hand of Ragnaros", -1, 80),
                Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                Item("Conjured Mana Cake", 3, 6))
        }
    }

    private fun output(app: GildedRose, iterations: Int) : String {
        var output = ""
        for (i in 0..iterations) {
            output += "Day $i \n"
                    for (item in items){
                        output = output + item + "\n"
                    }
            output += "\n"
            app.updateQuality()
        }
        return output
        }
}