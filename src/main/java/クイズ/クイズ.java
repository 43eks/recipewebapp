package クイズ;

import java.util.Scanner;

public class クイズ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 質問と選択肢、解説を作成
        String question = "次のうち、Javaの拡張子はどれですか？";
        String[] options = {"1. .java", "2. .exe", "3. .txt", "4. .jpg"};
        String[] explanations = {
            "正解です！.javaはJavaのソースコードファイルの拡張子です。",
            ".exeはWindowsの実行可能ファイルの拡張子です。",
            ".txtはテキストファイルの拡張子です。",
            ".jpgは画像ファイルの拡張子です。"
        };
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

        // ユーザーの答えが正解か不正解かを判断し、解説を表示
        if (userAnswer == correctAnswer) {
            System.out.println("正解です！");
        } else {
            System.out.println("不正解です。");
        }

        // 解説を表示
        System.out.println(explanations[userAnswer - 1]);

        scanner.close();
    }
}