package main;

import main.java.config.HibernateUtil;
import main.java.service.ProductService;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        System.out.println("It is running!");
        ProductService ps = new ProductService();
        ps.addProduct("Suzuki");
    }
}
