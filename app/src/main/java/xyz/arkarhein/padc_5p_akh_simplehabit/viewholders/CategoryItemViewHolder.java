package xyz.arkarhein.padc_5p_akh_simplehabit.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.CategoryVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.ProgramVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.delegates.CategoryDelegate;

public class CategoryItemViewHolder extends BaseViewHolder<ProgramVO> {

    @BindView(R.id.tv_meditation_name)
    TextView tvCategoryName;

    @BindView(R.id.rl_category_item)
    RelativeLayout rlCategoryItem;

    private ProgramVO mProgram;
    private CategoryVO categoryVO;

    private CategoryDelegate mCategoryDelegate;

    public CategoryItemViewHolder(View itemView, CategoryDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mCategoryDelegate = delegate;
    }

    @Override
    public void setData(ProgramVO data) {
        mProgram = data;
        tvCategoryName.setText(data.getTitle());
    }

    public void setCategory(CategoryVO category) {
        categoryVO = category;
    }

    @Override
    public void onClick(View view) {
        mCategoryDelegate.onTapCategory(categoryVO.getCategoryId(), mProgram.getProgramId());
    }
}
