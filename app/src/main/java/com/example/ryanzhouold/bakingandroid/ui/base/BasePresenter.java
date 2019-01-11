package com.example.ryanzhouold.bakingandroid.ui.base;

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */

public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T>{
    protected T mView;
    @Override
    public void onAttachTo(T view) {
        mView = view;
    }

    @Override
    public void onDetach() {
        mView = null;
    }
}
