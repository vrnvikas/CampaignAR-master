package com.campaignar.smis.campaignar.Fragments;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.campaignar.smis.campaignar.Adapter.LiveDiscussionRecyclerViewAdapter;
import com.campaignar.smis.campaignar.R;


public class FragmentLiveDiscussion extends Fragment {

    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private TypedArray imagesList;
    private LiveDiscussionRecyclerViewAdapter adapter;

    public FragmentLiveDiscussion() {
        // Required empty public constructor
    }

    public static FragmentLiveDiscussion newInstance() {
        FragmentLiveDiscussion fragment = new FragmentLiveDiscussion();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_live_discussion, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.live_discussion_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        imagesList = getResources().obtainTypedArray(R.array.images_live_discussion);
        adapter = new LiveDiscussionRecyclerViewAdapter(getActivity(), imagesList, mListener);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onLoadFramentPostQuestion();
    }
}
