package org.hyperskill.musicplayer.ui.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.hyperskill.musicplayer.R
import org.hyperskill.musicplayer.common.extension.formatDuration
import org.hyperskill.musicplayer.ui.listener.SongSelectListener
import org.hyperskill.musicplayer.ui.model.SongSelectorUiModel


class SongSelectorAdapter(
    private var songSelectors: List<SongSelectorUiModel>
) : RecyclerView.Adapter<SongSelectorAdapter.SongSelectorViewHolder>() {

    private var songSelectListener: SongSelectListener? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setSongSelectors(songsReceived: List<SongSelectorUiModel>){
        songSelectors =songsReceived
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongSelectorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_song_selector, parent, false)
        return SongSelectorViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongSelectorViewHolder, position: Int) {
        val songSelector = songSelectors[position]
        holder.bind(songSelector)
    }

    override fun getItemCount(): Int = songSelectors.size

    @SuppressLint("ClickableViewAccessibility")
    inner class SongSelectorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val checkBox: CheckBox = itemView.findViewById(R.id.songSelectorItemCheckBox)
        private val tvArtist: TextView = itemView.findViewById(R.id.songSelectorItemTvArtist)
        private val tvTitle: TextView = itemView.findViewById(R.id.songSelectorItemTvTitle)
        private val tvDuration: TextView = itemView.findViewById(R.id.songSelectorItemTvDuration)

        init {
            itemView.setOnClickListener{
                val isChecked = !checkBox.isChecked
                checkBox.isChecked = isChecked
                songSelectors[adapterPosition].isSelected = isChecked
                songSelectListener?.onClick(songSelectors[adapterPosition].song.id, isChecked)
                notifyItemChanged(adapterPosition)
            }

            checkBox.setOnCheckedChangeListener { compoundButton, isChecked ->
                if (songSelectors[adapterPosition].isSelected != isChecked) {
                    songSelectors[adapterPosition].isSelected = isChecked
                    itemView.setBackgroundColor(if (isChecked) Color.LTGRAY else Color.WHITE)
                    songSelectListener?.onClick(
                        songSelectors[adapterPosition].song.id,
                        isChecked
                    )
                }
            }
        }

        fun bind(songSelector: SongSelectorUiModel) {
            tvArtist.text = songSelector.song.artist
            tvTitle.text = songSelector.song.title
            tvDuration.text = formatDuration(songSelector.song.duration)
            checkBox.isChecked = songSelector.isSelected
            itemView.setBackgroundColor(if (songSelector.isSelected) Color.LTGRAY else Color.WHITE)
        }
    }

    fun setSongSelectListener(listener: SongSelectListener){
        songSelectListener = listener
    }

    fun getAdapterList(): List<SongSelectorUiModel>{
        return songSelectors
    }
}
