import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


class VacinationCenter {
    public static FileWriter serviceCenterFile = null;
    public static void main(String args[]) throws IOException {
        String sCurrentLine="";
        int TokenNum = 0;
        int NewStock, i = 1,vaccine=150, emptyBooth = 6, boothNum;
        int  conNo = 0;
        String menuOption,  address = "",injectorName = "",all_data = "";
        Booth b = new Booth();
        Patient p = new Patient(); //  TO CALL PATIENT CLASS

        try {
            serviceCenterFile = new FileWriter("F:\\serviceCenter.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("100 or VVB: View all Vaccination Booths\n" +
                "101 or VEB: View all Empty Booths\n" +
                "102 or APB: Add Patient to a Booth\n" +
                "103 or RPB: Remove Patient from a Booth\n" +
                "104 or VPS: View Patients Sorted in alphabetical order\n" +
                "105 or SPD: Store Program Data into file\n" +
                "106 or LPD: Load Program Data from file\n" +
                "107 or VRV: View Remaining Vaccinations\n" +
                "108 or AVS: Add Vaccinations to the Stock\n" +
                "999 or EXT: Exit the Program");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
        Scanner input = new Scanner(System.in);
        while (i > 0) {
            System.out.print("ENTER OPERATING CODE :");
            menuOption = input.next();

            if (menuOption.equals("100") || menuOption.equals("VVB")) {
                System.out.println("ALL VACCINATION BOOTH : 06");
            }

            if (menuOption.equals("101") || menuOption.equals("VEB")) {
                emptyBooth = emptyBooth - b.count;
                System.out.println("EMPTY BOOTH : "+emptyBooth);
            }

            if (menuOption.equals("102") || menuOption.equals("APB")) {
                TokenNum++;
                System.out.println("TOKEN NUMBER :" + TokenNum);
                System.out.print("ENTER INJECTOR'S NAME : ");
                injectorName = input.next();
                System.out.print("ENTER INJECTOR'S ADDRESS : ");
                address = input.next();
                System.out.print("ENTER INJECTOR'S CONTACT NUMBER : ");
                conNo = input.nextInt();
                p.injectorDetails();
                b.assignToBooth();
            }

            if (menuOption.equals("103") || menuOption.equals("RPB")) {
                System.out.println("ENTER WHICH BOOTH YOU WANT TO REMOVE : ");
                boothNum = input.nextInt();
                emptyBooth++;
            }

            if (menuOption.equals("104") || menuOption.equals("VPS")) {

            }

            if (menuOption.equals("105") || menuOption.equals("SPD")) {
                serviceCenterFile.write("INJECTOR'S NAME : " + injectorName + "\n" + " INJECTOR'S ADDRESS : " + address + "\n" + " INJECTOR'S CONTACT NUMBER : " + conNo + "\n" + " INJECTOR'S AGE : " + p.age + "\n" + " INJECTOR'S NIC NO : " + p.nic + " \n" + "" + "\n");
                serviceCenterFile.flush();
                System.out.println("NEW DATA SUCCESSFULLY ENTERED"); // to know data is enter or not
            }

            if (menuOption.equals("106") || menuOption.equals("LPD")) {
                try {

                    BufferedReader br = null;
                    FileReader fr = null;
                    fr = new FileReader("F:\\serviceCenter.txt");
                    br = new BufferedReader(fr);


                    while ((sCurrentLine = br.readLine()) != null) {
                        //System.out.println(sCurrentLine);
                        all_data = all_data + sCurrentLine;

                    }
                    System.out.println(all_data);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (menuOption.equals("107") || menuOption.equals("VRV")) {
                System.out.println("REMAINING VACCINES :" + b.vaccine);
            }

            if (menuOption.equals("108") || menuOption.equals("AVS")) {
                System.out.print("EAMOUNT OF NEWLY STORE VACCINE:");
                NewStock = input.nextInt();
                b.vaccine = b.vaccine + NewStock;
            }

            if (menuOption.equals("999") || menuOption.equals("EXT")) {
                System.exit(0);
            }
            if(b.vaccine ==20){
                System.out.println("WARNING!\n" + "20 Vaccinations Remaining");
            }

            i++;
        }
    }
}
