package xyz.arkarhein.padc_5p_akh_simplehabit.events;

import java.util.Collection;
import java.util.List;

import xyz.arkarhein.padc_5p_akh_simplehabit.data.HomeScreenVO;

public class SuccessEvent {

    private List<HomeScreenVO> mData;

    public SuccessEvent(List<HomeScreenVO> data) {
        this.mData = data;
    }

    public List<HomeScreenVO> getmData() {
        return mData;
    }
}
