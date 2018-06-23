package xyz.arkarhein.padc_5p_akh_simplehabit.mvp.presenters;

import xyz.arkarhein.padc_5p_akh_simplehabit.data.CurrentVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.ProgramVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.models.SimpleHabitsModel;
import xyz.arkarhein.padc_5p_akh_simplehabit.mvp.views.ItemDetailsView;

public class ItemDetailsPresenter extends BasePresenter<ItemDetailsView> {

    public ItemDetailsPresenter(ItemDetailsView mView) {
        super(mView);
    }

    public void onFinishCurrentUIComponent(String currentId, CurrentVO currentVO) {
        currentVO = SimpleHabitsModel.getsObjInstance().getCurrentProgram();
        mView.displayCurrentDetail(currentId, currentVO);
    }

    public void onFinishCategoryUIComponent(String categoryId, String programId, ProgramVO programVO) {
        programVO = SimpleHabitsModel.getsObjInstance().getProgram(categoryId, programId);
        mView.displayCategoryDetail(categoryId, programId, programVO);
    }
}
