package it.polimi.gma.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import it.polimi.gma.entities.Product;

@Stateless
public class ProductService {
	@PersistenceContext(unitName = "GMAEjb")
	private EntityManager em;

	public ProductService() {}

	public Product getProduct(String name) {
		List<Product> products = new ArrayList<>();
		try {
			products = em.createNamedQuery("Product.getProductResults", Product.class).setParameter("name", name)
					.getResultList();
		} catch (PersistenceException e) {
			throw new PersistenceException("Could not get the product");
		}
		
		if (products.isEmpty())
			return null;
		else 
			return products.get(products.size()-1);
	
	}
}
