package com.campaignar.smis.campaignar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.campaignar.smis.campaignar.Activity.YourInterestsDetail;
import com.campaignar.smis.campaignar.R;

/**
 * Created by Vikas Kumar on 30-09-2016.
 */

public class YourInterestsRecyclerViewAdapter extends
        RecyclerView.Adapter<YourInterestsRecyclerViewAdapter.YourInterestsViewHolder> {

    private FragmentActivity mContext;
    private TypedArray imagesList;

    public YourInterestsRecyclerViewAdapter(FragmentActivity context, TypedArray imagesList){
        mContext = context;
        this.imagesList = imagesList;
    }

    @Override
    public YourInterestsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.custom_row_your_interests, parent, false);

        // Return a new holder instance
        YourInterestsViewHolder viewHolder = new YourInterestsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(YourInterestsViewHolder holder, int position) {

        holder.imageView.setImageResource(imagesList.getResourceId(position,-1));

        switch (position){
            case 0:
                holder.imageViewHover.setBackgroundColor(mContext.getResources().getColor(R.color.green));
                holder.textViewTopic.setText("AGRICULTURE");
                break;
            case 1:
                holder.imageViewHover.setBackgroundColor(mContext.getResources().getColor(R.color.purple));
                holder.textViewTopic.setText("BUSINESS");
                break;
            case 2:
                holder.imageViewHover.setBackgroundColor(mContext.getResources().getColor(R.color.orange));
                holder.textViewTopic.setText("EDUCATION");
                break;
            case 3:
                holder.imageViewHover.setBackgroundColor(mContext.getResources().getColor(R.color.red));
                holder.textViewTopic.setText("HEALTH");
                break;
            default:
                holder.imageViewHover.setBackgroundColor(mContext.getResources().getColor(R.color.green));
                break;
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    private Context getContext() {
        return mContext;
    }

    public class YourInterestsViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView,imageViewHover;
        TextView textViewTopic;

        public YourInterestsViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.ivInterest);
            imageViewHover = (ImageView) itemView.findViewById(R.id.ivhover);
            textViewTopic = (TextView) itemView.findViewById(R.id.tvTopic);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getContext().startActivity(new Intent(getContext(), YourInterestsDetail.class));
                }
            });
        }
    }
}
