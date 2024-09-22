package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    Customer customer = new Customer();
    customer.setName("Max Mustermann");

    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);

    customer.getAddresses().add(address);

    Bank bank = new Bank();
    bank.setName("Pengebank");

    Pincode pincode1 = new Pincode();
    pincode1.setCode("123");
    pincode1.setCount(1);

    CreditCard card1 = new CreditCard();
    card1.setNumber(12345);
    card1.setBalance(-5000);
    card1.setCreditLimit(-10000);
    card1.setOwningBank(bank);
    card1.setPincode(pincode1);

    CreditCard card2 = new CreditCard();
    card2.setNumber(123);
    card2.setBalance(1);
    card2.setCreditLimit(2000);
    card2.setOwningBank(bank);
    card2.setPincode(pincode1); // Same pincode as card1

    customer.getCreditCards().add(card1);
    customer.getCreditCards().add(card2);

    // Persist
    em.persist(customer);
    em.persist(address);
    em.persist(bank);
    em.persist(pincode1);
    em.persist(card1);
    em.persist(card2);
  }
}
