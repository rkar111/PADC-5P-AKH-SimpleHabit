package xyz.arkarhein.padc_5p_akh_simplehabit.events;

import java.util.List;

import xyz.arkarhein.padc_5p_akh_simplehabit.data.CategoryVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.CurrentVO;
import xyz.arkarhein.padc_5p_akh_simplehabit.data.TopicsVO;

public class RestApiEvent {

    public static class EmptyResponseEvent {

    }

    public static class ErrorInvokingAPIEvent {
        private String errorMessage;

        public ErrorInvokingAPIEvent(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }

    public static class CurrentDataLoadedEvent {
        private CurrentVO currentList;

        public CurrentDataLoadedEvent(CurrentVO currentList) {
            this.currentList = currentList;
        }

        public CurrentVO getCurrentList() {
            return currentList;
        }
    }

    public static class CategoryDataLoadedEvent {
        private List<CategoryVO> categoryList;

        public CategoryDataLoadedEvent(List<CategoryVO> categoryList) {
            this.categoryList = categoryList;
        }

        public List<CategoryVO> getCategoryList() {
            return categoryList;
        }
    }

    public static class TopicDataLoadedEvent {
        private List<TopicsVO> topicsList;

        public TopicDataLoadedEvent(List<TopicsVO> topicsList) {
            this.topicsList = topicsList;
        }

        public List<TopicsVO> getTopicsList() {
            return topicsList;
        }
    }

}
