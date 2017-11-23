import java.util.Objects;

@SuppressWarnings("WeakerAccess")
public class Contact {
    private boolean asObject = false;
    private String firstName;
    private String lastName;
    private String email;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contact asObject() {
        asObject = !asObject;
        return this;
    }


    @Override
    public String toString() {
        if (asObject) {
            asObject();
            return super.toString();
        }
        return String.format("%-15s%-20s%s", firstName, lastName, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contact && !asObject)
            return Objects.equals(this.getFirstName(), ((Contact) obj).getFirstName()) &&
                    Objects.equals(this.getLastName(), ((Contact) obj).getLastName()) &&
                    Objects.equals(this.getEmail(), ((Contact) obj).getEmail());
        return super.equals(obj);
    }
}
