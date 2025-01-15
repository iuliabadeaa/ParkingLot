package com.parking.parkinglot;

import com.parking.parkinglot.common.UserDto;
import com.parking.parkinglot.ejb.CarsBean;
import com.parking.parkinglot.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddCar", value = "/AddCar")

public class AddCar extends HttpServlet {
    @Inject
    UsersBean usersBean;
    @Inject
    CarsBean carsBean;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List< UserDto> list =usersBean.findAllUserss();
        request.setAttribute("users", list);
        request.getRequestDispatcher("/WEB-INF/pages/addcar.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String licensePlate=request.getParameter("license_plate");
        String parkingSpot=request.getParameter("parking_spot");
        Long userId=Long.parseLong(request.getParameter("owner"));

        carsBean.createCar(licensePlate,parkingSpot,userId);
    }
}
