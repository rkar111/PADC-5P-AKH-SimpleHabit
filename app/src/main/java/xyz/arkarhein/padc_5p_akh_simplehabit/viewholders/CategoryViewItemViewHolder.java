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
import xyz.arkarhein.padc_5p_akh_simplehabit.delegates.CategoryDelegate;

public class CategoryViewItemViewHolder extends BaseViewHolder<CategoryVO> {

    @BindView(R.id.rv_category)
    RecyclerView rvCategory;

    @BindView(R.id.tv_category_heading)
    TextView tvCategoryHeading;

    private CategoryDelegate mCategoryDelegate;
    private CategoryItemAdapter mCategoryItemAdapter;

    public CategoryViewItemViewHolder(View itemView, CategoryDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mCategoryDelegate = delegate;

        mCategoryItemAdapter = new CategoryItemAdapter(itemView.getContext(), mCategoryDelegate);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(),
                LinearLayoutManager.HORIZONTAL, false);

        rvCategory.setAdapter(mCategoryItemAdapter);
        rvCategory.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void setData(CategoryVO data) {
        tvCategoryHeading.setText(data.getTitle());
        mCategoryItemAdapter.setNewData(data.getPrograms());
        mCategoryItemAdapter.setCategory(data);
    }


    @Override
    public void onClick(View view) {

    }
}
