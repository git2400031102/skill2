package com.inventory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        // 1️⃣ CREATE (Insert)
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p1 = new Product("Laptop", "HP Laptop", 55000, 5);
        Product p2 = new Product("Mouse", "Wireless Mouse", 500, 20);

        session.save(p1);
        session.save(p2);

        tx.commit();
        session.close();

        System.out.println("Products inserted");

        // 2️⃣ READ (Get by ID)
        session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, 1);
        System.out.println("Fetched product: " + product.getName());
        session.close();

        // 3️⃣ UPDATE (Price change)
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        product = session.get(Product.class, 1);
        product.setPrice(52000);

        tx.commit();
        session.close();
        System.out.println("Product updated");

        // 4️⃣ DELETE
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        product = session.get(Product.class, 2);
        session.delete(product);

        tx.commit();
        session.close();
        System.out.println("Product deleted");
    }
}