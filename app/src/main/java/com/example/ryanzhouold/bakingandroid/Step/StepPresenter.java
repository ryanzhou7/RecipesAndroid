package com.example.ryanzhouold.bakingandroid.Step;

import com.example.ryanzhouold.bakingandroid.modelLayer.pojo.Step;

import java.util.List;

public class StepPresenter implements StepContract.Presenter{

    private StepContract.View mView;
    private List<Step> mSteps;

    public StepPresenter(StepContract.View view, List<Step> steps){
        mView = view;
        mSteps = steps;
    }

    @Override
    public void start() {

    }

    @Override
    public void prevStepFrom(int pos) {
        if(pos<=0){
            mView.showMessage("You are at the first step");
        }
        else{
            mView.showStep(mSteps.get(pos-1));
        }
    }

    @Override
    public void nextStepFrom(int pos) {
        if(pos>=mSteps.size()){
            mView.showMessage("You are at the last step");
        }
        else{
            mView.showStep(mSteps.get(pos+1));
        }
    }

}
