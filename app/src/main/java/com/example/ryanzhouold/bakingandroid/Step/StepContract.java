package com.example.ryanzhouold.bakingandroid.Step;

import com.example.ryanzhouold.bakingandroid.BasePresenter;
import com.example.ryanzhouold.bakingandroid.BaseView;
import com.example.ryanzhouold.bakingandroid.modelLayer.pojo.Step;

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
