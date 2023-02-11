public class Task08{
	public static void main (String[] args) {
		//float x = Float.parseFloat(args[0]);
		//float y = Float.parseFloat(args[1]);

		
		for(double y = 10; y >= -10; y -= 0.21) {
			for(double x = -10; x <= 10; x += 0.12) {
				if(x <= 0 && x*x + (y - 2)*(y - 2) > 4 && x*x + y*y < 16 || x*x + (y + 2)*(y + 2) < 4) {
		   			if (!(x*x + (y + 2)*(y + 2) < 1)) {
		   				System.out.print(1);
		   			} else {
		   				System.out.print(0);
		   			}
				} else if (x*x + y*y < 16) {
    				if ((x*x + (y - 2)*(y - 2) < 1)) {
		   				System.out.print(1);
		   			} else {
		   				System.out.print(0);
		   			}
				} else {
					System.out.print(" ");
				}
	    		

			}

			System.out.println();

		}
	}
}