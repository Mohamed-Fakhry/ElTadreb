package com.example.computec.eltadreb.ui.video

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.computec.eltadreb.R
import com.example.computec.eltadreb.model.Comment
import com.example.computec.eltadreb.model.Video
import com.example.computec.eltadreb.ui.base.BaseYoutubeFragment
import com.example.computec.eltadreb.ui.video.adapter.CommentsAdapter
import com.example.computec.eltadreb.ui.video.listener.PlaybackEvent
import com.example.computec.eltadreb.ui.video.listener.PlayerStatusChange
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.fragment_video.*

class VideoFragment : BaseYoutubeFragment(), YouTubePlayer.OnInitializedListener, VideoContract.View {

    companion object {
        val API_Key: String = "AIzaSyDGfzDnE2jcKQXMPpzE5w_opjclr3Dej6Q"
        val VIDEO_ID: String = "id"

        fun newInstance(id: Int): VideoFragment {
            val videoFragment = VideoFragment()
            val bundle = Bundle()
            bundle.putInt(VIDEO_ID, id)
            videoFragment.arguments = bundle
            return videoFragment
        }
    }

    lateinit var video: Video
    lateinit var commentsAdapter: CommentsAdapter
    lateinit var videoPresenter: VideoContract.Presenter<VideoFragment>

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_video, container, false)

    override fun onStart() {
        super.onStart()
        setUp(null)
    }

    override fun setUp(view: View?) {
        videoPresenter = VideoPresenter()
        videoPresenter.onAttach(this)
        videoPresenter.getVideo(arguments.getInt(VIDEO_ID))

        scrollView?.post { scrollView.fullScroll(View.FOCUS_UP); }
        commentsRV?.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.VERTICAL, false)
        sendIV.setOnClickListener({
            val comment = Comment(content = commentET.text.toString())
            videoPresenter.setComment(comment, video.id)
        })
    }

    override fun onInitializationSuccess(provider: YouTubePlayer.Provider?
                                         , player: YouTubePlayer?, wasRestored: Boolean) {
        val playerStateChange = PlayerStatusChange()
        player?.setPlayerStateChangeListener(playerStateChange)
        val playbackEvent = PlaybackEvent()
        player?.setPlaybackEventListener(playbackEvent)

        if (!wasRestored) {
            player?.cueVideo(video.video)
        }
    }

    override fun onInitializationFailure(provider: YouTubePlayer.Provider?
                                         , player: YouTubeInitializationResult?) {
    }

    override fun setVideoView(video: Video) {
        this.video = video
        videoView?.initialize(API_Key, this)
        with(video) {
            titleTV.text = title
            descriptionTV.text = description
        }
        fabAction()
    }

    override fun addComment(comment: Comment) {
        video.comments?.add(comment)
        commentsAdapter.notifyDataSetChanged()
    }

    private fun fabAction() {
        fab.setOnClickListener {
            if (commentLL.visibility == View.GONE) {
                commentLL.visibility = View.VISIBLE
            } else if (commentLL.visibility == View.VISIBLE) {
                commentLL.visibility = View.GONE
            }
        }
    }

    override fun setVideoCommentView(comments: MutableList<Comment>) {
        commentsAdapter = CommentsAdapter(comments)
        commentsRV?.adapter = commentsAdapter
    }
}