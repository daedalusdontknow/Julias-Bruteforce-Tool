package daedalus;

public class Main {
        public static String password = "~~~";
        public static long start;

        static boolean debug = false;

        static int cores = 6; //number of cores to use 2, 3, 4, 6
        
        public static void main(String[] args) {

            System.out.println("                      __      ___                      ");
            System.out.println("                     / /_  __/ (_)___ ______           ");
            System.out.println("                __  / / / / / / / __ `/ ___/           ");
            System.out.println("               / /_/ / /_/ / / / /_/ (__  )            ");
            System.out.println("               \\____/\\__,_/_/_/\\__,_/____/             ");
            System.out.println("      ____             __       ____                   ");
            System.out.println("     / __ )_______  __/ /____  / __/___  _____________ ");
            System.out.println("    / __  / ___/ / / / __/ _ \\/ /_/ __ \\/ ___/ ___/ _ \\");
            System.out.println("   / /_/ / /  / /_/ / /_/  __/ __/ /_/ / /  / /__/  __/");
            System.out.println("  /_____/_/   \\__,_/\\__/\\___/_/  \\____/_/   \\___/\\___/ ");
            System.out.println("                 ______            __                  ");
            System.out.println("                /_  __/___  ____  / /                  ");
            System.out.println("                 / / / __ \\/ __ \\/ /                   ");
            System.out.println("                / / / /_/ / /_/ / /                    ");
            System.out.println("               /_/  \\____/\\____/_/                     ");
            System.out.println("                                                       By daedalus (PhilippG)");
            System.out.println("                                                                             ");
            

            if(args.length < 2) {
                PrintError("Usage: java -jar daedalus.jar <password> <threads(2, 3, 4, 6)> <debug(true, false)>");
                return;
            }

            password = args[0];
            cores = Integer.parseInt(args[1]);

            if(args.length > 2) {
                if(args[2].equals("true")) {
                    debug = true;
                } else {
                    debug = false;
                }
            }


            if(cores == 2)
            {      
                DualCore.Core1 core1 = new DualCore.Core1();
                DualCore.Core2 core2 = new DualCore.Core2();
    
                core1.start();
                core2.start();
            }

            else if(cores == 3)
            {      
                TripleCore.Core1 core1 = new TripleCore.Core1();
                TripleCore.Core2 core2 = new TripleCore.Core2();
                TripleCore.Core3 core3 = new TripleCore.Core3();
    
                core1.start();
                core2.start();
                core3.start();
            }

            else if(cores == 4)
            {      
                QuadCore.Core1 core1 = new QuadCore.Core1();
                QuadCore.Core2 core2 = new QuadCore.Core2();
                QuadCore.Core3 core3 = new QuadCore.Core3();
                QuadCore.Core4 core4 = new QuadCore.Core4();
    
                core1.start();
                core2.start();
                core3.start();
                core4.start();
            }

            else if(cores == 6)
            {
                HexaCore.Core1 core1 = new HexaCore.Core1();
                HexaCore.Core2 core2 = new HexaCore.Core2();
                HexaCore.Core3 core3 = new HexaCore.Core3();
                HexaCore.Core4 core4 = new HexaCore.Core4();
                HexaCore.Core5 core5 = new HexaCore.Core5();
                HexaCore.Core6 core6 = new HexaCore.Core6();
    
                core1.start();
                core2.start();
                core3.start();
                core4.start();
                core5.start();
                core6.start();
            }

            else 
            {
                PrintError("Invalid number of Threads");
                return;
            }

            start = System.currentTimeMillis();

        }
        
        public static String convertmillis(long input) {
            int days = 0, hours = 0, minutes = 0, seconds = 0, millis = 0;
                        
            int day = 86400000;
            int hour = 3600000;
            int minute = 60000;
            int second = 1000;
                    
                       
            if(input >= day) {
                 days = (int) (input / day);
                 millis = (int) (input % day);
            } else 
                millis = (int) input;
                           
            if(millis >= hour) {
                 hours = millis / hour;
                 millis = millis% hour;
            }
                       
            if(millis >= minute) {
                 minutes = millis / minute;
                 millis = millis % minute;
            }
            
            if(millis >= second) {
                seconds = millis / second;
                millis = millis % second;
            }
                      
            return (days  + " day(s), " + hours + "h, " + minutes + "min, " + seconds + "s and " + millis + "ms");
    }

    public static void PrintError(String error) {
        System.err.println("Error: " + error);
    }

    public static void PrintInfo(String info) {
        System.out.println("Info: " + info);
    }

    public static void PrintLog(String log) {
        if(debug){
            System.out.println("Log: " + log);
        }
    }

}