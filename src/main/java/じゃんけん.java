import java.util.Random;
import java.util.Scanner;

public class じゃんけん {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // じゃんけんの選択肢
        String[] choices = {"グー", "チョキ", "パー"};

        System.out.println("じゃんけんゲーム開始！");
        System.out.println("0: グー, 1: チョキ, 2: パー から選んでください。");

        System.out.print("あなたの手を選んでください (0-2): ");
        int playerChoice = scanner.nextInt();

        // 入力チェック
        if (playerChoice < 0 || playerChoice > 2) {
            System.out.println("無効な選択です。0〜2の番号を入力してください。");
            return;
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
        } else {
            System.out.println("あなたの負け...");
        }

        scanner.close();
    }
}