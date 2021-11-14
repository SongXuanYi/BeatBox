package com.diana.beatbox

import androidx.databinding.BaseObservable

class SoundViewModel(_beatBox: BeatBox): BaseObservable() {
    var sound: Sound = Sound()
        set(value) {
            field = value
            notifyChange()
        }
    val beatBox: BeatBox = _beatBox
    fun getTitle():String = sound.name
}