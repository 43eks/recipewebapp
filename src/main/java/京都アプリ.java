import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 京都アプリ {
    private static Map<String, List<String>> touristSpots = new HashMap<>();
    private static Map<String, List<String>> gourmetSpots = new HashMap<>();
    
    public static void main(String[] args) {
        initializeData();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n京都アプリ - メニュー");
            System.out.println("1. 観光地一覧");
            System.out.println("2. グルメスポット一覧");
            System.out.println("3. 終了");
            System.out.print("選択してください: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 改行消費
            
            switch (choice) {
                case 1:
                    displaySpots(touristSpots, "観光地");
                    break;
                case 2:
                    displaySpots(gourmetSpots, "グルメスポット");
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
        touristSpots.put("東山", Arrays.asList("清水寺", "銀閣寺", "八坂神社"));
        touristSpots.put("嵐山", Arrays.asList("渡月橋", "竹林の小径", "天龍寺"));
        
        gourmetSpots.put("東山", Arrays.asList("湯豆腐の店", "京懐石料理店"));
        gourmetSpots.put("嵐山", Arrays.asList("抹茶スイーツカフェ", "うなぎ専門店"));
    }
    
    private static void displaySpots(Map<String, List<String>> spots, String type) {
        System.out.println("\n" + type + "一覧:");
        for (Map.Entry<String, List<String>> entry : spots.entrySet()) {
            System.out.println("【" + entry.getKey() + "】");
            for (String spot : entry.getValue()) {
                System.out.println(" - " + spot);
            }
        }
    }
}

