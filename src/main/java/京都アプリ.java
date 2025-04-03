import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class 京都アプリ {
    private static Map<String, List<String>> sightseeingSpots = new HashMap<>();
    private static Map<String, List<String>> gourmetSpots = new HashMap<>();
    private static List<String> favoriteList = new ArrayList<>();

    public static void main(String[] args) {
        initializeData();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== 京都アプリ ===");
            System.out.println("1. 観光名所一覧");
            System.out.println("2. グルメスポット一覧");
            System.out.println("3. お気に入り一覧");
            System.out.println("4. お気に入りに追加");
            System.out.println("5. おすすめを表示");
            System.out.println("6. 終了");
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
                    displayFavorites();
                    break;
                case 4:
                    addFavorite(scanner);
                    break;
                case 5:
                    displayRecommendations();
                    break;
                case 6:
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

        gourmetSpots.put("東山", Arrays.asList("湯豆腐の名店", "抹茶スイーツカフェ", "京懐石料理"));
        gourmetSpots.put("嵐山", Arrays.asList("嵐山うどん", "桜餅の老舗", "鯛茶漬け"));
        gourmetSpots.put("伏見", Arrays.asList("酒蔵巡りの居酒屋", "京風おでん", "甘酒専門店"));
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

    // お気に入り一覧表示
    private static void displayFavorites() {
        System.out.println("\n=== お気に入り一覧 ===");
        if (favoriteList.isEmpty()) {
            System.out.println("お気に入りはまだ登録されていません。");
        } else {
            for (String favorite : favoriteList) {
                System.out.println(" - " + favorite);
            }
        }
    }

    // お気に入りに追加
    private static void addFavorite(Scanner scanner) {
        System.out.println("\n追加したいスポットを入力してください:");
        String spot = scanner.nextLine();
        if (isSpotExists(spot)) {
            favoriteList.add(spot);
            System.out.println(spot + " をお気に入りに追加しました。");
        } else {
            System.out.println("スポットが見つかりません。正しく入力してください。");
        }
    }

    // スポットが存在するかチェック
    private static boolean isSpotExists(String spot) {
        for (List<String> spots : sightseeingSpots.values()) {
            if (spots.contains(spot)) return true;
        }
        for (List<String> spots : gourmetSpots.values()) {
            if (spots.contains(spot)) return true;
        }
        return false;
    }

    // おすすめの観光名所・グルメスポットを表示
    private static void displayRecommendations() {
        System.out.println("\n=== おすすめスポット ===");

        if (favoriteList.isEmpty()) {
            System.out.println("お気に入りが登録されていません。まずはお気に入りに追加してみましょう。");
            return;
        }

        Set<String> recommended = new HashSet<>();

        // お気に入りにあるスポットと同じエリアの別のスポットをおすすめする
        for (String area : sightseeingSpots.keySet()) {
            List<String> sightseeing = sightseeingSpots.get(area);
            List<String> gourmet = gourmetSpots.get(area);

            for (String favorite : favoriteList) {
                if (sightseeing.contains(favorite)) {
                    recommended.addAll(sightseeing);
                    recommended.addAll(gourmet);
                }
                if (gourmet.contains(favorite)) {
                    recommended.addAll(sightseeing);
                    recommended.addAll(gourmet);
                }
            }
        }

        // すでにお気に入りに登録されているものは除外
        recommended.removeAll(favoriteList);

        if (recommended.isEmpty()) {
            System.out.println("新しいおすすめスポットはありません。");
        } else {
            for (String spot : recommended) {
                System.out.println(" - " + spot);
            }
        }
    }
}