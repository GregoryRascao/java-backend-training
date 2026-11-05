package main.java.service;

import main.java.config.HibernateUtil;
import main.java.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductService {

    public void addProduct(String brandName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product product = new Product();
        product.setBrand(brandName);

        session.persist(product);

        tx.commit();
        //session.close();

        System.out.println("Product saved!");
    }
}
