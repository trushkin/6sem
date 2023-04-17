package by.bsuir.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers5")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "zipcode")
    private Integer zipCode;
    @Column(name = "email")
    private String email;

    public Customer() {
    }

    public Customer(Long id, String name, String surname, Integer zipCode, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.zipCode = zipCode;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", zipCode=" + zipCode +
                ", email='" + email + '\'' +
                '}';
    }
}
