package com.example.ryanzhouold.bakingandroid.ui.base;

import androidx.fragment.app.Fragment;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment{

    private Unbinder mUnBinder;
    protected void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        mUnBinder.unbind();
    }
}

