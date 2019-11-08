package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.controller.HibernateOGMUtil;
import com.model.Products;

public class ProductsDao {
	private EntityManagerFactory emf;
	public void create(Products p) {
		emf=HibernateOGMUtil.getEntityManagerFactory();
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	public List<Products> findAll() {
		emf= HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = emf.createEntityManager();

		List<Products> products = em.createQuery("select s from Products s", Products.class).getResultList();

		return products;
	}
	public void delete(int id) {
		emf = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(em.find(Products.class, id));
		
		em.getTransaction().commit();
	}
	public Products update(int id, String name,double price,int quantity,String desc) {
		emf=HibernateOGMUtil.getEntityManagerFactory();
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Products p=em.find(Products.class, id);
		p.setName(name);
		p.setPrice(price);
		p.setQuantity(quantity);
		p.setDesc(desc);
		em.getTransaction().commit();
		return p;
	}
}
