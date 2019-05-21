package ps.pl.gc.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Employee {

    @Id
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    @NotNull
    @Size(min = 3, max = 60)
    private String email;

    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    @NotNull
    @Size(min = 2, max = 100)
    private String username;

    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    @NotNull
    @Size(min = 2, max = 100)
    private String firstName;

    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    @NotNull
    @Size(min = 2, max = 100)
    private String lastName;

    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    @NotNull
    @Size(min = 1, max = 1)
    private String shortGender;

    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    @NotNull
    @Size(min = 2, max = 20)
    private String gender;

    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    @NotNull
    @Size(min = 2, max = 100)
    private String street;

    @Basic(optional = false)
    @Column(nullable = false, length = 5)
    @NotNull
    @Size(min = 1, max = 5)
    private String streetNumber;

    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    @NotNull
    @Size(min = 2, max = 100)
    private String city;

    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    @NotNull
    @Size(min = 2, max = 100)
    private String company;

    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    @NotNull
    @Size(min = 2, max = 100)
    private String ipAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getShortGender() {
        return shortGender;
    }

    public void setShortGender(String shortGender) {
        this.shortGender = shortGender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", shortGender='" + shortGender + '\'' +
                ", gender='" + gender + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", city='" + city + '\'' +
                ", company='" + company + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
