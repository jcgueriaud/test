package com.gmail.jeanchristophe.component;

public class Address {

    private String address;

    private MyCoordinates coordinates;

    public Address(String address, MyCoordinates coordinates) {
        this.address = address;
        this.coordinates = coordinates;
    }

    public Address(String address, double latitude, double longitude) {
        this.address = address;
        this.coordinates = new MyCoordinates(latitude, longitude);
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MyCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(MyCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}
