package com.parking.parkinglot.ejb;

import com.parking.parkinglot.entities.Car;
import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless

public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;

    public List<CarDto> findAllCars(){
        LOG.info("Find all cars");
        try{
            TypedQuery<Car> typedQuery=entityManager.createQuery("SELECT c FROM Car c", Car.class);
            List<Car> cars=typedQuery.getResultList();
            return copyCarsToDto(cars);
        } catch (Exception ex){
            throw new EJBException(ex);
        }
    }

    private List<CarDto> copyCarsToDto(List<Car> list){
        List<CarDto> dtos=new ArrayList<>();
        for(Car car : list){
            CarDto c=new CarDto(car.getId(),car.getLicensePlate(), car.getParkingSpot(), car.getOwner().getUsername(), car.getData());
            dtos.add(c);
        }
        return dtos;
    }

    public void createCar(String licensePlate, String parkingSpot, Long userId){
        LOG.info("Create car");
        Car car=new Car();
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);
        User user=new User();
        car.setOwner(user);

        entityManager.persist(car);
    }
}
