package com.diana.beatbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class SingleFragmentActivity : AppCompatActivity(R.layout.activity_beat_box) {

    protected abstract fun createFragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragmentManager = supportFragmentManager
        var fragment: Fragment? = fragmentManager.findFragmentById(R.id.fragment_container)
        if (fragment==null){
            fragment=createFragment()
            fragmentManager.beginTransaction().add(R.id.fragment_container,fragment).commit()
        }
    }
    
}