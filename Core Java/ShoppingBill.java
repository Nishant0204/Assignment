package gen.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

class Product {

	private String id;
	private String pname;
	private int qty;
	private double price;
	private double totalPrice;

	Product(String id, String pname, int qty, double price, double totalPrice) {
		this.id = id;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.totalPrice = totalPrice;
	}

	public String getId() {
		return id;
	}

	public String getPname() {
		return pname;
	}

	public int getQty() {
		return qty;
	}

	public double getPrice() {
		return price;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public static void displayFormat() {
		System.out.format(
				"-----------------------------------------------------------------------------------------------------------------------------------");
		System.out.print("\nProduct ID \t\tName\t\tQuantity\t\tRate \t\t\t\tTotal Price\n");
		System.out.format(
				"-----------------------------------------------------------------------------------------------------------------------------------\n");
	}

	public void display() {
		System.out.format("   %-9s             %-9s      %5d               %9.2f                       %14.2f\n", id,
				pname, qty, price, totalPrice);
	}
}

public class ShoppingBill {
	public static void main(String args[]) {

		String id = null;
		String productName = null;
		int quantity = 0;
		double price = 0.0;
		double totalPrice = 0.0;
		double overAllPrice = 0.0;
		double cgst, sgst, subtotal = 0.0, discount = 0.0;
		char choice = '\0';
		System.out.println("\t\t\t\t--------------------Invoice-----------------");
		System.out.println("\t\t\t\t\t " + "  " + "Metro Mart Grocery Shop");
		System.out.println("\t\t\t\t\t3/98 Mecrobertganj New Mumbai");
		System.out.println("\t\t\t\t\t" + "    " + "Opposite Metro Walk");
		System.out.println("GSTIN: 03AWBPP8756K592" + "\t\t\t\t\t\t\tContact: (+91) 9988776655");

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		System.out.println("Date: " + formatter.format(date) + "  " + days[calendar.get(Calendar.DAY_OF_WEEK) - 1]
				+ "\t\t\t\t\t\t (+91) 9998887770");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Customer Name: ");
		String customername = scan.nextLine();

		List<Product> product = new ArrayList<Product>();
		do {

			System.out.println("Enter the product details: ");
			System.out.print("Product ID: ");
			id = scan.nextLine();
			System.out.print("Product Name: ");
			productName = scan.nextLine();
			System.out.print("Quantity: ");
			quantity = scan.nextInt();
			System.out.print("Price (per unit): ");
			price = scan.nextDouble();

			totalPrice = price * quantity;

			overAllPrice = overAllPrice + totalPrice;

			product.add(new Product(id, productName, quantity, price, totalPrice));

			System.out.print("Want to add more items? (y or n): ");

			choice = scan.next().charAt(0);

			scan.nextLine();
		} while (choice == 'y' || choice == 'Y');

		Product.displayFormat();
		for (Product p : product) {
			p.display();
		}

		System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal Amount (Rs.) " + overAllPrice);

		discount = overAllPrice * 2 / 100;
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t    Discount (Rs.) " + discount);

		subtotal = overAllPrice - discount;
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t          Subtotal " + subtotal);

		sgst = overAllPrice * 12 / 100;
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t          SGST (%) " + sgst);
		cgst = overAllPrice * 12 / 100;
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t          CGST (%) " + cgst);

		System.out.println("\n\t\t\t\t\t\t\t\t\t\t     Invoice Total " + (subtotal + cgst + sgst));
		System.out.println("\t\t\t\t----------------Thank You for Shopping!!-----------------");
		System.out.println("\t\t\t\t                     Visit Again");

		scan.close();
	}
}