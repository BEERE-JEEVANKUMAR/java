import models.Complaint;
import models.Employee;
import services.ComplaintService;
import services.ReportService;

import java.time.Month;
import java.util.List;
import java.util.Scanner;

public class ComplaintManagementSystem {

    public static void main(String[] args) {
        ComplaintService complaintService = new ComplaintService();
        ReportService reportService = new ReportService();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Complaint Management System ---");
            System.out.println("1. Register New Complaint");
            System.out.println("2. Assign Complaint");
            System.out.println("3. Update Complaint Status");
            System.out.println("4. Generate Monthly Report");
            System.out.println("5. View All Complaints");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter complaint description: ");
                    String description = scanner.nextLine();
                    complaintService.registerComplaint(customerName, description);
                }
                case 2 -> {
                    System.out.print("Enter complaint ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter employee name: ");
                    String employeeName = scanner.nextLine();
                    complaintService.assignComplaint(id, employeeName);
                }
                case 3 -> {
                    System.out.print("Enter complaint ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new status (Open/In-Progress/Resolved): ");
                    String status = scanner.nextLine();
                    complaintService.updateComplaintStatus(id, status);
                }
                case 4 -> {
                    System.out.print("Enter month (1-12): ");
                    int month = scanner.nextInt();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    reportService.generateMonthlyReport(complaintService.getAllComplaints(), Month.of(month), year);
                }
                case 5 -> {
                    List<Complaint> complaints = complaintService.getAllComplaints();
                    for (Complaint c : complaints) {
                        System.out.println(c);
                    }
                }
                case 6 -> {
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
