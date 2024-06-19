package Project.BusTicketBooking.Application.Service;


import Project.BusTicketBooking.Application.Model.Booking;
import Project.BusTicketBooking.Application.Model.PassengerDetail;
import Project.BusTicketBooking.Application.Model.Passengers;
import Project.BusTicketBooking.Application.Repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    //Method to save ticket Booking
    public Booking saveBooking(Booking booking){
        return bookingRepo.save(booking);
    }

    //Method to show All Bookings
    public List<Booking> getAllBookings(){
        return bookingRepo.findAll();
    }

    //Method to findBy BookingId
    public Booking getByBookingId(int bookingId){
        return bookingRepo.findByBookingId(bookingId).orElse(null);
    }

    //Method to get their ticket by credential
    public List<Booking> getBookingByPassenger(Passengers passengers){
        return bookingRepo.findByPassengers(passengers);
    }

    // Method to save booking details with multiple passengers
    public Booking saveBookingWithPassengerDetails(Booking booking, List<PassengerDetail> passengerDetails) {
        for (PassengerDetail detail : passengerDetails) {
            detail.setBooking(booking);
        }
        booking.setPassengerDetails(passengerDetails);
        return bookingRepo.save(booking);
    }

}









