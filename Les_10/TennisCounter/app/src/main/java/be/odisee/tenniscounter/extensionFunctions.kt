package be.odisee.tenniscounter

import android.text.format.DateFormat
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.util.*

@BindingAdapter("date")
fun TextView.date(dateLong: Long) {
    text = DateFormat.format("dd-MM-yyyy HH:mm", Date(dateLong))
}