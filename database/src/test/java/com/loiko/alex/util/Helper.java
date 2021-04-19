package com.loiko.alex.util;

import com.loiko.alex.brand.Brand;
import com.loiko.alex.carbody.CarBody;
import com.loiko.alex.country.Country;
import com.loiko.alex.engine.EngineType;
import com.loiko.alex.model.CarModel;
import com.loiko.alex.model.Model;
import com.loiko.alex.order.Order;
import com.loiko.alex.paymentform.PaymentForm;
import com.loiko.alex.producer.Producer;
import com.loiko.alex.sparepart.SparePart;
import com.loiko.alex.user.Admin;
import com.loiko.alex.user.Client;
import com.loiko.alex.user.User;
import com.loiko.alex.user.role.AdminRole;
import com.loiko.alex.user.role.ClientRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;

@Component
public class Helper {

    private final EntityManagerFactory managerFactory;

    @Autowired
    public Helper(EntityManagerFactory managerFactory) {
        this.managerFactory = managerFactory;
    }

    public void cleanDataBase() {
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        entityManager.createQuery("delete from Order").executeUpdate();
        entityManager.createQuery("delete from SparePart").executeUpdate();
        entityManager.createQuery("delete from Model").executeUpdate();
        entityManager.createQuery("delete from Producer").executeUpdate();
        entityManager.createQuery("delete from Admin").executeUpdate();
        entityManager.createQuery("delete from Client").executeUpdate();
        entityManager.createQuery("delete from User").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void insertingData() {
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        User kimi = Client.builder().email("kimikimi@gmail.com").login("Iceman").password("kimi").role(ClientRole.ORDINARY_CLIENT).build();
        User fernando = Client.builder().email("fern@gmail.com").login("Fernando").password("fernando").role(ClientRole.ORDINARY_CLIENT).build();
        User michael = Client.builder().email("micha@gmail.com").login("Red baron").password("Michael").role(ClientRole.VIP_CLIENT).build();
//        User kimi = new Client("Iceman", "kimi", "kimikimi@gmail.com", ClientRole.ORDINARY_CLIENT);
//        User fernando = new Client("Fernando", "fernando", "fern@gmail.com", ClientRole.ORDINARY_CLIENT);
//        User michael = new Client("Red baron", "Michael", "micha@gmail.com", ClientRole.VIP_CLIENT);
        entityManager.persist(kimi);
        entityManager.persist(fernando);
        entityManager.persist(michael);

        User ayrton = Admin.builder().email("ayr@gmail.com").login("Ayrton").password("ayrton").salary(500.00).adminRole(AdminRole.MAIN_ADMIN).build();
        User niki = Admin.builder().email("rat@gmail.com").login("Rat").password("niki").salary(350.5).adminRole(AdminRole.ADMIN).build();
        User james = Admin.builder().email("jamy@gmail.com").login("James").password("james").salary(450.0).adminRole(AdminRole.ADMIN).build();
//        User ayrton = new Admin(, "Ayrton", "ayrton", "ayr@gmail.com", AdminRole.MAIN_ADMIN);
        entityManager.persist(ayrton);
        entityManager.persist(niki);
        entityManager.persist(james);

        Producer amc = Producer.builder().producerName("AMC").country(Country.JAPAN).build();
        Producer airBlade = Producer.builder().producerName("Air Blade").country(Country.GERMANY).build();
        Producer ramsey = Producer.builder().producerName("Ramsey").country(Country.FRANCE).build();
        entityManager.persist(amc);
        entityManager.persist(airBlade);
        entityManager.persist(ramsey);

        CarModel mustang = CarModel.builder().brand(Brand.FORD).model("Mustang").build();
        Model fordMustang = Model.builder().carModel(mustang).carBody(CarBody.COUPE).engineType(EngineType.PETROL).build();
        CarModel c2 = CarModel.builder().brand(Brand.CITROEN).model("C2 VTR").build();
        Model citroenC2 = Model.builder().carModel(c2).carBody(CarBody.HATCHBACK).engineType(EngineType.PETROL).build();
        CarModel caravan = CarModel.builder().brand(Brand.DODGE).model("Caravan").build();
        Model dodgeCaravan = Model.builder().carModel(caravan).carBody(CarBody.MINIVAN).engineType(EngineType.DIESEL).build();
        entityManager.persist(fordMustang);
        entityManager.persist(citroenC2);
        entityManager.persist(dodgeCaravan);

        SparePart engine = SparePart.builder().sparePartName("Engine 1.6").vendorCode("DGVX213").producer(amc).price(324.21).build();
        SparePart wheel = SparePart.builder().sparePartName("Wheel 25\"").vendorCode("DHCBJ267").producer(airBlade).price(78.08).build();
        SparePart light = SparePart.builder().sparePartName("Light").vendorCode("HCJBCB32").producer(ramsey).price(15.86).build();
        entityManager.persist(engine);
        entityManager.persist(wheel);
        entityManager.persist(light);

        Order firstOrder = Order.builder().client(kimi).date(LocalDate.of(2021, 04, 15)).paymentForm(PaymentForm.CASH).build();
        Order secondOrder = Order.builder().client(michael).date(LocalDate.of(2021, 03, 27)).paymentForm(PaymentForm.CARD).build();
        Order thirdOrder = Order.builder().client(niki).date(LocalDate.of(2021, 02, 20)).paymentForm(PaymentForm.ONLINE).build();
        entityManager.persist(firstOrder);
        entityManager.persist(secondOrder);
        entityManager.persist(thirdOrder);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}