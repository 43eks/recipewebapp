import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        setLocationRelativeTo(null);
        add(new BoardPanel());
        setVisible(true);
    }
}

class BoardPanel extends JPanel implements MouseListener {
    private static final int SIZE = 8;
    private static final int CELL_SIZE = 80;

    private int[][] board = new int[SIZE][SIZE]; // 0=空白, 1=黒, 2=白
    private int currentPlayer = 1; // 1=黒, 2=白

    public BoardPanel() {
        // 初期配置
        board[3][3] = 2;
        board[3][4] = 1;
        board[4][3] = 1;
        board[4][4] = 2;

        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 背景
        g.setColor(new Color(34, 139, 34));
        g.fillRect(0, 0, CELL_SIZE * SIZE, CELL_SIZE * SIZE);

        // 盤面の線
        g.setColor(Color.BLACK);
        for (int i = 0; i <= SIZE; i++) {
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, CELL_SIZE * SIZE);
            g.drawLine(0, i * CELL_SIZE, CELL_SIZE * SIZE, i * CELL_SIZE);
        }

        // 石の描画
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] != 0) {
                    if (board[row][col] == 1) {
                        g.setColor(Color.BLACK);
                    } else {
                        g.setColor(Color.WHITE);
                    }
                    g.fillOval(col * CELL_SIZE + 10, row * CELL_SIZE + 10, 60, 60);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int col = e.getX() / CELL_SIZE;
        int row = e.getY() / CELL_SIZE;

        if (board[row][col] == 0) {
            board[row][col] = currentPlayer;
            currentPlayer = 3 - currentPlayer; // 1 → 2, 2 → 1
            repaint();
        }
    }

    // 使わないイベント
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}