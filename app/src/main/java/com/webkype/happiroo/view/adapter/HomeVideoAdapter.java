package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.webkype.happiroo.R;
import com.webkype.happiroo.model.CategoryModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeVideoAdapter extends RecyclerView.Adapter<HomeVideoAdapter.ViewHolder> {

    private Context context;
    private List<CategoryModel> stripCatList;

    public HomeVideoAdapter(Context context, List<CategoryModel> stripCatList){
        this.context = context;
        this.stripCatList = stripCatList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(context).inflate(R.layout.strip_video_item, parent, false);
       return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CategoryModel stripCatItem = stripCatList.get(position);


        if (!TextUtils.isEmpty(stripCatItem.getName()))
        {
            setHeaderVideoView(holder.playerView, holder.pbVideo,stripCatItem.getName());
        }else {
            Glide.with(context).load(stripCatItem.getImage())
                    .thumbnail(Glide.with(context).load(R.drawable.image_placeholder))
                    .into(holder.stripCatImageItem);
        }

        holder.stripCatLayoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent intent = new Intent(context, ServiceDetailActivity.class);
//                intent.putExtra("catId",stripCatItem.getCatId());
//                context.startActivity(intent);
            }
        });
    }
    private void setHeaderVideoView(PlayerView headerVideoPlayer,ProgressBar pbVideo,String videoLink) {
        final String TAG="ADAPTER VUDEO";
        Uri uri = Uri.parse(videoLink);
        MediaItem mediaItem = MediaItem.fromUri(uri);
        SimpleExoPlayer player = new SimpleExoPlayer.Builder(context).build();
        headerVideoPlayer.setPlayer(player);
        player.addMediaItem(mediaItem);
        player.addListener(new Player.EventListener() {
            @Override
            public void onPlaybackStateChanged(int playbackState) {
                String stateString;
                switch (playbackState) {
                    case ExoPlayer.STATE_IDLE:
                        stateString = "ExoPlayer.STATE_IDLE      -";
                        break;
                    case ExoPlayer.STATE_BUFFERING:
//                        pbVideo.setVisibility(View.VISIBLE);
                        stateString = "ExoPlayer.STATE_BUFFERING -";
                        break;
                    case ExoPlayer.STATE_READY:
//                        pbVideo.setVisibility(View.GONE);
                         headerVideoPlayer.setVisibility(View.VISIBLE);
                        player.setRepeatMode(Player.REPEAT_MODE_ALL);
                        stateString = "ExoPlayer.STATE_READY     -";
                        break;
                    case ExoPlayer.STATE_ENDED:
//                        pbVideo.setVisibility(View.GONE);
                        stateString = "ExoPlayer.STATE_ENDED     -";
                        break;
                    default:
                        stateString = "UNKNOWN_STATE             -";
                        break;
                }
                Log.d(TAG, "changed state to " + stateString);
            }
        });
        player.prepare();
        player.setVolume(0f);
        player.setPlayWhenReady(true);

//        binding.headerVideoPlayer.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_ZOOM);
//        player.setVideoScalingMode(C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
        /* binding.rlIndicatorHolder.setVisibility(View.GONE);
                binding.serviceDetailViewPager.setVisibility(View.GONE);
                binding.headerVideoPlayer.setVisibility(View.VISIBLE);*/
    }


    @Override
    public int getItemCount() {
        return (stripCatList != null ? stripCatList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.stripCatLayoutItem)
        ConstraintLayout stripCatLayoutItem;
        @BindView(R.id.pbVideo)
        ProgressBar pbVideo;
        @BindView(R.id.stripCatImageItem) ImageView stripCatImageItem;
        @BindView(R.id.headerVideoPlayer)
        PlayerView playerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
