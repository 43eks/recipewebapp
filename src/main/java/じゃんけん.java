import java.util.Random;
import java.util.Scanner;

public class じゃんけん {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // じゃんけんの選択肢
        String[] choices = {"グー", "チョキ", "パー"};
        
        // 勝利カウント
        int playerWins = 0;
        int computerWins = 0;
        final int WIN_LIMIT = 3; // 3勝したら決着

        System.out.println("じゃんけんゲーム開始！");
        System.out.println("0: グー, 1: チョキ, 2: パー から選んでください。");

        while (playerWins < WIN_LIMIT && computerWins < WIN_LIMIT) {
            System.out.print("\nあなたの手を選んでください (0-2): ");
            int playerChoice = scanner.nextInt();

            // 入力チェック
            if (playerChoice < 0 || playerChoice > 2) {
                System.out.println("無効な選択です。0〜2の番号を入力してください。");
                continue;
            }

            int computerChoice = random.nextInt(3); // 0, 1, 2 のどれかをランダムに選ぶ

            // 選んだ手を表示
            System.out.println("あなた: " + choices[playerChoice]);
            System.out.println("コンピュータ: " + choices[computerChoice]);

            // 勝敗判定
            if (playerChoice == computerChoice) {
                System.out.println("引き分け！");
            } else if ((playerChoice == 0 && computerChoice == 1) || 
                       (playerChoice == 1 && computerChoice == 2) || 
                       (playerChoice == 2 && computerChoice == 0)) {
                System.out.println("あなたの勝ち！");
                playerWins++;
            } else {
                System.out.println("あなたの負け...");
                computerWins++;
            }

            // 現在の勝敗カウントを表示
            System.out.println("現在のスコア - あなた: " + playerWins + "勝, コンピュータ: " + computerWins + "勝");
        }

        // 最終結果
        if (playerWins == WIN_LIMIT) {
            System.out.println("\nおめでとう！あなたの勝ちです！");
        } else {
            System.out.println("\n残念...コンピュータの勝ちです。");
        }

        scanner.close();
    }
}