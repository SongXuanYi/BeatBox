package com.diana.beatbox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diana.beatbox.databinding.FragmentBeatBoxBinding
import com.diana.beatbox.databinding.ListItemSoundBinding

class BeatBoxFragment : Fragment() {

    companion object {
        fun newInstance(): BeatBoxFragment = BeatBoxFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentBeatBoxBinding>(
            inflater,
            R.layout.fragment_beat_box,
            container,
            false
        )
        binding.recyclerView.layoutManager = GridLayoutManager(activity, 3)
        binding.recyclerView.adapter = SoundAdapter(activity)
        return binding.root
    }

    private class SoundHolder(binding: ListItemSoundBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val mBinding = binding
    }

    private class SoundAdapter(val activity: FragmentActivity?) :
        RecyclerView.Adapter<SoundHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
            val inflater: LayoutInflater = LayoutInflater.from(activity)
            val binding = DataBindingUtil.inflate<ListItemSoundBinding>(
                inflater,
                R.layout.list_item_sound,
                parent,
                false
            )
            return SoundHolder(binding)
        }

        override fun onBindViewHolder(holder: SoundHolder, position: Int) {

        }

        override fun getItemCount(): Int = 0
    }
}