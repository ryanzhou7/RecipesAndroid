package com.example.ryanzhouold.bakingandroid.ui.step;

import com.example.ryanzhouold.bakingandroid.ui.base.BasePresenter;
import com.example.ryanzhouold.bakingandroid.ui.base.BaseView;
import com.example.ryanzhouold.bakingandroid.data.dto.StepDto;

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
