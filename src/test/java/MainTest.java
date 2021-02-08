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

    private int[] arr(int[] task7, int n) {
        int r = 0;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < task7.length - 1; j++) {
                    r = task7[j + 1];
                    task7[j + 1] = task7[0];
                    task7[0] = r;
                    System.out.print(r);
                }

            }
        }
        return task7;
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

    private boolean foo(int[] task6) {
        int leftSum = task6[0] + task6[1];
        int rightSum = 0;

        for (int r = 2; r < task6.length; r++) {
            rightSum += task6[r];
        }
        if (leftSum == rightSum) {
            return true;
        }
        for (int r = 0; r < task6.length - 4; r++) {
            leftSum += task6[r + 2];
            rightSum -= task6[r + 2];
            if (leftSum == rightSum) return true;
        }
        return false;
    }
}

