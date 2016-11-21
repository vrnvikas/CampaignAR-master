package com.campaignar.smis.campaignar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.campaignar.smis.campaignar.Activity.YouTubePlayerActivity;
import com.campaignar.smis.campaignar.R;

/**
 * Created by Vikas Kumar on 30-09-2016.
 */

public class VideoGalleryRecyclerViewAdapter extends
        RecyclerView.Adapter<VideoGalleryRecyclerViewAdapter.VideoGalleryViewHolder> {

    private Context mContext;
    private TypedArray typedArray;

    public VideoGalleryRecyclerViewAdapter(Context context) {
        mContext = context;
        typedArray = context.getResources().obtainTypedArray(R.array.images_video_gallary);
    }

    @Override
    public VideoGalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.custom_row_video_gallery, parent, false);

        // Return a new holder instance
        VideoGalleryViewHolder viewHolder = new VideoGalleryViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VideoGalleryViewHolder holder, int position) {

        holder.ivVideoImage.setImageResource(typedArray.getResourceId(position,-1));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    private Context getContext() {
        return mContext;
    }

    public class VideoGalleryViewHolder extends RecyclerView.ViewHolder {

        ImageView ivVideoImage;

        public VideoGalleryViewHolder(View itemView) {
            super(itemView);

            ivVideoImage = (ImageView) itemView.findViewById(R.id.ivImageVideo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    YouTubePlayerActivity.VIDEO_ID = "iYblfAJx22k";
                    getContext().startActivity(new Intent(getContext(), YouTubePlayerActivity.class));
                }
            });


        }
    }
}
