package com.example.servicioswebs.model;

public class Usuario {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String dateOfBirth;
    private String country;
    private String city;
    private String address;
    private double annualIncome;
    private int creditScore;
    private boolean hasUnpaidDebt;
    private double unpaidDebtAmount;
    private String status;

    public Usuario() {
    }

    public Usuario(int id,
                   String firstName,
                   String lastName,
                   String email,
                   String phone,
                   String dateOfBirth,
                   String country,
                   String city,
                   String address,
                   double annualIncome,
                   int creditScore,
                   boolean hasUnpaidDebt,
                   double unpaidDebtAmount,
                   String status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.city = city;
        this.address = address;
        this.annualIncome = annualIncome;
        this.creditScore = creditScore;
        this.hasUnpaidDebt = hasUnpaidDebt;
        this.unpaidDebtAmount = unpaidDebtAmount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public boolean getHasUnpaidDebt() {
        return hasUnpaidDebt;
    }

    public void setHasUnpaidDebt(boolean hasUnpaidDebt) {
        this.hasUnpaidDebt = hasUnpaidDebt;
    }

    public double getUnpaidDebtAmount() {
        return unpaidDebtAmount;
    }

    public void setUnpaidDebtAmount(double unpaidDebtAmount) {
        this.unpaidDebtAmount = unpaidDebtAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
