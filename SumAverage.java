
package Arrays;

import java.util.Scanner;

public class SumAverage {

	public static void main(String[] args) {
		int n;
		float sum = 0;
		float avg;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Elements in array ");
		n = sc.nextInt();
		sc.nextLine();
		int a[] = new int[n];
		System.out.println("Enter all the Elements in array one by one \n");
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			sum = sum + a[i];
		}
		System.out.println("sum = " + sum);
		avg = (float) sum / n;
		System.out.println("avg = " + avg);
		sc.close();

	}
}
