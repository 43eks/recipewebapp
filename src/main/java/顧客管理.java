import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Customer {
    private String name;
    private String email;
    private String group;

    public Customer(String name, String email, String group) {
        this.name = name;
        this.email = email;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "顧客名: " + name + ", メール: " + email + ", グループ: " + group;
    }
}

public class 顧客管理 {

    private static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("顧客管理システム");
            System.out.println("1. 顧客追加");
            System.out.println("2. 顧客表示");
            System.out.println("3. グループで顧客検索");
            System.out.println("4. 終了");
            System.out.print("選択してください: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 改行の処理

            switch (choice) {
                case 1:
                    addCustomer(scanner);
                    break;
                case 2:
                    displayCustomers();
                    break;
                case 3:
                    searchByGroup(scanner);
                    break;
                case 4:
                    System.out.println("終了します。");
                    return;
                default:
                    System.out.println("無効な選択です。");
            }
        }
    }

    // 顧客の追加
    private static void addCustomer(Scanner scanner) {
        System.out.print("顧客名を入力してください: ");
        String name = scanner.nextLine();
        System.out.print("メールアドレスを入力してください: ");
        String email = scanner.nextLine();
        System.out.print("グループを入力してください（例: 企業、個人、VIPなど）: ");
        String group = scanner.nextLine();

        Customer customer = new Customer(name, email, group);
        customers.add(customer);
        System.out.println("顧客が追加されました。");
    }

    // 顧客情報の表示
    private static void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("顧客情報はありません。");
        } else {
            System.out.println("顧客一覧:");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    // グループで顧客検索
    private static void searchByGroup(Scanner scanner) {
        System.out.print("検索したいグループを入力してください: ");
        String group = scanner.nextLine();

        boolean found = false;
        System.out.println("グループ「" + group + "」の顧客:");
        for (Customer customer : customers) {
            if (customer.getGroup().equalsIgnoreCase(group)) {
                System.out.println(customer);
                found = true;
            }
        }

        if (!found) {
            System.out.println("そのグループの顧客は見つかりませんでした。");
        }
    }
}