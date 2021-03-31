package com.example.googleanaltics

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.googleanaltics.Adapters.CategoryAdapter
import com.example.googleanaltics.Models.Category
import com.google.firebase.analytics.FirebaseAnalytics
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private lateinit var listView: ListView
    private var timeInSeconds : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        /////////// Tracking and Analytics ///////////

        trackScreen("MainActivity")

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
        listView = findViewById(R.id.listView)
        var categories = ArrayList<Category>()
        categories.add(Category("Laptops", R.drawable.electro))
        categories.add(Category("Food", R.drawable.food))
        categories.add(Category("Clothes", R.drawable.clothes))
        categories.add(Category("Phones", R.drawable.phone))
        categories.add(Category("Smart Watches", R.drawable.watches))
        listView.adapter = CategoryAdapter(this, categories)
        listView.onItemClickListener =
            OnItemClickListener { _ , _ , position , _ ->
                val categoryName: String = categories[position].name
                val intent = Intent(this, CategoryProducts::class.java)
                intent.putExtra("categoryName", categoryName)
                Log.e("s","Clicked")
                // for track when user click on item
                itemClicked(categoryName)
                startActivity(intent)
            }
    }

    fun trackScreen(screenName:String){
        var bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME,screenName)
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW,bundle)
    }
    fun itemClicked(itemName:String){
        var bundle = Bundle()
        bundle.putString("categoryClicked",itemName)
        firebaseAnalytics.logEvent("categoryClicked",bundle)
    }

    override fun onDestroy() {
        super.onDestroy()
        var bundle = Bundle()
        bundle.putString("UserTimeInCategoryScreen",timeInSeconds.toString())
        firebaseAnalytics.logEvent("UserTimeInCategoryScreen",bundle)

    }
}