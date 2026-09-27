public class PSA {

    public static void printMenu() {
        System.out.println("\n===== PSA SERVICES =====");
        System.out.println("1. Birth Certificate");
        System.out.println("2. Marriage Certificate");
        System.out.println("3. Death Certificate");
        System.out.println("4. CENOMAR");
        System.out.println("5. Back");
    }

    private String document;
    private String requester;
    private String person;
    private String purpose;
    private int copies;
    private String delivery;
    private String deliveryDate;
    private double price;
    private String reference;

    public PSA(String document, String requester,
               String person, String purpose,
               int copies, String delivery,
               double price, String reference) {

        this.document = document;
        this.requester = requester;
        this.person = person;
        this.purpose = purpose;
        this.copies = copies;
        this.delivery = delivery;
        this.price = price;
        this.reference = reference;
    }

    public String getReference() { 
        return reference; 
    }

    public void setDeliveryDate(String date) {
        deliveryDate = date;
    }

    public void printDetails() {
        System.out.println("\n===== PSA REQUEST =====");

        System.out.println("Document: " + document);
        System.out.println("Requester: " + requester);
        System.out.println("Person: " + person);
        System.out.println("Purpose: " + purpose);
        System.out.println("Number of Copies: " + copies);
        System.out.println("Delivery/Pickup: " + delivery);

        System.out.printf("Price: PHP %.2f%n", price);

        System.out.println("Reference Number: " + reference);

        System.out.println("Delivery Date: " + deliveryDate);
    }
}