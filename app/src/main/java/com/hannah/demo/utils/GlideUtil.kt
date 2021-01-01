package com.hannah.demo.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * AUTHOR: hannah
 * DATE: 31/12/20
 */
@BindingAdapter(
    "srcUrl",
    "circleCrop",
    "placeholder",
    requireAll = false // make the attributes optional
)
fun ImageView.bindSrcUrl(
    url: String,
    circleCrop: Boolean = false,
    placeholder: Drawable?,
) = Glide.with(this).load(url).let { request ->
    if (circleCrop) {
        request.circleCrop()
    }
    if (placeholder != null) {
        request.placeholder(placeholder)
    }
    request.into(this)
}