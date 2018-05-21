package xyz.arkarhein.padc_5p_akh_simplehabit.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.adapters.EveningMeditationItemAdapter;

public class EveningMeditationViewItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.rv_evening_meditation)
    RecyclerView rvEveningMeditation;

    private EveningMeditationItemAdapter mEveningMeditationItemAdapter = new EveningMeditationItemAdapter();

    public EveningMeditationViewItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        LinearLayoutManager linearLayoutManagerEveningMiditation = new LinearLayoutManager(itemView.getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rvEveningMeditation.setAdapter(mEveningMeditationItemAdapter);
        rvEveningMeditation.setLayoutManager(linearLayoutManagerEveningMiditation);
    }
}
