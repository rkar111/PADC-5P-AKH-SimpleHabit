package xyz.arkarhein.padc_5p_akh_simplehabit.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.arkarhein.padc_5p_akh_simplehabit.data.TopicsVO;

public class GetTopicsResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private String page;

    @SerializedName("topics")
    private List<TopicsVO> topics;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<TopicsVO> getTopics() {
        return topics;
    }
}
