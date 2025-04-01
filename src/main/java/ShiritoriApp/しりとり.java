package ShiritoriApp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class しりとり {

    private static Set<String> usedWords = new HashSet<>();
    private static Map<String, List<String>> difficultyWords = new HashMap<>();
    private static int playerScore = 0;
    private static int computerScore = 0;
    private static String difficulty = "普通";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeWordLists();

        System.out.println("難易度を選んでください（簡単 / 普通 / 難しい / おに）：");
        difficulty = scanner.nextLine().trim();
        if (!difficultyWords.containsKey(difficulty)) {
            difficulty = "普通";
        }

        System.out.println("しりとりを始めます。");
        System.out.println("最初の単語を入力してください:");

        String lastWord = scanner.nextLine().trim();
        usedWords.add(lastWord);

        while (true) {
            System.out.println("「" + lastWord.charAt(lastWord.length() - 1) + "」で始まる単語を入力してください:");
            String playerInput = scanner.nextLine().trim();

            if (playerInput.isEmpty() || usedWords.contains(playerInput) ||
                playerInput.charAt(0) != lastWord.charAt(lastWord.length() - 1)) {
                System.out.println("不正な単語です。もう一度入力してください。");
                continue;
            }

            usedWords.add(playerInput);
            lastWord = playerInput;
            playerScore++;

            if (playerInput.endsWith("ん")) {
                System.out.println("「ん」で終わったのでゲーム終了！");
                break;
            }

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

    private static void initializeWordLists() {
        difficultyWords.put("簡単", Arrays.asList("りんご", "ごま", "まくら", "らっこ", "こま"));
        difficultyWords.put("普通", Arrays.asList("まんじゅう", "うなぎ", "ぎんこう", "こうえん", "えび"));
        difficultyWords.put("難しい", Arrays.asList("しんぶん", "ぶんぼうぐ", "ぐんま", "まっすぐ", "くつした"));
        difficultyWords.put("おに", Arrays.asList("ゲシュタルト崩壊", "アメリカンドリーム", "パラダイムシフト", "ニューロンネットワーク"));
    }

    private static String getComputerWord(char lastChar) {
        for (String word : difficultyWords.get(difficulty)) {
            if (!usedWords.contains(word) && word.charAt(0) == lastChar) {
                return word;
            }
        }
        return null;
    }
}
