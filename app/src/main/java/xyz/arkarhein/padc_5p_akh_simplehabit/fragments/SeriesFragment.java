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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.activities.ItemDetailsActivity;
import xyz.arkarhein.padc_5p_akh_simplehabit.adapters.BaseViewAdapter;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.HomeScreenVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.delegates.CurrentProgramDelegate;
import xyz.arkarhein.padc_5p_akh_simplehabit.delegates.HomeScreenDelegate;
import xyz.arkarhein.padc_5p_akh_simplehabit.mvp.presenters.HomeScreenPresenter;
import xyz.arkarhein.padc_5p_akh_simplehabit.mvp.views.HomeScreenView;

public class SeriesFragment extends Fragment {

    @BindView(R.id.rv_item_view)
    RecyclerView rvItemView;

    private HomeScreenPresenter mPresenter;

    private BaseViewAdapter mBaseViewAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        HomeScreenDelegate homeScreenDelegate = (HomeScreenDelegate) context;
        mPresenter = homeScreenDelegate.getPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        ButterKnife.bind(this, view);

        mBaseViewAdapter = new BaseViewAdapter(getContext(), mPresenter, mPresenter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()
                , LinearLayoutManager.VERTICAL, false);
        rvItemView.setAdapter(mBaseViewAdapter);
        rvItemView.setLayoutManager(linearLayoutManager);


        return view;
    }

    public void displayErrorMsg(String errorMsg) {
        Snackbar.make(rvItemView, errorMsg, Snackbar.LENGTH_INDEFINITE).show();
    }

    public void displaySessionList(List<HomeScreenVO> mData) {
        mBaseViewAdapter.setNewData(mData);
    }

    public void launchCurrent(String programId) {
        Intent intent = ItemDetailsActivity.newIntentCurrentProgram(getContext());
        startActivity(intent);
    }

    public void launchCategory(String programId, String categoryId) {
        Intent intent = ItemDetailsActivity.newIntentCategoryProgram(getContext(), programId, categoryId);
        startActivity(intent);
    }


}
