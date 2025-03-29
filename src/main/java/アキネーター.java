import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class アキネーター {
    private static Map<String, List<String>> 武将データ = new HashMap<>();
    private static Map<String, String> 武将豆知識 = new HashMap<>();
    private static Map<String, String> 武将家系情報 = new HashMap<>();
    private static Map<String, String> 武将お城情報 = new HashMap<>();
    private static Map<String, String> 武将性格 = new HashMap<>();
    private static Map<String, String> 武将名言 = new HashMap<>();
    private static List<String> 戦国豆知識 = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("戦国武将アキネーターを開始します！\n質問に y (はい) / n (いいえ) で答えてください。");

        // 初期データ
        add武将("伊達政宗", Arrays.asList("東北", "隻眼"), "伊達政宗は独眼竜の異名を持つカリスマ武将だった！", "伊達家の当主。政宗は伊達家を一族としてまとめ上げた。", "仙台城", "カリスマ性があり、野心家", "戦国の世に生まれたからには、大志を抱かねばならぬ！");
        add武将("片倉小十郎", Arrays.asList("東北"), "片倉小十郎は伊達政宗の忠実な家臣であり、優れた戦略家だった。", "片倉家の家臣で、伊達家の忠実なしもべ。", "仙台城", "忠義心が強く、冷静沈着", "主君を守ることこそ、我が使命なり！");
        add武将("黒田官兵衛", Arrays.asList("軍師", "豊臣"), "黒田官兵衛は豊臣秀吉の軍師として活躍し、後に福岡藩の基礎を築いた。", "黒田家の家督を継ぎ、後に福岡藩主となった。", "福岡城", "知略に優れた策略家", "勝つためには、策を尽くさねばならぬ。");

        // 戦国豆知識リスト
        戦国豆知識.add("戦国時代の鉄砲伝来は1543年、種子島にポルトガル人が漂着したことがきっかけ！");
        戦国豆知識.add("戦国武将の兜には、敵を威圧するために派手な装飾が施されていた！");
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
                System.out.println("【お城】" + 武将お城情報.get(name));
                System.out.println("【性格】" + 武将性格.get(name));
                System.out.println("【名言】\"" + 武将名言.get(name) + "\"");
                displayRandomTrivia();
                return;
            }
        }
        System.out.println("該当する武将が見つかりませんでした。");
    }

    private static void displayRandomTrivia() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	private static boolean askQuestion(Scanner scanner, String string) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
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
        武将データ.put(name, traits);
        武将豆知識.put(name, trivia);
        武将家系情報.put(name, familyInfo);
        武将お城情報.put(name, castleName);
        武将性格.put(name, personality);
        武将名言.put(name, quote);
    }
}
