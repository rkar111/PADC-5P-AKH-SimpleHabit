package xyz.arkarhein.padc_5p_akh_simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.CurrentVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.SessionsVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.viewholders.SessionItemViewHolder;

public class SessionItemAdapter extends BaseRecyclerAdapter<SessionItemViewHolder, SessionsVO> {
    public SessionItemAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public SessionItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View sessionItemView = mLayoutInflator.inflate(R.layout.sessions_items, parent, false);
        return new SessionItemViewHolder(sessionItemView);
    }
}
