package com.example.ryanzhouold.bakingandroid.ui.step;

import com.example.ryanzhouold.bakingandroid.ui.base.BasePresenter;
import com.example.ryanzhouold.bakingandroid.data.dto.StepDto;

public interface StepContract {
    interface Presenter{
        void prevStepFrom(int pos);
        void nextStepFrom(int pos);
    }

    interface View{
        void showStep(StepDto stepDto);
        void showMessage(String message);
    }
}
