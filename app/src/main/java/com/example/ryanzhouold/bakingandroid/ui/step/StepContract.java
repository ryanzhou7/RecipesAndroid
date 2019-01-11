package com.example.ryanzhouold.bakingandroid.ui.step;

import com.example.ryanzhouold.bakingandroid.ui.base.BaseContract;
import com.example.ryanzhouold.bakingandroid.ui.base.BasePresenter;
import com.example.ryanzhouold.bakingandroid.data.dto.StepDto;

public interface StepContract {
    interface Presenter<V extends View> extends BaseContract.Presenter<V>{
        void prevStepFrom(int pos);
        void nextStepFrom(int pos);
    }

    interface View extends BaseContract.View {
        void showStep(StepDto stepDto);
        void showMessage(String message);
    }
}
