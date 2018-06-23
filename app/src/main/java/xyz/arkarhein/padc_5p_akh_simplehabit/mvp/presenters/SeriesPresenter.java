package xyz.arkarhein.padc_5p_akh_simplehabit.mvp.presenters;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import xyz.arkarhein.padc_5p_akh_simplehabit.data.CurrentVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.models.SimpleHabitsModel;
import xyz.arkarhein.padc_5p_akh_simplehabit.delegates.CategoryDelegate;
import xyz.arkarhein.padc_5p_akh_simplehabit.delegates.CurrentProgramDelegate;
import xyz.arkarhein.padc_5p_akh_simplehabit.events.RestApiEvent;
import xyz.arkarhein.padc_5p_akh_simplehabit.events.SuccessEvent;
import xyz.arkarhein.padc_5p_akh_simplehabit.mvp.views.SeriesView;

public class SeriesPresenter extends BasePresenter<SeriesView> implements CurrentProgramDelegate, CategoryDelegate {



    public SeriesPresenter(SeriesView mView) {
        super(mView);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SimpleHabitsModel.getsObjInstance().loadData();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataLoaded(SuccessEvent event) {
        if (event.getmData() == null) {
            mView.displayErrorMsg("Empty Data");
        } else {
            mView.displaySessionList(event.getmData());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorAPIInvoking(RestApiEvent.ErrorInvokingAPIEvent errorInvokingAPIEvent) {
        mView.displayErrorMsg(errorInvokingAPIEvent.getErrorMessage());
    }

    @Override
    public void onTapCategory(String categoryId, String categoryProgramId) {
        mView.launchCategory(categoryId, categoryProgramId);
    }

    @Override
    public void onTapCurrentProgram(CurrentVO currentVO) {
        mView.launchCurrent(currentVO.getProgramId());
    }
}
