package com.example.etourismuttrakhand.ui.feature_details_screen.utils

import android.os.Handler
import android.os.ParcelFileDescriptor.open
import androidx.viewpager2.widget.ViewPager2
import com.example.etourismuttrakhand.R
import com.example.etourismuttrakhand.ui.feature_details_screen.data.model.PlaceImage
import com.example.etourismuttrakhand.ui.features_favourite.data_source.entities.Place

object Others {

fun ViewPager2.autoScroll(interval: Long) {

    val handler = Handler()
    var scrollPosition = 0

    val runnable = object : Runnable {

        override fun run() {

            val count = adapter?.itemCount ?: 0
            setCurrentItem(scrollPosition++ % count, true)

            handler.postDelayed(this, interval)
        }
    }

    registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            scrollPosition = position+1
        }
    })

    handler.post(runnable)
}

    val badrinathList = listOf(
      PlaceImage(
          image = R.drawable.badri1
      ),
        PlaceImage(
            image = R.drawable.badri2
        ), PlaceImage(
            image = R.drawable.badri5
        ), PlaceImage(
            image = R.drawable.badri6
        ),
    )
}