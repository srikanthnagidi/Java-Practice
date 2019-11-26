package reviews;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
public class FetchTopicList {
    @Setter
    private String url;
    @Getter
    private List<String> topics;
    @Getter
    private Map<String, String > topicLinks;
    @Getter
    private String sessionID;
    String userAgent = "userAgent/1.0";

    public void getAllTopics() throws IOException {
        topicLinks = new HashMap<String, String>();
        topics = new ArrayList<>();
        URL obj = new URL(url);
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("user-agent", "Mozilla/5.0");
        int responseCode = connection.getResponseCode();
        CookieStore cookieStore = cookieManager.getCookieStore();
        List<HttpCookie> cookieList = cookieStore.getCookies();
        for (HttpCookie cookie:cookieList){
            //System.out.println(cookie);
            if (cookie.getName().equals("JSESSIONID")){
                sessionID = cookie.getValue();
            }
        }
        //System.out.println(responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        Pattern p = Pattern.compile("href=\"(.*?)\"");
        while ((inputLine = in.readLine())!=null){
            if (inputLine.contains("a href")) {
                String title = StringUtils.substringBetween(inputLine, "<button class=\"btn-link browse-by-list-item-link\">", "</button>");
                if (title != null) {
                    //System.out.println(title);
                    topics.add(title);
                    Matcher m = p.matcher(inputLine);
                    if (m.find()) {
                        topicLinks.put(title, m.group(1));
                    }
                }
            }
        }
        in.close();
    }
}
