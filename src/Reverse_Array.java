import java.util.Arrays;
import java.util.Scanner;

public class Reverse_Array {
    public static void main(String[] args) {
       int[] array = {2,5,1,7,9,6,0,11,14,51};
        System.out.println("The given array is " + Arrays.toString(array));
        reverse(array);
        System.out.println("The reverse array is "+Arrays.toString(array) );
    }
    private static void reverse(int[] array){
        System.out.println("Array = "+ Arrays.toString(array));
       int max_Index= array.length-1;
       int halfLength= array.length/2;
       for (int i=0;i<halfLength;i++){
           int temp= array[i];
           array[i]=array[max_Index-i];
           array[max_Index-i]=temp;

       }
        System.out.println("Reversed array "+Arrays.toString(array));

    }
}
