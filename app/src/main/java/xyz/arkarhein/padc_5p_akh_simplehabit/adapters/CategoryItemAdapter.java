package xyz.arkarhein.padc_5p_akh_simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.CategoryVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.ProgramVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.delegates.CategoryDelegate;
import xyz.arkarhein.padc_5p_akh_simplehabit.viewholders.CategoryItemViewHolder;

public class CategoryItemAdapter extends BaseRecyclerAdapter<CategoryItemViewHolder, ProgramVO> {

    private CategoryDelegate mCategoryDelegate;

    private CategoryVO mRootCategory;

    public CategoryItemAdapter(Context context, CategoryDelegate categoryDelegate) {
        super(context);
        mCategoryDelegate = categoryDelegate;
    }

    @NonNull
    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        CategoryItemViewHolder categoryItemViewHolder = new CategoryItemViewHolder(layoutInflater.inflate(R.layout.category_items, parent, false), mCategoryDelegate);
        return categoryItemViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryItemViewHolder holder, int position) {
        holder.setData(mData.get(position));
        holder.setCategory(mRootCategory);

    }

    public void setCategory(CategoryVO category) {
        mRootCategory = category;
    }
}
