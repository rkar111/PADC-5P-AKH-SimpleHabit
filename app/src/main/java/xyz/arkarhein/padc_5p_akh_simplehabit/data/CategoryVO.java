package xyz.arkarhein.padc_5p_akh_simplehabit.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryVO implements HomeScreenVO {

    @SerializedName("category-id")
    private String categoryId;

    @SerializedName("title")
    private String title;

    @SerializedName("programs")
    private List<ProgramVO> programs;

    public String getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

    public List<ProgramVO> getPrograms() {
        return programs;
    }
}
