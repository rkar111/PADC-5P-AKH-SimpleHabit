package xyz.arkarhein.padc_5p_akh_simplehabit.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.adapters.AllTopicItemsAdapter;

public class AllTopicViewItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.rv_all_topic)
    RecyclerView rvAllTopic;

    private AllTopicItemsAdapter mAllTopicItemsAdapter = new AllTopicItemsAdapter();

    public AllTopicViewItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);


        LinearLayoutManager linearLayoutManagerAllTopic = new LinearLayoutManager(itemView.getContext(),
                LinearLayoutManager.VERTICAL, false);
        rvAllTopic.setAdapter(mAllTopicItemsAdapter);
        rvAllTopic.setLayoutManager(linearLayoutManagerAllTopic);

    }
}
