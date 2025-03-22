package recipe;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 勤怠管理コンソール {
    private final Map<String, 勤怠管理コンソール> employeeRecords;
    private static final Scanner scanner = new Scanner(System.in);

    public 勤怠管理コンソール() {
        this.employeeRecords = new HashMap<>();
    }

    // 従業員を登録
    public void addEmployee(String employeeId) {
        if (!employeeRecords.containsKey(employeeId)) {
            employeeRecords.put(employeeId, new 勤怠管理コンソール());
            System.out.println("従業員 " + employeeId + " を登録しました。");
        } else {
            System.out.println("この従業員はすでに登録されています。");
        }
    }

    // 従業員を削除
    public void removeEmployee(String employeeId) {
        if (employeeRecords.containsKey(employeeId)) {
            employeeRecords.remove(employeeId);
            System.out.println("従業員 " + employeeId + " を削除しました。");
        } else {
            System.out.println("従業員が見つかりません。");
        }
    }

    // 出勤処理
    public void checkIn(String employeeId) {
        if (employeeRecords.containsKey(employeeId)) {
            employeeRecords.put(employeeId, new 勤怠管理コンソール());
            System.out.println("従業員 " + employeeId + " が出勤しました。");
        } else {
            System.out.println("従業員が登録されていません。");
        }
    }

    // 退勤処理
    public void checkOut(String employeeId) {
        勤怠管理コンソール employee = employeeRecords.get(employeeId);
        if (employee != null) {
            employee.checkOut(employeeId);
            System.out.println("従業員 " + employeeId + " が退勤しました。");
        } else {
            System.out.println("従業員が見つかりません。");
        }
    }

    // 休憩開始
    public void startBreak(String employeeId) {
        勤怠管理コンソール employee = employeeRecords.get(employeeId);
        if (employee != null) {
            employee.startBreak(employeeId);
        } else {
            System.out.println("従業員が見つかりません。");
        }
    }

    // 休憩終了
    public void endBreak(String employeeId) {
        勤怠管理コンソール employee = employeeRecords.get(employeeId);
        if (employee != null) {
            employee.endBreak(employeeId);
        } else {
            System.out.println("従業員が見つかりません。");
        }
    }

    // 全従業員の勤務状況を表示
    public void printAllWorkStatus() {
        System.out.println("\n=========================");
        System.out.println("全従業員の勤務状況");
        System.out.println("=========================");
        if (employeeRecords.isEmpty()) {
            System.out.println("現在、登録されている従業員はいません。");
        } else {
            for (勤怠管理コンソール employee : employeeRecords.values()) {
                employee.printAllWorkStatus();
            }
        }
    }

    // メインメソッド
    public static void main(String[] args) {
        勤怠管理コンソール system = new 勤怠管理コンソール();
        while (true) {
            System.out.println("\n=== 勤怠管理システム ===");
            System.out.println("1. 従業員を追加");
            System.out.println("2. 従業員を削除");
            System.out.println("3. 出勤");
            System.out.println("4. 退勤");
            System.out.println("5. 休憩開始");
            System.out.println("6. 休憩終了");
            System.out.println("7. 全従業員の勤務状況を表示");
            System.out.println("8. 終了");
            System.out.print("選択してください: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("従業員IDを入力してください: ");
                    String addId = scanner.nextLine();
                    system.addEmployee(addId);
                    break;
                case 2:
                    System.out.print("削除する従業員IDを入力してください: ");
                    String removeId = scanner.nextLine();
                    system.removeEmployee(removeId);
                    break;
                case 3:
                    System.out.print("出勤する従業員IDを入力してください: ");
                    String checkInId = scanner.nextLine();
                    system.checkIn(checkInId);
                    break;
                case 4:
                    System.out.print("退勤する従業員IDを入力してください: ");
                    String checkOutId = scanner.nextLine();
                    system.checkOut(checkOutId);
                    break;
                case 5:
                    System.out.print("休憩を開始する従業員IDを入力してください: ");
                    String startBreakId = scanner.nextLine();
                    system.startBreak(startBreakId);
                    break;
                case 6:
                    System.out.print("休憩を終了する従業員IDを入力してください: ");
                    String endBreakId = scanner.nextLine();
                    system.endBreak(endBreakId);
                    break;
                case 7:
                    system.printAllWorkStatus();
                    break;
                case 8:
                    System.out.println("システムを終了します。");
                    return;
                default:
                    System.out.println("無効な選択です。もう一度入力してください。");
            }
        }
    }
}