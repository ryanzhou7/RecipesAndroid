package com.example.ryanzhouold.bakingandroid.ui.base;

public class BaseContract {
    public interface Presenter<V extends View>{
        void onAttachTo(V view);
        void onDetach();
    }
    public interface View<P> {
        //setPresenter(P p) , with <P> if need access to presenter
        //void setPresenter(P p);
    }
}
