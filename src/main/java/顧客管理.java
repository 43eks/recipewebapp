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

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGroup(String group) {
        this.group = group;
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
            System.out.println("\n=== 顧客管理システム ===");
            System.out.println("1. 顧客追加");
            System.out.println("2. 顧客表示");
            System.out.println("3. グループで顧客検索");
            System.out.println("4. 顧客編集");
            System.out.println("5. 顧客の並び替え");
            System.out.println("6. 顧客削除");
            System.out.println("7. 名前で顧客検索");
            System.out.println("8. メールアドレスで顧客検索");
            System.out.println("9. 終了");
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
                    searchByName(scanner);
                    break;
                case 4:
                    addCustomer(scanner);
                    break;
                case 5:
                    sortCustomers(scanner);
                    break;
                case 6:
                    addCustomer(scanner);
                    break;
                case 7:
                    searchByName(scanner);
                    break;
                case 8:
                    searchByEmail(scanner);
                    break;
                case 9:
                    System.out.println("終了します。");
                    scanner.close();
                    return;
                default:
                    System.out.println("無効な選択です。");
            }
        }
    }

    private static void sortCustomers(Scanner scanner) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	// 顧客の追加
    private static void addCustomer(Scanner scanner) {
        System.out.print("顧客名を入力してください: ");
        String name = scanner.nextLine();
        System.out.print("メールアドレスを入力してください: ");
        String email = scanner.nextLine();
        System.out.print("グループを入力してください（例: 企業、個人、VIPなど）: ");
        String group = scanner.nextLine();

        customers.add(new Customer(name, email, group));
        System.out.println("顧客が追加されました。");
    }

    // 顧客情報の表示
    private static void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("顧客情報はありません。");
        } else {
            System.out.println("=== 顧客一覧 ===");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    // 名前で顧客を検索
    private static void searchByName(Scanner scanner) {
        System.out.print("検索する名前を入力してください: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                System.out.println(customer);
                found = true;
            }
        }

        if (!found) {
            System.out.println("その名前の顧客は見つかりませんでした。");
        }
    }

    // メールアドレスで顧客を検索
    private static void searchByEmail(Scanner scanner) {
        System.out.print("検索するメールアドレスの一部を入力してください: ");
        String emailPart = scanner.nextLine();
        boolean found = false;

        for (Customer customer : customers) {
            if (customer.getEmail().contains(emailPart)) {
                System.out.println(customer);
                found = true;
            }
        }

        if (!found) {
            System.out.println("該当するメールアドレスの顧客は見つかりませんでした。");
        }
    }

    // 既存の検索、編集、並び替え、削除のメソッドはそのまま維持
}
