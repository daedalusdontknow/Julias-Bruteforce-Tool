package DualCore;

public class Core2 extends Thread {
    
    private static int min = 33 , max = 127;
    private static int Coremin = 80 , Coremax = 127;
    private static StringBuilder string = new StringBuilder("");

    @Override
    public void run(){

        while(true) {
			string.append((char) min);
		
			for(int i = 0; i < string.length() - 1; i++) {
				for(int j = Coremin; j  < Coremax; j++) {
					string.setCharAt(i, (char) j);
					loop(i + 1);
				}
			}
        }
    } 
    public static void loop(int index) {
		for(int i = min; i < max; i++) {
			string.setCharAt(index, (char) i);
			if(index < string.length() - 1)
				loop(index + 1);
				daedalus.Main.PrintLog(string.toString());
			if(string.toString().equals(daedalus.Main.password)) {
				System.err.println("password found: " + string);
                System.err.println("It took: " + daedalus.Main.convertmillis(System.currentTimeMillis() - daedalus.Main.start));
				System.exit(0);
			}
		}
	}

}
