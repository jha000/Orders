package com.example.realtimerecycleview;

public class User {

    String Product;
    String Amount;
    String Name;
    String Mobile;
    String Address;
    String Quantity;



    User ()
    {

    }
    public User(String product, String amount ,String name, String mobile, String address , String quantity) {
        this.Product = product;
        this.Amount = amount;
        this.Name = name;
        this.Mobile = mobile;
        this.Address = address;
        this.Quantity = quantity;

    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }
    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        this.Amount = amount;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity (String Quantity) {
        Quantity = Quantity;
    }
}