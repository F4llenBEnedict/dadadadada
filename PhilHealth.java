import java.util.ArrayList;

public class PhilHealth {

    public static void printMenu(String personName) {
        System.out.println("\n===== PHILHEALTH =====");
        System.out.println("Name: " + personName);
        System.out.println("1. Membership");
        System.out.println("2. Contribution");
        System.out.println("3. Contribution Record");
        System.out.println("4. Back");
    }

    private String category;
    private String employment;
    private String employer;
    private String occupation;
    private String reference;
    private String philHealthNumber;
    private double totalContribution;
    private double latestContribution;
    private String latestMonth;
    private boolean hasContribution;

    private ArrayList<String> contributionHistory = new ArrayList<>();

    public PhilHealth(String category, String employment,
                       String employer, String occupation,
                       String reference) {

        this.category = category;
        this.employment = employment;
        this.employer = employer;
        this.occupation = occupation;
        this.reference = reference;

        this.totalContribution = 0;
        this.hasContribution = false;
    }

    public String getReference() { 
        return reference; 
    }

    public void setPhilHealthNumber(String philHealthNumber) {
        this.philHealthNumber = philHealthNumber;
    }

    public String getPhilHealthNumber() { return philHealthNumber; }

    public void addContribution(String date, double amount) {

        totalContribution += amount;
        latestContribution = amount;
        latestMonth = date;
        hasContribution = true;

        contributionHistory.add(
            date + " | PHP " + String.format("%.2f", amount) + " | Paid"
        );
    }

    public void printDetails() {
        System.out.println("\n===== PHILHEALTH =====");
        System.out.println("Category: " + category);
        System.out.println("Employment Status: " + employment);
        System.out.println("Employer/Business: " + employer);
        System.out.println("Occupation: " + occupation);
        System.out.println("Reference Number: " + reference);
        System.out.println("Status: Processing");
    }

    public void printContribution() {
        System.out.println("\n===== PHILHEALTH CONTRIBUTION =====");

        System.out.println("PhilHealth Number: " + philHealthNumber);

        if (!hasContribution) {

            System.out.println("Status: NO CONTRIBUTION RECORD FOUND");
            System.out.println("Your account currently has no recorded contributions.");

            return;
        }

        System.out.println("Contribution Status: Active");
        System.out.println("Latest Contribution Month: " + latestMonth);
        System.out.printf("Latest Contribution: PHP %.2f%n",latestContribution);

        System.out.printf("Total Contributions: PHP %.2f%n",totalContribution);
    }

    public void printContributionHistory() {
        System.out.println("\n===== CONTRIBUTION HISTORY =====");

        if (contributionHistory.isEmpty()) {
            System.out.println("No contribution record found.");
            return;
        }

        for (String record : contributionHistory) {
            System.out.println(record);
        }
    }
}