package xyz.arkarhein.padc_5p_akh_simplehabit.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.TopicsVO;

public class TopicItemsViewHolder extends BaseViewHolder<TopicsVO> {

    @BindView(R.id.tv_topic_type)
    TextView tvTopicType;

    @BindView(R.id.tv_topic_desc)
    TextView tvTopicDesc;

    public TopicItemsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(TopicsVO data) {
        tvTopicType.setText(data.getTopicName());
        tvTopicDesc.setText(data.getTopicDesc());
    }


    @Override
    public void onClick(View v) {

    }
}
