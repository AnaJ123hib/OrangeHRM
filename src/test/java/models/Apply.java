package models;

import java.time.LocalDate;

public class Apply {
    private String leaveType;
    private LocalDate fromDate;
    private LocalDate  toDate;
    private String comments;
    private String duration;

    public Apply(
            String leaveType, LocalDate fromDate,
            LocalDate toDate, String comments, String duration
    ) {
        this.leaveType = leaveType;
        this.fromDate = fromDate;
        this.toDate= toDate;
        this.comments = comments;
        this.duration = duration;
    }

    public String getLeaveType(){
        return leaveType;
    }
    public LocalDate getFromDate() {
        return fromDate;
    }
    public LocalDate getToDate() {
        return toDate;
    }
    public String getComments() {
        return comments;
    }
    public String getDuration(){ return  duration; }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }
    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }
    public void setToDate(LocalDate toDate) {
        this.toDate= toDate;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public void setDuration(String duration) { this.duration = duration; }
}
