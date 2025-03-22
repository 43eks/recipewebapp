package recipe;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 勤怠管理コンソール {

    // 従業員情報を管理するMap
    private final Map<String, 勤怠情報> employeeRecords;
    private static final Scanner scanner = new Scanner(System.in);

    public 勤怠管理コンソール() {
        this.employeeRecords = new HashMap<>();
    }

    // 従業員を登録
    public void addEmployee(String employeeId) {
        if (!employeeRecords.containsKey(employeeId)) {
            employeeRecords.put(employeeId, new 勤怠情報(employeeId));
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
        勤怠情報 employee = employeeRecords.get(employeeId);
        if (employee != null) {
            employee.checkIn();
            System.out.println("従業員 " + employeeId + " が出勤しました。");
        } else {
            System.out.println("従業員が登録されていません。");
        }
    }

    // 退勤処理
    public void checkOut(String employeeId) {
        勤怠情報 employee = employeeRecords.get(employeeId);
        if (employee != null) {
            employee.checkOut();
            System.out.println("従業員 " + employeeId + " が退勤しました。");
        } else {
            System.out.println("従業員が見つかりません。");
        }
    }

    // 休憩開始
    public void startBreak(String employeeId) {
        勤怠情報 employee = employeeRecords.get(employeeId);
        if (employee != null) {
            employee.startBreak();
            System.out.println("従業員 " + employeeId + " の休憩を開始しました。");
        } else {
            System.out.println("従業員が見つかりません。");
        }
    }

    // 休憩終了
    public void endBreak(String employeeId) {
        勤怠情報 employee = employeeRecords.get(employeeId);
        if (employee != null) {
            employee.endBreak();
            System.out.println("従業員 " + employeeId + " の休憩が終了しました。");
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
            for (勤怠情報 employee : employeeRecords.values()) {
                employee.printWorkStatus();
            }
        }
    }

    // CSV出力
    public void exportToCSV() {
        String fileName = "勤怠データ.csv";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("社員ID,出勤時間,退勤時間,総労働時間(分),休憩時間合計(分),実際の労働時間(分)\n");
            for (勤怠情報 employee : employeeRecords.values()) {
                writer.write(employee.toCSV() + "\n");
            }
            System.out.println("CSVファイルを出力しました: " + fileName);
        } catch (IOException e) {
            System.out.println("CSV出力エラー: " + e.getMessage());
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
            System.out.println("8. CSV出力");
            System.out.println("9. 終了");
            System.out.print("選択してください: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("従業員IDを入力してください: ");
                    system.addEmployee(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("削除する従業員IDを入力してください: ");
                    system.removeEmployee(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("出勤する従業員IDを入力してください: ");
                    system.checkIn(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("退勤する従業員IDを入力してください: ");
                    system.checkOut(scanner.nextLine());
                    break;
                case 5:
                    System.out.print("休憩を開始する従業員IDを入力してください: ");
                    system.startBreak(scanner.nextLine());
                    break;
                case 6:
                    System.out.print("休憩を終了する従業員IDを入力してください: ");
                    system.endBreak(scanner.nextLine());
                    break;
                case 7:
                    system.printAllWorkStatus();
                    break;
                case 8:
                    system.exportToCSV();
                    break;
                case 9:
                    System.out.println("システムを終了します。");
                    return;
                default:
                    System.out.println("無効な選択です。もう一度入力してください。");
            }
        }
    }

    // 勤怠情報を管理するクラス
    static class 勤怠情報 {
        private String employeeId;
        private LocalDateTime checkInTime;
        private LocalDateTime checkOutTime;
        private LocalDateTime breakStartTime;
        private LocalDateTime breakEndTime;
        private long totalBreakTime = 0; // 休憩時間合計(分)
        
        public 勤怠情報(String employeeId) {
            this.employeeId = employeeId;
        }

        // 出勤処理
        public void checkIn() {
            this.checkInTime = LocalDateTime.now();
        }

        // 退勤処理
        public void checkOut() {
            this.checkOutTime = LocalDateTime.now();
        }

        // 休憩開始
        public void startBreak() {
            this.breakStartTime = LocalDateTime.now();
        }

        // 休憩終了
        public void endBreak() {
            if (this.breakStartTime != null) {
                this.breakEndTime = LocalDateTime.now();
                this.totalBreakTime += Duration.between(breakStartTime, breakEndTime).toMinutes();
            }
        }

        // 勤務状況の表示
        public void printWorkStatus() {
            System.out.println("社員ID: " + employeeId);
            System.out.println("出勤時間: " + (checkInTime != null ? checkInTime : "未出勤"));
            System.out.println("退勤時間: " + (checkOutTime != null ? checkOutTime : "未退勤"));
            System.out.println("総労働時間: " + (checkInTime != null && checkOutTime != null ? Duration.between(checkInTime, checkOutTime).toMinutes() : 0) + " 分");
            System.out.println("休憩時間合計: " + totalBreakTime + " 分");
            System.out.println("実働時間: " + ((checkInTime != null && checkOutTime != null) ?
                    (Duration.between(checkInTime, checkOutTime).toMinutes() - totalBreakTime) : 0) + " 分");
        }

        // CSV出力用のフォーマット
        public String toCSV() {
            return String.format("%s,%s,%s,%d,%d,%d",
                    employeeId,
                    checkInTime != null ? checkInTime : "未出勤",
                    checkOutTime != null ? checkOutTime : "未退勤",
                    checkInTime != null && checkOutTime != null ? Duration.between(checkInTime, checkOutTime).toMinutes() : 0,
                    totalBreakTime,
                    (checkInTime != null && checkOutTime != null) ?
                            (Duration.between(checkInTime, checkOutTime).toMinutes() - totalBreakTime) : 0);
        }
    }
}