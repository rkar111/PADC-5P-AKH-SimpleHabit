package xyz.arkarhein.padc_5p_akh_simplehabit.network;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.arkarhein.padc_5p_akh_simplehabit.events.RestApiEvent;
import xyz.arkarhein.padc_5p_akh_simplehabit.network.responses.GetCategoryResponse;
import xyz.arkarhein.padc_5p_akh_simplehabit.network.responses.GetCurrentResponse;
import xyz.arkarhein.padc_5p_akh_simplehabit.network.responses.GetTopicsResponse;

public class SimpleHabitsRetrofitDataAgent implements SimpleHabitsDataAgent {

    private static SimpleHabitsRetrofitDataAgent sObjInstance;

    private SimpleHabitsApi mSimpleHabitsApi;

    private SimpleHabitsRetrofitDataAgent() {

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        mSimpleHabitsApi = retrofit.create(SimpleHabitsApi.class);

    }

    public static SimpleHabitsRetrofitDataAgent getsObjInstance() {
        if (sObjInstance == null)
            sObjInstance = new SimpleHabitsRetrofitDataAgent();

        return sObjInstance;
    }

    @Override
    public void loadCurrent(int page, String accessToken) {
        Call<GetCurrentResponse> currentResponseCall = mSimpleHabitsApi.getCurrent(1, "b002c7e1a528b7cb460933fc2875e916");
        currentResponseCall.enqueue(new Callback<GetCurrentResponse>() {
            @Override
            public void onResponse(Call<GetCurrentResponse> call, Response<GetCurrentResponse> response) {
                GetCurrentResponse getCurrentResponse = response.body();
                if (getCurrentResponse != null) {
                    RestApiEvent.CurrentDataLoadedEvent currentDataLoadedEvent = new RestApiEvent.CurrentDataLoadedEvent(getCurrentResponse.getCurrentProgram());
                    EventBus.getDefault().post(currentDataLoadedEvent);
                } else {
                    RestApiEvent.ErrorInvokingAPIEvent errorInvokingAPIEvent = new RestApiEvent.ErrorInvokingAPIEvent("No Data to Show");
                    EventBus.getDefault().post(errorInvokingAPIEvent);
                }
            }

            @Override
            public void onFailure(Call<GetCurrentResponse> call, Throwable t) {
                RestApiEvent.ErrorInvokingAPIEvent errorInvokingAPIEvent = new RestApiEvent.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorInvokingAPIEvent);
            }
        });
    }

    @Override
    public void loadCategory(int page, String accessToken) {
        Call<GetCategoryResponse> categoryResponseCall = mSimpleHabitsApi.getCategory(1, "b002c7e1a528b7cb460933fc2875e916");
        categoryResponseCall.enqueue(new Callback<GetCategoryResponse>() {
            @Override
            public void onResponse(Call<GetCategoryResponse> call, Response<GetCategoryResponse> response) {
                GetCategoryResponse getCategoryResponse = response.body();
                if (getCategoryResponse != null) {
                    RestApiEvent.CategoryDataLoadedEvent categoryDataLoadedEvent = new RestApiEvent.CategoryDataLoadedEvent(getCategoryResponse.getCategoriesPrograms());
                    EventBus.getDefault().post(categoryDataLoadedEvent);

                } else {
                    RestApiEvent.ErrorInvokingAPIEvent errorInvokingAPIEvent = new RestApiEvent.ErrorInvokingAPIEvent("No Data to Show");
                    EventBus.getDefault().post(errorInvokingAPIEvent);
                }
            }

            @Override
            public void onFailure(Call<GetCategoryResponse> call, Throwable t) {
                RestApiEvent.ErrorInvokingAPIEvent errorInvokingAPIEvent = new RestApiEvent.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorInvokingAPIEvent);
            }
        });
    }

    @Override
    public void loadTopics(int page, String accessToken) {
        Call<GetTopicsResponse> topicsResponseCall = mSimpleHabitsApi.getTopics(1, "b002c7e1a528b7cb460933fc2875e916");
        topicsResponseCall.enqueue(new Callback<GetTopicsResponse>() {
            @Override
            public void onResponse(Call<GetTopicsResponse> call, Response<GetTopicsResponse> response) {
                GetTopicsResponse getTopicsResponse = response.body();
                if (getTopicsResponse != null) {
                    RestApiEvent.TopicDataLoadedEvent topicDataLoadedEvent = new RestApiEvent.TopicDataLoadedEvent(getTopicsResponse.getTopics());
                    EventBus.getDefault().post(topicDataLoadedEvent);
                } else {
                    RestApiEvent.ErrorInvokingAPIEvent errorInvokingAPIEvent = new RestApiEvent.ErrorInvokingAPIEvent("No Data to Show");
                    EventBus.getDefault().post(errorInvokingAPIEvent);
                }
            }

            @Override
            public void onFailure(Call<GetTopicsResponse> call, Throwable t) {
                RestApiEvent.ErrorInvokingAPIEvent errorInvokingAPIEvent = new RestApiEvent.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorInvokingAPIEvent);
            }
        });
    }

}
