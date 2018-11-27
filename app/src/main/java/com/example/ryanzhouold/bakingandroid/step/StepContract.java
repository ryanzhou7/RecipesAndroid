package com.example.ryanzhouold.bakingandroid.step;

import com.example.ryanzhouold.bakingandroid.baseContract.BasePresenter;
import com.example.ryanzhouold.bakingandroid.baseContract.BaseView;
import com.example.ryanzhouold.bakingandroid.data.entity.Step;

public interface StepContract {
    interface Presenter extends BasePresenter{
        void prevStepFrom(int pos);
        void nextStepFrom(int pos);
    }

    interface View extends BaseView<Presenter>{
        void showStep(Step step);
        void showMessage(String message);
    }
}
