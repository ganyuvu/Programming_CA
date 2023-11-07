package Programming_CA.Programming_CA;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class CAMainApp {
    public static void main(String[] args) throws IOException {

        Comparator<Activity> comp = null;

        String userFileSelect = "";

        System.out.println("Welcome to the Activity Tracker!");
        System.out.println("Enter File Name Here:");


        Scanner kb = new Scanner(System.in);
        userFileSelect = kb.nextLine();

        ArrayList<Activity> stats = new ArrayList<Activity>();
        readFile("src/Programming_CA/TestStats/" + userFileSelect, stats);


//        for (Activity a : stats) {
//            System.out.printf("%-20s %-20s %-20d %-20.1f %-20d\n", a.getActivityType(), a.getDate(), a.getDuration(), a.getDistance(), a.getAvgHeartRate());
//        }

//        comp = new CaloriesBurnedComparatorDesc();
//        Collections.sort(stats, comp);

//        System.out.println("\nSorting By Desc");
//        for (Activity a : stats) {
//            System.out.printf("%-20s %-20s %-20d %-20.1f %-20d\n", a.getActivityType(), a.getDate(), a.getDuration(), a.getDistance(), a.getAvgHeartRate());
//        }

        boolean Exit = false;
        while (!Exit) {

            //userFileSelect = kb.nextLine();

            System.out.println("\nMain Menu:");
            System.out.println("----------------------");
            System.out.println("0. Exit");
            System.out.println("1. View Activities");
            System.out.println("2. View Specific fields");
            System.out.println("3. View Statistics");
            System.out.println("----------------------");

            int userInput = kb.nextInt();
            kb.nextLine();

            if (userInput == 0){
                Exit = true;
            }

            else if (userInput == 1)
            {
                menu1();

                int choice = kb.nextInt();
                kb.nextLine();

                if(choice == 1)
                {
                    //call calories burned in (descending) method
                }
                else if(choice == 2)
                {
                    //call Date (Ascending/Descending) method
                }
                else if(choice == 3)
                {
                    //call Activity Duration (Ascending/Descending) method
                }
                else if(choice == 4)
                {
                    //call Type of Activity method
                }
                else if(choice == 5)
                {
                    //call Distance (Ascending/Descending) method
                }
            }

            else if (userInput == 2)
            {
              menu2();


              int choice = kb.nextInt();
              kb.nextLine();

                if(choice == 1){
                    //call Activity type
                    for (Activity a: stats)
                    {
                        System.out.println(a.getActivityType());
                    }
                }
                else if(choice == 2){
                    //call Above a minimum distance
                    double UserMinDistance = 0;
                    System.out.println("What's your minimum distance?(enter as Double): ");
                    UserMinDistance = kb.nextDouble();
                    for(Activity a: stats)
                    {
                        if(UserMinDistance < a.getDistance())
                        {
                            System.out.println(a.getDistance());
                        }
                    }
                }
                else if(choice == 3){
                    //call Type of energy expended
                }
                else if(choice == 4){
                    //call Above a minimum duration
                }
            }

            else if (userInput == 3){
                //menu3();

                int choice = kb.nextInt();
                kb.nextLine();

                if(choice == 1){
                    //call Average distance per activity
                }
                else if(choice == 2){
                    //call Average calories burned
                }
            }
        }

    }

    private static Activity parseLine2(String line)
    {
        String ActivityType;
        String Date;
        int Duration;
        double Distance;
        int AvgHeartRate;

        StringTokenizer st = new StringTokenizer(line, ",");
        ActivityType = st.nextToken();
        Date = st.nextToken();
        Duration = Integer.parseInt(st.nextToken().trim());
        Distance = Double.parseDouble(st.nextToken().trim());
        AvgHeartRate = Integer.parseInt(st.nextToken().trim());


        return new Activity(ActivityType,Date,Duration,Distance,AvgHeartRate);
    }

    public static void readFile(String fileName, ArrayList<Activity> stats) throws IOException {
        File f = new File(fileName);
        Scanner fileIn = new Scanner(f);

        boolean firstLine = true;
        String line;

        while (fileIn.hasNextLine()) {
            //This is just to skip over the 5 header strings that are in the CSV for some reason.
            if (firstLine) {
                fileIn.nextLine();
                firstLine = false;
            }

            line = fileIn.nextLine();
            Activity a = parseLine2(line);
            stats.add(a);
        }
    }

    public static void menu1(){
        System.out.println("0. Exit");
        System.out.println("1. View Activities (Descending)");
        System.out.println("2. Date (Ascending/Descending)");
        System.out.println("3. Activity Duration (Ascending/Descending)");
        System.out.println("4. Type of Activity");
        System.out.println("5. Distance (Ascending/Descending)");
    }
    public static void menu2(){
        System.out.println("1. Activity type");
        System.out.println("2. Above a minimum distance");
        System.out.println("3. Type of energy expended");
        System.out.println("4. Above a minimum duration");
    }
    public static void menu3(){
        System.out.println("1. Average distance per activity");
        System.out.println("1. Average calories burned");
    }

}



