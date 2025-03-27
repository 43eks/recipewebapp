import java.util.Random;
import java.util.Scanner;

public class 数字当てゲーム {

    public static void main(String[] args) {
        // プレイヤーの名前を入力
        Scanner scanner = new Scanner(System.in);
        System.out.print("お名前を入力してください: ");
        String playerName = scanner.nextLine();

        // ゲーム開始のメッセージ
        System.out.println(playerName + "さん、数字当てゲームを始めます！");

        // 時間制限設定（秒単位）
        int timeLimit = 30; // 30秒制限

        // ランダムに選ばれる数字を生成
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;
        int guess = 0;
        int attempts = 0;

        // ゲーム開始時間を記録
        long startTime = System.currentTimeMillis();

        // ゲームループ
        while (guess != targetNumber) {
            // 経過時間を計算
            long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;

            if (elapsedTime >= timeLimit) {
                System.out.println("時間切れ！ゲームオーバーです。");
                break;
            }

            System.out.print("予想する数字を入力してください: ");
            guess = scanner.nextInt();
            attempts++;

            // ヒントを表示
            if (guess < targetNumber) {
                System.out.println("もっと大きい数字です。");
            } else if (guess > targetNumber) {
                System.out.println("もっと小さい数字です。");
            } else {
                System.out.println(playerName + "さん、正解です！おめでとうございます！");
                System.out.println("試行回数: " + attempts);
                break;
            }
        }

        scanner.close();
    }
}