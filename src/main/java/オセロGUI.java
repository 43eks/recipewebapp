import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class オセロGUI extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new オセロGUI());
    }

    public オセロGUI() {
        setTitle("オセロゲーム");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 660);
        setLocationRelativeTo(null); // 画面中央に表示
        
        JPanel panel = new JPanel();
        JButton button = new JButton("スタート");
        panel.add(button);
        add(panel);
        
        setVisible(true);
    }
}