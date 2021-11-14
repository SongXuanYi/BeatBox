package com.diana.beatbox

import android.content.res.AssetManager
import android.util.Log
import androidx.fragment.app.FragmentActivity
import java.io.IOException

class BeatBox(context: FragmentActivity?) {

    companion object {
        private const val TAG = "BeatBox"
        private const val SOUNDS_FOLDER = "sample_sounds"
    }

    private val assets: AssetManager? = context?.assets
    private val sounds: MutableList<Sound> = ArrayList()

    init {
        loadSounds()
    }

    private fun loadSounds() {
        val soundNames: Array<String>

        try {
            soundNames = assets?.list(SOUNDS_FOLDER)!!
            Log.i(TAG, "Found " + soundNames.size + " sounds")
        } catch (ioe: IOException) {
            Log.e(TAG, "Could not list assets", ioe)
            return
        }

        for (filename: String in soundNames) {
            val assetPath = "$SOUNDS_FOLDER/$filename"
            val sound = Sound(assetPath)
            sounds.add(sound)
        }
    }
    fun getSounds():MutableList<Sound> = sounds
}