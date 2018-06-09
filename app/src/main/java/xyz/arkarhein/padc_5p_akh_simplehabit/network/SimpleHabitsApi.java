package xyz.arkarhein.padc_5p_akh_simplehabit.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.arkarhein.padc_5p_akh_simplehabit.network.responses.GetCategoryResponse;
import xyz.arkarhein.padc_5p_akh_simplehabit.network.responses.GetCurrentResponse;
import xyz.arkarhein.padc_5p_akh_simplehabit.network.responses.GetTopicsResponse;

public interface SimpleHabitsApi {

    @FormUrlEncoded
    @POST("getTopics.php")
    Call<GetTopicsResponse> getTopics(@Field("page") int page,
                                      @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    Call<GetCurrentResponse> getCurrent(@Field("page") int page,
                                        @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    Call<GetCategoryResponse> getCategory(@Field("page") int page,
                                          @Field("access_token") String accessToken);

}
