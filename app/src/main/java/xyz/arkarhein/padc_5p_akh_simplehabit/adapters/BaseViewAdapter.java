package xyz.arkarhein.padc_5p_akh_simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.CategoryVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.CurrentVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.HomeScreenVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.TopicsVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.viewholders.BaseViewHolder;
import xyz.arkarhein.padc_5p_akh_simplehabit.viewholders.CategoryViewItemViewHolder;
import xyz.arkarhein.padc_5p_akh_simplehabit.viewholders.SimpleHabitStarterViewHolder;
import xyz.arkarhein.padc_5p_akh_simplehabit.viewholders.TopicItemsViewHolder;

public class BaseViewAdapter extends BaseRecyclerAdapter<BaseViewHolder, HomeScreenVO> {

    private static final int VT_SIMPLE_HABIT_STARTER = 0;
    private static final int VT_EVENING_MEDITATION = 1;
    private static final int VT_ALL_TOPIC = 2;

    public BaseViewAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder = null;
        switch (viewType) {
            case VT_SIMPLE_HABIT_STARTER:
                viewHolder = new SimpleHabitStarterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_habit_starter_item_view
                        , parent, false));
                break;
            case VT_EVENING_MEDITATION:
                viewHolder = new CategoryViewItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_view
                        , parent, false));
                break;
            case VT_ALL_TOPIC:
                viewHolder = new TopicItemsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.all_topic_items
                        , parent, false));
                break;
        }
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof CurrentVO) {
            return VT_SIMPLE_HABIT_STARTER;
        } else if (mData.get(position) instanceof CategoryVO) {
            return VT_EVENING_MEDITATION;
        } else if (mData.get(position) instanceof TopicsVO) {
            return VT_ALL_TOPIC;
        }
        return position;
    }
}
