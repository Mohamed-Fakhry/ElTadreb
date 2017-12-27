package com.example.computec.eltadreb.ui.video

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.ui.base.BaseYoutubeCustomActivity
import com.example.computec.eltadreb.utils.ActivityUtils
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : BaseYoutubeCustomActivity() {

    companion object {
        private val VIDEO_ID: String = "id"

        fun getStartIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, VideoActivity::class.java)
            intent.putExtra(VIDEO_ID, id)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        setUp()
    }

    override fun setUp() {
        fragmentManager.let {
            val id = intent.getIntExtra(VIDEO_ID, -1)
            if (id != -1)
                ActivityUtils.addFragmentToActivity(fragmentManager,
                        VideoFragment.newInstance(id))
        }
    }


}
