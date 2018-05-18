package xyz.arkarhein.padc_5p_akh_simplehabit.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.adapters.EveningMeditationItemAdapter;
import xyz.arkarhein.padc_5p_akh_simplehabit.adapters.HealthyMindItemAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rv_evening_meditation)
    RecyclerView rvEveningMeditation;

    @BindView(R.id.rv_healthy_mind)
    RecyclerView rvHealthyMind;

    private EveningMeditationItemAdapter mEveningMeditationItemAdapter = new EveningMeditationItemAdapter();
    private HealthyMindItemAdapter mHealthyMindItemAdapter = new HealthyMindItemAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.meditation_series);

        LinearLayoutManager linearLayoutManagerEveningMiditation = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rvEveningMeditation.setAdapter(mEveningMeditationItemAdapter);
        rvEveningMeditation.setLayoutManager(linearLayoutManagerEveningMiditation);

        LinearLayoutManager linearLayoutManagerHealthyMind = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rvHealthyMind.setAdapter(mHealthyMindItemAdapter);
        rvHealthyMind.setLayoutManager(linearLayoutManagerHealthyMind);


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
}