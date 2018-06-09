package xyz.arkarhein.padc_5p_akh_simplehabit.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.arkarhein.padc_5p_akh_simplehabit.data.CurrentVO;

public class GetCurrentResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("currentProgram")
    private CurrentVO currentProgram;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public CurrentVO getCurrentProgram() {
        return currentProgram;
    }
}
