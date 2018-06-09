package xyz.arkarhein.padc_5p_akh_simplehabit.viewholders;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.padc_5p_akh_simplehabit.R;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.CurrentVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.SessionsVO;

public class SessionItemViewHolder extends BaseViewHolder<SessionsVO> {

    @BindView(R.id.tv_session_name)
    TextView tvSessionName;

    @BindView(R.id.tv_session_number)
    TextView tvSessionNumber;

    @BindView(R.id.tv_session_period)
    TextView tvSessionPeriod;

    public SessionItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(SessionsVO data) {
        tvSessionName.setText(data.getTitle());
        tvSessionNumber.setText(data.getSessionId());
        String timeLength = data.getLengthInSeconds() / 60 + ":" + data.getLengthInSeconds() % 60;
        tvSessionPeriod.setText(timeLength);

    }

    @Override
    public void onClick(View v) {

    }
}
