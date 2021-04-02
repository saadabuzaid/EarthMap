package Assignment;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Earth run = new Earth();
        run.readDataMap("earth.xyz");
        run.readDataArray("earth.xyz");
        System.out.println("Enter an input to calculate teh percentage of coordinates above, and below" + "\n");
        System.out.println("Enter 1 or 2 to choose"+"\n");
        Scanner Choice = new Scanner(System.in);
        int ChoiceValue = Choice.nextInt();
        if (ChoiceValue == 1) {
            System.out.println("Enter an altitiude to calculate the percentages of cordinates above and below"+"\n");

            Scanner input = new Scanner(System.in);
            while (true) {
                if (input.hasNextDouble()) {
                    double value = input.nextDouble();
                    run.percentageAbove(value);
                    run.percentageBelow(value);
                    input = new Scanner(System.in);
                    System.out.println("Enter another input or 'quit' to quit" + "\n");
                } else if (!input.hasNextDouble() && !input.next().equals("quit")) {
                    System.out.println("Enter a valid Input or 'quit' to quit" + "\n");
                    input = new Scanner(System.in);
                } else
                    break;
            }
            System.out.println("BYE!");


        }
        else if(ChoiceValue==2){
            System.out.println("Please enter a longitude (0-360) and latitude (-90-90):"+"\n");
            Scanner input= new Scanner(System.in);
            while(true){
                if (input.hasNextDouble()) {
                    System.out.println("YOur altitude is "+run.getAltitude(input.nextDouble(),input.nextDouble()));
                    input = new Scanner(System.in);
                    System.out.println("Enter another input or 'quit' to quit" + "\n");
                } else if (!input.hasNextDouble() && !input.next().equals("quit")) {
                    System.out.println("Enter a valid Input or 'quit' to quit" + "\n");
                    input = new Scanner(System.in);
                } else
                    break;
            }
            System.out.println("BYE!");

        }
    }

}
