package pe.edu.upc.vpg04.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dni", length = 8, nullable = false)
    private String dni;
    @Column(name = "username",length = 20, nullable = false)
    private String username;
    @Column(name = "lastname",length = 20, nullable = false)
    private String lastname;
    @Column(name = "email",length = 20, nullable = false)
    private String email;
    @Column(name = "password",length = 200, nullable = false)
    private String password;
    @Column(name = "birthdate",nullable = false)
    private LocalDate birthdate;
    @Column(name = "address",length = 100, nullable = false)
    private String address;
    private Boolean enabled;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private List<Role> roles;

    public Users() {
    }

    public Users(int id, String dni, String username, String lastname, String email, String password, LocalDate birthdate, String address, Boolean enabled, List<Role> roles) {
        this.id = id;
        this.dni = dni;
        this.username = username;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.address = address;
        this.enabled = enabled;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
