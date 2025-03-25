import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
            System.out.println("4. 顧客情報編集");
            System.out.println("5. 顧客の並び替え");
            System.out.println("6. 顧客削除");
            System.out.println("7. 顧客フィルター");
            System.out.println("8. 終了");
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
                    editCustomer(scanner);
                    break;
                case 5:
                    sortCustomers(scanner);
                    break;
                case 6:
                    deleteCustomer(scanner);
                    break;
                case 7:
                    filterCustomers(scanner);
                    break;
                case 8:
                    System.out.println("終了します。");
                    scanner.close();
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

    // グループで顧客検索
    private static void searchByGroup(Scanner scanner) {
        System.out.print("検索したいグループを入力してください: ");
        String group = scanner.nextLine();

        boolean found = false;
        System.out.println("=== グループ「" + group + "」の顧客 ===");
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

    // 顧客情報の編集
    private static void editCustomer(Scanner scanner) {
        System.out.print("編集する顧客名を入力してください: ");
        String name = scanner.nextLine();

        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                System.out.print("新しい顧客名（変更しない場合はEnterを押してください）: ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) {
                    customer.setName(newName);
                }

                System.out.print("新しいメールアドレス（変更しない場合はEnterを押してください）: ");
                String newEmail = scanner.nextLine();
                if (!newEmail.isEmpty()) {
                    customer.setEmail(newEmail);
                }

                System.out.print("新しいグループ（変更しない場合はEnterを押してください）: ");
                String newGroup = scanner.nextLine();
                if (!newGroup.isEmpty()) {
                    customer.setGroup(newGroup);
                }

                System.out.println("顧客情報が更新されました: " + customer);
                return;
            }
        }

        System.out.println("指定した顧客が見つかりませんでした。");
    }

    // 顧客の並び替え
    private static void sortCustomers(Scanner scanner) {
        if (customers.isEmpty()) {
            System.out.println("顧客情報がありません。");
            return;
        }

        System.out.println("1. 名前で並び替え（昇順）");
        System.out.println("2. 名前で並び替え（降順）");
        System.out.println("3. グループで並び替え（昇順）");
        System.out.println("4. グループで並び替え（降順）");
        System.out.print("選択してください: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // 改行の処理

        switch (option) {
            case 1:
                customers.sort((a, b) -> a.getName().compareTo(b.getName()));
                System.out.println("名前の昇順で並び替えました。");
                break;
            case 2:
                customers.sort((a, b) -> b.getName().compareTo(a.getName()));
                System.out.println("名前の降順で並び替えました。");
                break;
            case 3:
                customers.sort((a, b) -> a.getGroup().compareTo(b.getGroup()));
                System.out.println("グループの昇順で並び替えました。");
                break;
            case 4:
                customers.sort((a, b) -> b.getGroup().compareTo(a.getGroup()));
                System.out.println("グループの降順で並び替えました。");
                break;
            default:
                System.out.println("無効な選択です。");
                return;
        }

        // 並び替え後の顧客リストを表示
        displayCustomers();
    }

    // 顧客の削除
    private static void deleteCustomer(Scanner scanner) {
        System.out.print("削除する顧客名を入力してください: ");
        String name = scanner.nextLine();

        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("顧客が削除されました。");
                return;
            }
        }

        System.out.println("指定した顧客が見つかりませんでした。");
    }

    // 顧客フィルター
    private static void filterCustomers(Scanner scanner) {
        System.out.print("フィルター条件を入力してください（例: グループ名または名前）: ");
        String filter = scanner.nextLine();

        List<Customer> filteredCustomers = customers.stream()
            .filter(customer -> customer.getName().contains(filter) || customer.getGroup().contains(filter))
            .collect(Collectors.toList());

        if (filteredCustomers.isEmpty()) {
            System.out.println("条件に一致する顧客は見つかりませんでした。");
        } else {
            System.out.println("=== フィルタリング結果 ===");
            for (Customer customer : filteredCustomers) {
                System.out.println(customer);
            }
        }
    }
}