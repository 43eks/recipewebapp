package クイズ;

import java.util.Scanner;

public class クイズ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // クイズのデータ（問題、選択肢、正解、解説）
        String[] questions = {
            "次のうち、Javaの拡張子はどれですか？",
            "プログラミング言語Pythonの創始者は誰ですか？",
            "HTMLは何の略ですか？"
        };

        String[][] options = {
            {"1. .java", "2. .exe", "3. .txt", "4. .jpg"},
            {"1. Guido van Rossum", "2. James Gosling", "3. Bjarne Stroustrup", "4. Dennis Ritchie"},
            {"1. HyperText Markup Language", "2. HomeTool Markup Language", "3. Hyperlink Text Machine Language", "4. HyperTime Multi Language"}
        };

        String[] explanations = {
            "正解です！.javaはJavaのソースコードファイルの拡張子です。",
            "正解です！Guido van RossumはPythonの創始者です。",
            "正解です！HTMLはHyperText Markup Languageの略です。"
        };

        String[] wrongExplanations = {
            ".exeはWindowsの実行可能ファイルの拡張子です。",
            ".exeはJavaとは関係ありません。",
            "HTMLはウェブページの構造を記述するための言語です。"
        };

        int[] correctAnswers = {1, 1, 1}; // 正解の番号（1が正解）

        // ユーザーの回答を追跡
        int correctCount = 0;
        int totalQuestions = questions.length;

        // 複数の問題を出題
        for (int i = 0; i < totalQuestions; i++) {
            // クイズの出題
            System.out.println(questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            // ユーザーの入力を受け取る
            System.out.print("番号を選んでください: ");
            int userAnswer = scanner.nextInt();

            // ユーザーの答えが正解か不正解かを判断し、解説を表示
            if (userAnswer == correctAnswers[i]) {
                System.out.println("正解です！");
                System.out.println(explanations[i]);
                correctCount++; // 正解数をカウント
            } else {
                System.out.println("不正解です。");
                System.out.println(wrongExplanations[i]);
            }

            System.out.println(); // 空行を挿入
        }

        // 正答率を計算して表示
        double accuracy = ((double) correctCount / totalQuestions) * 100;
        System.out.printf("あなたの正答率は %.2f%% です。\n", accuracy);

        scanner.close();
    }
}