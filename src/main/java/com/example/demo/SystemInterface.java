package com.example.demo;

import java.util.ArrayList;

import Exceptions.NotEnoughtInStockException;
import Exceptions.ProductNotFoundException;
import Exceptions.SaleNotFoundException;

public interface SystemInterface {
	public void addProduct (Produto newProduct, int amount);
	
	public SalesReceipt generateSalesReceipt(ArrayList<Sale> sales) throws NotEnoughtInStockException, ProductNotFoundException; 
	public SalesReceipt generateSalesReceipt(FinalSale productSales) throws NotEnoughtInStockException, ProductNotFoundException;	
	public FinalSale generateSale(ArrayList<Sale> sales) throws NotEnoughtInStockException, ProductNotFoundException;
	public String printStock() ;
	public void addProductSaleOnASale(Long id, Sale sale) throws ProductNotFoundException, SaleNotFoundException;
	public void updatePrice(int cod, Double newPrice);
	public Iterable<FinalSale> getSales();
}
