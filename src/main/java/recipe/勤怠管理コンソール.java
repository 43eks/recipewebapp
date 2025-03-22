package recipe;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class 勤怠管理コンソール {
    private String employeeId;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private List<BreakTime> breaks;

    public 勤怠管理コンソール(String employeeId) {
        this.employeeId = employeeId;
        this.checkInTime = LocalDateTime.now();
        this.breaks = new ArrayList<>();
    }

    // 退勤処理
    public void checkOut() {
        this.checkOutTime = LocalDateTime.now();
    }

    // 休憩開始
    public void startBreak() {
        if (checkOutTime != null) {
            System.out.println("退勤済みのため、休憩はできません。");
            return;
        }
        if (!breaks.isEmpty() && breaks.get(breaks.size() - 1).getEndTime() == null) {
            System.out.println("すでに休憩中です。");
            return;
        }
        breaks.add(new BreakTime(LocalDateTime.now()));
        System.out.println("休憩を開始しました。");
    }

    // 休憩終了
    public void endBreak() {
        if (breaks.isEmpty() || breaks.get(breaks.size() - 1).getEndTime() != null) {
            System.out.println("休憩が開始されていません。");
            return;
        }
        breaks.get(breaks.size() - 1).setEndTime(LocalDateTime.now());
        System.out.println("休憩を終了しました。");
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    // 総労働時間（休憩を含む）
    public long getWorkDuration() {
        return (checkInTime != null && checkOutTime != null) ?
                Duration.between(checkInTime, checkOutTime).toMinutes() : 0;
    }

    // 休憩時間の合計
    public long getTotalBreakTime() {
        return breaks.stream()
                .filter(b -> b.getEndTime() != null)
                .mapToLong(b -> Duration.between(b.getStartTime(), b.getEndTime()).toMinutes())
                .sum();
    }

    // 実際の労働時間（休憩時間を除く）
    public long getActualWorkDuration() {
        return getWorkDuration() - getTotalBreakTime();
    }

    // 休憩時間を管理するクラス
    private static class BreakTime {
        private final LocalDateTime startTime;
        private LocalDateTime endTime;

        public BreakTime(LocalDateTime startTime) {
            this.startTime = startTime;
        }

        public LocalDateTime getStartTime() {
            return startTime;
        }

        public LocalDateTime getEndTime() {
            return endTime;
        }

        public void setEndTime(LocalDateTime endTime) {
            this.endTime = endTime;
        }
    }

    // テスト用 main メソッド
    public static void main(String[] args) throws InterruptedException {
        勤怠管理コンソール employee = new 勤怠管理コンソール("EMP001");

        // 休憩を試す
        Thread.sleep(1000); // シミュレーションのための遅延
        employee.startBreak();
        Thread.sleep(2000); // 休憩時間のシミュレーション
        employee.endBreak();

        // 退勤
        Thread.sleep(1000);
        employee.checkOut();

        // 勤務状況を表示
        System.out.println("社員ID: " + employee.getEmployeeId());
        System.out.println("出勤時間: " + employee.getCheckInTime());
        System.out.println("退勤時間: " + employee.getCheckOutTime());
        System.out.println("総労働時間 (分): " + employee.getWorkDuration());
        System.out.println("休憩時間合計 (分): " + employee.getTotalBreakTime());
        System.out.println("実際の労働時間 (分): " + employee.getActualWorkDuration());
    }
}