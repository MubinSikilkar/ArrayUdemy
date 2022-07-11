import java.util.Scanner;

public class basicArrayInit {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int[] myIntegers = getIntegers(5);
        for (int i = 0; i < myIntegers.length; i++) {
            System.out.println("Element " + i + ", typed value was " + myIntegers[i]);
        }
        System.out.println("The average is "+getAverage(myIntegers));


    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values");
        int values[] = new int[number];
        for (int i = 0; i < values.length; i++) {
            values[i] = sc.nextInt();

        }
        return values;
    }
    public static double getAverage(int[] Array){
        int sum =0;
        for (int i=0;i<Array.length;i++){
            sum+=Array[i];
        }
        return (double) sum /(double) Array.length;
    }
}
