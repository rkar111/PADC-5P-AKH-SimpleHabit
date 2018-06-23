package xyz.arkarhein.padc_5p_akh_simplehabit.mvp.presenters;

import xyz.arkarhein.padc_5p_akh_simplehabit.mvp.views.BaseView;

public abstract class BasePresenter<T extends BaseView> {

    protected T mView;  //T is a place holder.

    public BasePresenter(T mView) {
        this.mView = mView;
    }

    public void onCreate() {

    }

    public void onStart() {

    }

    public void onResume() {

    }

    public void onPause() {

    }

    public void onStop() {
    }

    public void onDestroy() {

    }


}

