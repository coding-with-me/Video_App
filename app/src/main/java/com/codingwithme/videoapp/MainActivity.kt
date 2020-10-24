package com.codingwithme.videoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var arrVideoModel = ArrayList<VideoModel>()
    var videoAdapter:VideoAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrVideoModel.add(VideoModel("Tree with flowers","The branches of a tree wave in the breeze, with pointy leaves ","https://assets.mixkit.co/videos/preview/mixkit-tree-with-yellow-flowers-1173-large.mp4"))
        arrVideoModel.add(VideoModel("multicolored lights","A man with a small beard and mustache wearing a white sweater, sunglasses, and a backwards black baseball cap turns his head in different directions under changing colored lights.","https://assets.mixkit.co/videos/preview/mixkit-man-under-multicolored-lights-1237-large.mp4"))
        arrVideoModel.add(VideoModel("holding neon light","Bald man with a short beard wearing a large jean jacket holds a long tubular neon light thatch","https://assets.mixkit.co/videos/preview/mixkit-man-holding-neon-light-1238-large.mp4"))
        arrVideoModel.add(VideoModel("Sun over hills","The sun sets or rises over hills, a body of water beneath them.","https://assets.mixkit.co/videos/preview/mixkit-sun-over-hills-1183-large.mp4"))

        videoAdapter = VideoAdapter(arrVideoModel)
        viewPager.adapter = videoAdapter

    }
}