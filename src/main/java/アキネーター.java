import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class アキネーター {
    private static Map<String, List<String>> 武将データ = new HashMap<>();
    private static Map<String, String> 武将豆知識 = new HashMap<>();
    private static Map<String, String> 武将家系情報 = new HashMap<>();
    private static Map<String, String> 武将お城情報 = new HashMap<>();
    private static List<String> 戦国豆知識 = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("戦国武将アキネーターを開始します！\n質問に y (はい) / n (いいえ) で答えてください。");

        // 初期データ追加
        add武将("伊達政宗", Arrays.asList("東北", "隻眼"), "伊達政宗は独眼竜の異名を持つカリスマ武将だった！", "伊達家の当主。政宗は伊達家を一族としてまとめ上げた。", "仙台城");
        add武将("織田信長", Arrays.asList("尾張", "天下統一"), "織田信長は革新的な政策と戦術で戦国時代を大きく変えた。", "織田家の当主。", "安土城");
        add武将("武田信玄", Arrays.asList("甲斐", "騎馬軍団"), "武田信玄は風林火山の旗のもと、最強の騎馬軍団を率いた。", "武田家の当主。", "躑躅ヶ崎館");
        
        // 戦国豆知識リスト
        戦国豆知識.add("戦国時代の鉄砲伝来は1543年、種子島にポルトガル人が漂着したことがきっかけ！");
        戦国豆知識.add("関ヶ原の戦いはわずか半日で決着がついたが、日本の歴史を大きく変えた。");

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
                System.out.println("【豆知識】" + 武将豆知識.get(name));
                System.out.println("【家系情報】" + 武将家系情報.get(name));
                System.out.println("【お城】" + 武将お城情報.get(name));  // お城情報の表示
                displayRandomTrivia();
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
        System.out.print("この武将の豆知識を入力してください: ");
        String trivia = scanner.nextLine();
        System.out.print("この武将の家系情報を入力してください: ");
        String familyInfo = scanner.nextLine();
        System.out.print("この武将が城主だったお城の名前を入力してください: ");
        String castleName = scanner.nextLine();
        add武将(name, traits, trivia, familyInfo, castleName);
        System.out.println(name + "を追加しました！");
    }

    private static void add武将(String name, List<String> traits, String trivia, String familyInfo, String castleName) {
        武将データ.put(name, traits);
        武将豆知識.put(name, trivia);
        武将家系情報.put(name, familyInfo);
        武将お城情報.put(name, castleName);  // お城情報の追加
    }

    private static boolean askQuestion(Scanner scanner, String question) {
        System.out.print(question + " (y/n): ");
        String answer = scanner.next().trim().toLowerCase();
        scanner.nextLine(); // バッファクリア
        return answer.equals("y");
    }

    private static void displayRandomTrivia() {
        Random random = new Random();
        int index = random.nextInt(戦国豆知識.size());
        System.out.println("【戦国豆知識】" + 戦国豆知識.get(index));
    }
}
