package com.parking.parkinglot.common;

public class CarDto {
    Long id;
    String licensePlate;
    String parkingSpot;
    String ownerName;
    String data;
    public CarDto(Long id, String licensePlate, String parkingSpot, String ownerName, String data) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.parkingSpot = parkingSpot;
        this.ownerName = ownerName;
        this.data = data;
    }
    public Long getId() {
        return id;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public String getParkingSpot() {
        return parkingSpot;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public String getData() { return data; }
}
