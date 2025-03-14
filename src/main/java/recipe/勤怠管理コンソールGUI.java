package recipe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class 勤怠管理コンソールGUI extends JFrame {

    private JTextField nameField;
    private JTextField timeField;
    private JTextArea logArea;
    private JButton clockInButton;
    private JButton clockOutButton;

    public 勤怠管理コンソールGUI() {
        // フレームの設定
        setTitle("勤怠管理システム");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 名前入力欄
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        JLabel nameLabel = new JLabel("名前:");
        nameField = new JTextField();
        JLabel timeLabel = new JLabel("時間:");
        timeField = new JTextField();
        timeField.setEditable(false); // 時刻フィールドは編集不可
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(timeLabel);
        inputPanel.add(timeField);

        // ボタン設定
        clockInButton = new JButton("出勤");
        clockOutButton = new JButton("退勤");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(clockInButton);
        buttonPanel.add(clockOutButton);

        // ログエリア
        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);

        // コンポーネントをフレームに追加
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // ボタンのアクションリスナー
        clockInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String time = getCurrentTime();
                timeField.setText(time); // 現在時刻を表示
                logArea.append("出勤: " + name + " - " + time + "\n");
            }
        });

        clockOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String time = getCurrentTime();
                timeField.setText(time); // 現在時刻を表示
                logArea.append("退勤: " + name + " - " + time + "\n");
            }
        });
    }

    // 現在の時刻を取得するメソッド
    private String getCurrentTime() {
        LocalTime currentTime = LocalTime.now(); // 現在時刻を取得
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss"); // フォーマット
        return currentTime.format(formatter); // フォーマットした時刻を返す
    }

    public static void main(String[] args) {
        // GUIを表示
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new 勤怠管理コンソールGUI().setVisible(true);
            }
        });
    }
}