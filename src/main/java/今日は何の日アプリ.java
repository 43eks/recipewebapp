import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class 今日は何の日アプリ {
    public static void main(String[] args) {
        try {
            String urlString = "https://byabbe.se/on-this-day/3/25/events.json";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // User-Agent を設定
            conn.setRequestProperty("User-Agent", "Java/11");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                System.out.println("Response: " + content.toString());
            } else {
                System.out.println("HTTPエラーコード: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}