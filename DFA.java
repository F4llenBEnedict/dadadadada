public class DFA {

    public static void printMenu() {
        System.out.println("\n===== DFA SERVICES =====");
        System.out.println("1. Passport Application");
        System.out.println("2. Check Application Status");
        System.out.println("3. Delivery/Release");
        System.out.println("4. Back");
    }

    private String applicantName;
    private int age;
    private String applicationType;
    private String oldPassportNumber;
    private String dateIssued;
    private String dateExpired;
    private String circumstance;
    private String supportingDocuments;
    private String appointmentDate;
    private String branch;
    private String processingType;
    private double payment;
    private String reference;
    private String status;
    private String releaseMethod;
    private String releaseDate;

    public DFA(String applicantName, int age,
               String applicationType) {
        this.applicantName = applicantName;
        this.age = age;
        this.applicationType = applicationType;
        this.status = "Submitted";
    }

    public String getReference() { 
        return reference; 
    }

    public String getStatus() { 
        return status; 
    }

    public void setOldPassportDetails(String number,
                                      String issued,
                                      String expired) {
        this.oldPassportNumber = number;
        this.dateIssued = issued;
        this.dateExpired = expired;
    }

    public void setLostDamagedDetails(String circumstance) {
        this.circumstance = circumstance;
    }

    public void setSupportingDocuments(String documents) {
        this.supportingDocuments = documents;
    }

    public void setAppointment(String date, String branch) {
        this.appointmentDate = date;
        this.branch = branch;
    }

    public void setProcessing(String type, double payment) {
        this.processingType = type;
        this.payment = payment;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setRelease(String method, String date) {
        this.releaseMethod = method;
        this.releaseDate = date;
    }

    public void printDetails() {
        System.out.println("\n===== DFA PASSPORT APPLICATION =====");

        System.out.println("Applicant: " + applicantName);
        System.out.println("Age: " + age);
        System.out.println("Application Type: " + applicationType);

        if (oldPassportNumber != null) {

            System.out.println("Old Passport Number: " + oldPassportNumber);

            System.out.println("Date Issued: " + dateIssued);

            System.out.println("Date Expired: " + dateExpired);
        }

        if (circumstance != null) {
            System.out.println("Circumstance: " + circumstance);
        }

        System.out.println("Supporting Documents: " + supportingDocuments);

        System.out.println("Appointment Date: " + appointmentDate);

        System.out.println("Branch/Consular Office: " + branch);

        System.out.println("Processing Type: " + processingType);

        System.out.printf("Payment: PHP %.2f%n",payment);

        System.out.println("Reference Number: " + reference);

        System.out.println("Status: " + status);

        if (releaseMethod != null) {
            System.out.println("Delivery/Pickup: " + releaseMethod);

            System.out.println("Release Date: " + releaseDate);
        }
    }

    public void printStatus() {
        System.out.println("\n===== DFA APPLICATION STATUS =====");

        System.out.println("Applicant: " + applicantName);
        System.out.println("Reference Number: " + reference);
        System.out.println("Status: " + status);
    }

    public void updateStatus(String newStatus) {
        status = newStatus;
    }
}