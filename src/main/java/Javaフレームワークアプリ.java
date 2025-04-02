import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Javaフレームワークアプリ {

    private static List<Framework> frameworks = new ArrayList<>();

    public static void main(String[] args) {
        // 初期フレームワークの追加
        frameworks.add(new Framework("Spring Boot", "軽量で設定が少なくても動作する", "Webアプリ, マイクロサービス", "https://spring.io/projects/spring-boot\nセットアップ方法: Spring Initializr を使用してプロジェクトを作成。"));
        frameworks.add(new Framework("Jakarta EE", "大規模システム向けの標準技術", "業務システム, 企業向けアプリ", "https://jakarta.ee/\nセットアップ方法: MavenまたはGradleで依存関係を追加。"));
        frameworks.add(new Framework("Quarkus", "軽量でクラウドネイティブ対応", "マイクロサービス, コンテナ環境", "https://quarkus.io/\nセットアップ方法: Quarkus CLIを使用して新規プロジェクトを作成。"));
        frameworks.add(new Framework("Micronaut", "低メモリ消費で高速起動", "マイクロサービス, サーバーレス", "https://micronaut.io/\nセットアップ方法: Micronaut CLIでプロジェクトを作成。"));
        frameworks.add(new Framework("Vert.x", "非同期処理が得意", "リアルタイムアプリ, チャットアプリ", "https://vertx.io/\nセットアップ方法: MavenまたはGradleを使用して依存関係を追加。"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. フレームワークの一覧表示");
            System.out.println("2. フレームワークの追加");
            System.out.println("3. フレームワークの削除");
            System.out.println("4. フレームワークを検索");
            System.out.println("5. フレームワークの実装方法を見る");
            System.out.println("6. 終了");
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
                    showImplementationMethods(scanner);
                    break;
                case 6:
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
            for (int i = 0; i < frameworks.size(); i++) {
                System.out.println((i + 1) + ". " + frameworks.get(i).getName());
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
        System.out.print("実装方法のURLを入力: ");
        String implementation = scanner.nextLine();

        frameworks.add(new Framework(name, description, usage, implementation));
        System.out.println(name + " フレームワークを追加しました。");
    }

    // フレームワーク削除
    private static void removeFramework(Scanner scanner) {
        System.out.print("削除したいフレームワークの番号を入力: ");
        int index = scanner.nextInt() - 1;  // ユーザー入力は1から始まるので、インデックスは0から

        if (index >= 0 && index < frameworks.size()) {
            frameworks.remove(index);
            System.out.println("フレームワークを削除しました。");
        } else {
            System.out.println("無効な番号です。");
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

    // 実装方法表示
    private static void showImplementationMethods(Scanner scanner) {
        System.out.print("実装方法を知りたいフレームワークの番号を入力: ");
        int index = scanner.nextInt() - 1;  // ユーザー入力は1から始まるので、インデックスは0から

        if (index >= 0 && index < frameworks.size()) {
            Framework fw = frameworks.get(index);
            System.out.println("実装方法: " + fw.getImplementation());
        } else {
            System.out.println("無効な番号です。");
        }
    }

    // Frameworkクラス
    static class Framework {
        private String name;
        private String description;
        private String usage;
        private String implementation;

        public Framework(String name, String description, String usage, String implementation) {
            this.name = name;
            this.description = description;
            this.usage = usage;
            this.implementation = implementation;
        }

        public String getName() {
            return name;
        }

        public String getImplementation() {
            return implementation;
        }

        @Override
        public String toString() {
            return "名前: " + name + "\n特徴: " + description + "\n用途: " + usage + "\n";
        }
    }
}