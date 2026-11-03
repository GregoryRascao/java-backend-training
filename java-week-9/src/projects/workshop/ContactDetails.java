public class ContactDetails {
    String email;
    String city;

    public ContactDetails(String email, String city) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be blank");
        }
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City cannot be blank");
        }

        this.email = email.trim();
        this.city = city.trim();
    }

    public String getEmail() {
        return email;
    }

    public String getCity()  {
        return city;
    }
}
