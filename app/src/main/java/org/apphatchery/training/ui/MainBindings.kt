package org.apphatchery.training.ui

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import java.util.*

@BindingAdapter("setText")
fun setText(textView: TextView, string: String) {
    textView.text = string
}


@BindingAdapter("setVisibility")
fun setVisibility(view: ImageView, boolean: Boolean) {
    view.isVisible = boolean
}


@BindingAdapter("setImage")
fun setImage(view: ImageView, @DrawableRes avatar: Int) {
    view.setBackgroundResource(avatar)
}


@BindingAdapter("timestamp")
fun timestamp(view: TextView, timestamp: Long) {

    val calendar = Calendar.getInstance()
    calendar.timeInMillis = timestamp

    view.text = String.format(
        "%d/%d/%d",
        calendar.get(Calendar.DAY_OF_MONTH),
        calendar.get(Calendar.MONTH).plus(1),
        calendar.get(Calendar.YEAR)
    )

}