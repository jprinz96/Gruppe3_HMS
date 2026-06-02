package at.fhburgenland;

import at.fhburgenland.entity.*;
import jakarta.persistence.*;

import java.util.List;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Gruppe3_HMS");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        List<Guest> guests = em.createNativeQuery("select * from guest", Guest.class)
                .getResultList();
        for (Guest guest : guests) {
            System.out.println(guest);
        }
        em.close();
        emf.close();
    }
}
