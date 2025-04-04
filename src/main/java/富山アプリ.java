import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 富山アプリ {
    private static Map<String, List<String>> sightseeingSpots = new HashMap<>();
    private static Map<String, List<String>> gourmetSpots = new HashMap<>();

    public static void main(String[] args) {
        initializeData();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== 富山アプリ ===");
            System.out.println("1. 観光名所一覧");
            System.out.println("2. グルメスポット一覧");
            System.out.println("3. 終了");
            System.out.print("選択してください: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

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
                    System.out.println("無効な選択です。");
            }
        }
    }

    private static void initializeData() {
        sightseeingSpots.put("富山市", Arrays.asList("富山城", "ガラス美術館", "環水公園"));
        sightseeingSpots.put("高岡市", Arrays.asList("高岡大仏", "瑞龍寺", "雨晴海岸"));
        sightseeingSpots.put("黒部市", Arrays.asList("黒部峡谷", "宇奈月温泉", "黒部ダム"));

        gourmetSpots.put("富山市", Arrays.asList("白えび丼", "ます寿司", "富山ブラックラーメン"));
        gourmetSpots.put("高岡市", Arrays.asList("コロッケ", "高岡ラーメン", "甘味処の和スイーツ"));
        gourmetSpots.put("黒部市", Arrays.asList("黒部うなぎ", "温泉まんじゅう", "地元そば"));
    }

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