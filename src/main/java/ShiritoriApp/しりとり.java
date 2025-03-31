package ShiritoriApp;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class しりとり {

    // 使われた単語を保存するセット
    private static Set<String> usedWords = new HashSet<>();
    
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

            // 正常な入力の場合は単語を追加して次のターンに進む
            usedWords.add(playerInput);
            lastWord = playerInput; // 最後の単語を更新

            System.out.println("「" + playerInput + "」で次のターンへ。");
        }
    }
}