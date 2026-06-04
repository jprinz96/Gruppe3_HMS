package at.fhburgenland;

import at.fhburgenland.entity.*;
import at.fhburgenland.enums.RoomCategory;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Gruppe3_HMS");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Zimmer-ID: ");
        String roomId = scanner.nextLine();

        System.out.print("Zimmernummer: ");
        int roomNumber = Integer.parseInt(scanner.nextLine());

        System.out.print("Kategorie (Standard, Deluxe oder Suite): ");
        RoomCategory category = RoomCategory.fromString(scanner.nextLine());

        System.out.print("Preis pro Nacht: ");
        BigDecimal price = new BigDecimal(scanner.nextLine().replace(',', '.'));

        Room room = new Room(roomId, roomNumber, category, price);

        em.getTransaction().begin();
        em.persist(room);
        em.getTransaction().commit();

        System.out.println("Zimmer gespeichert: " + room.getRoomId());
        List<Room> rooms = em.createQuery("SELECT r FROM Room r", Room.class).getResultList();
        for (Room r : rooms) {
            System.out.println(r);
        }

    }


}

//Tests
        /*
        try {
            em.getTransaction().begin();

            Zip zip = em.find(Zip.class, "12345");

            if (zip == null) {
                zip = new Zip("12345", "Velaris");
                em.persist(zip);
            }

            Guest guest = new Guest(
                    "Feyre",
                    "Acheron",
                    LocalDate.of(1990, 5, 15),
                    "feyreLovesRhys@mail.com",
                    null,
                    "Starstreet",
                    "1",
                    zip
            );

            em.persist(guest);
            em.getTransaction().commit();


        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            e.printStackTrace();
        }

        List<Guest> guests = em.createQuery("select g from Guest g", Guest.class).getResultList();
        for (Guest g : guests) {
            System.out.println(g);
        }
          List<Event> events = em.createQuery("select e from Event e", Event.class).getResultList();
        for (Event e : events) {
            System.out.println(e);
        }
         em.getTransaction().begin();
        Room room = new Room("R401", 401, RoomCategory.Standard, new BigDecimal(90.5));
        em.persist(room);
        em.getTransaction().commit();

       List<Room> rooms = em.createQuery("SELECT r FROM Room r", Room.class).getResultList();
        for (Room r : rooms) {
            System.out.println(r);

        }
        */
