package com.example.lab_week_06

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CatDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_detail)

        val nameView: TextView = findViewById(R.id.detail_cat_name)
        val breedView: TextView = findViewById(R.id.detail_cat_breed)
        val genderView: TextView = findViewById(R.id.detail_cat_gender)
        val bioView: TextView = findViewById(R.id.detail_cat_bio)
        val photoView: ImageView = findViewById(R.id.detail_cat_photo)

        val name = intent.getStringExtra("cat_name")
        val breed = intent.getStringExtra("cat_breed")
        val gender = intent.getStringExtra("cat_gender")
        val bio = intent.getStringExtra("cat_bio")
        val image = intent.getStringExtra("cat_image")

        nameView.text = name
        breedView.text = breed
        genderView.text = gender
        bioView.text = bio

        GlideImageLoader(this).loadImage(image ?: "", photoView)
    }
}
