package xyz.arkarhein.padc_5p_akh_simplehabit.mvp.views;

import java.util.List;

import xyz.arkarhein.padc_5p_akh_simplehabit.data.HomeScreenVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.ProgramVO;

public interface SeriesView extends BaseView {

    void displaySessionList(List<HomeScreenVO> mData);

    void launchCategory(String programId, String categoryId);

    void launchCurrent(String programId);
}
