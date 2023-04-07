package by.bsuir;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "city")
    private String city;

    @Column(name = "credit_limit")
    private Integer creditLimit;

    @Column(name = "main_address")
    private String mainAddress;

    @Column(name = "additional_address")
    private String additionalAddress;

    public Customer() {
    }

    public Customer(String name, String surname, String city, Integer creditLimit, String mainAddress, String additionalAddress) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.creditLimit = creditLimit;
        this.mainAddress = mainAddress;
        this.additionalAddress = additionalAddress;
    }

    public Customer(Integer id, String name, String surname, String city, Integer creditLimit, String mainAddress, String additionalAddress) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.creditLimit = creditLimit;
        this.mainAddress = mainAddress;
        this.additionalAddress = additionalAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(String mainAddress) {
        this.mainAddress = mainAddress;
    }

    public String getAdditionalAddress() {
        return additionalAddress;
    }

    public void setAdditionalAddress(String additionalAddress) {
        this.additionalAddress = additionalAddress;
    }
}
