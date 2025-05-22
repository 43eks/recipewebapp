import java.util.*;

public class Javaフレームワークアプリ {
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

    private static void displayList(String string, Map<String, List<String>> sightseeingSpots2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	// 初期データを追加
    private static void initializeData() {
        sightseeingSpots.put("東山", Arrays.asList("清水寺", "八坂神社", "高台寺"));
        sightseeingSpots.put("嵐山", Arrays.asList("渡月橋", "竹林の道", "天龍寺"));
        sightseeingSpots.put("伏見", Arrays.asList("伏見稲荷大社", "寺田屋", "月桂冠大倉