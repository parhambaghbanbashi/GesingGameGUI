
import java.util.Random;
public class RandomGenerator {


	public static int RandomInt(int min, int max) {
	    Random r = new Random();
	    return r.nextInt((max - min) + 1) + min;
	}

	
	
}