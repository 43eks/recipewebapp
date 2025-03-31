package ShiritoriApp;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class しりとり extends Application {

    private static final List<String> usedWords = new ArrayList<>();
    private static String lastLetter = "";

    @Override
    public void start(Stage primaryStage) {
        // ウィンドウタイトル設定
        primaryStage.setTitle("しりとりゲーム");

        // UI部品作成
        Label instructionLabel = new Label("しりとりを始めましょう！単語を入力してください。");
        TextField wordInputField = new TextField();
        Button submitButton = new Button("入力");
        Button resetButton = new Button("ゲーム開始");
        ListView<String> historyListView = new ListView<>();

        // 初期化ボタン：ゲームをリセット
        resetButton.setOnAction(e -> {
            usedWords.clear();
            lastLetter = "";
            historyListView.getItems().clear();
            wordInputField.clear();
        });

        // 入力ボタン：しりとりのルールに従って単語を追加
        submitButton.setOnAction(e -> {
            String inputWord = wordInputField.getText().trim();

            if (inputWord.isEmpty()) {
                return;
            }

            // 最初の単語またはルールのチェック
            if (usedWords.isEmpty()) {
                usedWords.add(inputWord);
                historyListView.getItems().add("あなた: " + inputWord);
                lastLetter = inputWord.substring(inputWord.length() - 1); // 最後の文字を取得
            } else {
                // しりとりのルールをチェック
                if (inputWord.charAt(0) != lastLetter.charAt(0)) {
                    historyListView.getItems().add("ルール違反！ 最後の文字「" + lastLetter + "」で始めてください。");
                } else if (usedWords.contains(inputWord)) {
                    historyListView.getItems().add("その単語はすでに使われています！");
                } else {
                    usedWords.add(inputWord);
                    historyListView.getItems().add("あなた: " + inputWord);
                    lastLetter = inputWord.substring(inputWord.length() - 1); // 最後の文字を更新
                }
            }

            // フィールドクリア
            wordInputField.clear();
        });

        // レイアウト設定
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(instructionLabel, wordInputField, submitButton, resetButton, historyListView);

        // シーンとウィンドウ表示
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
