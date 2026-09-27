import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    static ArrayList<Person> people = new ArrayList<>();
    static ArrayList<NBI> nbiRecords = new ArrayList<>();
    static ArrayList<PhilHealth> philHealthRecords = new ArrayList<>();
    static ArrayList<SSS> sssRecords = new ArrayList<>();
    static ArrayList<DFA> dfaRecords = new ArrayList<>();
    static ArrayList<PSA> psaRecords = new ArrayList<>();

    static int refCounter = 1000;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("   GOVERNMENT SERVICES SYSTEM");
            System.out.println("================================");
            System.out.println("1. Registration");
            System.out.println("2. NBI");
            System.out.println("3. PhilHealth");
            System.out.println("4. SSS");
            System.out.println("5. DFA");
            System.out.println("6. PSA");
            System.out.println("7. View All Records");
            System.out.println("8. Exit");

            System.out.print("Choose: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    register();
                    break;

                case 2:
                    nbi();
                    break;

                case 3:
                    philHealth();
                    break;

                case 4:
                    sss();
                    break;

                case 5:
                    dfa();
                    break;
                    case 6:
                    psa();
                    break;

                case 7:
                    printRecords();
                    break;

                case 8:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);
    }

    static String generateReference() {
        refCounter++;
        return "REF-" + refCounter;
    }

    static Person getCurrentPerson() {

        if (people.isEmpty()) {
            System.out.println("Please register first.");
            return null;
        }

        return people.get(people.size() - 1);
    }

    static void register() {

        System.out.println("\n===== REGISTRATION =====");

        System.out.print("Last Name: ");
        String lastName = input.nextLine();

        System.out.print("First Name: ");
        String firstName = input.nextLine();
        System.out.print("Middle Name (- if none): ");
        String middleName = input.nextLine();

        System.out.print("Suffix (- if none): ");
        String suffix = input.nextLine();

        System.out.print("Age: ");
        int age = input.nextInt();
        input.nextLine();

        System.out.print("Contact Number: ");
        String contact = input.nextLine();

        System.out.print("Province: ");
        String province = input.nextLine();

        System.out.print("City: ");
        String city = input.nextLine();

        System.out.print("Barangay: ");
        String barangay = input.nextLine();

        System.out.print("ZIP Code: ");
        String zip = input.nextLine();

        System.out.print("Sex: ");
        String sex = input.nextLine();

        System.out.print("Email: ");
        String email = input.nextLine();

        System.out.print("Status: ");
        String status = input.nextLine();

        System.out.print("Employment Status: ");
        String employmentStatus = input.nextLine();

        Person person = new Person(
                lastName,
                firstName,
                middleName,
                suffix,
                age,
                contact,
                province,
                city,
                barangay,
                zip,
                sex,
                email,
                status,
                employmentStatus
        );

        people.add(person);

        System.out.println("\nRegistration successful!");

        person.printDetails();
    }


    static void nbi() {

        Person person = getCurrentPerson();
        if (person == null) return;

        int choice;

        do {
            NBI.printMenu(person.getFullName());

            System.out.print("Choose: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                System.out.print("Clearance Details: ");
                String details = input.nextLine();

                System.out.print("Deliver or Pickup: ");
                String delivery = input.nextLine();

                System.out.print("Delivery/Pickup Date: ");
                String date = input.nextLine();

                System.out.print("Payment: ");
                String payment = input.nextLine();

                String reference = generateReference();

                NBI nbi = new NBI("Clearance");
                nbi.setClearance(details, delivery, date, payment, reference);
                nbiRecords.add(nbi);

                System.out.println("\nNBI Clearance request submitted!");
                nbi.printDetails();

            } else if (choice == 2) {

                System.out.print("Complaint Type: ");
                String complaintType = input.nextLine();

                String reportedPerson = null;
                String reportedAge = null;
                String reportedAddress = null;
                String description = null;

                System.out.print("Is this complaint against a specific person? (yes/no): ");
                String against = input.nextLine();

                if (against.equalsIgnoreCase("yes")) {

                    System.out.print("Reported Person's Name: ");
                    reportedPerson = input.nextLine();

                    System.out.print("Reported Person's Age: ");
                    reportedAge = input.nextLine();

                    System.out.print("Reported Person's Address: ");
                    reportedAddress = input.nextLine();

                } else {

                    System.out.print("Description: ");
                    description = input.nextLine();
                }

                System.out.print("What Happened: ");
                String incident = input.nextLine();

                System.out.print("Location: ");
                String location = input.nextLine();

                String reference = generateReference();

                NBI nbi = new NBI("Complaint");
                nbi.setComplaint(complaintType, reportedPerson, reportedAge,
                        reportedAddress, description, incident, location, reference);
                nbiRecords.add(nbi);

                System.out.println("\nNBI Complaint filed!");
                nbi.printDetails();
            }

        } while (choice != 3);
    }

    static void philHealth() {

        Person person = getCurrentPerson();
        if (person == null) return;

        int choice;

        do {
            PhilHealth.printMenu(person.getFullName());

            System.out.print("Choose: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                System.out.print("Category (Employed/Self-Employed/Voluntary): ");
                String category = input.nextLine();

                System.out.print("Employment Status: ");
                String employment = input.nextLine();

                System.out.print("Employer/Business: ");
                String employer = input.nextLine();

                System.out.print("Occupation: ");
                String occupation = input.nextLine();

                String reference = generateReference();

                PhilHealth ph = new PhilHealth(category, employment, employer, occupation, reference);
                ph.setPhilHealthNumber("PH-" + refCounter);
                philHealthRecords.add(ph);

                System.out.println("\nPhilHealth membership submitted!");
                ph.printDetails();

            } else if (choice == 2) {

                if (philHealthRecords.isEmpty()) {
                    System.out.println("No PhilHealth membership found. Please register a membership first.");
                    continue;
                }

                PhilHealth ph = philHealthRecords.get(philHealthRecords.size() - 1);

                System.out.print("Contribution Month (e.g. January 2026): ");
                String date = input.nextLine();

                System.out.print("Amount: ");
                double amount = Double.parseDouble(input.nextLine());

                ph.addContribution(date, amount);

                System.out.println("\nContribution recorded!");
                ph.printContribution();

            } else if (choice == 3) {

                if (philHealthRecords.isEmpty()) {
                    System.out.println("No PhilHealth membership found.");
                    continue;
                }

                PhilHealth ph = philHealthRecords.get(philHealthRecords.size() - 1);
                ph.printContributionHistory();
            }

        } while (choice != 4);
    }

    static void sss() {

        Person person = getCurrentPerson();
        if (person == null) return;

        int choice;

        do {
            SSS.printMenu();

            System.out.print("Choose: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                System.out.print("Employment Status: ");
                String employment = input.nextLine();

                System.out.print("Employer/Business: ");
                String employer = input.nextLine();

                System.out.print("Occupation: ");
                String occupation = input.nextLine();

                String reference = generateReference();

                SSS record = new SSS(
                        person.getFullName(),
                        person.getAddress(),
                        person.getContact(),
                        person.getEmail(),
                        employment,
                        employer,
                        occupation,
                        reference
                );
                record.setSssNumber("SSS-" + refCounter);
                sssRecords.add(record);

                System.out.println("\nSSS membership submitted!");
                record.printDetails();

            } else if (choice == 2) {

                if (sssRecords.isEmpty()) {
                    System.out.println("No SSS membership found. Please register a membership first.");
                    continue;
                }

                SSS record = sssRecords.get(sssRecords.size() - 1);

                System.out.print("Contribution Month (e.g. January 2026): ");
                String date = input.nextLine();

                System.out.print("Amount: ");
                double amount = Double.parseDouble(input.nextLine());

                record.addContribution(date, amount);

                System.out.println("\nContribution recorded!");
                record.printContribution();

            } else if (choice == 3) {

                if (sssRecords.isEmpty()) {
                    System.out.println("No SSS membership found.");
                    continue;
                }

                sssRecords.get(sssRecords.size() - 1).printMemberInformation();

            } else if (choice == 4) {

                if (sssRecords.isEmpty()) {
                    System.out.println("No SSS membership found.");
                    continue;
                }

                sssRecords.get(sssRecords.size() - 1).printBenefits();

            } else if (choice == 5) {

                if (sssRecords.isEmpty()) {
                    System.out.println("No SSS membership found.");
                    continue;
                }

                sssRecords.get(sssRecords.size() - 1).printRecord();
            }

        } while (choice != 6);
    }

    static void dfa() {

        Person person = getCurrentPerson();
        if (person == null) return;

        int choice;

        do {
            DFA.printMenu();

            System.out.print("Choose: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                System.out.print("Application Type (New/Renewal/Lost/Damaged): ");
                String applicationType = input.nextLine();

                DFA record = new DFA(person.getFullName(), person.getAge(), applicationType);

                if (applicationType.equalsIgnoreCase("Renewal")) {

                    System.out.print("Old Passport Number: ");
                    String number = input.nextLine();

                    System.out.print("Date Issued: ");
                    String issued = input.nextLine();

                    System.out.print("Date Expired: ");
                    String expired = input.nextLine();

                    record.setOldPassportDetails(number, issued, expired);

                } else if (applicationType.equalsIgnoreCase("Lost")
                        || applicationType.equalsIgnoreCase("Damaged")) {

                    System.out.print("Circumstance: ");
                    String circumstance = input.nextLine();

                    record.setLostDamagedDetails(circumstance);
                }

                System.out.print("Supporting Documents: ");
                String documents = input.nextLine();
                record.setSupportingDocuments(documents);

                System.out.print("Appointment Date: ");
                String appointmentDate = input.nextLine();

                System.out.print("Branch/Consular Office: ");
                String branch = input.nextLine();

                record.setAppointment(appointmentDate, branch);

                System.out.print("Processing Type (Regular/Expedited): ");
                String processingType = input.nextLine();

                System.out.print("Payment: ");
                double payment = Double.parseDouble(input.nextLine());

                record.setProcessing(processingType, payment);

                String reference = generateReference();
                record.setReference(reference);

                dfaRecords.add(record);

                System.out.println("\nDFA passport application submitted!");
                record.printDetails();

            } else if (choice == 2) {

                if (dfaRecords.isEmpty()) {
                    System.out.println("No DFA application found.");
                    continue;
                }

                dfaRecords.get(dfaRecords.size() - 1).printStatus();

            } else if (choice == 3) {

                if (dfaRecords.isEmpty()) {
                    System.out.println("No DFA application found. Please apply first.");
                    continue;
                }

                DFA record = dfaRecords.get(dfaRecords.size() - 1);

                System.out.print("Delivery or Pickup: ");
                String method = input.nextLine();

                System.out.print("Release Date: ");
                String date = input.nextLine();

                record.setRelease(method, date);
                record.updateStatus("Ready for Release");

                System.out.println("\nRelease details saved!");
                record.printDetails();
            }

        } while (choice != 4);
    }

    static void psa() {

        Person person = getCurrentPerson();
        if (person == null) return;

        int choice;

        do {
            PSA.printMenu();

            System.out.print("Choose: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice >= 1 && choice <= 4) {

                String document;

                switch (choice) {
                    case 1: document = "Birth Certificate"; break;
                    case 2: document = "Marriage Certificate"; break;
                    case 3: document = "Death Certificate"; break;
                    default: document = "CENOMAR"; break;
                }

                System.out.print("Requester Name: ");
                String requester = input.nextLine();

                System.out.print("Person on Document: ");
                String docPerson = input.nextLine();

                System.out.print("Purpose: ");
                String purpose = input.nextLine();

                System.out.print("Number of Copies: ");
                int copies = Integer.parseInt(input.nextLine());

                System.out.print("Delivery or Pickup: ");
                String delivery = input.nextLine();

                System.out.print("Price per Copy: ");
                double pricePerCopy = Double.parseDouble(input.nextLine());

                double price = pricePerCopy * copies;

                String reference = generateReference();

                PSA record = new PSA(document, requester, docPerson, purpose,
                        copies, delivery, price, reference);

                System.out.print("Delivery Date: ");
                String deliveryDate = input.nextLine();
                record.setDeliveryDate(deliveryDate);

                psaRecords.add(record);

                System.out.println("\nPSA request submitted!");
                record.printDetails();
            }

        } while (choice != 5);
    }

    static void printRecords() {

        System.out.println("\n===== ALL RECORDS =====");

        System.out.println("\n--- Registered People (" + people.size() + ") ---");
        for (Person p : people) {
            p.printDetails();
        }

        System.out.println("\n--- NBI Records (" + nbiRecords.size() + ") ---");
        for (NBI record : nbiRecords) {
            record.printDetails();
        }

        System.out.println("\n--- PhilHealth Records (" + philHealthRecords.size() + ") ---");
        for (PhilHealth record : philHealthRecords) {
            record.printDetails();
        }

        System.out.println("\n--- SSS Records (" + sssRecords.size() + ") ---");
        for (SSS record : sssRecords) {
            record.printDetails();
        }

        System.out.println("\n--- DFA Records (" + dfaRecords.size() + ") ---");
        for (DFA record : dfaRecords) {
            record.printDetails();
        }

        System.out.println("\n--- PSA Records (" + psaRecords.size() + ") ---");
        for (PSA record : psaRecords) {
            record.printDetails();
        }
    }
}