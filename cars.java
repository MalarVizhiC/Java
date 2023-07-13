package Arrays;

// Access the 3 character in the string

public class cars {

	public static void main(String[] args) {
		String[] cars = { "bMW", "Audi", "City", "Skoda" };
		for (int i = 0; i < cars.length; i++) {
			System.out.println(cars[i].charAt(2));
		}

	}

}
