package com.campaignar.smis.campaignar.Adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.campaignar.smis.campaignar.R;

/**
 * Created by Vikas Kumar on 03-10-2016.
 */

public class GallaryGridViewRecyclerViewAdapter extends
        RecyclerView.Adapter<GallaryGridViewRecyclerViewAdapter.GallaryViewHolder> {

    private Context mContext;
    private TypedArray imagesList;

    public GallaryGridViewRecyclerViewAdapter(Context context, TypedArray imagesList){
        mContext = context;
        this.imagesList = imagesList;

    }

    @Override
    public GallaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.custom_row_gallary_view, parent, false);

        GallaryViewHolder holder = new GallaryViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(GallaryViewHolder holder, int position) {

        holder.imageView.setImageResource(imagesList.getResourceId(position,-1));

    }

    @Override
    public int getItemCount() {
        return imagesList.length();
    }

    public class GallaryViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        public GallaryViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.ivGallary);
        }
    }
}
