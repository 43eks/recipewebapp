package ShiritoriApp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class しりとり {

    // 使われた単語を保存するセット
    private static Set<String> usedWords = new HashSet<>();
    // コンピュータが使う単語リスト（500個の単語）
    private static List<String> availableWords = Arrays.asList(
            "りんご", "ごま", "まくら", "らっこ", "こま", "まんじゅう", "うなぎ", "ぎんこう", "こうえん", "えび",
            "びん", "んま", "まめ", "めん", "んま", "まほう", "うさぎ", "ぎょうざ", "ざる", "るび", "びょうき", "きりん", "んま",
            "まご", "ごみ", "みかん", "んま", "まくら", "らいおん", "んき", "きしゃ", "しゃくし", "しろ", "ろうか", "かま", "まつり",
            "りんご", "ごめん", "んけ", "けん", "んま", "まつり", "りあん", "んい", "いす", "すいか", "かみ", "みどり", "りんご",
            "ごはん", "んま", "まる", "るい", "いぬ", "ぬりえ", "えんぴつ", "つみき", "きんぎょ", "よる", "るしあ", "あらし",
            "しま", "ます", "すいようび", "びりや", "やきそば", "ばね", "ねこ", "こむぎ", "ぎんこう", "こうえん", "えす", "すみれ",
            "れいぞうこ", "こけ", "けんこう", "こうえん", "えんぴつ", "つけもの", "もの", "のり", "りんご", "ごめん", "んま", 
            "まんきつ", "つる", "るい", "いえ", "えんぴつ", "つの", "のこぎり", "りょうしん", "しん", "んま", "まめ", "めし",
            "しまうま", "まん", "んけ", "けん", "んま", "まい", "いか", "かに", "にんじん", "んぴ", "ぴあ", "あさ", "さくら", "らじ",
            "じかん", "んま", "まん", "んこ", "こめ", "めん", "んま", "まつり", "りす", "すけ", "けい", "いか", "かた", "たけ",
            "けつ", "つみ", "みき", "きく", "くま", "まつ", "つか", "かん", "んま", "まる", "るい", "いぬ", "ぬいぐるみ", "みず",
            "ずきん", "んま", "まつ", "つけ", "けん", "んま", "まい", "いし", "しん", "んま", "まさ", "さくら", "らい", "いと",
            "とけ", "けん", "んま", "まな", "なむ", "むし", "しん", "んま", "まつ", "つく", "くろ", "ろう", "うま", "まく", "くち",
            "ちく", "くじ", "じけ", "けし", "しん", "んま", "まむ", "むぎ", "ぎょう", "うら", "らく", "くろ", "ろう", "うし", "しん",
            "んま", "まん", "んま", "まめ"
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lastWord = ""; // 最後の単語を保持する変数
        String playerInput = "";

        System.out.println("しりとりを始めます。");
        System.out.println("最初の単語を入力してください:");

        // 最初の単語を取得
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
                System.out.println("前の単語の最後の文字「" + lastWord.charAt(lastWord.length() - 1) + "」で始めてください。");
                continue;
            }

            // 「ん」がついていた場合は終了
            if (playerInput.charAt(playerInput.length() - 1) == 'ん') {
                System.out.println("「" + playerInput + "」は「ん」で終わったため、ゲーム終了です。プレイヤーの負けです！");
                break;
            }

            // 正常な入力の場合は単語を追加して次のターンに進む
            usedWords.add(playerInput);
            lastWord = playerInput; // 最後の単語を更新

            System.out.println("プレイヤーのターンが終了しました。");

            // コンピュータのターン
            String computerWord = getComputerWord(lastWord.charAt(lastWord.length() - 1));
            if (computerWord != null) {
                // 「ん」がついていた場合は終了
                if (computerWord.charAt(computerWord.length() - 1) == 'ん') {
                    System.out.println("コンピュータは「" + computerWord + "」を出しました。");
                    System.out.println("「ん」で終わったため、ゲーム終了です。プレイヤーの勝ちです！");
                    break;
                }

                usedWords.add(computerWord);
                lastWord = computerWord;
                System.out.println("コンピュータは「" + computerWord + "」を出しました。");
            } else {
                System.out.println("コンピュータは出せる単語がありません。プレイヤーの勝ちです！");
                break;
            }
        }
    }

    // コンピュータが次に出す単語を決定するメソッド
    private static String getComputerWord(char lastChar) {
        // 最後の文字で始まる単語を検索
        for (String word : availableWords) {
            if (!usedWords.contains(word) && word.charAt(0) == lastChar) {
                return word;
            }
        }
        return null; // 出せる単語がない場合
    }
}