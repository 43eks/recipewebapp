import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
                "伊達政宗は独眼竜の異名を持つカリスマ武将だった！", "伊達家の当主。",
                "仙台城", "カリスマ性があり、野心家", "戦国の世に生まれたからには、大志を抱かねばならぬ！");
        add武将("片倉小十郎", Arrays.asList("東北", "忠臣", "冷静沈着"),
                "片倉小十郎は伊達政宗の忠実な家臣であり、優れた戦略家だった。", "片倉家の家臣。",
                "仙台城", "忠義心が強く、冷静沈着", "主君を守ることこそ、我が使命なり！");
        add武将("佐々成政", Arrays.asList("北陸", "織田", "勇猛果敢"),
                "佐々成政は織田家の家臣で、北陸の戦いで活躍した。", "佐々家の当主。",
                "富山城", "勇敢で忠誠心が厚い", "義を貫くことこそが、武士の道である。");
        add武将("斎藤道三", Arrays.asList("美濃", "下克上", "策略家"),
                "斎藤道三は下克上を成し遂げ、美濃を支配した。", "斎藤家の当主。",
                "稲葉山城", "冷徹で計算高い", "国を治めるのは、智略こそが鍵である。");
        add武将("山中鹿之介", Arrays.asList("中国地方", "忠義", "三日月の誓い"),
                "山中鹿之介は尼子家の忠臣で、再興を誓った。", "山中家の家臣。",
                "月山富田城", "忠義に厚く、不屈の精神", "願わくば、我に七難八苦を与えたまえ！");
        add武将("真田昌幸", Arrays.asList("信濃", "策略家", "徳川を翻弄"),
                "真田昌幸は知略に優れ、徳川軍を何度も撃退した。", "真田家の当主。",
                "上田城", "策略家で機転が利く", "智を尽くして戦えば、勝機は必ずある。");

        while (true) {
            System.out.println("1. アキネーターをプレイ\n2. 武将を追加\n3. 終了");
            System.out.print("選択してください: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

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

    private static void add武将FromUser(Scanner scanner) {
		// TODO 自動生成されたメソッド・スタブ
		
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
                return;
            }
        }
        System.out.println("該当する武将が見つかりませんでした。");
    }

    private static boolean askQuestion(Scanner scanner, String question) {
        System.out.print(question + " (y/n): ");
        String answer = scanner.next().trim().toLowerCase();
        scanner.nextLine();
        return answer.equals("y");
    }

    private static void add武将(String name, List<String> traits, String trivia, String familyInfo, String castleName, String personality, String quote) {
        武将データ.put(name, new 武将情報(traits, trivia, familyInfo, castleName, personality, quote));
    }
}
