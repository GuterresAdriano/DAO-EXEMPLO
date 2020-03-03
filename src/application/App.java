package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class App {

	public static void main(String[] args) {
		
		Seller seller = new Seller(1, "Name", "Email", new Date(), new Department(1, "dep Name"));
		
		System.out.println(seller);
		
	}
}
