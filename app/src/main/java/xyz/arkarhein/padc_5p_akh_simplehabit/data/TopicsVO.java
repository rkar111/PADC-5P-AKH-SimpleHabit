package xyz.arkarhein.padc_5p_akh_simplehabit.data;

import com.google.gson.annotations.SerializedName;

public class TopicsVO implements HomeScreenVO {

    @SerializedName("topic-name")
    private String topicName;
    @SerializedName("topic-desc")
    private String topicDesc;
    @SerializedName("icon")
    private String icon;
    @SerializedName("background")
    private String background;

    public String getTopicName() {
        return topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public String getIcon() {
        return icon;
    }

    public String getBackground() {
        return background;
    }
}
