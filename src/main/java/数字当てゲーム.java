import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class 数字当てゲーム {

    static List<Player> leaderboard = new ArrayList<>(); // ランキング用のリスト

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            // プレイヤーの名前を入力
            System.out.print("お名前を入力してください: ");
            String playerName = scanner.nextLine();

            // 難易度を選択
            System.out.println("難易度を選んでください:");
            System.out.println("1. 易しい (1から50)");
            System.out.println("2. 普通 (1から100)");
            System.out.println("3. 難しい (1から200)");
            System.out.print("難易度を選んでください (1, 2, 3): ");
            int difficulty = scanner.nextInt();
            int maxRange = 0;
            int maxAttempts = 0;

            switch (difficulty) {
                case 1:
                    maxRange = 50;
                    maxAttempts = 10; // 易しいモード
                    break;
                case 2:
                    maxRange = 100;
                    maxAttempts = 7; // 普通モード
                    break;
                case 3:
                    maxRange = 200;
                    maxAttempts = 5; // 難しいモード
                    break;
                default:
                    System.out.println("無効な選択肢です。デフォルトの難易度 (普通) が選択されます。");
                    maxRange = 100;
                    maxAttempts = 7;
            }

            // ゲーム開始のメッセージ
            System.out.println(playerName + "さん、数字当てゲームを始めます！");

            // ランダムに選ばれる数字を生成
            Random random = new Random();
            int targetNumber = random.nextInt(maxRange) + 1;
            int guess = 0;
            int attempts = 0;
            int hintCount = 0;  // ヒントの回数カウンタ

            // 時間制限を設定
            long startTime = System.currentTimeMillis();
            long timeLimit = 30000; // 30秒制限
            boolean isTimeUp = false;

            // ゲーム本体
            while (guess != targetNumber && attempts < maxAttempts) {
                if (hintCount < 3 && attempts >= 2) {
                    // 2回目以降の試行時にヒントを提供
                    System.out.print("ヒントを使いますか？(yes/no): ");
                    String hintResponse = scanner.next();
                    if (hintResponse.equalsIgnoreCase("yes")) {
                        giveHint(targetNumber, maxRange);
                        hintCount++;
                    }
                }

                System.out.print("予想する数字を入力してください (1〜" + maxRange + "): ");
                guess = scanner.nextInt();
                attempts++;

                // 時間制限チェック
                long elapsedTime = System.currentTimeMillis() - startTime;
                if (elapsedTime > timeLimit) {
                    isTimeUp = true;
                    break; // 時間切れ
                }

                if (guess < targetNumber) {
                    System.out.println("もっと大きい数字です。");
                } else if (guess > targetNumber) {
                    System.out.println("もっと小さい数字です。");
                } else {
                    System.out.println(playerName + "さん、正解です！おめでとうございます！");
                    System.out.println("試行回数: " + attempts);
                }
            }

            // 結果の表示
            if (isTimeUp) {
                System.out.println("時間切れです！");
            } else if (guess != targetNumber) {
                System.out.println("試行回数を超過しました。正解は " + targetNumber + " でした。");
            }

            // プレイヤーのスコアを保存
            long totalTime = System.currentTimeMillis() - startTime;
            leaderboard.add(new Player(playerName, attempts, totalTime));

            // ゲームをもう一度プレイするか尋ねる
            System.out.print("もう一度プレイしますか？(yes/no): ");
            playAgain = scanner.next();
            scanner.nextLine(); // バッファのクリア

        } while (playAgain.equalsIgnoreCase("yes"));

        // ランキングの表示
        displayLeaderboard();
        scanner.close();
        System.out.println("ゲームを終了します。ありがとうございました！");
    }

    // ヒント機能
    public static void giveHint(int targetNumber, int maxRange) {
        Random random = new Random();
        int hintType = random.nextInt(2);  // ヒントタイプのランダム選択 (0 = 数字の範囲, 1 = 奇数/偶数)

        if (hintType == 0) {
            System.out.println("ヒント: 数字は " + (targetNumber <= maxRange / 2 ? "1〜" + maxRange / 2 : (maxRange / 2 + 1) + "〜" + maxRange) + " の範囲にあります。");
        } else {
            System.out.println("ヒント: 数字は " + (targetNumber % 2 == 0 ? "偶数" : "奇数") + " です。");
        }
    }

    // ランキングを表示するメソッド
    public static void displayLeaderboard() {
        System.out.println("\n=== ランキング ===");
        leaderboard.sort(Comparator.comparingInt(Player::getAttempts).thenComparingLong(Player::getTotalTime));

        for (int i = 0; i < leaderboard.size(); i++) {
            Player player = leaderboard.get(i);
            long timeInSeconds = TimeUnit.MILLISECONDS.toSeconds(player.getTotalTime());
            System.out.println((i + 1) + ". " + player.getName() + " - 試行回数: " + player.getAttempts() + ", 時間: " + timeInSeconds + "秒");
        }
    }

    // プレイヤークラス (名前、試行回数、かかった時間)
    static class Player {
        private String name;
        private int attempts;
        private long totalTime;

        public Player(String name, int attempts, long totalTime) {
            this.name = name;
            this.attempts = attempts;
            this.totalTime = totalTime;
        }

        public String getName() {
            return name;
        }

        public int getAttempts() {
            return attempts;
        }

        public long getTotalTime() {
            return totalTime;
        }
    }
}