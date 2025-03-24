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

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
            System.out.println("1. 顧客追加");
            System.out.println("2. 顧客削除");
            System.out.println("3. 顧客編集");
            System.out.println("4. 顧客検索");
            System.out.println("5. 検索フィルター");
            System.out.println("6. 並び替え");
            System.out.println("7. 終了");
            System.out.print("選択してください: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 改行消費

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    deleteCustomer();
                    break;
                case 3:
                    editCustomer();
                    break;
                case 4:
                    searchCustomer();
                    break;
                case 5:
                    filterCustomer();
                    break;
                case 6:
                    sortCustomer();
                    break;
                case 7:
                    System.out.println("終了します。");
                    return;
                default:
                    System.out.println("無効な選択です。もう一度入力してください。");
            }
        }
    }

    // 🔹 1. 顧客追加
    private static void addCustomer() {
        System.out.print("名前を入力: ");
        String name = scanner.nextLine();
        System.out.print("メールアドレスを入力: ");
        String email = scanner.nextLine();
        System.out.print("電話番号を入力: ");
        String phone = scanner.nextLine();

        Customer newCustomer = new Customer(customerIdCounter++, name, email, phone);
        customerList.add(newCustomer);
        System.out.println("✅ 顧客を追加しました!");
    }

    // 🔹 2. 顧客削除
    private static void deleteCustomer() {
        System.out.print("削除する顧客の ID を入力: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean removed = customerList.removeIf(c -> c.getId() == id);
        if (removed) {
            System.out.println("✅ 顧客を削除しました!");
        } else {
            System.out.println("⚠ 顧客が見つかりません。");
        }
    }

    // 🔹 3. 顧客編集
    private static void editCustomer() {
        System.out.print("編集する顧客の ID を入力: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Customer c : customerList) {
            if (c.getId() == id) {
                System.out.print("新しい名前 (変更しない場合は Enter): ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) c.setName(name);

                System.out.print("新しいメールアドレス (変更しない場合は Enter): ");
                String email = scanner.nextLine();
                if (!email.isEmpty()) c.setEmail(email);

                System.out.print("新しい電話番号 (変更しない場合は Enter): ");
                String phone = scanner.nextLine();
                if (!phone.isEmpty()) c.setPhone(phone);

                System.out.println("✅ 顧客情報を更新しました!");
                return;
            }
        }
        System.out.println("⚠ 顧客が見つかりません。");
    }

    // 🔍 4. 顧客検索
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

    // 🎯 5. 検索フィルター
    private static void filterCustomer() {
        System.out.print("フィルター: 指定した文字で始まる名前を入力: ");
        String nameStart = scanner.nextLine();

        List<Customer> result = new ArrayList<>();
        for (Customer c : customerList) {
            if (c.getName().startsWith(nameStart)) {
                result.add(c);
            }
        }

        displayResults(result);
    }

    // 📝 6. 並び替え機能
    private static void sortCustomer() {
        System.out.println("並び替えの基準を選択:");
        System.out.println("1. 名前順");
        System.out.println("2. メールアドレス順");
        System.out.println("3. 電話番号順");
        System.out.print("選択してください: ");
        int sortChoice = scanner.nextInt();
        scanner.nextLine();

        switch (sortChoice) {
            case 1:
                customerList.sort(Comparator.comparing(Customer::getName));
                break;
            case 2:
                customerList.sort(Comparator.comparing(Customer::getEmail));
                break;
            case 3:
                customerList.sort(Comparator.comparing(Customer::getPhone));
                break;
            default:
                System.out.println("無効な選択です。");
                return;
        }
        System.out.println("✅ 並び替えました!");
        displayResults(customerList);
    }

    // 📌 検索結果を表示
    private static void displayResults(List<Customer> result) {
        if (result.isEmpty()) {
            System.out.println("⚠ 該当する顧客が見つかりませんでした。");
        } else {
            System.out.println("\n🔍 検索結果:");
            for (Customer c : result) {
                System.out.println(c);
            }
        }
    }
}