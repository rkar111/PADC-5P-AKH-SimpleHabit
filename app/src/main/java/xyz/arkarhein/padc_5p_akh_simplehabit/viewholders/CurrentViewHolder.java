package xyz.arkarhein.padc_5p_akh_simplehabit.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.CurrentVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.delegates.CurrentProgramDelegate;

public class CurrentViewHolder extends BaseViewHolder<CurrentVO> {

    @BindView(R.id.tv_simple_habit)
    TextView tvSimpleHabit;

    @BindView(R.id.btn_start)
    Button btnStart;

    @BindView(R.id.tv_time_start_here)
    TextView tvTime;

    @BindView(R.id.rl_current)
    RelativeLayout rlCurrent;

    private CurrentProgramDelegate mCurrentProgramDelegate;
    private CurrentVO currentVO;

    public CurrentViewHolder(View itemView, CurrentProgramDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        mCurrentProgramDelegate = delegate;
        rlCurrent.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        mCurrentProgramDelegate.onTapCurrentProgram(currentVO);
    }

    @Override
    public void setData(CurrentVO data) {
        currentVO = data;
        tvSimpleHabit.setText(data.getTitle());
        btnStart.setText(data.getCurrentPeriod());


        String avgLength = "";
        for (int length : data.getAverageLengths()) {
            avgLength += length + ", ";
        }
        tvTime.setText(avgLength + " min");
    }


}
