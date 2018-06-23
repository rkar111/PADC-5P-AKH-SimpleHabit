package xyz.arkarhein.padc_5p_akh_simplehabit.fragments;

import android.content.Context;
import android.content.Intent;
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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.activities.ItemDetailsActivity;
import xyz.arkarhein.padc_5p_akh_simplehabit.adapters.BaseViewAdapter;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.HomeScreenVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.ProgramVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.models.SimpleHabitsModel;
import xyz.arkarhein.padc_5p_akh_simplehabit.delegates.CategoryDelegate;
import xyz.arkarhein.padc_5p_akh_simplehabit.delegates.CurrentProgramDelegate;
import xyz.arkarhein.padc_5p_akh_simplehabit.events.RestApiEvent;
import xyz.arkarhein.padc_5p_akh_simplehabit.events.SuccessEvent;
import xyz.arkarhein.padc_5p_akh_simplehabit.mvp.presenters.SeriesPresenter;
import xyz.arkarhein.padc_5p_akh_simplehabit.mvp.views.SeriesView;

public class SeriesFragment extends Fragment implements SeriesView {

    @BindView(R.id.rv_item_view)
    RecyclerView rvItemView;

    private BaseViewAdapter mBaseViewAdapter;
    private SeriesPresenter mSeriesPresenter;


    private CurrentProgramDelegate currentProgramDelegate;
    private CategoryDelegate categoryDelegate;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        ButterKnife.bind(this, view);
        mSeriesPresenter = new SeriesPresenter(this);
        mSeriesPresenter.onCreate();


        mBaseViewAdapter = new BaseViewAdapter(getContext(), mSeriesPresenter,mSeriesPresenter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()
                , LinearLayoutManager.VERTICAL, false);
        rvItemView.setAdapter(mBaseViewAdapter);
        rvItemView.setLayoutManager(linearLayoutManager);


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
        mSeriesPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mSeriesPresenter.onStop();
    }

    @Override
    public void displayErrorMsg(String errorMsg) {
        Snackbar.make(rvItemView, errorMsg, Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void displaySessionList(List<HomeScreenVO> mData) {
        mBaseViewAdapter.setNewData(mData);
    }

    @Override
    public void launchCurrent(String programId) {
        Intent intent = ItemDetailsActivity.newIntentCurrentProgram(getContext());
        startActivity(intent);
    }

    @Override
    public void launchCategory(String programId, String categoryId) {
        Intent intent = ItemDetailsActivity.newIntentCategoryProgram(getContext(), programId, categoryId);
        startActivity(intent);
    }
}
