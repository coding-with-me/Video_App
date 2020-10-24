package com.codingwithme.videoapp

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_video.view.*

class VideoAdapter(arrVideo:ArrayList<VideoModel>) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    var arrVideoModel:ArrayList<VideoModel> = arrVideo

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_video,parent,false))
    }

    override fun getItemCount(): Int {
        return arrVideoModel.size
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.setVideoData(arrVideoModel[position])
    }

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun setVideoData(videoModel: VideoModel){

            itemView.tvTitle.text = videoModel.videoTitle
            itemView.tvDesc.text = videoModel.videoDesc
            itemView.videoView.setVideoPath(videoModel.videoUrl)
            itemView.videoView.setOnPreparedListener(object :MediaPlayer.OnPreparedListener{
                override fun onPrepared(mp: MediaPlayer) {
                    itemView.progressBar.visibility = View.GONE
                    mp.start()
                    val videoRatio = mp.videoWidth.toFloat() / mp.videoHeight.toFloat()
                    val screenRatio = itemView.videoView.width.toFloat() / itemView.videoView.height.toFloat()

                    val scale = videoRatio / screenRatio
                    if (scale > 1f){
                        itemView.videoView.scaleX = scale
                    }else{
                        itemView.videoView.scaleY = (1f / scale)
                    }
                }

            })

            itemView.videoView.setOnCompletionListener { object : MediaPlayer.OnCompletionListener{
                override fun onCompletion(mp: MediaPlayer) {
                    mp.start()
                }
            } }

        }

    }

}