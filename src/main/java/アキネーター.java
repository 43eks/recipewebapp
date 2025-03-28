
import java.util.Scanner;

class Node {
    String question;
    Node yesNode;
    Node noNode;
    
    Node(String question) {
        this.question = question;
    }
}

public class アキネーター {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 決定木の作成
        Node root = new Node("戦で優れた軍略を持っていたか？");
        
        root.yesNode = new Node("九州地方に関係があるか？");
        root.noNode = new Node("関ヶ原の戦い以前から名将だったか？");
        
        root.yesNode.yesNode = new Node("黒田官兵衛"); // 九州関係 → 黒田官兵衛
        root.yesNode.noNode = new Node("伊達政宗"); // 九州関係なし → 伊達政宗
        
        root.noNode.yesNode = new Node("毛利元就"); // 関ヶ原以前 → 毛利元就
        root.noNode.noNode = new Node("家臣として活躍したか？");
        
        root.noNode.noNode.yesNode = new Node("片倉小十郎"); // 家臣 → 片倉小十郎
        root.noNode.noNode.noNode = new Node("真田昌幸"); // そうでない → 真田昌幸
        
        // ゲーム開始
        System.out.println("戦国武将アキネーターを開始します！");
        Node currentNode = root;
        
        while (currentNode.yesNode != null && currentNode.noNode != null) {
            System.out.print(currentNode.question + " (y/n): ");
            String answer = scanner.next();
            
            if (answer.equalsIgnoreCase("y")) {
                currentNode = currentNode.yesNode;
            } else {
                currentNode = currentNode.noNode;
            }
        }
        
        // 結果発表
        System.out.println("あなたが思い浮かべたのは「" + currentNode.question + "」ですね！");
        scanner.close();
    }
}

