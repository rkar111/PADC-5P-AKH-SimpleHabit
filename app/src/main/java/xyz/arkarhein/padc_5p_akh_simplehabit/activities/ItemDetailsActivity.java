package xyz.arkarhein.padc_5p_akh_simplehabit.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.SimpleHabitApp;
import xyz.arkarhein.padc_5p_akh_simplehabit.adapters.SessionItemAdapter;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.CurrentVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.ProgramVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.models.SimpleHabitsModel;

public class ItemDetailsActivity extends BaseActivity {

    @BindView(R.id.item_details_toolbar)
    Toolbar toolbar;

    @BindView(R.id.rv_sessions)
    RecyclerView rvSessions;

    @BindView(R.id.tv_item_detail_heading)
    TextView tvItemDetailHeading;

    @BindView(R.id.tv_item_detail)
    TextView tvItemDetail;


    private SessionItemAdapter mSessionItemAdapter;

    public static Intent newIntentCurrentProgram(Context context) {
        Intent intent = new Intent(context, ItemDetailsActivity.class);
        intent.putExtra(SimpleHabitApp.VIEW_TYPE, SimpleHabitApp.CURRENT_PROGRAM);
        return intent;
    }

    public static Intent newIntentCategoryProgram(Context context, String categoryId, String categoryProgramId) {
        Intent intent = new Intent(context, ItemDetailsActivity.class);
        intent.putExtra(SimpleHabitApp.VIEW_TYPE, SimpleHabitApp.CATEGORY);
        intent.putExtra(SimpleHabitApp.CATEGORY_ID, categoryId);
        intent.putExtra(SimpleHabitApp.CATEGORY_PROGRAM_ID, categoryProgramId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        ButterKnife.bind(this, this);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_arrow_back_24dp));
        }


        String programId = getIntent().getStringExtra(SimpleHabitApp.PROGRAM_ID);

        mSessionItemAdapter = new SessionItemAdapter(getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext()
                , LinearLayoutManager.VERTICAL, false);
        rvSessions.setLayoutManager(linearLayoutManager);
        rvSessions.setAdapter(mSessionItemAdapter);


        if (getIntent().getStringExtra(SimpleHabitApp.VIEW_TYPE).equals(SimpleHabitApp.CURRENT_PROGRAM)) {
            CurrentVO currentProgram = SimpleHabitsModel.getsObjInstance().getCurrentProgram();
            mSessionItemAdapter.setNewData(currentProgram.getSessions());
            tvItemDetailHeading.setText(currentProgram.getTitle());
            tvItemDetail.setText(currentProgram.getDescription());


        } else if (getIntent().getStringExtra(SimpleHabitApp.VIEW_TYPE).equals(SimpleHabitApp.CATEGORY)) {
            String categoryId = getIntent().getStringExtra(SimpleHabitApp.CATEGORY_ID);
            String categoryProgramId = getIntent().getStringExtra(SimpleHabitApp.CATEGORY_PROGRAM_ID);

            ProgramVO categoryProgram = SimpleHabitsModel.getsObjInstance().getProgram(categoryId, categoryProgramId);
            mSessionItemAdapter.setNewData(categoryProgram.getSessions());
            tvItemDetailHeading.setText(categoryProgram.getTitle());
            tvItemDetail.setText(categoryProgram.getDescription());
        }

    }


}
