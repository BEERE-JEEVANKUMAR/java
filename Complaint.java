import java.time.LocalDate;

public class Complaint {
    private static int counter = 1;
    private int id;
    private String customerName;
    private String description;
    private String status;
    private String assignedEmployee;
    private LocalDate date;

    public Complaint(String customerName, String description) {
        this.id = counter++;
        this.customerName = customerName;
        this.description = description;
        this.status = "Open";
        this.assignedEmployee = "Unassigned";
        this.date = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getAssignedEmployee() {
        return assignedEmployee;
    }

    public LocalDate getDate() {
        return date;
    }

    public void assignEmployee(String employeeName) {
        this.assignedEmployee = employeeName;
        this.status = "In-Progress";
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Complaint ID: " + id +
                ", Customer: " + customerName +
                ", Description: " + description +
                ", Status: " + status +
                ", Assigned to: " + assignedEmployee +
                ", Date: " + date;
    }
}

