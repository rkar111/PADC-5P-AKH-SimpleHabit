package xyz.arkarhein.padc_5p_akh_simplehabit.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.adapters.HealthyMindItemAdapter;

public class HealthyMindViewItemViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.rv_healthy_mind)
    RecyclerView rvHealthyMind;

    private HealthyMindItemAdapter mHealthyMindItemAdapter = new HealthyMindItemAdapter();

    public HealthyMindViewItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        LinearLayoutManager linearLayoutManagerHealthyMind = new LinearLayoutManager(itemView.getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rvHealthyMind.setAdapter(mHealthyMindItemAdapter);
        rvHealthyMind.setLayoutManager(linearLayoutManagerHealthyMind);
    }
}
