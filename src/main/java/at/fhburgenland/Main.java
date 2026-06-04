package at.fhburgenland;

import at.fhburgenland.entity.*;
import at.fhburgenland.enums.EventStatus;
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




    }


}

//Tests
        /*
//Guest
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

//Room
         em.getTransaction().begin();
        Room room = new Room("R401", 401, RoomCategory.Standard, new BigDecimal(90.5));
        em.persist(room);
        em.getTransaction().commit();

       List<Room> rooms = em.createQuery("SELECT r FROM Room r", Room.class).getResultList();
        for (Room r : rooms) {
            System.out.println(r);

        }

//Event
                System.out.print("Event titel: ");
        String title = scanner.nextLine();

        System.out.print("Event Date: ");
        LocalDate eventDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Min Participants: ");
        int  minParticipants = scanner.nextInt();
        scanner.nextLine();

        System.out.print("event status: ");
        EventStatus eventStatus = EventStatus.fromString(scanner.nextLine());

        Event event = new Event(title, eventDate, minParticipants, eventStatus);

        em.getTransaction().begin();
        em.persist(event);
        em.getTransaction().commit();

        List<Event> events = em.createQuery("SELECT e FROM Event e", Event.class).getResultList();
        for (Event e : events) {
            System.out.println(e);
        }
        */
