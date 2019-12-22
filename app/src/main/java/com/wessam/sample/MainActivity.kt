package com.wessam.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wessam.library.LayoutImage
import com.wessam.library.NoInternetLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NoInternetLayout.Builder(this, R.layout.activity_main).setImage(LayoutImage.DINOSAUR).animate()

    }

}