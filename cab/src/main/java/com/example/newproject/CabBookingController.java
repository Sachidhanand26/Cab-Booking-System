package com.example.newproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CabBookingController {
    @Autowired
    private CabBookingRepository cabBookingRepository;

    @GetMapping("/bookings")
    public List<CabBooking> getBookings() {
        return cabBookingRepository.findAll();
    }

    @PostMapping("/addBooking")
    public CabBooking addBooking(@RequestParam String name, @RequestParam String pickupLocation, @RequestParam String destination) {
        CabBooking booking = new CabBooking();
        booking.setName(name);
        booking.setPickupLocation(pickupLocation);
        booking.setDestination(destination);
        return cabBookingRepository.save(booking);
    }
}

