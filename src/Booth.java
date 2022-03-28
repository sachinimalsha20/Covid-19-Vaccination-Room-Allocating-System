import java.util.Scanner;

class Booth {
    int boothNum,count=0;
    int j = 0, vaccine = 150;
    String CustomerName, VaccineR, A, S, P;
    String[] ServiceCenter = new String[7];
    String e = "Empty";

    public void assignToBooth() {

        Patient p=new Patient();
        Scanner input = new Scanner(System.in);
        while (j < 6) {
            ServiceCenter[j] = e;
            j++;
        }

        System.out.println("Booth 0 & 1=Astrazeneca\n" + "Booth 2 & 3=Sinopharm\n" + "Booth 4 & 5=Pfizer"); //to know these
        System.out.print("ENTER BOOTH NUMBER TO ADD PATIENT :");
        boothNum = input.nextInt();
        if (ServiceCenter[(boothNum)].equals(e)) { //to cheack booth is empty or not
            System.out.print("ENTER INJECTOR'S NAME : ");
            CustomerName = input.next();
            count++;
            ServiceCenter[(boothNum)]=CustomerName;
            vaccine = vaccine - 1; //vaccine will decrease once the patient is assigned
            if ((VaccineR == A) && (boothNum == 0) || (boothNum == 1)) {  //if vaccine request 'A' and the entered booth number is 0 or 1 then assign here
                System.out.println("Booth " + boothNum + ":" + CustomerName + " AstraZeneca");
            }
            if ((VaccineR == S) && (boothNum == 2) || (boothNum == 3)) {  //if vaccine request 'S' and the entered booth number is 2 or 3 then assign here
                System.out.println("Booth " + boothNum + ":" + CustomerName + " Sinopharm");
            }
            if ((VaccineR == P) && (boothNum == 4) || (boothNum == 5)) {  //if vaccine request 'P' and the entered booth number is 4 or 5 then assign here
                System.out.println("Booth " + boothNum + ":" + CustomerName + " Pfizer");
            }
        }

    }
}