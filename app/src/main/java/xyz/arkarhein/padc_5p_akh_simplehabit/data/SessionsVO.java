package xyz.arkarhein.padc_5p_akh_simplehabit.data;

import com.google.gson.annotations.SerializedName;

public class SessionsVO {

    @SerializedName("session-id")
    private String sessionId;

    @SerializedName("title")
    private String title;

    @SerializedName("length-in-seconds")
    private int lengthInSeconds;

    @SerializedName("file-path")
    private String filePath;

    public String getSessionId() {
        return sessionId;
    }

    public String getTitle() {
        return title;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getFilePath() {
        return filePath;
    }
}
