package com.bignerdranch.android.photogallery

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PhotoPageActivity: AppCompatActivity() {

    override fun onCreate(savedIstanceState: Bundle?){
        super.onCreate(savedIstanceState)
        setContentView(R.layout.activity_photo_page)

        val fm = supportFragmentManager
        val currentFragment = fm.findFragmentById(R.id.fragmentContainer)

        if (currentFragment==null){
            val fragment = PhotoPageFragment.newInstance(intent.data!!) // Uri? was expected (intent.data) не может оно быть null по идее...
            fm.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }
    companion object{
        fun newIntent(context: Context, photoPageUri: Uri): Intent{
            return Intent(context, PhotoPageActivity::class.java).apply{
                data = photoPageUri
            }
        }
    }
}