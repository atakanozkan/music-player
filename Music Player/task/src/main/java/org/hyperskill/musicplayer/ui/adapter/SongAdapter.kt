package org.hyperskill.musicplayer.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.hyperskill.musicplayer.R
import org.hyperskill.musicplayer.common.extension.formatDuration
import org.hyperskill.musicplayer.ui.listener.SongClickListener
import org.hyperskill.musicplayer.ui.model.SongPlayMode
import org.hyperskill.musicplayer.ui.model.SongTrackUiModel
import org.hyperskill.musicplayer.ui.model.SongUiModel

class SongAdapter(
    private var songs: List<SongUiModel>,
    private var currentTrack: SongTrackUiModel?
) : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    private var songClickListener: SongClickListener? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setSongs(songsReceived: List<SongUiModel>){
        songs =songsReceived
        notifyDataSetChanged()
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setCurrentTrack(track : SongTrackUiModel){
        currentTrack = track
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun changeCurrentTrackMode(mode: SongPlayMode){
        currentTrack?.let {
            it.songPlayMode = mode
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_song, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.bind(song)
    }

    inner class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val btnPlayPause: ImageButton = itemView.findViewById(R.id.songItemImgBtnPlayPause)
        private val tvArtist: TextView = itemView.findViewById(R.id.songItemTvArtist)
        private val tvTitle: TextView = itemView.findViewById(R.id.songItemTvTitle)
        private val tvDuration: TextView = itemView.findViewById(R.id.songItemTvDuration)

        init {
            btnPlayPause.setOnClickListener {
                songClickListener?.onClick(songs[adapterPosition].id)
            }
            itemView.setOnLongClickListener {
                songClickListener?.onLongClick(songs[adapterPosition].id)
                true
            }
        }

        @SuppressLint("NotifyDataSetChanged")
        fun bind(song: SongUiModel) {
            tvArtist.text = song.artist
            tvTitle.text = song.title
            tvDuration.text = formatDuration(song.duration)

            val isPlaying = currentTrack?.song == song && currentTrack?.songPlayMode == SongPlayMode.PLAYING
            if (isPlaying) {
                btnPlayPause.setImageResource(R.drawable.ic_pause)
            }
            else {
                btnPlayPause.setImageResource(R.drawable.ic_play)
            }
        }
    }

    fun setClickListener(listener: SongClickListener){
        songClickListener = listener
    }

    override fun getItemCount(): Int = songs.size
}