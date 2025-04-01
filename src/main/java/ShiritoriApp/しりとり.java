package ShiritoriApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class しりとり {

    private static Set<String> usedWords = new HashSet<>();
    private static List<String> easyWords = Arrays.asList(
            "りんご", "ごま", "まくら", "らっこ", "こま", "まんじゅう", "うなぎ", "ぎんこう", "こうえん", "えび",
            "びん", "たきび", "まめ", "めん", "んま", "まほう", "うさぎ", "ぎょうざ", "ざる", "るび"
    );
    private static List<String> normalWords = Arrays.asList(
            "しんぶん", "んち", "ちか", "かみ", "みかん", "んとう", "うえ", "えき", "きん", "んけ",
            "けんか", "かご", "ごま", "まくら", "ダンス", "おに", "らん", "おすし", "しょく", "くつ"
    );
    private static List<String> hardWords = Arrays.asList(
            "しんけい", "いんさつ", "つうしん", "んせき", "きかい", "いりょう", "うんどう", "うわさ", "さかな", "ならいごと",
            "ともだち", "ちから", "らくがき", "きんぎょ", "よみもの", "のどか", "かんそう", "うんめい", "いばら", "らんま"
    );
    private static List<String> oniWords = Arrays.asList(
            "ゲシュタルト崩壊", "アメリカ", "ラッパ", "パラダイス", "サンバ", "バルカン", "カリフォルニア", "アンデス", "スカンジナビア", "アイスランド",
            "ドミニカ", "カタコンベ", "ベネズエラ", "ラビリンス", "スフィンクス", "スカーレット", "トレジャー", "ジャガイモ", "モニュメント", "トーテム"
    );
    
    private static List<String> availableWords;
    private static int playerScore = 0;
    private static int computerScore = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("難易度を選択してください (1: かんたん, 2: ふつう, 3: むずかしい, 4: おに)");
        int difficulty = scanner.nextInt();
        scanner.nextLine(); // 改行を消費

        switch (difficulty) {
            case 1 -> availableWords = new ArrayList<>(easyWords);
            case 2 -> availableWords = new ArrayList<>(normalWords);
            case 3 -> availableWords = new ArrayList<>(hardWords);
            case 4 -> availableWords = new ArrayList<>(oniWords);
            default -> {
                System.out.println("無効な入力です。デフォルトのかんたんモードを選択します。");
                availableWords = new ArrayList<>(easyWords);
            }
        }
        
        System.out.println("しりとりを始めます。");
        System.out.println("最初の単語を入力してください:");

        String lastWord = scanner.nextLine().trim();
        usedWords.add(lastWord);

        while (true) {
            System.out.println("「" + lastWord.charAt(lastWord.length() - 1) + "」で始まる単語を入力してください:");
            String playerInput = scanner.nextLine().trim();
            
            if (playerInput.endsWith("ん")) {
                System.out.println("「ん」で終わったのでゲーム終了！");
                break;
            }
            if (!playerInput.startsWith(String.valueOf(lastWord.charAt(lastWord.length() - 1))) || usedWords.contains(playerInput)) {
                System.out.println("無効な単語です。別の単語を入力してください。");
                continue;
            }
            usedWords.add(playerInput);
            lastWord = playerInput;
            playerScore++;
            
            System.out.println("コンピュータのターン...");
            String computerWord = getComputerWord(lastWord.charAt(lastWord.length() - 1));
            if (computerWord == null) {
                System.out.println("コンピュータは言葉を思いつけませんでした。あなたの勝ちです！");
                break;
            }
            System.out.println("コンピュータ: " + computerWord);
            usedWords.add(computerWord);
            lastWord = computerWord;
            computerScore++;
            
            if (computerWord.endsWith("ん")) {
                System.out.println("コンピュータが「ん」で終わったのでゲーム終了！");
                break;
            }
        }
        
        System.out.println("ゲーム終了！");
        System.out.println("プレイヤーのスコア: " + playerScore);
        System.out.println("コンピュータのスコア: " + computerScore);

        if (playerScore > computerScore) {
            System.out.println("おめでとうございます！あなたの勝ちです！");
        } else if (playerScore < computerScore) {
            System.out.println("コンピュータの勝ちです！");
        } else {
            System.out.println("引き分けです！");
        }
    }

    private static String getComputerWord(char lastChar) {
        for (String word : availableWords) {
            if (!usedWords.contains(word) && word.charAt(0) == lastChar) {
                return word;
            }
        }
        return null;
    }
}
