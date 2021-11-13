package com.diana.beatbox

import androidx.fragment.app.Fragment

class BeatBoxActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment = BeatBoxFragment.newInstance()

}