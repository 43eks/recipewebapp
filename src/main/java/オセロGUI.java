import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class オセロGUI extends JFrame {

    public static void main(String[] args) {
        // この一行を追加して、JFrameのインスタンスを作成する前にスレッドが安全に実行されるようにする
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new オセロGUI();
            }
        });
    }

    public オセロGUI() {
        setTitle("オセロゲーム");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 660);
        setLocationRelativeTo(null); // 画面中央に表示
        add(new JLabel("オセロGUIの準備中...", SwingConstants.CENTER));
        setVisible(true); // これを実行しないとウィンドウは表示されない
    }
}