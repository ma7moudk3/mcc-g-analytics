package com.example.googleanaltics

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.googleanaltics.Adapters.ProductsAdapter
import com.example.googleanaltics.Models.Product
import com.google.firebase.analytics.FirebaseAnalytics

class CategoryProducts : AppCompatActivity() {
    var data: ArrayList<Product>? = null
    private lateinit var listView: ListView
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private var timeInSeconds : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        /////////// Tracking and Analytics ///////////
        trackScreen("CategoryProductsActivity")
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

        setContentView(R.layout.activity_category_products)
        val categoryName = intent.getStringExtra("categoryName")
        val actionBar = supportActionBar
        actionBar!!.title = categoryName
        listView = findViewById(R.id.productsListView)

        data = ArrayList<Product>()
        if (categoryName.equals("Phones")) {
            data!!.add(
                Product(
                    "Iphone x",
                    R.drawable.phone,
                    "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book.\n"
                )
            )

            data!!.add(
                Product(
                    "Iphone x",
                    R.drawable.phone,
                    "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book.\n"
                )
            )

            data!!.add(
                Product(
                    "Iphone x",
                    R.drawable.phone,
                    "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book.\n"
                )
            )

            data!!.add(
                Product(
                    "Iphone x",
                    R.drawable.phone,
                    "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book.\n"
                )
            )
        } else if (categoryName.equals("Laptops")) {
            data!!.add(
                Product(
                    "MacBook Pro",
                    R.drawable.electro,
                    "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book.\n"
                )
            )

            data!!.add(
                Product(
                    "MacBook Pro",
                    R.drawable.electro,
                    "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book.\n"
                )
            )
        } else if (categoryName.equals("Food")) {
            data!!.add(
                Product(
                    "Spagetty",
                    R.drawable.food,
                    "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book.\n"
                )
            )

            data!!.add(
                Product(
                    "Spagetty",
                    R.drawable.food,
                    "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book.\n"
                )
            )

            data!!.add(
                Product(
                    "Spagetty",
                    R.drawable.food,
                    "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book.\n"
                )
            )

            data!!.add(
                Product(
                    "Spagetty",
                    R.drawable.food,
                    "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book.\n"
                )
            )
        } else if (categoryName.equals("Clothes")) {
            data!!.add(
                Product(
                    "Nice Suite",
                    R.drawable.clothes,
                    "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book.\n"
                )
            )

            data!!.add(
                Product(
                    "Nice Suite",
                    R.drawable.clothes,
                    "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book.\n"
                )
            )

            data!!.add(
                Product(
                    "Nice Suite",
                    R.drawable.clothes,
                    "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book.\n"
                )
            )
        } else if (categoryName.equals("Smart Watches")) {
            data!!.add(
                Product(
                    "Apple Watch",
                    R.drawable.watches,
                    "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book.\n"
                )
            )
            data!!.add(
                Product(
                    "Apple Watch",
                    R.drawable.watches,
                    "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book.\n"
                )
            )
            data!!.add(
                Product(
                    "Apple Watch",
                    R.drawable.watches,
                    "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book.\n"
                )
            )

        }

        listView.adapter=ProductsAdapter(this, data!! )

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val productName = data!![position].name
                val productDiscription = data!![position].description
                val productImage = data!![position].img
                Log.e("s", data!![position].name)
                Log.e("s", data!![position].description)
                Log.e("s", data!![position].img.toString())

                val intent = Intent(this, ProdDetailsActivity::class.java)
                intent.putExtra("productName", productName)
                intent.putExtra("productDiscription", productDiscription)
                intent.putExtra("productImage", productImage)
                Log.e("s", "Clicked")
                itemClicked(productName)
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