package reviews;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TopicReviews {

    private FetchTopicList fetchTopicList;
    private List<String> pages;
    private String topic;
    private static final String A_TAG_PATTERN = "<a target=\"(.*?)\" href=\"(.*?)\">(.*?)</a>";

    Pattern pTag = Pattern.compile(A_TAG_PATTERN);

    Pattern hrefTag = Pattern.compile("href=\"(.*?)\"");

    public TopicReviews(FetchTopicList fetchTopicList) {
        this.fetchTopicList = fetchTopicList;
    }

    private List<String> getPageLinks() throws IOException {
        selectTopic();
        String key = this.topic;
        //System.out.println(key);
        String url = fetchTopicList.getTopicLinks().get(key);
        //System.out.println(url);
        List<String> pageLinks = new ArrayList<>();
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("user-agent", "Mozilla/5.0");;
        connection.setRequestProperty("Cookie", "JSESSIONID=" +  URLEncoder.encode(fetchTopicList.getSessionID(), "UTF-8"));
        //System.out.println(URLEncoder.encode(fetchTopicList.getSessionID(), "UTF-8"));
        int responseCode = connection.getResponseCode();
        //System.out.println(responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            //System.out.println(inputLine);
            if (inputLine.contains("class=\"inline-checkbox pull-right\"")) {
                String allLinks = StringUtils.substringBetween(inputLine, "<ul class=\"pagination-page-list\">", "</ul>");
                String [] links = StringUtils.substringsBetween(allLinks, "<a href=\"", "\">");
                if (links != null) Arrays.asList(links).forEach(link -> pageLinks.add(link));
            }
        }
        return pageLinks;
    }
    private void selectTopic(){
        int randomNumber = (int)(Math.random()*((fetchTopicList.getTopics().size()-1 - 0)) + 0);
        this.topic = fetchTopicList.getTopics().get(randomNumber);
        System.out.println("Topic: " + this.topic);
    }
    private String dateConversion(String date) throws ParseException {
        Date date1=new SimpleDateFormat("dd MMMM yyyy").parse(date);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return (f.format(date1));
    }
    public void writeReviews(File filename) throws IOException, ParseException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        List<String> pageLinks = getPageLinks();
        for (String url : pageLinks) {
            //System.out.println(url);
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("user-agent", "Mozilla/5.0");
            connection.setRequestProperty("Cookie", "JSESSIONID=" + URLEncoder.encode(fetchTopicList.getSessionID(), "UTF-8"));
            //System.out.println(URLEncoder.encode(fetchTopicList.getSessionID(), "UTF-8"));
            int responseCode = connection.getResponseCode();
            //System.out.println(responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.contains("class=\"inline-checkbox pull-right\"")) {
                    //System.out.println(inputLine);
                    String [] title = StringUtils.substringsBetween(inputLine, "<div class=\"search-results-item-body\">", "</h3>");
                    //System.out.println(title.length);
                    String [] reviewLinks;
                    String [] reviewTitle;
                    if (title != null) {
                        reviewLinks = new String[title.length];
                        reviewTitle = new String[title.length];
                        for (int i = 0; i < title.length; i++) {
                            Matcher m = hrefTag.matcher(title[i]);
                            if (m.find()) reviewLinks[i] = "http://onlinelibrary.wiley.com"+ m.group(1).substring(5);
                            Matcher atag = pTag.matcher(title[i]);
                            if (atag.find()) reviewTitle[i] = atag.group(3);
                        }
                        String[] authors = StringUtils.substringsBetween(inputLine, "<div class=\"search-result-authors\"> <div>", "</div>");
                        /*if (authors != null) {
                            Arrays.stream(authors).collect(Collectors.toList()).forEach(value -> System.out.println(value));
                        }*/
                        String[] dates = StringUtils.substringsBetween(inputLine, "<div class=\"search-result-date\"> <div>", "</div>");
                        //if (dates != null) Arrays.stream(dates).collect(Collectors.toList()).forEach(date -> System.out.println(date));

                        for (int i=0; i<title.length; i++){
                            writer.write(reviewLinks[i] + " | " + this.topic +  "|" + reviewTitle[i] + "|" + authors[i] +"|" + dateConversion(dates[i]) + "\n");
                        }
                        //System.out.println(title.length + " " + authors.length + " " + dates.length);
                    }
                }
            }
        }
        writer.close();
    }
}
