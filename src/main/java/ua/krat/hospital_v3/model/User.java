package ua.krat.hospital_v3.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @NotEmpty(message = "First name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 in 30 characters ")
    @Column(name = "first_name")
    private String name;

    @NotEmpty(message = "Last name should not be empty")
    @Size(min = 2, max = 40, message = "Name should be between 2 in 30 characters ")
    @Column(name = "last_name")
    private String lastName;

    @Email(message = "Email is invalid")
    @NotEmpty(message = "Email should not be empty")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Password should not be empty")
    @Size(min = 3, message = " Password should be at least 3 characters")
    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;

//    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "Please use pattern XXX-XXX-XXXX")
    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToOne(mappedBy = "user",
    cascade = CascadeType.ALL)
    private Patient patient;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
