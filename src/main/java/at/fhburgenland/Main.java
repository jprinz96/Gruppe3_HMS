package at.fhburgenland;

import at.fhburgenland.entity.*;
import jakarta.persistence.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Gruppe3_HMS");
        EntityManager em = emf.createEntityManager();

        printZips(em);
        printGuests(em);
        printRooms(em);
        printReservations(em);

        em.close();
        emf.close();
    }

    private static void printZips(EntityManager em) {
        System.out.println("\n--- ZIP ---");

        List<Zip> zips = em.createQuery("select z from Zip z", Zip.class)
                .getResultList();

        for (Zip zip : zips) {
            System.out.println(zip.getZipcode() + " - " + zip.getCity());
        }
    }

    private static void printGuests(EntityManager em) {
        System.out.println("\n--- GUEST ---");

        List<Guest> guests = em.createQuery("select g from Guest g", Guest.class)
                .getResultList();

        for (Guest guest : guests) {
            System.out.println(
                    guest.getGuestId() + " - " +
                            guest.getFirstname() + " " +
                            guest.getLastname() + " - " +
                            guest.getEmail() + " - " +
                            guest.getZip().getZipcode() + " " +
                            guest.getZip().getCity()
            );
        }
    }

    private static void printRooms(EntityManager em) {
        System.out.println("\n--- ROOM ---");

        List<Room> rooms = em.createQuery("select r from Room r", Room.class)
                .getResultList();

        for (Room room : rooms) {
            System.out.println(
                    room.getRoomId() + " - Zimmer " +
                            room.getRoomNumber() + " - " +
                            room.getCategory() + " - " +
                            room.getPricePerNightEur() + " EUR"
            );
        }
    }

    private static void printReservations(EntityManager em) {
        System.out.println("\n--- RESERVATION ---");

        List<Reservation> reservations = em.createQuery("select r from Reservation r", Reservation.class)
                .getResultList();

        for (Reservation reservation : reservations) {
            System.out.println(
                    reservation.getReservationId() + " - " +
                            reservation.getGuest().getFirstname() + " " +
                            reservation.getGuest().getLastname() + " - " +
                            reservation.getCheckinDate() + " bis " +
                            reservation.getCheckoutDate() + " - " +
                            reservation.getStatus()
            );
        }

    }
}
