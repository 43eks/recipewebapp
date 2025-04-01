package ShiritoriApp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class しりとり {
    private static Set<String> usedWords = new HashSet<>();
    private static List<String> easyWords = Arrays.asList("りんご", "ごま", "まくら", "らっこ", "こま");
    private static List<String> normalWords = Arrays.asList("りんご", "ごま", "まくら", "らっこ", "こま", "まんじゅう", "うなぎ", "ぎんこう");
    private static List<String> hardWords = Arrays.asList("ゲシュタルト崩壊", "アメリカ", "ラッパ", "パラダイス", "ディスカバリー", "イノベーション");
    private static List<String> availableWords;

    private static int playerScore = 0;
    private static int computerScore = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("難易度を選んでください (1: かんたん, 2: ふつう, 3: むずかしい): ");
        int difficulty = scanner.nextInt();
        scanner.nextLine(); // 改行を消費

        switch (difficulty) {
            case 1:
                availableWords = easyWords;
                break;
            case 3:
                availableWords = hardWords;
                break;
            default:
                availableWords = normalWords;
        }

        System.out.println("しりとりを始めます。最初の単語を入力してください:");
        String lastWord = scanner.nextLine().trim();
        usedWords.add(lastWord);

        while (true) {
            System.out.println("「" + lastWord.charAt(lastWord.length() - 1) + "」で始まる単語を入力してください:");
            String playerInput = scanner.nextLine().trim();

            if (playerInput.isEmpty() || usedWords.contains(playerInput) || playerInput.charAt(0) != lastWord.charAt(lastWord.length() - 1)) {
                System.out.println("無効な単語です。");
                continue;
            }
            
            if (playerInput.endsWith("ん")) {
                System.out.println("「ん」で終わったのでゲーム終了！");
                break;
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
