package com.example.lab_week_06

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity(), OnCatClickListener {
    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }
    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // 🔹 Aktifkan swipe-to-delete
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // 🔹 Tambahkan minimal 10 data
        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.ExoticShorthair,
                    "Tommy",
                    "Loves playing with yarn",
                    "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.BalineseJavanese,
                    "Luna",
                    "Elegant and calm",
                    "https://cdn2.thecatapi.com/images/4gs.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.AmericanCurl,
                    "Misty",
                    "Always curious and playful",
                    "https://cdn2.thecatapi.com/images/8u2.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.ExoticShorthair,
                    "Oscar",
                    "Sleeps all day, active at night",
                    "https://cdn2.thecatapi.com/images/bpc.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.BalineseJavanese,
                    "Shadow",
                    "Likes to hide in corners",
                    "https://cdn2.thecatapi.com/images/MTc5ODA2NQ.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.AmericanCurl,
                    "Rocky",
                    "Strong but gentle",
                    "https://cdn2.thecatapi.com/images/dqi.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Bella",
                    "Friendly and loves kids",
                    "https://cdn2.thecatapi.com/images/c9a.jpg"
                )
            )
        )
    }

    override fun onCatClicked(cat: CatModel) {
        val intent = Intent(this, CatDetailActivity::class.java).apply {
            putExtra("cat_name", cat.name)
            putExtra("cat_breed", cat.breed.toString())
            putExtra("cat_gender", cat.gender.toString())
            putExtra("cat_bio", cat.biography)
            putExtra("cat_image", cat.imageUrl)
        }
        startActivity(intent)
    }
}
