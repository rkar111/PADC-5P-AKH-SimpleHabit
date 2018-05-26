package xyz.arkarhein.padc_5p_akh_simplehabit.network;

public interface SimpleHabitsDataAgent {

    void loadCurrent(int page, String accessToken);

    void loadCategory(int page, String accessToken);

    void loadTopics(int page, String accessToken);


}
