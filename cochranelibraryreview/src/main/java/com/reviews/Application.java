import reviews.FetchTopicList;
import reviews.TopicReviews;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class Application {
    public static void main(String[] args) throws IOException {
        FetchTopicList fetchTopicList = new FetchTopicList();
        fetchTopicList.setUrl("https://www.cochranelibrary.com/cdsr/reviews/topics");
        fetchTopicList.getAllTopics();

        TopicReviews topicReviews = new TopicReviews(fetchTopicList);
        try {
            topicReviews.writeReviews(new File("output.txt"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
