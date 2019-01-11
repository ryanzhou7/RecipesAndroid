package com.example.ryanzhouold.bakingandroid.ui.base;

public class BaseContract {
    public interface BasePresenter<V extends BaseView>{
        void onAttachTo(V view);
        void onDetach();
    }
    public interface BaseView{
    }
}
