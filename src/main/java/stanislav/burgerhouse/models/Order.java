package stanislav.burgerhouse.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private String customerName;
    private String burgerType;
    private int pattiesNumber;
    private String sauce;
    private String restaurant;
    private String friesChoice;
    private String drinkChoice;
    private int price;
    private String burgerDescription;


    // Getters and setters

    public String getBurgerDescription() {
        return burgerDescription;
    }

    public void setBurgerDescription(String burgerDescription) {
        this.burgerDescription = burgerDescription;
    }

    public String getFriesChoice() {
        return friesChoice;
    }

    public void setFriesChoice(String friesChoice) {
        this.friesChoice = friesChoice;
    }

    public String getDrinkChoice() {
        return drinkChoice;
    }

    public void setDrinkChoice(String drinkChoice) {
        this.drinkChoice = drinkChoice;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBurgerType() {
        return burgerType;
    }

    public void setBurgerType(String burgerType) {
        this.burgerType = burgerType;
    }

    public int getPattiesNumber() {
        return pattiesNumber;
    }

    public void setPattiesNumber(int pattiesNumber) {
        this.pattiesNumber = pattiesNumber;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

}
