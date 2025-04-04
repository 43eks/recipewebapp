package クイズ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 北海道アプリ {
    private static Map<String, List<String>> sightseeingSpots = new HashMap<>();
    private static Map<String, List<String>> gourmetSpots = new HashMap<>();

    public static void main(String[] args) {
        initializeData();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== 北海道アプリ ===");
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

    private static void initializeData() {
        sightseeingSpots.put("札幌", Arrays.asList("大通公園", "時計台", "藻岩山"));
        sightseeingSpots.put("函館", Arrays.asList("五稜郭", "函館山", "元町教会群"));
        sightseeingSpots.put("小樽", Arrays.asList("小樽運河", "オルゴール堂", "北一硝子"));

        gourmetSpots.put("札幌", Arrays.asList("札幌ラーメン", "ジンギスカン", "スープカレー"));
        gourmetSpots.put("函館", Arrays.asList("海鮮丼", "イカ刺し", "塩ラーメン"));
        gourmetSpots.put("小樽", Arrays.asList("お寿司", "小樽ビール", "あんかけ焼きそば"));
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