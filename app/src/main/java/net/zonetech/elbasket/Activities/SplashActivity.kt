package net.zonetech.elbasket.Activities

import android.content.Intent
import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import net.zonetech.elbasket.Helpers.Fonts
import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.Common
import java.util.*

class SplashActivity : AppCompatActivity() {
    private val TAG = "SplashActivity"
    lateinit var fonts: Fonts;
    var Arabic=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Log.d(TAG, "onCreate: ")
        initLanguage()
    }


    private fun initLanguage(){
        var locale:Locale?=null
        fonts=Fonts(this)
        fonts.Fonts()
        Arabic=fonts.isArabic
        if (Arabic) {

            Log.d(TAG, "initLanguage: Arabic*********************************")
            locale = Locale("ar")

        } else if (!Arabic) {
            Log.d(TAG,"initLanguage : English*******************************")
            locale = Locale("en")
        }

        if (locale != null) {
            resources.configuration.locale = locale
            resources.configuration.setLocale(locale)
            resources.updateConfiguration(resources.configuration, resources.displayMetrics)
        }

        intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}