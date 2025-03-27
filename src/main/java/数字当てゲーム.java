import java.util.Random;
import java.util.Scanner;

public class 数字当てゲーム {

    public static void main(String[] args) {
        // ゲーム開始のメッセージ
        System.out.println("数字当てゲームを始めます！");
        System.out.println("1から100までの数字を当ててください。");

        // ランダムに選ばれる数字を生成
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;  // 1から100までのランダムな数字
        int guess = 0;  // プレイヤーの予測値
        int attempts = 0;  // 試行回数

        // ユーザー入力を取得するためのスキャナー
        Scanner scanner = new Scanner(System.in);

        // ゲームループ
        while (guess != targetNumber) {
            // プレイヤーに数字を入力させる
            System.out.print("予想する数字を入力してください: ");
            guess = scanner.nextInt();  // 数字を入力

            // 試行回数をカウント
            attempts++;

            // ヒントを表示
            if (guess < targetNumber) {
                System.out.println("もっと大きい数字です。");
            } else if (guess > targetNumber) {
                System.out.println("もっと小さい数字です。");
            } else {
                // 正解した場合
                System.out.println("正解です！おめでとうございます！");
                System.out.println("試行回数: " + attempts);
            }
        }

        // ゲーム終了
        scanner.close();
    }
}