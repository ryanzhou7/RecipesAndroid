package com.example.ryanzhouold.bakingandroid.view.step;

import com.example.ryanzhouold.bakingandroid.BasePresenter;
import com.example.ryanzhouold.bakingandroid.BaseView;
import com.example.ryanzhouold.bakingandroid.model.dto.StepDto;

public interface StepContract {
    interface Presenter extends BasePresenter{
        void prevStepFrom(int pos);
        void nextStepFrom(int pos);
    }

    interface View extends BaseView<Presenter>{
        void showStep(StepDto stepDto);
        void showMessage(String message);
    }
}
