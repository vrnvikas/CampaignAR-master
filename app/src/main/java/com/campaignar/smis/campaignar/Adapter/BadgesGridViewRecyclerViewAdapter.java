package com.campaignar.smis.campaignar.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.campaignar.smis.campaignar.R;

/**
 * Created by Vikas Kumar on 01-10-2016.
 */

public class BadgesGridViewRecyclerViewAdapter extends
        RecyclerView.Adapter<BadgesGridViewRecyclerViewAdapter.BadgesViewHolder> {

    Context context;
    String[] badgesNames;
    String[] badgesInfo;
    String[] badgesEarned;

    public BadgesGridViewRecyclerViewAdapter(Context context,String[] badgesNameList,String[] badgesInfoList){
        this.context = context;
        badgesNames = badgesNameList;
        badgesInfo = badgesInfoList;
    }

    @Override
    public BadgesGridViewRecyclerViewAdapter.BadgesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.custom_row_badges_view, parent, false);

        // Return a new holder instance
        BadgesViewHolder viewHolder = new BadgesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BadgesGridViewRecyclerViewAdapter.BadgesViewHolder holder, int position) {

        holder.tvBadgesName.setText(badgesNames[position]);
        holder.tvBadgesInfo.setText(badgesInfo[position]);

    }

    @Override
    public int getItemCount() {
        return badgesNames.length;
    }

    public class BadgesViewHolder extends RecyclerView.ViewHolder {

        TextView tvBadgesName,tvBadgesInfo;


        public BadgesViewHolder(View itemView) {
            super(itemView);
            tvBadgesName = (TextView) itemView.findViewById(R.id.tvBadgeName);
            tvBadgesInfo = (TextView) itemView.findViewById(R.id.tvBadgeInfo);
        }
    }
}
