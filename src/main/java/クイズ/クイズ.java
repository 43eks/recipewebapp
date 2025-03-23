package クイズ;

import java.util.Scanner;

public class クイズ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 質問と選択肢を作成
        String question = "次のうち、Javaの拡張子はどれですか？";
        String[] options = {"1. .java", "2. .exe", "3. .txt", "4. .jpg"};
        int correctAnswer = 1; // 正解の選択肢番号（1が正解）

        // クイズの開始
        System.out.println("クイズアプリへようこそ！");
        System.out.println(question);
        for (String option : options) {
            System.out.println(option);
        }

        // ユーザーの入力を受け取る
        System.out.print("番号を選んでください: ");
        int userAnswer = scanner.nextInt();

        // 正解チェック
        if (userAnswer == correctAnswer) {
            System.out.println("正解です！");
        } else {
            System.out.println("不正解です。正解は: " + options[correctAnswer - 1]);
        }

        scanner.close();
    }
}