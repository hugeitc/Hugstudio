package com.hugstudio.chuyenbenlycafe;

import android.os.Bundle;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class YoutubeFragment extends YouTubePlayerSupportFragment implements YouTubePlayer.OnInitializedListener{

	private String videoID;
	private String videoTitle;
	public YoutubeFragment() {
		// TODO Auto-generated constructor stub
	}
	
	/**
     * Returns a new instance of this Fragment
     *
     * @param videoId The ID of the video to play
     */
    public static YoutubeFragment newInstance(final String videoID, final String videoTitle) {
        final YoutubeFragment youTubeFragment = new YoutubeFragment();
        final Bundle bundle = new Bundle();
        bundle.putString("videoID", videoID);
        bundle.putString("videoTitle", videoTitle);
        youTubeFragment.setArguments(bundle);
        return youTubeFragment;
    }
    
    @Override
    public void onCreate(Bundle bundle){
    	super.onCreate(bundle);
    	Bundle arguments = getArguments();
    	if (bundle != null && bundle.containsKey("videoID")) {
            videoID = bundle.getString("videoID");
            videoTitle = bundle.getString("videoTitle");
        } else if (arguments != null && arguments.containsKey("videoID")) {
            videoID = arguments.getString("videoID");
            videoTitle = arguments.getString("videoTitle");
        }

        initialize(getString(R.string.DEV_KEY), this);
    }

	@Override
	public void onInitializationFailure(Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
		// TODO Auto-generated method stub
		if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(getActivity(), 0).show();
        } else {
            //Handle the failure
            Toast.makeText(getActivity(), R.string.error_init_failure, Toast.LENGTH_LONG).show();
        }
	}

	@Override
	public void onInitializationSuccess(Provider provider, YouTubePlayer youTubePlayer, boolean restored) {
		// TODO Auto-generated method stub
		
		//Here we can set some flags on the player

        //This flag tells the player to switch to landscape when in fullscreen, it will also return to portrait
        //when leaving fullscreen
        youTubePlayer.setFullscreenControlFlags(YouTubePlayer.FULLSCREEN_FLAG_CONTROL_ORIENTATION);

        //This flag tells the player to automatically enter fullscreen when in landscape. Since we don't have
        //landscape layout for this activity, this is a good way to allow the user rotate the video player.
        youTubePlayer.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE);

        //This flag controls the system UI such as the status and navigation bar, hiding and showing them
        //alongside the player UI
        youTubePlayer.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_CONTROL_SYSTEM_UI);
        
		if(videoID!=null){
			if(restored){
				youTubePlayer.play();
			}
			else{
				youTubePlayer.loadVideo(videoID);
			}
		}
	}

	public String getVideoID() {
		return videoID;
	}

	public void setVideoID(String videoID) {
		this.videoID = videoID;
		initialize(getString(R.string.DEV_KEY), this);
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

}
