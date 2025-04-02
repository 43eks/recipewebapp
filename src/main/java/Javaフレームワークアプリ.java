

import java.util.ArrayList;
import java.util.List;

public class Javaフレームワークアプリ {

    public static void main(String[] args) {
        List<Framework> frameworks = new ArrayList<>();

        frameworks.add(new Framework("Spring Boot", "軽量で設定が少なくても動作する", "Webアプリ, マイクロサービス"));
        frameworks.add(new Framework("Jakarta EE", "大規模システム向けの標準技術", "業務システム, 企業向けアプリ"));
        frameworks.add(new Framework("Quarkus", "軽量でクラウドネイティブ対応", "マイクロサービス, コンテナ環境"));
        frameworks.add(new Framework("Micronaut", "低メモリ消費で高速起動", "マイクロサービス, サーバーレス"));
        frameworks.add(new Framework("Vert.x", "非同期処理が得意", "リアルタイムアプリ, チャットアプリ"));

        System.out.println("代表的なJavaバックエンドフレームワーク:");
        for (Framework fw : frameworks) {
            System.out.println(fw);
        }
    }
}

class Framework {
    private String name;
    private String description;
    private String usage;

    public Framework(String name, String description, String usage) {
        this.name = name;
        this.description = description;
        this.usage = usage;
    }

    @Override
    public String toString() {
        return "名前: " + name + "\n特徴: " + description + "\n用途: " + usage + "\n";
    }
}