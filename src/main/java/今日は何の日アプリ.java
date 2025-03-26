import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class 今日は何の日アプリ {
    public static void main(String[] args) {
        try {
            String urlString = "https://api.wikimedia.org/feed/v1/wikipedia/en/onthisday/events/2025/03/25";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // ★ User-Agent を設定する
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                System.out.println(content.toString());
            } else {
                System.out.println("HTTPエラーコード: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}