import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONObject;

public class 今日は何の日アプリ {
    public static void main(String[] args) {
        try {
            // APIのURL（例えば、Today in History API）
            String urlString = "https://api.wikimedia.org/feed/v1/wikipedia/en/onthisday/events/2025/03/25"; // 日付を動的に取得することも可能
            
            // URLオブジェクトを作成
            URL url = new URL(urlString);
            
            // 接続を開く
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            // レスポンスを取得
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            String inputLine;
            StringBuilder response = new StringBuilder();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            // JSONレスポンスを解析
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray events = jsonResponse.getJSONArray("events");
            
            // 出力
            if (events.length() > 0) {
                System.out.println("今日は何の日？");
                for (int i = 0; i < events.length(); i++) {
                    JSONObject event = events.getJSONObject(i);
                    String year = event.getString("year");
                    String description = event.getString("description");
                    System.out.println(year + ": " + description);
                }
            } else {
                System.out.println("今日は特別な出来事はありません。");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}