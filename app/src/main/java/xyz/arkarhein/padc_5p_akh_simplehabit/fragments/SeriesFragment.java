package xyz.arkarhein.padc_5p_akh_simplehabit.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.adapters.BaseViewAdapter;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.models.SimpleHabitsModel;
import xyz.arkarhein.padc_5p_akh_simplehabit.delegates.CategoryDelegate;
import xyz.arkarhein.padc_5p_akh_simplehabit.delegates.CurrentProgramDelegate;
import xyz.arkarhein.padc_5p_akh_simplehabit.events.RestApiEvent;
import xyz.arkarhein.padc_5p_akh_simplehabit.events.SuccessEvent;

public class SeriesFragment extends Fragment {

    @BindView(R.id.rv_item_view)
    RecyclerView rvItemView;

    private BaseViewAdapter mBaseViewAdapter;

    private CurrentProgramDelegate mCurrentProgramDelegate;

    private CategoryDelegate mCategoryDelegate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        ButterKnife.bind(this, view);

        mBaseViewAdapter = new BaseViewAdapter(getContext(), mCurrentProgramDelegate, mCategoryDelegate);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()
                , LinearLayoutManager.VERTICAL, false);
        rvItemView.setAdapter(mBaseViewAdapter);
        rvItemView.setLayoutManager(linearLayoutManager);


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCurrentProgramDelegate = (CurrentProgramDelegate) context;
        mCategoryDelegate = (CategoryDelegate) context;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataLoaded(SuccessEvent event) {
        mBaseViewAdapter.setNewData(event.getmData());
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorInvokingAPI(RestApiEvent.ErrorInvokingAPIEvent event) {
        Snackbar.make(rvItemView, event.getErrorMessage(), Snackbar.LENGTH_INDEFINITE).show();
    }
}
