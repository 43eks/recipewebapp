import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Customer {
    private int id;
    private String name;
    private String email;
    private String phone;

    public Customer(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", 名前: " + name + ", メール: " + email + ", 電話: " + phone;
    }
}

public class 顧客管理 {
    private static List<Customer> customerList = new ArrayList<>();
    private static int customerIdCounter = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // サンプルデータ
        customerList.add(new Customer(customerIdCounter++, "田中 太郎", "tanaka@example.com", "090-1234-5678"));
        customerList.add(new Customer(customerIdCounter++, "佐藤 花子", "sato@example.com", "080-9876-5432"));
        customerList.add(new Customer(customerIdCounter++, "鈴木 一郎", "suzuki@example.com", "070-1111-2222"));

        while (true) {
            System.out.println("\n顧客管理システム");
            System.out.println("1. 顧客検索");
            System.out.println("2. 検索フィルター");
            System.out.println("3. 並び替え");
            System.out.println("4. 終了");
            System.out.print("選択してください: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 改行消費

            switch (choice) {
                case 1:
                    searchCustomer();
                    break;
                case 2:
                    filterCustomer();
                    break;
                case 3:
                    sortCustomer();
                    break;
                case 4:
                    System.out.println("終了します。");
                    return;
                default:
                    System.out.println("無効な選択です。もう一度入力してください。");
            }
        }
    }

    // 🔍 1. 顧客検索
    private static void searchCustomer() {
        System.out.print("検索キーワード（名前・メール・電話番号）: ");
        String keyword = scanner.nextLine().toLowerCase();

        List<Customer> result = new ArrayList<>();
        for (Customer c : customerList) {
            if (c.getName().toLowerCase().contains(keyword) ||
                c.getEmail().toLowerCase().contains(keyword) ||
                c.getPhone().contains(keyword)) {
                result.add(c);
            }
        }

        displayResults(result);
    }

    // 🎯 2. 検索フィルター
    private static void filterCustomer() {
        System.out.println("フィルター条件を選択:");
        System.out.println("1. 指定した文字で始まる名前");
        System.out.println("2. 指定したドメインのメール");
        System.out.println("3. 指定したキャリアの電話番号");
        System.out.print("選択してください: ");
        int filterChoice = scanner.nextInt();
        scanner.nextLine(); // 改行消費

        List<Customer> result = new ArrayList<>();
        switch (filterChoice) {
            case 1:
                System.out.print("名前の先頭の文字列を入力: ");
                String nameStart = scanner.nextLine();
                for (Customer c : customerList) {
                    if (c.getName().startsWith(nameStart)) {
                        result.add(c);
                    }
                }
                break;
            case 2:
                System.out.print("メールのドメインを入力（例: example.com）: ");
                String domain = scanner.nextLine();
                for (Customer c : customerList) {
                    if (c.getEmail().endsWith("@" + domain)) {
                        result.add(c);
                    }
                }
                break;
            case 3:
                System.out.print("電話番号のキャリア（例: 090, 080, 070）を入力: ");
                String carrier = scanner.nextLine();
                for (Customer c : customerList) {
                    if (c.getPhone().startsWith(carrier)) {
                        result.add(c);
                    }
                }
                break;
            default:
                System.out.println("無効な選択です。");
                return;
        }

        displayResults(result);
    }

    // 📝 3. 並び替え機能
    private static void sortCustomer() {
        System.out.println("並び替えの基準を選択:");
        System.out.println("1. 名前順（昇順）");
        System.out.println("2. メールアドレス順（昇順）");
        System.out.println("3. 電話番号順（昇順）");
        System.out.print("選択してください: ");
        int sortChoice = scanner.nextInt();
        scanner.nextLine(); // 改行消費

        switch (sortChoice) {
            case 1:
                customerList.sort(Comparator.comparing(Customer::getName));
                System.out.println("🔹 名前順（昇順）で並び替えました。");
                break;
            case 2:
                customerList.sort(Comparator.comparing(Customer::getEmail));
                System.out.println("🔹 メールアドレス順（昇順）で並び替えました。");
                break;
            case 3:
                customerList.sort(Comparator.comparing(Customer::getPhone));
                System.out.println("🔹 電話番号順（昇順）で並び替えました。");
                break;
            default:
                System.out.println("無効な選択です。");
                return;
        }

        displayResults(customerList);
    }

    // 📌 検索結果を表示
    private static void displayResults(List<Customer> result) {
        if (result.isEmpty()) {
            System.out.println("該当する顧客が見つかりませんでした。");
        } else {
            System.out.println("\n🔍 検索結果:");
            for (Customer c : result) {
                System.out.println(c);
            }
        }
    }
}