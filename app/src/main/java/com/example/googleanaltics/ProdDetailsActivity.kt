package com.example.googleanaltics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.analytics.FirebaseAnalytics

class ProdDetailsActivity : AppCompatActivity() {
    var imgProduct: ImageView? = null
    var productDisc: TextView? = null
    var productName: TextView? = null
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private var timeInSeconds : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prod_details)
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        /////////// Tracking and Analytics ///////////
        trackScreen("${ intent.getStringExtra("productName") } Details Activity")
        // Calculate User Time in Screen the in onDestroy function I send time in seconds
        // because onDestroy called when user leave the screen
        val timer = object: CountDownTimer(240 * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeInSeconds++
            }
            override fun onFinish() {
            }
        }
        timer.start()
        /////////////////
        val actionBar = supportActionBar
        actionBar!!.title = intent.getStringExtra("productName")
        imgProduct = findViewById(R.id.DetailsproductImage)
        productDisc = findViewById(R.id.tvProductDetailsDiscription)
        productName = findViewById(R.id.tvProductDetailsName)
        productName!!.text = intent.getStringExtra("productName")
        productDisc!!.text = intent.getStringExtra("productDiscription")

        imgProduct!!.setImageResource(intent.getIntExtra("productImage", 0))
    }
    fun trackScreen(screenName:String){
        var bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME,screenName)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW,bundle)
    }


    override fun onDestroy() {
        super.onDestroy()
        var bundle = Bundle()
        bundle.putString("UserTimeInCategoryScreen",timeInSeconds.toString())
        firebaseAnalytics.logEvent("UserTimeInCategoryScreen",bundle)

    }
}