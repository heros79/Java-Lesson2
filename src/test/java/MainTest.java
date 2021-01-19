import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void off() {

        int[] arrN4 = {1, 2, 3, 4, 5};
        int[] afterArrN4 = {2, 3, 4, 5, 1};
        int n = 4;
        int[] testArrN4 = arr(arrN4, n);

        for (int i = 0; i < arrN4.length; i++) {
            assertEquals(afterArrN4[i], testArrN4[i]);
        }

        int[] arrN3 = {1, 2, 3, 4, 5};
        int[] afterArrN3 = {3, 4, 5, 1, 2};
        n = 3;
        int[] testArrN3 = arr(arrN3, n);

        for (int i = 0; i < arrN3.length; i++) {
            assertEquals(afterArrN3[i], testArrN3[i]);
        }

        int[] arrN2 = {1, 2, 3, 4};
        int[] afterArrN2 = {3, 4, 1, 2};
        n = 2;
        int[] testArrN2 = arr(arrN2, n);

        for (int i = 0; i < arrN2.length; i++) {
            assertEquals(afterArrN2[i], testArrN2[i]);
        }
    }

    private int[] arr(int[] array, int n) {
        int temporary = array[0];
        int mark = 0;
        boolean odd = false;
        int arrLength = array.length;

        if (n % 2 == 0 && array.length % 2 == 0) {
            odd = true;
        }

        for (int i = 0; i < array.length; i++) {
            int position = reassignNumber(arrLength, mark + n);
            int newIndex = array[position];
            array[position] = temporary;
            if (odd && i % 2 != 0) {
                mark = position + 1;
                temporary = array[mark];
            } else {
                mark = position;
                temporary = newIndex;
            }
        }
        return array;
    }

    public static int reassignNumber(int arrLength, int number){
        if (number < 0) {
            while (number <= 0) {
                number += arrLength;
            }
        } else {
            while (number >= arrLength) {
                number -= arrLength;
            }
        }
        return number;
    }


    @Test
    public void summ() {
        int arr[] = {1, 1, 3, 1, 1, 3};
        int arr1[] = {1, 1, 3, 4, 2, 2, 1, 1, 3};
        int arr2[] = {1, 2, 2, 2, 2, 2};
        int arr3[] = {1, 1, 2, 3, 2, 3, 0, 2, 3};

        assertEquals(foo(arr), true);
        assertEquals(foo(arr1), true);
        assertEquals(foo(arr2), false);
        assertEquals(foo(arr3), false);

    }

    private boolean foo(int[] massive) {
        int left_sum=massive[0];
        int right_sum=massive[massive.length-1];

        for (int i = 1 ; i < massive.length ; i++) {
            left_sum+= massive[i];
            right_sum=massive[massive.length-1];
            for (int descending = massive.length-2; descending > i ; descending--) {
                right_sum += massive[descending];
                if (right_sum > left_sum) {
                    break;
                }
            }
            if(left_sum==right_sum){
                System.out.println("\n\nTask6\nThe index of the end of the left side:"+i);
                return true;
            }
        }

        return false;
    }
}

