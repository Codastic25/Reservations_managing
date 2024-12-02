public class Customer {

    private String name;
    private String phone;
    private String membershipType;

    public Customer(String name, String phone, String membershipType) {
        this.name = name;
        this.phone = phone;
        this.membershipType = membershipType; // The type of membership (e.g., Regular, Premium).
    }

    public String getName() { // customer with specific membership
        return ("Customer " + name);
    }

    public String getNumber() { // customer with specific membership
        return ("Number " + phone);
    }

    public String getMembershipType() { // customer with specific membership
        return ("Membership " + membershipType);
    }
}
