import java.util.Random;
import java.util.Scanner;

public class 数字当てゲーム {

    public static void main(String[] args) {
        // ゲーム開始のメッセージ
        System.out.println("数字当てゲームを始めます！");
        System.out.println("難易度を選んでください:");
        System.out.println("1: 簡単 (1から50)");
        System.out.println("2: 中級 (1から100)");
        System.out.println("3: 難しい (1から200)");

        // スキャナーを使って難易度を選ばせる
        Scanner scanner = new Scanner(System.in);
        int difficulty = scanner.nextInt();
        
        // 難易度に応じた最大値を設定
        int maxNumber = 0;
        switch (difficulty) {
            case 1:
                maxNumber = 50;
                break;
            case 2:
                maxNumber = 100;
                break;
            case 3:
                maxNumber = 200;
                break;
            default:
                System.out.println("無効な選択です。中級(1から100)に設定します。");
                maxNumber = 100;
                break;
        }

        // ランダムに数字を選ぶ
        Random random = new Random();
        int targetNumber = random.nextInt(maxNumber) + 1;
        int guess = 0;
        int attempts = 0;

        // ゲームループ
        while (guess != targetNumber) {
            System.out.print("予想する数字を入力してください: ");
            guess = scanner.nextInt();
            attempts++;

            // ヒントを表示
            if (guess < targetNumber) {
                System.out.println("もっと大きい数字です。");
            } else if (guess > targetNumber) {
                System.out.println("もっと小さい数字です。");
            } else {
                System.out.println("正解です！おめでとうございます！");
                System.out.println("試行回数: " + attempts);
            }
        }

        scanner.close();
    }
}