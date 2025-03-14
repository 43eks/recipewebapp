package recipe;

import java.time.LocalDateTime;

public class 勤怠管理コンソール {
    private String employeeId;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    public 勤怠管理コンソール(String employeeId) {
        this.employeeId = employeeId;
        this.checkInTime = LocalDateTime.now();
    }

    public void checkOut() {
        this.checkOutTime = LocalDateTime.now();
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

    public long getWorkDuration() {
        return checkInTime != null && checkOutTime != null ?
            java.time.Duration.between(checkInTime, checkOutTime).toMinutes() : 0;
    }
}
