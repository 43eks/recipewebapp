import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 京都アプリ {
    private static Map<String, List<String>> sightseeingSpots = new HashMap<>();
    private static Map<String, List<String>> gourmetSpots = new HashMap<>();

    public static void main(String[] args) {
        initializeData();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== 京都アプリ ===");
            System.out.println("1. 観光名所一覧");
            System.out.println("2. グルメスポット一覧");
            System.out.println("3. 終了");
            System.out.print("選択してください: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 改行を消費

            switch (choice) {
                case 1:
                    displayList("観光名所", sightseeingSpots);
                    break;
                case 2:
                    displayList("グルメスポット", gourmetSpots);
                    break;
                case 3:
                    System.out.println("アプリを終了します。");
                    return;
                default:
                    System.out.println("無効な選択です。もう一度入力してください。");
            }
        }
    }

    // 初期データを追加
    private static void initializeData() {
        sightseeingSpots.put("東山", Arrays.asList("清水寺", "八坂神社", "高台寺"));
        sightseeingSpots.put("嵐山", Arrays.asList("渡月橋", "竹林の道", "天龍寺"));
        sightseeingSpots.put("伏見", Arrays.asList("伏見稲荷大社", "寺田屋", "月桂冠大倉記念館"));
        sightseeingSpots.put("天橋立", Arrays.asList("天橋立ビューランド", "元伊勢籠神社", "傘松公園"));
        sightseeingSpots.put("南丹", Arrays.asList("美山かやぶきの里", "るり渓温泉", "日吉ダム"));
        sightseeingSpots.put("向日市", Arrays.asList("向日神社", "長岡宮跡", "竹の径"));

        gourmetSpots.put("東山", Arrays.asList("湯豆腐の名店", "抹茶スイーツカフェ", "京懐石料理"));
        gourmetSpots.put("嵐山", Arrays.asList("嵐山うどん", "桜餅の老舗", "鯛茶漬け"));
        gourmetSpots.put("伏見", Arrays.asList("酒蔵巡りの居酒屋", "京風おでん", "甘酒専門店"));
        gourmetSpots.put("天橋立", Arrays.asList("海鮮丼の名店", "黒ちくわ", "天橋立ワイン"));
        gourmetSpots.put("南丹", Arrays.asList("ジビエ料理", "美山牛乳ソフトクリーム", "地元産そば"));
        gourmetSpots.put("向日市", Arrays.asList("たけのこ料理", "向日市ラーメン", "手作り和菓子店"));
    }

    // 一覧表示
    private static void displayList(String title, Map<String, List<String>> data) {
        System.out.println("\n=== " + title + " ===");
        for (String area : data.keySet()) {
            System.out.println("【" + area + "】");
            for (String spot : data.get(area)) {
                System.out.println(" - " + spot);
            }
        }
    }
}