package Utilities;

import java.util.Random;

public class FakeUtility {
	
	public static int randomNumberGenerator() {
		Random random = new Random();                // java cls - Random's obj
		int randomNumber = random.nextInt(10000);    // random int nums in btw 10000
		return randomNumber;
	}
}
