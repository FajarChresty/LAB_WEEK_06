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
        val itemTouchHelper = ItemTouchHelper(catAdapter.SwipeToDeleteCallback())
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // isi data dummy
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
                )
            )
        )
    }

    override fun onCatClicked(cat: CatModel) {
        // Untuk sekarang masih bisa pakai AlertDialog atau nanti di Part selanjutnya Intent ke Detail
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
