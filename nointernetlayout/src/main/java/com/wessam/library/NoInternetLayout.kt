package com.wessam.library

import android.app.Activity
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import kotlinx.android.synthetic.main.no_internet_layout.*
import java.security.AccessController.getContext

class NoInternetLayout(private val activity: Activity, private val layoutResID: Int) {

    private fun onRetryButtonClick() {
        activity.retry_button.setOnClickListener {
            if (NetworkChecker.isNetworkConnected(activity.applicationContext))
                activity.setContentView(layoutResID)
        }
    }


    /**
     * @param activity .
     * @param layoutResID activity layout resource id
     */
    class Builder(private val activity: Activity, layoutResID: Int) {

        private var noInternetLayout: NoInternetLayout = NoInternetLayout(activity, layoutResID)

        init {
            if (NetworkChecker.isNetworkConnected(activity.applicationContext)) {
                activity.setContentView(layoutResID)
            } else {
                activity.setContentView(R.layout.no_internet_layout)

                noInternetLayout.onRetryButtonClick()
            }
        }


        /**
         * animate the image.
         */
        fun animate(): Builder {
            if (!NetworkChecker.isNetworkConnected(activity.applicationContext)) {
                val anim = AlphaAnimation(0f, 1f)
                anim.duration = 6000

                anim.repeatMode = AlphaAnimation.RESTART
                anim.repeatCount = Animation.INFINITE

                activity.no_internet_image.animation = anim
            }
            return this
        }


        /**
         * set the title of the layout.
         * default title: [No internet connection!]
         * @param title of type String.
         */
        fun mainTitle(title: String): Builder {
            if (!NetworkChecker.isNetworkConnected(activity.applicationContext))
                activity.main_title.text = title
            return this
        }


        /**
         * set the title of the layout.
         * default title: [No internet connection!]
         * @param titleID of type Int.
         */
        fun mainTitle(titleID: Int): Builder {
            if (!NetworkChecker.isNetworkConnected(activity.applicationContext))
                activity.main_title.setText(titleID)
            return this
        }


        /**
         * set the secondary text of the layout.
         * default text: [Please check your internet connection and try again]
         * @param secondaryText of type String.
         */
        fun secondaryText(secondaryText: String): Builder {
            if (!NetworkChecker.isNetworkConnected(activity.applicationContext))
                activity.secondary_text.text = secondaryText
            return this
        }


        /**
         * set the secondary text of the layout.
         * default text: [Please check your internet connection and try again]
         * @param secondaryTextID of type Int.
         */
        fun secondaryText(secondaryTextID: Int): Builder {
            if (!NetworkChecker.isNetworkConnected(activity.applicationContext))
                activity.secondary_text.setText(secondaryTextID)
            return this
        }


        /**
         * set the retry button text.
         * default text: [RETRY]
         * @param text of type String.
         */
        fun buttonText(text: String): Builder {
            if (!NetworkChecker.isNetworkConnected(activity.applicationContext))
                activity.retry_button.text = text
            return this
        }


        /**
         * set the retry button text.
         * default text: [RETRY]
         * @param textID of type Int.
         */
        fun buttonText(textID: Int): Builder {
            if (!NetworkChecker.isNetworkConnected(activity.applicationContext))
                activity.retry_button.setText(textID)
            return this
        }


        /**
         * set the image of the layout from some images in the library.
         * default image: [Animated image]
         * @param image of type LayoutImage.
         */
        fun setImage(image: LayoutImage): Builder {
            val imageResourceID = when (image) {
                LayoutImage.CLASSIC -> R.drawable.clasic
                LayoutImage.CLOUD -> R.drawable.cloud
                LayoutImage.DINOSAUR -> R.drawable.dinosaur
                LayoutImage.SHELL -> R.drawable.shell
                LayoutImage.SIMPLE -> R.drawable.simple
            }

            if (!NetworkChecker.isNetworkConnected(activity.applicationContext)) {
                activity.no_internet_image2.visibility = View.GONE
                activity.no_internet_image.setImageResource(imageResourceID)
            }
            return this
        }


        /**
         * set the image of the layout by the user.
         * default image: [Animated image]
         * @param imageResourceID of type Int.
         */
        fun setImage(imageResourceID: Int): Builder {
            if (!NetworkChecker.isNetworkConnected(activity.applicationContext)) {
                activity.no_internet_image2.visibility = View.GONE
                activity.no_internet_image.setImageResource(imageResourceID)
            }
            return this
        }

    }

}