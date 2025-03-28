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
    private static List<String> 戦国豆知識 = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("戦国武将アキネーターを開始します！\n質問に y (はい) / n (いいえ) で答えてください。");

        // 初期データ
        add武将("伊達政宗", Arrays.asList("東北", "隻眼"), "伊達政宗は独眼竜の異名を持つカリスマ武将だった！", "伊達家の当主。政宗は伊達家を一族としてまとめ上げた。", "仙台城");
        add武将("片倉小十郎", Arrays.asList("東北"), "片倉小十郎は伊達政宗の忠実な家臣であり、優れた戦略家だった。", "片倉家の家臣で、伊達家の忠実なしもべ。", "仙台城");
        add武将("黒田官兵衛", Arrays.asList("軍師", "豊臣"), "黒田官兵衛は豊臣秀吉の軍師として活躍し、後に福岡藩の基礎を築いた。", "黒田家の家督を継ぎ、後に福岡藩主となった。", "福岡城");
        add武将("真田昌幸", Arrays.asList("軍師"), "真田昌幸は知略に優れ、上田城の戦いで徳川軍を二度も撃退した。", "真田家の当主。真田家はその知恵と勇気で知られる。", "上田城");
        add武将("毛利元就", Arrays.asList("中国地方"), "毛利元就は『三本の矢』の教えで知られ、毛利家を大勢力に成長させた。", "毛利家の家族で、三本の矢の教えが家族を団結させた。", "吉田郡山城");
        add武将("織田信長", Arrays.asList("尾張", "天下布武"), "織田信長は戦国時代の革命児で、全国統一を目指した。", "織田家の当主で、斬新な戦術を多用した。", "安土城");
        add武将("長宗我部元親", Arrays.asList("四国"), "長宗我部元親は四国を統一した戦国武将。", "長宗我部家の当主。", "岡豊城");
        add武将("島津義久", Arrays.asList("九州"), "島津義久は九州の雄で、戦国時代を生き抜いた。", "島津家の当主。", "鹿児島城");
        add武将("天草四郎", Arrays.asList("江戸初期", "キリシタン"), "天草四郎は島原の乱を指導したカリスマ的存在。", "江戸時代初期の宗教的指導者。", "原城");
        add武将("最上義光", Arrays.asList("東北"), "最上義光は東北の戦国大名で、外交戦略に長けていた。", "最上家の当主。", "山形城");
        add武将("武田信玄", Arrays.asList("甲斐", "風林火山"), "武田信玄は戦国最強の騎馬軍団を率いた。", "武田家の当主。", "躑躅ヶ崎館");
        add武将("北条氏政", Arrays.asList("関東"), "北条氏政は小田原城を拠点に関東を支配した。", "北条家の当主。", "小田原城");

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

	private static void add武将FromUser(Scanner scanner) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	private static void playGame(Scanner scanner) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	private static void add武将(String string, List<String> asList, String string2, String string3, String string4) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
