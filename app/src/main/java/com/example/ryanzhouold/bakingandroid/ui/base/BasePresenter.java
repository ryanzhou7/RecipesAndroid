package com.example.ryanzhouold.bakingandroid.ui.base;

/**
 * Every presenter in the app must either implement this interface or extend Presenter
 * indicating the MvpView type that wants to be attached with.
 */

public class BasePresenter<T extends BaseContract.View> implements BaseContract.Presenter<T> {
    protected T mView;
    public void onAttachTo(T view) {
        mView = view;
    }

    @Override
    public void onDetach() {
        mView = null;
    }
}
