package com.hannah.demo.ui.bookkeeping.dummy

import java.lang.StringBuilder
import java.util.ArrayList
import java.util.HashMap

/**
 * AUTHOR: hannah
 * DATE: 2020-11-09
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<DummyItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    private val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    private const val COUNT = 25

    init {
        for (i in 1..COUNT){
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    private fun createDummyItem(position: Int): DummyItem {
        return DummyItem(position.toString(), "Item $position", makeDetail(position))
    }

    private fun makeDetail(position: Int): String {
        val builder = StringBuilder();
        builder.append("Detail about Item: ").append(position)
        for (i in 0 until position){
            builder.append("\n more details information here")
        }
        return builder.toString()
    }

}