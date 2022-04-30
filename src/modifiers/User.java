package modifiers;

/*
    GETTING THE FULL NAME
    Here is the User class with two fields: firstName and lastName.

    Implement two null-safety setters and one calculated getter in the following ways:

    both setters should accept and set a value if it is not null or an empty string "";
    the getter should return the full name of the user by concatenating firstName and lastName using a single space between them. If one of the parts was not set, the getter should return another part without additional spaces. If both parts are empty, the getter should return the word "Unknown".

    There are two examples below:
 */

import java.nio.charset.StandardCharsets;

public class User {

    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName != null && !"".equals(firstName) ? firstName : this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName != null && !"".equals(lastName) ? lastName : this.lastName;
    }

    public String getFullName() {
        String result;

        if ("".equals(this.firstName) && "".equals(this.lastName)) {
            result = "Unknown";
        } else if ("".equals(this.firstName)) {
            result = this.lastName;
        } else if ("".equals(this.lastName)) {
            result = this.firstName;
        } else {
            result = String.format("%s %s", this.firstName, this.lastName);
        }
        return result;
    }


}
