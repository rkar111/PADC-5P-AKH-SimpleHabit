package xyz.arkarhein.padc_5p_akh_simplehabit.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.viewholders.AllTopicViewItemViewHolder;
import xyz.arkarhein.padc_5p_akh_simplehabit.viewholders.EveningMeditationViewItemViewHolder;
import xyz.arkarhein.padc_5p_akh_simplehabit.viewholders.HealthyMindViewItemViewHolder;
import xyz.arkarhein.padc_5p_akh_simplehabit.viewholders.SimpleHabitStarterViewHolder;

public class BaseViewAdapter extends RecyclerView.Adapter {

    private static final int VT_SIMPLE_HABIT_STARTER = 0;
    private static final int VT_EVENING_MEDITATION = 1;
    private static final int VT_HEALTHY_MIND = 2;
    private static final int VT_ALL_TOPIC = 3;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case VT_SIMPLE_HABIT_STARTER:
                viewHolder = new SimpleHabitStarterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_habit_starter_item_view
                        , parent, false));
                break;
            case VT_EVENING_MEDITATION:
                viewHolder = new EveningMeditationViewItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.evening_meditation_item_view
                        , parent, false));
                break;
            case VT_HEALTHY_MIND:
                viewHolder = new HealthyMindViewItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.healthy_mind_item_view
                        , parent, false));
                break;
            case VT_ALL_TOPIC:
                viewHolder = new AllTopicViewItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.all_topic_item_view
                        , parent, false));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        int i = 0;
        switch (position) {
            case 0:
                i = VT_SIMPLE_HABIT_STARTER;
                break;
            case 1:
                i = VT_EVENING_MEDITATION;
                break;
            case 2:
                i = VT_HEALTHY_MIND;
                break;
            case 3:
                i = VT_ALL_TOPIC;
                break;
        }
        return i;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
