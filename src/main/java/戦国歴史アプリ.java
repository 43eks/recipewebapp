import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class 戦国歴史アプリ extends Application {

    private Label questionLabel;
    private RadioButton[] options;
    private ToggleGroup group;
    private Button answerButton;
    private Label resultLabel;
    
    private List<Question> questions;
    private Question currentQuestion;
    private Random random;

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

    @Override
    public void start(Stage primaryStage) {
        // クイズデータを作成
        questions = new ArrayList<>();
        questions.add(new Question("織田信長が本能寺の変で討たれた年は？", new String[]{"1575年", "1582年", "1600年", "1615年"}, 1));
        questions.add(new Question("関ヶ原の戦いは何年？", new String[]{"1590年", "1600年", "1614年", "1620年"}, 1));
        random = new Random();

        // UI要素の作成
        questionLabel = new Label("クイズがここに表示されます");
        group = new ToggleGroup();
        options = new RadioButton[4];
        for (int i = 0; i < 4; i++) {
            options[i] = new RadioButton();
            options[i].setToggleGroup(group);
        }
        answerButton = new Button("回答する");
        resultLabel = new Label("");

        // レイアウト
        VBox layout = new VBox(10);
        layout.getChildren().add(questionLabel);
        layout.getChildren().addAll(options);
        layout.getChildren().addAll(answerButton, resultLabel);

        // 回答ボタンのアクション
        answerButton.setOnAction(e -> checkAnswer());

        // 最初の問題を表示
        setRandomQuestion();

        // シーン設定
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("戦国クイズアプリ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setRandomQuestion() {
        currentQuestion = questions.get(random.nextInt(questions.size()));
        questionLabel.setText(currentQuestion.question);
        for (int i = 0; i < options.length; i++) {
            options[i].setText(currentQuestion.choices[i]);
        }
    }

    private void checkAnswer() {
        for (int i = 0; i < options.length; i++) {
            if (options[i].isSelected()) {
                if (i == currentQuestion.correctAnswer) {
                    resultLabel.setText("正解！");
                } else {
                    resultLabel.setText("不正解。正解は " + currentQuestion.choices[currentQuestion.correctAnswer]);
                }
                setRandomQuestion(); // 次の問題へ
                return;
            }
        }
        resultLabel.setText("選択肢を選んでください");
    }

    public static void main(String[] args) {
        launch(args);
    }
}