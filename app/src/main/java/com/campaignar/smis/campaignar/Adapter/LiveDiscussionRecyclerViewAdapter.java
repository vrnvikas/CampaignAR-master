package com.campaignar.smis.campaignar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.campaignar.smis.campaignar.Fragments.FragmentLiveDiscussion;
import com.campaignar.smis.campaignar.R;

/**
 * Created by Vikas Kumar on 03-10-2016.
 */

public class LiveDiscussionRecyclerViewAdapter extends
        RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static final int ITEM_TYPE_NORMAL = 1;
    public static final int ITEM_TYPE_HEADER = 0;
    private final FragmentLiveDiscussion.OnFragmentInteractionListener mListener;
    private Context mContext;
    private TypedArray imagesList;

    public LiveDiscussionRecyclerViewAdapter(Context context, TypedArray imagesList, FragmentLiveDiscussion.OnFragmentInteractionListener mListener) {
        mContext = context;
        this.imagesList = imagesList;
        this.mListener = mListener;
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_TYPE_HEADER;
        } else {
            return ITEM_TYPE_NORMAL;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == ITEM_TYPE_NORMAL) {
            View normalView = LayoutInflater.from(mContext).inflate(R.layout.custom_row_live_discussion_small, null);
            return new LiveDiscussionViewHolderNormal(normalView);
        } else if (viewType == ITEM_TYPE_HEADER) {
            View headerRow = LayoutInflater.from(mContext).inflate(R.layout.custom_row_live_discussion_big, null);
            return new LiveDiscussionViewHolderHeader(headerRow);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final int itemType = getItemViewType(position);

        if (itemType == ITEM_TYPE_NORMAL) {
            ((LiveDiscussionViewHolderNormal) holder).setData(imagesList.getResourceId(position, -1));
        } else if (itemType == ITEM_TYPE_HEADER) {
            ((LiveDiscussionViewHolderHeader) holder).setData(imagesList.getResourceId(position, -1));
        }

    }


    @Override
    public int getItemCount() {
        return imagesList.length();
    }

    public class LiveDiscussionViewHolderNormal extends RecyclerView.ViewHolder {

        private LinearLayout view;

        public LiveDiscussionViewHolderNormal(View itemView) {
            super(itemView);
            view = (LinearLayout) itemView.findViewById(R.id.parent);
        }

        public void setData(int resourceId) {
            view.setBackgroundResource(resourceId);
        }

    }


    public class LiveDiscussionViewHolderHeader extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView, ivShare;
        private TextView tvPostQuestion;

        public LiveDiscussionViewHolderHeader(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.ivLiveDiscussion);
            tvPostQuestion = (TextView) itemView.findViewById(R.id.tvPostQuestion);
            ivShare = (ImageView) itemView.findViewById(R.id.ivShare);

            ivShare.setOnClickListener(this);
            tvPostQuestion.setOnClickListener(this);


        }

        public void setData(int resourceId) {
            imageView.setImageResource(resourceId);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.ivShare) {
                Share();
            }
            if (v.getId() == R.id.tvPostQuestion) {
                mListener.onLoadFramentPostQuestion();
            }
        }

        private void Share() {

            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Bhar");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
            mContext.startActivity(Intent.createChooser(sharingIntent, "Share via"));

        }
    }
}
