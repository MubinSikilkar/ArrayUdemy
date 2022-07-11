import java.util.Scanner;

public class minimumElement {
    public static void main(String[] args) {
        System.out.println(readInteger());
        int[] returnedArray= readElements(readInteger());
       int returnedMin = findMin(returnedArray);
        System.out.println("Min value is: "+returnedMin);



    }
        public static int readInteger(){
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter the count ");
            int count= sc.nextInt();
            sc.nextLine();
            return count;
        }

        public static int[] readElements(int elements){
        Scanner sc = new Scanner(System.in);
        int[] array = new int[elements];
        for (int i=0;i< array.length;i++){
            int totalElements = sc.nextInt();
            sc.nextLine();
            array[i]= totalElements;
        }
        return array;

        }
        public static int findMin(int[] array){
        int min= Integer.MAX_VALUE;
        for (int i=0;i< array.length;i++){
            int minValue = array[i];
            if (minValue<min){
                min= minValue;
            }
        }
        return min;
        }

    }

