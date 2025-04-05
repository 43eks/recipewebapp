package クイズ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 北海道アプリ {
    private static Map<String, List<String>> sightseeingSpots = new HashMap<>();
    private static Map<String, List<String>> gourmetSpots = new HashMap<>();
    private static Map<String, String> sightseeingDetails = new HashMap<>();

    public static void main(String[] args) {
        printJavaInfo(); // ← Javaバージョン表示

        initializeData();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== 北海道アプリ ===");
            System.out.println("1. 観光名所一覧");
            System.out.println("2. グルメスポット一覧");
            System.out.println("3. 観光名所の詳細を見る");
            System.out.println("4. 終了");
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
                    showSightseeingDetail(scanner);
                    break;
                case 4:
                    System.out.println("アプリを終了します。");
                    return;
                default:
                    System.out.println("無効な選択です。もう一度入力してください。");
            }
        }
    }

    private static void printJavaInfo() {
        System.out.println("==== Java実行環境情報 ====");
        System.out.println("Javaバージョン: " + System.getProperty("java.version"));
        System.out.println("Javaベンダー: " + System.getProperty("java.vendor"));
        System.out.println("Javaホーム: " + System.getProperty("java.home"));
        System.out.println("==========================");
    }

    private static void initializeData() {
        sightseeingSpots.put("札幌", Arrays.asList("大通公園", "時計台", "藻岩山"));
        sightseeingSpots.put("函館", Arrays.asList("五稜郭", "函館山", "元町教会群"));
        sightseeingSpots.put("小樽", Arrays.asList("小樽運河", "オルゴール堂", "北一硝子"));

        gourmetSpots.put("札幌", Arrays.asList("札幌ラーメン", "ジンギスカン", "スープカレー"));
        gourmetSpots.put("函館", Arrays.asList("海鮮丼", "イカ刺し", "塩ラーメン"));
        gourmetSpots.put("小樽", Arrays.asList("お寿司", "小樽ビール", "あんかけ焼きそば"));

        sightseeingDetails.put("大通公園", "札幌中心部にある美しい都市公園。四季折々の花が楽しめる。");
        sightseeingDetails.put("時計台", "札幌の象徴的建築物。明治時代に建設された歴史的建物。");
        sightseeingDetails.put("藻岩山", "札幌市街を一望できる夜景スポット。ロープウェイあり。");

        sightseeingDetails.put("五稜郭", "星形の西洋式城郭。桜の名所としても知られる。");
        sightseeingDetails.put("函館山", "函館市を見渡せる絶景スポット。夜景が有名。");
        sightseeingDetails.put("元町教会群", "歴史ある教会が点在する異国情緒あふれるエリア。");

        sightseeingDetails.put("小樽運河", "石造倉庫とガス灯が並ぶロマンチックな運河沿い。");
        sightseeingDetails.put("オルゴール堂", "アンティークなオルゴールが並ぶ観光施設。");
        sightseeingDetails.put("北一硝子", "伝統的な小樽ガラスの工房とギャラリー。");
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

    private static void showSightseeingDetail(Scanner scanner) {
        System.out.println("\n詳細を見たい観光名所を入力してください:");
        String input = scanner.nextLine();
        if (sightseeingDetails.containsKey(input)) {
            System.out.println("■ " + input + " の詳細");
            System.out.println(sightseeingDetails.get(input));
        } else {
            System.out.println("その観光名所は見つかりませんでした。正しい名前を入力してください。");
        }
    }
}