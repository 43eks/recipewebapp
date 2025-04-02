import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Javaフレームワークアプリ {

    private static List<Framework> frameworks = new ArrayList<>();

    public static void main(String[] args) {
        // 初期フレームワークの追加
        frameworks.add(new Framework("Spring Boot", "軽量で設定が少なくても動作する", "Webアプリ, マイクロサービス"));
        frameworks.add(new Framework("Jakarta EE", "大規模システム向けの標準技術", "業務システム, 企業向けアプリ"));
        frameworks.add(new Framework("Quarkus", "軽量でクラウドネイティブ対応", "マイクロサービス, コンテナ環境"));
        frameworks.add(new Framework("Micronaut", "低メモリ消費で高速起動", "マイクロサービス, サーバーレス"));
        frameworks.add(new Framework("Vert.x", "非同期処理が得意", "リアルタイムアプリ, チャットアプリ"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. フレームワークの一覧表示");
            System.out.println("2. フレームワークの追加");
            System.out.println("3. フレームワークの削除");
            System.out.println("4. フレームワークを検索");
            System.out.println("5. 終了");
            System.out.print("選択してください: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // 改行を消費

            switch (choice) {
                case 1:
                    displayFrameworks();
                    break;
                case 2:
                    addFramework(scanner);
                    break;
                case 3:
                    removeFramework(scanner);
                    break;
                case 4:
                    searchFramework(scanner);
                    break;
                case 5:
                    System.out.println("アプリケーションを終了します。");
                    return;
                default:
                    System.out.println("無効な選択です。もう一度入力してください。");
            }
        }
    }

    // フレームワーク一覧表示
    private static void displayFrameworks() {
        if (frameworks.isEmpty()) {
            System.out.println("フレームワークは登録されていません。");
        } else {
            System.out.println("登録されているフレームワーク:");
            for (Framework fw : frameworks) {
                System.out.println(fw);
            }
        }
    }

    // フレームワーク追加
    private static void addFramework(Scanner scanner) {
        System.out.print("フレームワーク名を入力: ");
        String name = scanner.nextLine();
        System.out.print("特徴を入力: ");
        String description = scanner.nextLine();
        System.out.print("用途を入力: ");
        String usage = scanner.nextLine();

        frameworks.add(new Framework(name, description, usage));
        System.out.println(name + " フレームワークを追加しました。");
    }

    // フレームワーク削除
    private static void removeFramework(Scanner scanner) {
        System.out.print("削除したいフレームワーク名を入力: ");
        String name = scanner.nextLine();

        Framework toRemove = null;
        for (Framework fw : frameworks) {
            if (fw.getName().equalsIgnoreCase(name)) {
                toRemove = fw;
                break;
            }
        }

        if (toRemove != null) {
            frameworks.remove(toRemove);
            System.out.println(name + " フレームワークを削除しました。");
        } else {
            System.out.println(name + " は登録されていないフレームワークです。");
        }
    }

    // フレームワーク検索
    private static void searchFramework(Scanner scanner) {
        System.out.print("検索したいフレームワーク名を入力: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Framework fw : frameworks) {
            if (fw.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(fw);
                found = true;
            }
        }

        if (!found) {
            System.out.println("指定されたフレームワークは見つかりませんでした。");
        }
    }

    // Frameworkクラス
    static class Framework {
        private String name;
        private String description;
        private String usage;

        public Framework(String name, String description, String usage) {
            this.name = name;
            this.description = description;
            this.usage = usage;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "名前: " + name + "\n特徴: " + description + "\n用途: " + usage + "\n";
        }
    }
}