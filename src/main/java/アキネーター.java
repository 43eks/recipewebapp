import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class アキネーター {
    private static Map<String, List<String>>武将データ = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("戦国武将アキネーターを開始します！\n質問に y (はい) / n (いいえ) で答えてください。");

        // 初期データ
        add武将("伊達政宗", Arrays.asList("東北", "隻眼"));
        add武将("片倉小十郎", Arrays.asList("東北"));
        add武将("黒田官兵衛", Arrays.asList("軍師", "豊臣"));
        add武将("真田昌幸", Arrays.asList("軍師"));
        add武将("毛利元就", Arrays.asList("中国地方"));

        while (true) {
            System.out.println("1. アキネーターをプレイ\n2. 武将を追加\n3. 終了");
            System.out.print("選択してください: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // バッファクリア

            if (choice == 1) {
                playGame(scanner);
            } else if (choice == 2) {
                add武将FromUser(scanner);
            } else if (choice == 3) {
                System.out.println("ゲームを終了します。ありがとうございました！");
                break;
            }
        }
        scanner.close();
    }

    private static void playGame(Scanner scanner) {
        System.out.println("あなたが考えている武将を当てます！");
        for (Map.Entry<String, List<String>> entry : 武将データ.entrySet()) {
            String name = entry.getKey();
            List<String> traits = entry.getValue();
            boolean match = true;
            for (String trait : traits) {
                if (!askQuestion(scanner, trait + "に関連がありますか？")) {
                    match = false;
                    break;
                }
            }
            if (match) {
                System.out.println("あなたが考えているのは『" + name + "』ですね！");
                return;
            }
        }
        System.out.println("該当する武将が見つかりませんでした。");
    }

    private static void add武将FromUser(Scanner scanner) {
        System.out.print("追加する武将の名前を入力してください: ");
        String name = scanner.nextLine();
        List<String> traits = new ArrayList<>();
        System.out.println("武将の特徴を入力してください (終了するには 'done' を入力) ");
        while (true) {
            System.out.print("特徴: ");
            String trait = scanner.nextLine();
            if (trait.equalsIgnoreCase("done")) break;
            traits.add(trait);
        }
        add武将(name, traits);
        System.out.println(name + "を追加しました！");
    }

    private static void add武将(String name, List<String> traits) {
        武将データ.put(name, traits);
    }

    private static boolean askQuestion(Scanner scanner, String question) {
        System.out.print(question + " (y/n): ");
        String answer = scanner.next().trim().toLowerCase();
        scanner.nextLine(); // バッファクリア
        return answer.equals("y");
    }
}
