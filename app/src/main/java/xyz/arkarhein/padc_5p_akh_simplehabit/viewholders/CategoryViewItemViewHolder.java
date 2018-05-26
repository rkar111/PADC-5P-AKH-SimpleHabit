package xyz.arkarhein.padc_5p_akh_simplehabit.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.adapters.CategoryItemAdapter;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.CategoryVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.ProgramVO;

public class CategoryViewItemViewHolder extends BaseViewHolder<CategoryVO> {

    @BindView(R.id.rv_category)
    RecyclerView rvCategory;

    @BindView(R.id.tv_category_heading)
    TextView tvCategoryHeading;

    private CategoryItemAdapter mCategoryItemAdapter;

    public CategoryViewItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        mCategoryItemAdapter = new CategoryItemAdapter(itemView.getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rvCategory.setAdapter(mCategoryItemAdapter);
        rvCategory.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void setData(CategoryVO data) {
        mCategoryItemAdapter.setNewData(data.getPrograms());
        tvCategoryHeading.setText(data.getTitle());

    }


}
