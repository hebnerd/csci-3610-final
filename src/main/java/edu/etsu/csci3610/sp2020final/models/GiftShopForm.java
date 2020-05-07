package edu.etsu.csci3610.sp2020final.models;

import javax.validation.constraints.NotNull;

public class GiftShopForm {
    private int gecko;
    private int toad;
    private int beardedDragon;
    private int frog;
    private int poisonFrog;
    private int bobsLizardShackShirt;
    private int lacysReptileShackShirt;
    private int bumperSticker;
    @NotNull
    private String name;
    @NotNull
    private String creditCardNumber;
    @NotNull
    private String securityCode;
    @NotNull
    private String creditCardExpirationDate;
    @NotNull
    private String streetAddress;
    @NotNull
    private String zipCode;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @NotNull
    private int totalCost;

    private String discountCode;

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public int getGecko() {
        return gecko;
    }

    public void setGecko(int gecko) {
        this.gecko = gecko;
    }

    public int getToad() {
        return toad;
    }

    public void setToad(int toad) {
        this.toad = toad;
    }

    public int getBeardedDragon() {
        return beardedDragon;
    }

    public void setBeardedDragon(int beardedDragon) {
        this.beardedDragon = beardedDragon;
    }

    public int getFrog() {
        return frog;
    }

    public void setFrog(int frog) {
        this.frog = frog;
    }

    public int getPoisonFrog() {
        return poisonFrog;
    }

    public void setPoisonFrog(int poisonFrog) {
        this.poisonFrog = poisonFrog;
    }

    public int getBobsLizardShackShirt() {
        return bobsLizardShackShirt;
    }

    public void setBobsLizardShackShirt(int bobsLizardShackShirt) {
        this.bobsLizardShackShirt = bobsLizardShackShirt;
    }

    public int getLacysReptileShackShirt() {
        return lacysReptileShackShirt;
    }

    public void setLacysReptileShackShirt(int lacysReptileShackShirt) {
        this.lacysReptileShackShirt = lacysReptileShackShirt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getCreditCardExpirationDate() {
        return creditCardExpirationDate;
    }

    public void setCreditCardExpirationDate(String creditCardExperiationDate) {
        this.creditCardExpirationDate = creditCardExperiationDate;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public int getBumperSticker() {
        return bumperSticker;
    }

    public void setBumperSticker(int bumperSticker) {
        this.bumperSticker = bumperSticker;
    }

}
