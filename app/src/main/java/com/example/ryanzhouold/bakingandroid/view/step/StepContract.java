package com.example.ryanzhouold.bakingandroid.view.step;

import com.example.ryanzhouold.bakingandroid.presenter.BasePresenter;
import com.example.ryanzhouold.bakingandroid.presenter.BaseView;
import com.example.ryanzhouold.bakingandroid.model.dto.Step;

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
