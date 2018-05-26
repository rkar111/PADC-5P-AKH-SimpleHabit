package xyz.arkarhein.padc_5p_akh_simplehabit.data.models;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import xyz.arkarhein.padc_5p_akh_simplehabit.data.HomeScreenVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.events.RestApiEvent;
import xyz.arkarhein.padc_5p_akh_simplehabit.events.SuccessEvent;
import xyz.arkarhein.padc_5p_akh_simplehabit.network.SimpleHabitsRetrofitDataAgent;

public class SimpleHabitsModel {

    private static SimpleHabitsModel sObjInstance;

    private List<HomeScreenVO> seriesData;

    private SimpleHabitsModel() {
        EventBus.getDefault().register(this);
        seriesData = new ArrayList<>();
    }

    public static SimpleHabitsModel getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new SimpleHabitsModel();
        }
        return sObjInstance;
    }

    public void loadData() {
        SimpleHabitsRetrofitDataAgent.getsObjInstance().loadCurrent(1, "b002c7e1a528b7cb460933fc2875e916");
    }

    @Subscribe
    public void onCurrentDataLoaded(RestApiEvent.CurrentDataLoadedEvent event) {
        seriesData.add(event.getCurrentList());
        SimpleHabitsRetrofitDataAgent.getsObjInstance().loadCategory(1, "b002c7e1a528b7cb460933fc2875e916");
    }

    @Subscribe
    public void onCategoryDataLoaded(RestApiEvent.CategoryDataLoadedEvent event) {
        seriesData.addAll(event.getCategoryList());
        SimpleHabitsRetrofitDataAgent.getsObjInstance().loadTopics(1, "b002c7e1a528b7cb460933fc2875e916");
    }


    @Subscribe
    public void onTopicDataLoaded(RestApiEvent.TopicDataLoadedEvent event) {
        seriesData.addAll(event.getTopicsList());
        SuccessEvent dataReadyEvent = new SuccessEvent(seriesData);
        EventBus.getDefault().post(dataReadyEvent);

    }
}
