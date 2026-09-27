import java.util.ArrayList;

public class SSS {

    public static void printMenu() {
        System.out.println("\n===== SSS SERVICES =====");
        System.out.println("1. Membership");
        System.out.println("2. Contribution");
        System.out.println("3. Member Information");
        System.out.println("4. Benefits");
        System.out.println("5. Print Records");
        System.out.println("6. Back");
    }

    private String name;
    private String address;
    private String contact;
    private String email;
    private String employment;
    private String employer;
    private String occupation;
    private String sssNumber;
    private String reference;
    private double totalContribution;
    private double latestContribution;
    private String latestMonth;

    private ArrayList<String> contributionHistory = new ArrayList<>();

    public SSS(String name, String address, String contact,
               String email, String employment,
               String employer, String occupation,
               String reference) {

        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.employment = employment;
        this.employer = employer;
        this.occupation = occupation;
        this.reference = reference;
    }

    public String getReference() { 
        return reference; 
    }

    public void setSssNumber(String sssNumber) { 
        this.sssNumber = sssNumber; 
    }

    public String getSssNumber() { 
        return sssNumber; 
    }

    public void addContribution(String date, double amount) {

        totalContribution += amount;
        latestContribution = amount;
        latestMonth = date;

        contributionHistory.add(date + " | PHP " + String.format("%.2f", amount) +" | Paid");
    }

    public void printDetails() {
        System.out.println("\n===== SSS MEMBERSHIP =====");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Contact: " + contact);
        System.out.println("Email: " + email);
        System.out.println("Employment Status: " + employment);
        System.out.println("Employer/Business: " + employer);
        System.out.println("Occupation: " + occupation);
        System.out.println("Reference Number: " + reference);
    }

    public void printContribution() {
        System.out.println("\n===== SSS CONTRIBUTION =====");

        System.out.println("SSS Number: " + sssNumber);

        if (contributionHistory.isEmpty()) {

            System.out.println("Contribution Status: Inactive");
            System.out.println("NO CONTRIBUTION RECORD FOUND");

            return;
        }

        System.out.println("Contribution Status: Active");
        System.out.println("Latest Month: " + latestMonth);

        System.out.printf("Latest Contribution: PHP %.2f%n",latestContribution);

        System.out.printf("Total Contributions: PHP %.2f%n",totalContribution);
    }

    public void printHistory() {
        System.out.println("\n===== SSS CONTRIBUTION HISTORY =====");

        if (contributionHistory.isEmpty()) {
            System.out.println("No contribution record found.");
            return;
        }

        for (String record : contributionHistory) {
            System.out.println(record);
        }
    }

    public void printMemberInformation() {
        System.out.println("\n===== SSS MEMBER INFORMATION =====");

        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Contact: " + contact);
        System.out.println("Email: " + email);
        System.out.println("SSS Number: " + sssNumber);
        System.out.println("Employment Status: " + employment);
        System.out.println("Employer: " + employer);
        System.out.println("Occupation: " + occupation);
    }

    public void printBenefits() {
        System.out.println("\n===== SSS BENEFITS =====");
        System.out.println("1. Sickness");
        System.out.println("2. Maternity");
        System.out.println("3. Disability");
        System.out.println("4. Retirement");
        System.out.println("5. Death");
        System.out.println("6. Funeral");
        System.out.println("7. Unemployment");
    }

    public void printRecord() {
        System.out.println("\n===== SSS RECORD =====");

        printMemberInformation();
        printContribution();
        printHistory();
    }
}