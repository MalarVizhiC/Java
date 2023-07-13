package Ecommerce;

import java.util.Scanner;

public class EcommerceCli {
	SqlDBcode db;

	public EcommerceCli() {
		this.db = new SqlDBcode();
	}

	public void homeMenu() {
		System.out.println("\n************ECOMMERCE.COM*****************\n");
		System.out.println("               1. Products");
		System.out.println("               2. Orders");
		System.out.println("               3. Profile");
		System.out.println("               4. Address");
		System.out.println("               5. Cart");
		System.out.println("               0. Exit");
	}

	public void displayProductMenu() {
		System.out.println("\n'''''''''''' PRODUCT MENU '''''''''''''''''\n");
		System.out.println("               1. Get Product info");
		System.out.println("               2. List Products By Price");
		System.out.println("               3. update products");
		System.out.println("               4. Add to cart");
		System.out.println("               0. Exit");
		System.out.println("               5. Go to main menu");

	}

	public void displayOrderMenu() {
		System.out.println("\n'''''''''''' ORDER MENU '''''''''''''''''\n");
		System.out.println("               1.Recent order");
		System.out.println("               2.Query order");
		System.out.println("               3.Create order");
		System.out.println("               4.Cancel order");
		System.out.println("               5. Go to main menu");
		System.out.println("               0. Exit");

	}

	public void displayProfileMenu() {
		System.out.println("\n''''''''''' PROFILE MENU ''''''''''''''''\n");
		System.out.println("               1.View Profile");
		System.out.println("               2.Change Address");
		System.out.println("               3. Go to main menu");
		System.out.println("               0. Exit");

	}

	public void dispalyCartMenu() {
		System.out.println("\n''''''''''' CART MENU ''''''''''''''''\n");
		System.out.println("               1.view cart");
		System.out.println("               2.Delete cart");
		System.out.println("               3. Go to main menu");
		System.out.println("               0. Exit");

	}

	public void address() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name :");
		String name = sc.nextLine();
		System.out.println("Enter your House no:");
		int Hno = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your city");
		String city = sc.nextLine();
		System.out.println("your Address : \n" + name + " , " + Hno + " " + city + " " + "is saved");
		sc.close();
	}

	public void changeaddress() {
		System.out.println("placeholder change Address ");

	}

	public void listProductsByPrice() {
		System.out.println("placeholder Listing product by price");

	}

	public void offerZone() {
		System.out.println("placeholder Listing product offers");

	}

	public void addtocart() {
		System.out.println("placeholder Adding product into the cart");

	}

	public void recentOrder(int oid) {
		System.out.println("placeholder Recent orders ....");

	}

	public void createOrder() {
		System.out.println("placeholder Creating order ....");

	}

	public void cancelOrder(int oid) {
		System.out.println("placeholder Cancelling order ....");
	}

	public void saveForLater() {
		System.out.println("placeholder Save for later");

	}

	public static void main(String[] args) {
		EcommerceCli ecom = new EcommerceCli();
		Scanner sc = new Scanner(System.in);

		boolean run_mainMenu = true;
		while (run_mainMenu) {
			ecom.homeMenu();
			System.out.println("Enter Your Choice");

			if (sc.hasNextInt()) {
				int ch = sc.nextInt();

				switch (ch) {
				case 0:
					System.out.println("Thanks for visiting us");
					run_mainMenu = false;
					break;

				case 1:
					boolean run_productMenu = true;
					while (run_productMenu) {
						ecom.db.listproducts();
						ecom.displayProductMenu();
						sc = new Scanner(System.in);
						System.out.println("Enter your Product menu choice ");
						if (sc.hasNextInt()) {
							int c = sc.nextInt();
							switch (c) {
							case 0:
								System.out.println("Thanks, Exits Product menu");
								run_productMenu = false;
								break;
							case 1:
								System.out.println("Enter the product id:");
								int pid = sc.nextInt();
								ecom.db.getProductinfo(pid);
								run_productMenu = false;
								run_mainMenu = false;
								break;
							case 2:
//								ecom.listProductsByPrice();
								ecom.db.listproductsSortByPrice();
								run_productMenu = false;
								run_mainMenu = false;
								break;
							case 3:
								ecom.db.updateProducts(9, "chess", 500, 0);
								run_productMenu = false;
								run_mainMenu = false;
								break;
							case 4:
								ecom.addtocart();
								run_productMenu = false;
								run_mainMenu = false;
								break;
							case 5:
								run_productMenu = false;
								break;
							default:
								System.out.println("Enter valid input");
								sc.nextLine();
							}

						} else {
							System.out.println("Invalid product menu input");
							sc.nextLine();
						}

					}
					break;

				case 2:
					boolean run_orderMenu = true;
					while (run_orderMenu) {
						ecom.db.listorders();
						ecom.displayOrderMenu();
						sc = new Scanner(System.in);
						System.out.println("Enter your order menu choice ");
						if (sc.hasNextInt()) {
							int c = sc.nextInt();
							switch (c) {
							case 0:
								System.out.println("Thanks, Exits order menu");
								run_orderMenu = false;
								break;
							case 1:
								ecom.recentOrder(12);
								run_orderMenu = false;
								run_mainMenu = false;
								break;
							case 2:
								System.out.println("Enter orderid");
								int id = sc.nextInt();
								ecom.db.queryordersById(id);
								run_orderMenu = false;
								run_mainMenu = false;
								break;
							case 3:
								ecom.createOrder();
								run_orderMenu = false;
								run_mainMenu = false;
								break;
							case 4:
								ecom.cancelOrder(12);
								run_orderMenu = false;
								run_mainMenu = false;
								break;
							case 5:
								run_orderMenu = false;
								break;
							default:
								System.out.println("Enter valid input");
								sc.nextLine();
							}

						} else {
							System.out.println("Invalid product menu input");
							sc.nextLine();
						}
					}
					break;
				case 3:
					boolean run_profilerMenu = true;
					while (run_profilerMenu) {
						System.out.println();
						ecom.displayProfileMenu();
						sc = new Scanner(System.in);
						System.out.println("Enter your Product menu choice ");
						if (sc.hasNextInt()) {
							int c = sc.nextInt();
							switch (c) {
							case 0:
								System.out.println("Thanks, Exits profile menu");
								run_profilerMenu = false;
								break;
							case 1:
								ecom.db.viewprofile();
								run_profilerMenu = false;
								run_mainMenu = false;
								break;
							case 2:
								ecom.changeaddress();
								run_profilerMenu = false;
								run_mainMenu = false;
								break;

							case 3:
								run_profilerMenu = false;
								break;
							default:
								System.out.println("Enter valid input");
								sc.nextLine();
							}

						} else {
							System.out.println("Invalid profile menu input");
							sc.nextLine();
						}

					}
					break;
				case 4:
					ecom.address();
					run_mainMenu = false;
					break;

				case 5:
					boolean run_cartMenu = true;
					while (run_cartMenu) {

						ecom.dispalyCartMenu();
						sc = new Scanner(System.in);
						System.out.println("Enter your cart menu choice ");
						if (sc.hasNextInt()) {
							int c = sc.nextInt();
							switch (c) {
							case 0:
								System.out.println("Thanks, Exits profile menu");
								run_cartMenu = false;
								break;
							case 1:
								ecom.db.viewcart();
								run_cartMenu = false;
								run_mainMenu = false;
								break;
							case 2:
								System.out.println("Enter the id: ");
								int id = sc.nextInt();
								ecom.db.deletecart(id);
								run_cartMenu = false;
								run_mainMenu = false;
								break;

							case 3:
								run_cartMenu = false;
								break;
							default:
								System.out.println("Enter valid input");
								sc.nextLine();
							}

						} else {
							System.out.println("Invalid cart menu input");
							sc.nextLine();
						}

					}
					break;

				default:
					System.out.println("Enter the valid input");
					sc.nextLine();

				}
			}

			else {
				System.out.println("Invalid input");
				sc.nextLine();

			}

		}
		sc.close();
		System.out.println("The program completed");
	}
}
