public class Person {

    private String lastName;
    private String firstName;
    private String middleName;
    private String suffix;
    private int age;
    private String contact;
    private String province;
    private String city;
    private String barangay;
    private String zip;
    private String sex;
    private String email;
    private String status;
    private String employmentStatus;

    public Person(String lastName, String firstName, String middleName,
                  String suffix, int age, String contact,
                  String province, String city, String barangay,
                  String zip, String sex, String email,
                  String status, String employmentStatus) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.suffix = suffix;
        this.age = age;
        this.contact = contact;
        this.province = province;
        this.city = city;
        this.barangay = barangay;
        this.zip = zip;
        this.sex = sex;
        this.email = email;
        this.status = status;
        this.employmentStatus = employmentStatus;
    }

    public String getLastName() { 
        return lastName; 
    }

    public String getFirstName() { 
        return firstName; 
    }

    public String getMiddleName() { 
        return middleName; 
    }

    public String getSuffix() { 
        return suffix; 
    }

    public int getAge() { 
        return age; 
    }

    public String getContact() { 
        return contact; 
    }

    public String getProvince() { 
        return province; 
    }

    public String getCity() { 
        return city; 
    }

    public String getBarangay() { 
        return barangay; 
    }

    public String getZip() { 
        return zip; 
    }

    public String getSex() { 
        return sex; 
    }

    public String getEmail() { 
        return email; 
    }

    public String getStatus() { 
        return status; 
    }

    public String getEmploymentStatus() { 
        return employmentStatus; 
    }

    public String getFullName() {

        String name = lastName + ", " + firstName;

        if (!middleName.equals("-")) {
            name += " " + middleName;
        }

        if (!suffix.equals("-")) {
            name += " " + suffix;
        }

        return name;
    }

    public String getAddress() {
        return barangay + ", " + city + ", " + province + " " + zip;
    }

    public void printDetails() {

        System.out.println("\n===== PERSONAL INFORMATION =====");
        System.out.println("Name: " + getFullName());
        System.out.println("Age: " + age);
        System.out.println("Contact Number: " + contact);
        System.out.println("Address: " + getAddress());
        System.out.println("Sex: " + sex);
        System.out.println("Email: " + email);
        System.out.println("Status: " + status);
        System.out.println("Employment Status: " + employmentStatus);
    }
}