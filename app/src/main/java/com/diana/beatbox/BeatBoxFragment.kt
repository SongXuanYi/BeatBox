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

    private lateinit var beatBox: BeatBox

    companion object {
        fun newInstance(): BeatBoxFragment = BeatBoxFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        beatBox = BeatBox(activity)
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
        binding.recyclerView.adapter = SoundAdapter(activity, beatBox.getSounds(),beatBox)
        return binding.root
    }

    private class SoundHolder(binding: ListItemSoundBinding,beatBox: BeatBox) :
        RecyclerView.ViewHolder(binding.root) {
        private val mBinding = binding
        init {
            mBinding.viewModel = SoundViewModel(beatBox)
        }
        fun bind(sound: Sound){
            mBinding.viewModel?.sound = sound
            mBinding.executePendingBindings()
        }
    }

    private class SoundAdapter(val activity: FragmentActivity?, val sounds: MutableList<Sound>,val beatBox: BeatBox) :
        RecyclerView.Adapter<SoundHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
            val inflater: LayoutInflater = LayoutInflater.from(activity)
            val binding = DataBindingUtil.inflate<ListItemSoundBinding>(
                inflater,
                R.layout.list_item_sound,
                parent,
                false
            )
            return SoundHolder(binding,beatBox)
        }

        override fun onBindViewHolder(holder: SoundHolder, position: Int) {
            val sound = sounds[position]
            holder.bind(sound)
        }

        override fun getItemCount(): Int = sounds.size
    }
}