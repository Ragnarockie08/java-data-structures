import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
//        Integer a = -128;
//        Integer b = -128;
//        System.out.println(5%5);
        int[] array = new int[]{1, 2, 3, 4, 5};
//        System.out.println(Arrays.toString(tailor(array, 3)));
//        System.out.println(Arrays.toString(array));
//        leftRotation(array, 3);
        rightRotation(array, 3);
    }

    private static int[] tailor(int[] array, int step){

        int[] output = new int[array.length];
        int startIndex = 0;
        int toRemove;
        int index = 0;

        while (array.length > 0){
            toRemove = (startIndex + step-1)%array.length;
            output[index++] = array[toRemove];
            array = removeElem(array, toRemove);
            startIndex = toRemove;
        }
        return output;
    }

    private static void leftRotation(int[] array, int step){
        int[] output = new int[array.length];

        for (int i = 0; i < output.length;i++){
            output[(i + array.length-step)%array.length] = array[i];
        }

        System.out.println(Arrays.toString(output));
    }

    private static void rightRotation(int[] array, int step){

        int[] output = new int[array.length];

        for (int i = 0; i < array.length; i++){
            output[(i + step) % array.length] = array[i];
        }

        System.out.println(Arrays.toString(output));
    }

    private static int[] removeElem(int[] array, int i){

        for (int j = i; j < array.length-1; j++){
            array[j] = array[j+1];
        }
        return Arrays.copyOf(array, array.length-1);

    }
}
