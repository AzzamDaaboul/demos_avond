package be.odisee.gameofthrones

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
fun ImageView.bindImage(url: String?) {
    if (url != null) {
        Glide.with(this)
            .load(url)
            .apply(
                RequestOptions().placeholder(R.drawable.logo)
                    .error(R.drawable.ic_launcher_background)
            )
            .into(this)
    }
}