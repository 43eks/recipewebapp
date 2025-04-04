import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class 富山アプリ {
    private static Map<String, List<String>> sightseeingSpots = new HashMap<>();
    private static Map<String, List<String>> gourmetSpots = new HashMap<>();
    private static Map<String, List<String>> culturalAssets = new HashMap<>();

    public static void main(String[] args) {
        initializeData();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== 富山アプリ ===");
            System.out.println("1. 観光名所一覧");
            System.out.println("2. グルメスポット一覧");
            System.out.println("3. 詳細情報（観光）");
            System.out.println("4. 詳細情報（グルメ）");
            System.out.println("5. 地域一覧");
            System.out.println("6. 重要文化財一覧");
            System.out.println("7. 終了");
            System.out.print("選択してください: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> displayList("観光名所", sightseeingSpots);
                case 2 -> displayList("グルメスポット", gourmetSpots);
                case 3 -> showDetail(scanner, sightseeingSpots, "観光名所");
                case 4 -> showDetail(scanner, gourmetSpots, "グルメスポット");
                case 5 -> showRegions();
                case 6 -> displayList("重要文化財", culturalAssets);
                case 7 -> {
                    System.out.println("アプリを終了します。");
                    return;
                }
                default -> System.out.println("無効な選択です。もう一度入力してください。");
            }
        }
    }

    private static void initializeData() {
        sightseeingSpots.put("富山市", Arrays.asList("富山城", "ガラス美術館"));
        sightseeingSpots.put("高岡市", Arrays.asList("瑞龍寺", "高岡大仏"));
        sightseeingSpots.put("南砺市", Arrays.asList("五箇山合掌造り集落", "城端別院善徳寺"));

        gourmetSpots.put("富山市", Arrays.asList("白えび天丼", "ます寿司"));
        gourmetSpots.put("高岡市", Arrays.asList("高岡コロッケ", "昆布締め寿司"));
        gourmetSpots.put("南砺市", Arrays.asList("五箇山豆腐", "山菜料理"));

        culturalAssets.put("高岡市", Arrays.asList("瑞龍寺（国宝）", "勝興寺（重要文化財）"));
        culturalAssets.put("南砺市", Arrays.asList("城端別院善徳寺", "五箇山の合掌造り（世界遺産）"));
        culturalAssets.put("氷見市", Arrays.asList("氷見の伝統漁法", "放生津八幡宮"));
    }

    private static void displayList(String title, Map<String, List<String>> data) {
        System.out.println("\n=== " + title + " ===");
        for (String area : data.keySet()) {
            System.out.println("【" + area + "】");
            for (String item : data.get(area)) {
                System.out.println(" - " + item);
            }
        }
    }

    private static void showDetail(Scanner scanner, Map<String, List<String>> data, String title) {
        System.out.print("\n地域を入力してください（例: 富山市）: ");
        String area = scanner.nextLine();
        if (data.containsKey(area)) {
            System.out.println("\n【" + area + "】の" + title + ":");
            for (String spot : data.get(area)) {
                System.out.println(" - " + spot);
            }
        } else {
            System.out.println("地域が見つかりません。");
        }
    }

    private static void showRegions() {
        System.out.println("\n=== 地域一覧 ===");
        Set<String> allAreas = new HashSet<>();
        allAreas.addAll(sightseeingSpots.keySet());
        allAreas.addAll(gourmetSpots.keySet());
        allAreas.addAll(culturalAssets.keySet());
        for (String area : allAreas) {
            System.out.println(" - " + area);
        }
    }
}