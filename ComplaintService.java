import java.util.ArrayList;
import java.util.List;

public class ComplaintService {
    private List<Complaint> complaints;

    public ComplaintService() {
        complaints = new ArrayList<>();
    }

    public void registerComplaint(String customerName, String description) {
        Complaint complaint = new Complaint(customerName, description);
        complaints.add(complaint);
        System.out.println("Complaint registered with ID: " + complaint.getId());
    }

    public void assignComplaint(int complaintId, String employeeName) {
        for (Complaint complaint : complaints) {
            if (complaint.getId() == complaintId) {
                complaint.assignEmployee(employeeName);
                System.out.println("Complaint assigned to " + employeeName);
                return;
            }
        }
        System.out.println("Complaint ID not found.");
    }

    public void updateComplaintStatus(int complaintId, String status) {
        for (Complaint complaint : complaints) {
            if (complaint.getId() == complaintId) {
                complaint.updateStatus(status);
                System.out.println("Complaint status updated to " + status);
                return;
            }
        }
        System.out.println("Complaint ID not found.");
    }

    public List<Complaint> getAllComplaints() {
        return complaints;
    }
}

