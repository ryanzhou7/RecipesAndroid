package com.example.ryanzhouold.bakingandroid.view.step;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ryanzhouold.bakingandroid.R;
import com.example.ryanzhouold.bakingandroid.model.constants.Keys;
import com.example.ryanzhouold.bakingandroid.model.dto.Step;

import java.util.ArrayList;
import java.util.List;


public class StepFragment extends Fragment implements StepContract.View{
    private StepPresenter mStepPresenter;
    private Button mNextStep;
    private Button mPrevStep;
    private TextView mTextViewStep;
    private boolean mIsTwoPane = false;
    private List<Step> mSteps;


    public StepFragment() {
        // Required empty public constructor
    }

    public static StepFragment newInstance(boolean isTwoPane, List<Step> steps){
        StepFragment fragment = new StepFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(Keys.IS_TWO_PANE_KEY, isTwoPane);
        bundle.putParcelableArrayList(Keys.STEPS_KEY, (ArrayList<? extends Parcelable>) steps);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            mIsTwoPane = getArguments().getBoolean(Keys.IS_TWO_PANE_KEY);
            mSteps = getArguments().getParcelableArrayList(Keys.STEPS_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step, container, false);
        mPrevStep = view.findViewById(R.id.button_previous);
        mNextStep = view.findViewById(R.id.button_next);
        mTextViewStep = view.findViewById(R.id.textViewStep);
        mStepPresenter = new StepPresenter(this, mSteps);
        showStep(mSteps.get(0));
        mPrevStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mListener.prevRecipe(mStep.getId());
            }
        });
        mNextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mListener.nextRecipe(mStep.getId());
            }
        });
        return view;
    }

    @Override
    public void setPresenter(StepContract.Presenter presenter) {
    }

    @Override
    public void showStep(Step step) {
        mTextViewStep.setText(step.toString());
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
