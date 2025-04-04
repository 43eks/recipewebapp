import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings("preview")
private static Map<String, List<String>> sightseeingSpots = new HashMap<>();
private static Map<String, List<String>> gourmetSpots = new HashMap<>();
private static Map<String, String> sightseeingDetails = new HashMap<>(); // 👈 追加

public static void main(String[] args) {
    initializeData();
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("\n=== 富山アプリ ===");
        System.out.println("1. 観光名所一覧");
        System.out.println("2. グルメスポット一覧");
        System.out.println("3. 観光名所の詳細を見る"); // 👈 新機能
        System.out.println("4. 終了");
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
                showSightseeingDetail(scanner);
                break;
            case 4:
                System.out.println("アプリを終了します。");
                return;
            default:
                System.out.println("無効な選択です。");
        }
    }
}

private static void showSightseeingDetail(Scanner scanner) {
	// TODO 自動生成されたメソッド・スタブ
	
}

private static void displayList(String string, Map<String, List<String>> sightseeingSpots2) {
	// TODO 自動生成されたメソッド・スタブ
	
}

private static void initializeData() {
	// TODO 自動生成されたメソッド・スタブ
	
}