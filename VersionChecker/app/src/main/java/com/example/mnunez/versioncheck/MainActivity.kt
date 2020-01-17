package com.example.mnunez.versioncheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mlVersion.setOnClickListener {
            val mlVersion = VersionChecker.getAppVersionById(VersionChecker.MeliApps.ML, this)
            if (mlVersion != null) {
                longToast("Mercado Libre versionCode: " + mlVersion.versionCode + " versionName: " + mlVersion.versionName)
            } else {
                longToast("Mercado Libre no está insatalada")
            }
        }

        mpVersion.setOnClickListener {
            val mpVersion = VersionChecker.getAppVersionById(VersionChecker.MeliApps.MP, this)
            if (mpVersion != null) {
                longToast("Mercado Pago versionCode: " + mpVersion.versionCode + " versionName: " + mpVersion.versionName)
            } else {
                longToast("Mercado Pago no está insatalada")
            }
        }
    }
}
