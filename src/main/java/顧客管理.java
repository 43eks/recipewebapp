
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    @Override
    public String toString() {
        return "ID: " + id + ", 名前: " + name + ", メール: " + email;
    }
}

public class 顧客管理 {
    private List<Customer> customers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int nextId = 1;

    public void run() {
        while (true) {
            System.out.println("\n顧客管理システム");
            System.out.println("1. 顧客を追加");
            System.out.println("2. 顧客一覧を表示");
            System.out.println("3. 顧客を検索");
            System.out.println("4. 顧客を削除");
            System.out.println("5. 終了");
            System.out.print("選択: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    listCustomers();
                    break;
                case 3:
                    searchCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    System.out.println("終了します。");
                    return;
                default:
                    System.out.println("無効な選択です。もう一度選んでください。");
            }
        }
    }

    private void addCustomer() {
        System.out.print("名前: ");
        String name = scanner.nextLine();
        System.out.print("メール: ");
        String email = scanner.nextLine();
        customers.add(new Customer(nextId++, name, email));
        System.out.println("顧客を追加しました。");
    }

    private void listCustomers() {
        if (customers.isEmpty()) {
            System.out.println("登録されている顧客はいません。");
        } else {
            for (Customer c : customers) {
                System.out.println(c);
            }
        }
    }

    private void searchCustomer() {
        System.out.print("検索するID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Customer c : customers) {
            if (c.getId() == id) {
                System.out.println("見つかりました: " + c);
                return;
            }
        }
        System.out.println("顧客が見つかりませんでした。");
    }

    private void deleteCustomer() {
        System.out.print("削除するID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        customers.removeIf(c -> c.getId() == id);
        System.out.println("削除が完了しました。");
    }

    public static void main(String[] args) {
        new 顧客管理().run();
    }
}