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
import xyz.arkarhein.padc_5p_akh_simplehabit.viewholders.CategoryItemViewHolder;

public class CategoryItemAdapter extends BaseRecyclerAdapter<CategoryItemViewHolder, ProgramVO> {

    public CategoryItemAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryItemView = mLayoutInflator.inflate(R.layout.category_items, parent, false);
        return new CategoryItemViewHolder(categoryItemView);
    }
}
