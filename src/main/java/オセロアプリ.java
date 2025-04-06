import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class オセロアプリ extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new オセロアプリ());
    }

    public オセロアプリ() {
        setTitle("オセロゲーム");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 660);
        setLocationRelativeTo(null); // 画面中央に表示
        add(new JLabel("オセロGUIの準備中...", SwingConstants.CENTER));
        setVisible(true);
    }
}