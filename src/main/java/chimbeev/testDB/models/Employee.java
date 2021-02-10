package chimbeev.testDB.models;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Employee {
    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;
    @NotEmpty(message = "Email shouldnt be empty")
    @Email(message = "Email should be valid")
    private String email;
    private String lastName, gender, country;
    @Pattern(regexp = "\\d{4}[-]\\d{2}[-]\\d{2}", message = "Date should follow pattern yyyy-mm-dd")
    private String dateOfBirth;

    public Employee(int id, String name, String lastName, String gender, String email, String dateOfBirth, String country) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
    }
    public Employee() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Employee " + getId() + " name: " + getName()  + " last name: " + getLastName() +
                "gender: " + getGender() + "email: " + getEmail() + "date of birth: " + getDateOfBirth()
                + "country :" + getCountry();
    }
}
