package com.abstractultra.saferspace

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import io.radar.sdk.Radar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_more_info.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Radar.initialize("prj_test_pk_65eb3283643d862e050466eadedd1eac6649c3d7")
        Radar.userId = "AU"
        Radar.description = "Main User"
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1002)
        Radar.trackOnce { status, location, events, user ->
            // do something with status, location, events, user
        }
        Radar.startTracking()
        infobutton.setOnClickListener {
            val myIntent = Intent(this@MainActivity, MoreInfo::class.java)
            this@MainActivity.startActivity(myIntent)
        }
    }

}
