package xyz.arkarhein.padc_5p_akh_simplehabit.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by aung on 12/2/17.
 */

public abstract class BaseViewHolder<W> extends RecyclerView.ViewHolder {

    private W mData;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setData(W data);
}
