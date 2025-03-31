package ShiritoriApp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class しりとり {

    // 使われた単語を保存するセット
    private static Set<String> usedWords = new HashSet<>();
    // コンピュータが使う単語リスト（1000個の単語）
    private static List<String> availableWords = Arrays.asList(
            "りんご", "ごま", "まくら", "らっこ", "こま", "まんじゅう", "うなぎ", "ぎんこう", "こうえん", "えび",
            "びん", "たきび", "まめ", "めん", "んま", "まほう", "うさぎ", "ぎょうざ", "ざる", "るび", "びょうき", "きりん", "んま",
            "まご", "ごみ", "みかん", "んま", "まくら", "らいおん", "んき", "きしゃ", "しゃくし", "しろ", "ろうか", "かま", "まつり",
            "りんご", "ごめん", "んけ", "けん", "おにぎり", "まつり", "りあん", "んい", "いす", "すいか", "かみ", "みどり", "りんご",
            "ごはん", "あまくさしろう", "まる", "るい", "いぬ", "ぬりえ", "えんぴつ", "つみき", "きんぎょ", "よる", "るしあ", "あらし",
            "しま", "ます", "すいようび", "びりや", "やきそば", "ばね", "ねこ", "こむぎ", "ぎんこう", "こうえん", "えす", "すみれ",
            "れいぞうこ", "こけ", "けんこう", "こうえん", "えんぴつ", "つけもの", "もの", "のり", "りんご", "ごめん", "んま",
            "まんきつ", "つる", "るい", "いえ", "えんぴつ", "つの", "のこぎり", "りょうしん", "しん", "んま", "まめ", "めし",
            "しまうま", "まん", "けだま", "けん", "んま", "まい", "いか", "かに", "にんじん", "んぴ", "ぴあ", "あさ", "さくら", "らじ",
            "じかん", "んま", "まん", "こたつ", "こめ", "めん", "んま", "まつり", "りす", "すけ", "けい", "いか", "かた", "たけ",
            "けつ", "つみ", "みき", "きく", "くま", "まつ", "つか", "かん", "んま", "まる", "るい", "いぬ", "ぬいぐるみ", "みず",
            "ずきん", "んま", "まつ", "つけ", "けん", "んま", "まい", "いし", "しん", "んま", "まさ", "さくら", "らい", "いと",
            "とけ", "けん", "んま", "まな", "なむ", "むし", "しん", "んま", "まつ", "つく", "くろ", "ろう", "うま", "まく", "くち",
            "ちく", "くじ", "じけ", "けし", "しん", "たまこんにゃく", "まむ", "むぎ", "ぎょう", "うら", "らく", "くろ", "ろう", "うし", "しん",
            "んま", "まん", "んま", "まめ", "めし", "しまうま", "まん", "んけ", "けん", "んま", "まい", "いし", "しん", "んま",
            "まさ", "さくら", "らい", "いぬ", "ぬいぐるみ", "みかん", "んま", "まんきつ", "つる", "るい", "いえ", "えんぴつ",
            "つき", "きり", "りんご", "ごはん", "んま", "まくら", "らいおん", "んけ", "けん", "んま", "まい", "いぬ", "ぬりえ"
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
                System.out.println("最後の文字と一致しません。もう一度入力してください。");
                continue;
            }

            // プレイヤーが正しい単語を入力した場合、使用済みリストに追加
            usedWords.add(playerInput);
            lastWord = playerInput;

            // 「ん」で終わったら終了
            if (playerInput.charAt(playerInput.length() - 1) == 'ん') {
                System.out.println("「ん」で終わったため、ゲーム終了です！");
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

            // 「ん」で終わったら終了
            if (computerWord.charAt(computerWord.length() - 1) == 'ん') {
                System.out.println("コンピュータが「ん」で終わったため、ゲーム終了です！");
                break;
            }
        }
    }

    // コンピュータが使う単語を取得するメソッド
    private static String getComputerWord(char lastChar) {
        // 最後の文字で始まる単語を検索
        for (String word : availableWords) {
            if (!usedWords.contains(word) && word.charAt(0) == lastChar) {
                return word;
            }
        }
        return null; // コンピュータが使える単語がない場合
    }
}