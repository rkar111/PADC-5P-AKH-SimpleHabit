package xyz.arkarhein.padc_5p_akh_simplehabit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.adapters.ItemAdapter;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.HomeScreenVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.delegates.HomeScreenDelegate;
import xyz.arkarhein.padc_5p_akh_simplehabit.fragments.SeriesFragment;
import xyz.arkarhein.padc_5p_akh_simplehabit.fragments.OnTheGoFragment;
import xyz.arkarhein.padc_5p_akh_simplehabit.fragments.TeachersFragment;
import xyz.arkarhein.padc_5p_akh_simplehabit.mvp.presenters.HomeScreenPresenter;
import xyz.arkarhein.padc_5p_akh_simplehabit.mvp.views.HomeScreenView;

public class MainActivity extends BaseActivity implements HomeScreenDelegate, HomeScreenView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tl_tab)
    TabLayout tbTab;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    ItemAdapter itemAdapter;
    private HomeScreenPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);
        mPresenter = new HomeScreenPresenter(this);
        mPresenter.onCreate();

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Meditate");
        }

        itemAdapter = new ItemAdapter(getSupportFragmentManager());
        tbTab.setupWithViewPager(viewPager);
        itemAdapter.addTab("On The Go", new OnTheGoFragment());
        itemAdapter.addTab("Series", new SeriesFragment());
        itemAdapter.addTab("Teachers", new TeachersFragment());
        viewPager.setAdapter(itemAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    @Override
    public HomeScreenPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }


    @Override
    public void displaySessionList(List<HomeScreenVO> mData) {
        SeriesFragment seriesFragment = (SeriesFragment) itemAdapter.getItem(1);
        seriesFragment.displaySessionList(mData);
    }

    @Override
    public void launchCategory(String programId, String categoryId) {
        SeriesFragment seriesFragment = (SeriesFragment) itemAdapter.getItem(1);
        seriesFragment.launchCategory(programId, categoryId);
    }

    @Override
    public void launchCurrent(String programId) {
        SeriesFragment seriesFragment = (SeriesFragment) itemAdapter.getItem(1);
        seriesFragment.launchCurrent(programId);
    }

    @Override
    public void displayErrorMsg(String errorMsg) {
        SeriesFragment seriesFragment = (SeriesFragment) itemAdapter.getItem(1);
        seriesFragment.displayErrorMsg(errorMsg);
    }
}
