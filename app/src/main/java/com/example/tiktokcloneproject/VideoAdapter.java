package com.example.tiktokcloneproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<Video> videos;
    Context context;

    public VideoAdapter(Context context, List<Video> videos) {
        this.context = context;
        this.videos = videos;
    }

    public void addVideoObject(Video video) {
        this.videos.add(video);
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.video_container, parent, false ));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoObjects(videos.get(position));
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder {

        VideoView videoView;
        TextView txvDescription, txvTitle;
        ImageView imvComment;
        ProgressBar pgbWait;


        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            txvTitle = itemView.findViewById(R.id.txvTitle);
            txvDescription = itemView.findViewById(R.id.txvDescription);
            imvComment = itemView.findViewById(R.id.imvComment);
            pgbWait = itemView.findViewById(R.id.pgbWait);

        }

        @SuppressLint("ClickableViewAccessibility")
        public void setVideoObjects(final Video videoObjects) {
            txvTitle.setText("@" + videoObjects.getAuthorId().trim());
            txvDescription.setText(videoObjects.getDescription());
            imvComment = itemView.findViewById(R.id.imvComment);
            videoView.setVideoPath(videoObjects.getUrl());

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    pgbWait.setVisibility(View.GONE);
                    mediaPlayer.start();
                }
            });

            videoView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if(videoView.isPlaying()) {
                        videoView.pause();
                        return false;
                    }
                    else {
                        videoView.start();
                        return false;
                    }
                }
            });

            imvComment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), CommentActivity.class);
                    view.getContext().startActivity(intent);
                }
            });
        }
    } // class ViewHolder


}// class adapter
