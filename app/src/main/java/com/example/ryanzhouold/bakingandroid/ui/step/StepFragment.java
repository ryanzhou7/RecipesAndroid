package com.example.ryanzhouold.bakingandroid.ui.step;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import butterknife.BindBool;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ryanzhouold.bakingandroid.R;
import com.example.ryanzhouold.bakingandroid.data.constants.Keys;
import com.example.ryanzhouold.bakingandroid.data.dto.StepDto;
import com.example.ryanzhouold.bakingandroid.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;


public class StepFragment extends BaseFragment implements StepContract.View{

    @BindView(R.id.button_previous) Button mNextStep;
    @BindView(R.id.button_next) Button mPrevStep;
    @BindView(R.id.textViewStep) TextView mTextViewStep;
    private boolean mIsTwoPane = false;
    private StepPresenter mStepPresenter;
    private List<StepDto> mStepDtos;


    public StepFragment() {
        // Required empty public constructor
    }

    public static StepFragment newInstance(boolean isTwoPane, List<StepDto> stepDtos){
        StepFragment fragment = new StepFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(Keys.IS_TWO_PANE_KEY, isTwoPane);
        bundle.putParcelableArrayList(Keys.STEPS_KEY, (ArrayList<? extends Parcelable>) stepDtos);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            mIsTwoPane = getArguments().getBoolean(Keys.IS_TWO_PANE_KEY);
            mStepDtos = getArguments().getParcelableArrayList(Keys.STEPS_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        mStepPresenter = new StepPresenter(this, mStepDtos);
        showStep(mStepDtos.get(0));
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
    public void showStep(StepDto stepDto) {
        mTextViewStep.setText(stepDto.toString());
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
