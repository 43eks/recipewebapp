package クイズ;

import java.util.Random;
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

        // ランダムに問題を選ぶ
        Random random = new Random();
        int questionIndex = random.nextInt(questions.length);

        // クイズの出題
        System.out.println("クイズアプリへようこそ！");
        System.out.println(questions[questionIndex]);
        for (String option : options[questionIndex]) {
            System.out.println(option);
        }

        // ユーザーの入力を受け取る
        System.out.print("番号を選んでください: ");
        int userAnswer = scanner.nextInt();

        // ユーザーの答えが正解か不正解かを判断し、解説を表示
        if (userAnswer == correctAnswers[questionIndex]) {
            System.out.println("正解です！");
            System.out.println(explanations[questionIndex]);
        } else {
            System.out.println("不正解です。");
            System.out.println(wrongExplanations[questionIndex]);
        }

        scanner.close();
    }
}