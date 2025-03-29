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
        add武将("伊達政宗", Arrays.asList("東北", "隻眼"), "独眼竜の異名を持つカリスマ武将。", "伊達家の当主。", "仙台城", "カリスマ性があり、野心家", "戦国の世に生まれたからには、大志を抱かねばならぬ！");
        add武将("片倉小十郎", Arrays.asList("東北"), "伊達政宗の忠実な家臣で戦略家。", "片倉家の家臣。", "仙台城", "忠義心が強く、冷静沈着", "主君を守ることこそ、我が使命なり！");
        add武将("黒田官兵衛", Arrays.asList("軍師", "豊臣"), "豊臣秀吉の軍師として活躍。", "黒田家の当主。", "福岡城", "知略に優れた策略家", "勝つためには、策を尽くさねばならぬ。");
        add武将("佐々成政", Arrays.asList("猛将", "織田"), "織田信長に仕えた勇猛な武将。", "佐々家の当主。", "富山城", "大胆不敵", "運命を切り拓くのは己の力だ！");
        add武将("斎藤道三", Arrays.asList("美濃", "戦国大名"), "美濃のマムシと呼ばれた戦国大名。", "斎藤家の当主。", "稲葉山城", "狡猾で策略家", "天下は力で奪い取るものなり！");
        add武将("山中鹿之介", Arrays.asList("忠義", "尼子家"), "尼子家を支えた忠義の士。", "山中家の家臣。", "月山富田城", "忠誠心が強い", "願わくば、我に七難八苦を与えたまえ！");
        add武将("真田昌幸", Arrays.asList("知略", "真田家"), "真田家を支えた戦国の知将。", "真田家の当主。", "上田城", "冷静沈着", "戦とは知恵を尽くすものよ。");

        // 新規追加の7名
        add武将("豊臣秀吉", Arrays.asList("天下人", "豊臣"), "農民から天下人へと成り上がった伝説の武将。", "豊臣家の創始者。", "大阪城", "人たらしで大胆", "鳴かぬなら鳴かせてみせようホトトギス。");
        add武将("徳川家康", Arrays.asList("江戸", "忍耐"), "忍耐強く江戸幕府を開いた知略家。", "徳川家の当主。", "江戸城", "慎重かつ冷静", "鳴かぬなら鳴くまで待とうホトトギス。");
        add武将("前田利家", Arrays.asList("加賀", "槍の又左"), "加賀百万石の礎を築いた武将。", "前田家の当主。", "金沢城", "義理堅く勇敢", "義をもって戦うべし！");
        add武将("上杉謙信", Arrays.asList("義", "越後"), "戦国最強と名高い義の武将。", "上杉家の当主。", "春日山城", "義を重んじる", "我、義に生きる！");
        add武将("本多忠勝", Arrays.asList("猛将", "徳川"), "徳川家康を支えた無敵の猛将。", "本多家の家臣。", "岡崎城", "剛勇無双", "我が生涯に一片の悔いなし！");
        add武将("藤堂高虎", Arrays.asList("築城", "知略"), "何度も主君を変えながらも成功した築城の名人。", "藤堂家の当主。", "今治城", "適応力に優れる", "人の世は流れゆくものなり。");
        add武将("直江兼続", Arrays.asList("愛", "上杉"), "「愛」の前立て兜が有名な上杉家の忠臣。", "直江家の家臣。", "米沢城", "忠義心が強い", "愛こそが武士の誇りである！");

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

    private static void displayRandomTrivia() {
        if (!戦国豆知識.isEmpty()) {
            int randomIndex = (int) (Math.random() * 戦国豆知識.size());
            System.out.println("【戦国豆知識】" + 戦国豆知識.get(randomIndex));
        }
    }

    private static boolean askQuestion(Scanner scanner, String question) {
        System.out.print(question + " (y/n): ");
        String answer = scanner.nextLine();
        return answer.equalsIgnoreCase("y");
    }
}