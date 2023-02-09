package com.javarush;

import com.javarush.dao.*;
import com.javarush.entity.*;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Main {
    private final ActorDao actorDao;
    private final AddressDao addressDao;
    private final CategoryDao categoryDao;
    private final CityDao cityDao;
    private final CountryDao countryDao;
    private final CustomerDao customerDao;
    private final FeatureDao featureDao;
    private final FilmDao filmDao;
    private final FilmTextDau filmTextDau;
    private final InventoryDao inventoryDao;
    private final LanguageDao languageDao;
    private final PaymentDao paymentDao;
    private final RentalDao rentalDao;
    private final StaffDao staffDao;
    private final StoreDao storeDao ;

    SessionFactory sessionFactory = new PropertiesSessionFactoryProviderImpl().getSessionFactory();

    Main() {
        this.actorDao = new ActorDao(sessionFactory);
        this.addressDao = new AddressDao(sessionFactory);
        this.cityDao = new CityDao(sessionFactory);
        this.categoryDao = new CategoryDao(sessionFactory);
        this.countryDao = new CountryDao(sessionFactory);
        this.customerDao = new CustomerDao(sessionFactory);
        this.featureDao = new FeatureDao(sessionFactory);
        this.filmDao = new FilmDao(sessionFactory);
        this.filmTextDau = new FilmTextDau(sessionFactory);
        this.inventoryDao = new InventoryDao(sessionFactory);
        this.languageDao = new LanguageDao(sessionFactory);
        this.paymentDao = new PaymentDao(sessionFactory);
        this.rentalDao = new RentalDao(sessionFactory);
        this.staffDao = new StaffDao(sessionFactory);
        this.storeDao = new StoreDao(sessionFactory);

    }

    public static void main(String[] args) {
        Main main = new Main();
        Customer customer = main.createCustomer();
        }

        private Customer createCustomer() {
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();

                List<Store> list = storeDao.getItems(0, 1);
                Store store = storeDao.getItems(0, 1).get(0);
                City city = cityDao.getByName("Dallas");

                Address address = new Address();
                address.setAddress("4997 Nash Street");
                address.setPhone("214-204-7576");
                address.setCityId(city);
                address.setDistrict("TX");
                addressDao.save(address);

                Customer customer = new Customer();
                customer.setStore(store);
                customer.setAddress(address);
                customer.setFirstNam("Bob");
                customer.setLastName("Sponge");
                customer.setEmail("spongeBob@gmail.com");
                customer.setIsActive(true);

                transaction.commit();
                return customer;
            }
        }

        private void customerReturnInventoryToStore() {
            try (Session session = sessionFactory.getCurrentSession()) {
                session.beginTransaction();

                Rental rental = rentalDao.getAnyUnreturnedRental();
                rental.setRentalDate(LocalDateTime.now());

                rentalDao.save(rental);

                session.getTransaction().commit();
            }
        }
}