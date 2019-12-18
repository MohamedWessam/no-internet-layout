package com.wessam.library

import android.app.Activity
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import kotlinx.android.synthetic.main.no_internet_layout.*

class NoInternetLayout(private val activity: Activity, private val layoutResID: Int) {

    /**
     * animate the image.
     */
    private fun animateImageView() {
        val anim = AlphaAnimation(0f, 1f)
        anim.duration = 6000

        anim.repeatMode = AlphaAnimation.RESTART
        anim.repeatCount = Animation.INFINITE

        activity.no_internet_image.animation = anim
    }


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
                noInternetLayout.animateImageView()

                noInternetLayout.onRetryButtonClick()
            }
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

    }

}