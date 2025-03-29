import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class アキネーター {
    private static class 武将情報 {
        List<String> 特徴;
        String 豆知識;
        String 家系情報;
        String お城;
        String 性格;
        String 名言;

        武将情報(List<String> 特徴, String 豆知識, String 家系情報, String お城, String 性格, String 名言) {
            this.特徴 = 特徴;
            this.豆知識 = 豆知識;
            this.家系情報 = 家系情報;
            this.お城 = お城;
            this.性格 = 性格;
            this.名言 = 名言;
        }
    }

    private static Map<String, 武将情報> 武将データ = new HashMap<>();
    private static List<String> 戦国豆知識 = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("戦国武将アキネーターを開始します！\n質問に y (はい) / n (いいえ) で答えてください。");

        // 初期データ
        add武将("伊達政宗", Arrays.asList("東北", "隻眼", "独立心が強い", "槍を好む"),
                "伊達政宗は独眼竜の異名を持つカリスマ武将だった！", "伊達家の当主。政宗は伊達家を一族としてまとめ上げた。",
                "仙台城", "カリスマ性があり、野心家", "戦国の世に生まれたからには、大志を抱かねばならぬ！");

        add武将("黒田官兵衛", Arrays.asList("軍師", "豊臣", "冷静沈着", "戦略家"),
                "黒田官兵衛は豊臣秀吉の軍師として活躍し、後に福岡藩の基礎を築いた。",
                "黒田家の家督を継ぎ、後に福岡藩主となった。", "福岡城", "知略に優れた策略家", "勝つためには、策を尽くさねばならぬ。");

        // 戦国豆知識
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

        for (Map.Entry<String, 武将情報> entry : 武将データ.entrySet()) {
            String name = entry.getKey();
            武将情報 info = entry.getValue();
            boolean match = true;

            for (String trait : info.特徴) {
                if (!askQuestion(scanner, trait + "に関連がありますか？")) {
                    match = false;
                    break;
                }
            }

            if (match) {
                System.out.println("あなたが考えているのは『" + name + "』ですね！");
                System.out.println("【豆知識】" + info.豆知識);
                System.out.println("【家系情報】" + info.家系情報);
                System.out.println("【お城】" + info.お城);
                System.out.println("【性格】" + info.性格);
                System.out.println("【名言】\"" + info.名言 + "\"");
                displayRandomTrivia();
                return;
            }
        }
        System.out.println("該当する武将が見つかりませんでした。");
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
        System.out.print("この武将の性格を入力してください: ");
        String personality = scanner.nextLine();
        System.out.print("この武将の名言を入力してください: ");
        String quote = scanner.nextLine();
        add武将(name, traits, trivia, familyInfo, castleName, personality, quote);
        System.out.println(name + "を追加しました！");
    }

    private static void add武将(String name, List<String> traits, String trivia, String familyInfo, String castleName, String personality, String quote) {
        武将データ.put(name, new 武将情報(traits, trivia, familyInfo, castleName, personality, quote));
    }
}