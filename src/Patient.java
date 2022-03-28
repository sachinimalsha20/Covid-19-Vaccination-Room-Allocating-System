import java.util.Scanner;

class Patient {
    public static String firstName, surName, City,  vaccinereqested;
    public static int age;
    public static String nic;


    public static void injectorDetails() {
        Scanner input = new Scanner(System.in);
        System.out.print("ENTER INJECTOR'S FIRST NAME :");  //the details will be taken
        firstName = input.next();
        System.out.print("ENTER INJECTOR'S SURNAME : ");
        surName = input.next();
        System.out.print("ENTER INJECTOR'S AGE:");
        age = input.nextInt();
        System.out.print("ENTER INJECTOR'S CITY : ");
        City = input.next();
        System.out.print("ENTER INJECTOR'S NIC NO. OR PASSPORT NAME:");
        nic = input.next();
        System.out.println("'A' for AstraZeneca\n" + "'S' for Sinopharm=S\n" + "'P' for Pfizer\n ENTER VACCINE REQUESTED : " ); //to get injectors details
        vaccinereqested = input.next();

    }
}

