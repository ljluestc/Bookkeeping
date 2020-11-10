package com.hannah.demo.ui.bookkeeping.dummy

/**
 * AUTHOR: hannah
 * DATE: 2020-11-09
 */
data class DummyItem(val id: String, val content: String, val details: String) {
    override fun toString(): String = content
}
