
public class CollatzCode {

		public static void main(String[] args) {
			
			System.out.println(computeCollatz(999999));
		}
		public static int computeCollatz(int input) {
			if(input == 1) {
				return input;
			}
			if (input % 2 == 0) {
				return computeCollatz(input/2);
			} else {
				return computeCollatz(input * 3 + 1);
				}	
		}
	}


