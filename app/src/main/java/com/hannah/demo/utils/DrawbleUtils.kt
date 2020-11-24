package com.hannah.demo.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import com.hannah.demo.R

/**
 * AUTHOR: hannah
 * DATE: 2020-11-23
 */
//class DrawbleUtils {
//    val myImage: Drawable = ResourcesCompat.getDrawable(context.resources, R.drawable.my_image, null)
//
//}

fun ImageView.imageCardAssignation(imageSelected: Int): Int {
    return when(imageSelected) {
        0 -> R.drawable.ic_add
        1 -> R.drawable.ic_home_black_24dp
        2 -> R.drawable.ic_launcher_foreground
        else -> R.drawable.ic_menu_camera
    }
}

