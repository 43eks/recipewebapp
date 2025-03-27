import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class QuizApp {
    static class Question {
        String question;
        String[] choices;
        int correctAnswer; // 正解の選択肢インデックス

        Question(String q, String[] c, int correct) {
            this.question = q;
            this.choices = c;
            this.correctAnswer = correct;
        }
    }

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("織田信長が本能寺の変で討たれた年は？", new String[]{"1575年", "1582年", "1600年", "1615年"}, 1));
        questions.add(new Question("関ヶ原の戦いは何年？", new String[]{"1590年", "1600年", "1614年", "1620年"}, 1));

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("日本戦国クイズ！ランダムに出題します。\n");

        // ランダムに1問出題
        Question q = questions.get(random.nextInt(questions.size()));
        System.out.println(q.question);
        for (int i = 0; i < q.choices.length; i++) {
            System.out.println((i + 1) + ". " + q.choices[i]);
        }

        System.out.print("答えの番号を入力: ");
        int answer = scanner.nextInt() - 1;

        if (answer == q.correctAnswer) {
            System.out.println("正解！");
        } else {
            System.out.println("不正解。正解は " + (q.correctAnswer + 1) + ". " + q.choices[q.correctAnswer] + " です。");
        }

        scanner.close();
    }
}