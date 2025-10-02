package services;

import models.Complaint;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class ReportService {

    public void generateMonthlyReport(List<Complaint> complaints, Month month, int year) {
        System.out.println("Monthly Complaint Report for " + month + " " + year);
        System.out.println("------------------------------------------------");

        for (Complaint complaint : complaints) {
            if (complaint.getDate().getMonth() == month && complaint.getDate().getYear() == year) {
                System.out.println(complaint);
            }
        }
    }
}
