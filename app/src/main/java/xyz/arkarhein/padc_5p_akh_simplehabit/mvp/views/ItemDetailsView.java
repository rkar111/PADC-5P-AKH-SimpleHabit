package xyz.arkarhein.padc_5p_akh_simplehabit.mvp.views;

import xyz.arkarhein.padc_5p_akh_simplehabit.data.CurrentVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.ProgramVO;

public interface ItemDetailsView extends BaseView {

    void displayCurrentDetail(String currentId, CurrentVO currentVO);

    void displayCategoryDetail(String categoryId, String programId, ProgramVO programVO);

}
