package com.campaignar.smis.campaignar.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.campaignar.smis.campaignar.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentPostQuestion.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentPostQuestion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPostQuestion extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView tvUpvote,tvVoted;
    private ImageView ivUpvote,ivVoted;
    private static boolean voted = false;
    private static boolean upVote = false;

    private OnFragmentInteractionListener mListener;

    public FragmentPostQuestion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentPostQuestion.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPostQuestion newInstance(String param1, String param2) {
        FragmentPostQuestion fragment = new FragmentPostQuestion();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.post_question, container, false);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvUpvote = (TextView) view.findViewById(R.id.tvUpvote);
        tvVoted = (TextView) view.findViewById(R.id.tvVoted);
        ivUpvote = (ImageView) view.findViewById(R.id.ivUparrow);
        ivVoted = (ImageView) view.findViewById(R.id.ivUparrowsecond);


        tvUpvote.setOnClickListener(this);
        tvVoted.setOnClickListener(this);
        ivVoted.setOnClickListener(this);
        ivUpvote.setOnClickListener(this);


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onLoadFragmentLiveDiscussion();
        }
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

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tvVoted:
                if(!voted){
                    tvVoted.setTextColor(getActivity().getResources().getColor(R.color.colorAccent));
                    ivVoted.setImageResource(R.drawable.upvote_active_54);
                    voted = true;
                }else {
                    tvVoted.setTextColor(getActivity().getResources().getColor(R.color.gray_40));
                    ivVoted.setImageResource(R.drawable.upvote_54);
                    voted = false;
                }
                break;
            case R.id.tvUpvote:
                if(!upVote){
                    tvUpvote.setTextColor(getActivity().getResources().getColor(R.color.colorAccent));
                    ivUpvote.setImageResource(R.drawable.upvote_active_54);
                    upVote = true;
                }else {
                    tvUpvote.setTextColor(getActivity().getResources().getColor(R.color.gray_40));
                    ivUpvote.setImageResource(R.drawable.upvote_54);
                    upVote = false;
                }
                break;
            case R.id.ivUparrow:
                break;
            case R.id.ivUparrowsecond:
                break;
        }

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onLoadFragmentLiveDiscussion();
    }
}
