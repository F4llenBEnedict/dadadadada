public class NBI {

    public static void printMenu(String personName) {
        System.out.println("\n===== NBI SERVICES =====");
        System.out.println("Name: " + personName);
        System.out.println("1. Clearance");
        System.out.println("2. Complaint");
        System.out.println("3. Back");
    }

    private String type;
    private String details;
    private String delivery;
    private String date;
    private String payment;
    private String complaintType;
    private String reportedPerson;
    private String reportedAge;
    private String reportedAddress;
    private String description;
    private String incident;
    private String location;
    private String reference;
    private String status;

    public NBI(String type) {
        this.type = type;
    }

    public String getType() { return type; }
    public String getReference() { return reference; }
    public String getStatus() { return status; }

    public void setClearance(String details, String delivery,
                              String date, String payment,
                              String reference) {

        this.details = details;
        this.delivery = delivery;
        this.date = date;
        this.payment = payment;
        this.reference = reference;
        this.status = "Submitted";
    }

    public void setComplaint(String complaintType,
                              String reportedPerson,
                              String reportedAge,
                              String reportedAddress,
                              String description,
                              String incident,
                              String location,
                              String reference) {

        this.complaintType = complaintType;
        this.reportedPerson = reportedPerson;
        this.reportedAge = reportedAge;
        this.reportedAddress = reportedAddress;
        this.description = description;
        this.incident = incident;
        this.location = location;
        this.reference = reference;
        this.status = "Submitted";
    }

    public void printDetails() {

        if (type.equals("Clearance")) {
            System.out.println("\n===== NBI CLEARANCE =====");
            System.out.println("Details: " + details);
            System.out.println("Delivery/Pickup: " + delivery);
            System.out.println("Date: " + date);
            System.out.println("Payment: " + payment);
            System.out.println("Reference Number: " + reference);
            System.out.println("Status: " + status);

        } 

        else {
            System.out.println("\n===== NBI COMPLAINT =====");
            System.out.println("Complaint Type: " + complaintType);

            if (reportedPerson != null) {
                System.out.println("Reported Person: " + reportedPerson);
                System.out.println("Age: " + reportedAge);
                System.out.println("Address: " + reportedAddress);
            }

            if (description != null) {
                System.out.println("Description: " + description);
            }

            System.out.println("What Happened: " + incident);
            System.out.println("Location: " + location);
            System.out.println("Reference Number: " + reference);
            System.out.println("Status: " + status);
        }
    }
}