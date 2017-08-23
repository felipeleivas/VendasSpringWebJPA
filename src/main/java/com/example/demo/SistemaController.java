package com.example.demo;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import Exceptions.NotEnoughtInStockException;
import Exceptions.ProductNotFoundException;
import Exceptions.SaleNotFoundException;

@RestController
public class SistemaController {
	
	SystemInterface systemMng;
	
	@Autowired
	public SistemaController( SystemInterface sisMg) {
		this.systemMng = sisMg;
	}
	//localhost:8080/show-storage
	@GetMapping("/show-storage")
	public	String showStorage() {
		return this.systemMng.printStock();
	}
	
	@PatchMapping("update-price/{id}")
	public ResponseEntity<Produto>  updatePrice(@PathVariable("id") int id, Double newPrice){
		this.systemMng.updatePrice(id, newPrice);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	//localhost:8080/add-product
	@RequestMapping("/add-product")
	public ResponseEntity<Produto> addProduct(int cod, String name, Double price, int amount){
		this.systemMng.addProduct(new Produto(name, cod, price),amount);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping("/sell-product2")
	public SalesReceipt sellProduct2(int cod, int amount) {		
		Sale sale = new Sale(cod,amount);
		ArrayList<Sale> sales = new ArrayList<>();
		sales.add(sale);		
				
		try {
			SalesReceipt rec = systemMng.generateSalesReceipt(sales);
			return rec;
		} catch (NotEnoughtInStockException | ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/sell-product")
	public String sellProduct(int cod, int amount) {		
		Sale sale = new Sale(cod,amount);
		ArrayList<Sale> sales = new ArrayList<>();
		sales.add(sale);		
				
		try {
			SalesReceipt rec = systemMng.generateSalesReceipt(sales);
			return rec.toString();
		} catch (NotEnoughtInStockException | ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERRO";
		}
	}
	
	@PutMapping("/addProduct/{saleID}")
	public ResponseEntity<Produto>  addProductSale(@PathVariable("saleID") Long id, int prodCod, int amount){
		try {
			this.systemMng.addProductSaleOnASale(id, new Sale(prodCod, amount));
			return new ResponseEntity<>(HttpStatus.OK);
		} 
		catch (ProductNotFoundException  | SaleNotFoundException e2) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}			
	}
	
	@GetMapping("/showsales")
	public Iterable<FinalSale> showSales(){
		return this.systemMng.getSales();
	}
}
