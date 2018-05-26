package xyz.arkarhein.padc_5p_akh_simplehabit.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.CategoryVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.ProgramVO;

public class CategoryItemViewHolder extends BaseViewHolder<ProgramVO> {

    @BindView(R.id.tv_meditation_name)
    TextView tvCategoryName;

    @BindView(R.id.meditation_time)
    TextView tvMeditationTime;

    public CategoryItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(ProgramVO data) {
        tvCategoryName.setText(data.getTitle());
    }

}
