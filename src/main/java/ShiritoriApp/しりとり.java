package ShiritoriApp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class しりとり {

    // 使われた単語を保存するセット
    private static Set<String> usedWords = new HashSet<>();
    
    // 各難易度ごとの単語リスト
    private static List<String> veryEasyWords = Arrays.asList(
            "りんご", "ごま", "まんじゅう", "うさぎ", "ぎんこう", "こうえん", "えび", "びん", "たきび", "まめ"
    );
    
    private static List<String> easyWords = Arrays.asList(
            "りんご", "ごま", "まくら", "らっこ", "こま", "まんじゅう", "うなぎ", "ぎんこう", "こうえん", "えび",
            "びん", "たきび", "まめ", "めん", "んま", "まほう", "うさぎ", "ぎょうざ", "ざる", "るび"
    );

    private static List<String> mediumWords = Arrays.asList(
            "しんぶん", "まつ", "つき", "きた", "たけやま", "まつ", "つる", "るい", "いぬ", "ぬけ",
            "ゲシュタルト崩壊", "アメリカ", "ラッパ", "パラダイス", "さくらんぼ", "ぼたん", "たぬき", "きのこ",
            "こま", "まっすぐ", "ぐんま", "まつ", "つき", "きた", "たけやま", "まつ", "つる", "るい"
    );
    
    private static List<String> hardWords = Arrays.asList(
            "いざよい", "よだれ", "れいむ", "むし", "しらたま", "まお", "おろち", "ちょう", "うま", "ます",
            "すいか", "からす", "すいせん", "んとう", "うんこ", "ことり", "りんご", "ごま", "まんじゅう",
            "うなぎ", "ぎんこう", "こうえん", "えび", "びん", "たきび", "まめ", "めん", "んま", "まほう",
            "うさぎ", "ぎょうざ", "ざる", "るび", "びょうき", "きりん", "んま", "まん", "んか", "かばん"
    );

    private static List<String> oniWords = Arrays.asList(
            "あんぱん", "んま", "まるごと", "とら", "らっぱ", "ぱん", "んま", "まま", "まど", "どんぶり",
            "りす", "すし", "しんぶん", "んち", "ちか", "かみ", "みかん", "んとう", "うえ", "えき",
            "きん", "んけ", "けんか", "かご", "ごま", "まくら", "ダンス", "おに", "らん", "お",
            "おすし", "しょく", "くつ", "つくえ", "えき", "きのこ", "こま", "まっすぐ", "ぐんま",
            "まつ", "つき", "きた", "たけやま", "まつ", "つる", "るい", "いぬ", "ぬけ", "ゲシュタルト崩壊",
            "アメリカ", "ラッパ", "パラダイス", "あんぱん", "んま", "まるごと", "とら", "らっぱ", "ぱん"
    );
    
    // プレイヤーとコンピュータのスコア
    private static int playerScore = 0;
    private static int computerScore = 0;

    // 難易度設定
    private static String difficulty = "veryEasy"; // デフォルトは「veryEasy」

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lastWord = ""; // 最後の単語を保持する変数
        String playerInput = "";

        // 難易度を選択
        System.out.println("難易度を選んでください: veryEasy, easy, medium, hard, oni");
        difficulty = scanner.nextLine().trim();

        // 最初の単語を取得
        System.out.println("しりとりを始めます。最初の単語を入力してください:");
        while (true) {
            playerInput = scanner.nextLine().trim();
            if (playerInput.isEmpty()) {
                System.out.println("単語を入力してください。");
                continue;
            }
            // 最初の単語を使用したとしてセットに追加
            usedWords.add(playerInput);
            lastWord = playerInput;
            break;
        }

        // しりとりのループ
        while (true) {
            // プレイヤーのターン
            System.out.println("「" + lastWord.charAt(lastWord.length() - 1) + "」で始まる単語を入力してください:");
            playerInput = scanner.nextLine().trim();

            if (playerInput.isEmpty()) {
                System.out.println("単語を入力してください。");
                continue;
            }

            // 単語が使用済みかチェック
            if (usedWords.contains(playerInput)) {
                System.out.println("その単語はすでに使われています。別の単語を入力してください。");
                continue;
            }

            // 最後の文字が一致するかチェック
            if (playerInput.charAt(0) != lastWord.charAt(lastWord.length() - 1)) {
                System.out.println("最後の文字と一致しません。もう一度入力してください。");
                continue;
            }

            // プレイヤーが正しい単語を入力した場合、使用済みリストに追加
            usedWords.add(playerInput);
            lastWord = playerInput;
            playerScore++; // プレイヤーが正しい単語を入力したのでスコアを加算

            // もし「ん」で終わったらゲーム終了
            if (playerInput.endsWith("ん")) {
                System.out.println("「ん」で終わったのでゲーム終了！");
                break;
            }

            // コンピュータのターン
            System.out.println("コンピュータのターン...");
            String computerWord = getComputerWord(lastWord.charAt(lastWord.length() - 1));
            if (computerWord == null) {
                System.out.println("コンピュータは言葉を思いつけませんでした。あなたの勝ちです！");
                break;
            }

            System.out.println("コンピュータ: " + computerWord);
            usedWords.add(computerWord);
            lastWord = computerWord;
            computerScore++; // コンピュータが正しい単語を入力したのでスコアを加算

            // もし「ん」で終わったらゲーム終了
            if (computerWord.endsWith("ん")) {
                System.out.println("コンピュータが「ん」で終わったのでゲーム終了！");
                break;
            }
        }

        // ゲーム終了後、最終スコアを表示
        System.out.println("ゲーム終了！");
        System.out.println("プレイヤーのスコア: " + playerScore);
        System.out.println("コンピュータのスコア: " + computerScore);

        // 勝者を表示
        if (playerScore > computerScore) {
            System.out.println("おめでとうございます！あなたの勝ちです！");
        } else if (playerScore < computerScore) {
            System.out.println("コンピュータの勝ちです！");
        } else {
            System.out.println("引き分けです！");
        }
    }

    // コンピュータが使う単語を取得するメソッド
    private static String getComputerWord(char lastChar) {
        List<String> selectedWords;
        
        // 難易度に応じた単語リストを選択
        switch (difficulty) {
            case "easy":
                selectedWords = easyWords;
                break;
            case "medium":
                selectedWords = mediumWords;
                break;
            case "hard":
                selectedWords = hardWords;
                break;
            case "oni":
                selectedWords = oniWords;
                break;
            case "veryEasy":
            default:
                selectedWords = veryEasyWords;
                break;
        }

        // 単語リストの中から使われていない単語を探す
        for (String word : selectedWords) {
            if (!usedWords.contains(word) && word.charAt(0) == lastChar) {
                return word;
            }
        }

        // 使用できる単語がない場合はnullを返す
        return null;
    }
}