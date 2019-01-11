package id.onestep.networkingandroidmvvm.adapters

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions

class BindingConverter {
    companion object {
        @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(imageView: ImageView,url:String){
            Glide.with(imageView.context)
                .load(url)
                .apply(RequestOptions()
                    .format(DecodeFormat.PREFER_ARGB_8888))
                .into(imageView)
        }
    }
}