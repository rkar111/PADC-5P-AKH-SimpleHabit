package xyz.arkarhein.padc_5p_akh_simplehabit.mvp.views;

import java.util.List;

import xyz.arkarhein.padc_5p_akh_simplehabit.data.HomeScreenVO;

public interface SeriesView extends BaseView {

    void displaySessionList(List<HomeScreenVO> mData);

    void lauchSessionList(String programId, String categoryId);

    void lauchCurrentProgram(String programId);
}
