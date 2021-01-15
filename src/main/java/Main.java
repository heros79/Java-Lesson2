public class Main {

    public static void main(String[] args) {

        /*char [] array = new char[5];

        array[1] = 'J';

        for (int i = 0; i < array.length; i++) {
            array[i] = (char)(65 + i);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }*/

        char[]arr = {'a', 'b', 'c'};
        arr[0] = 'd';

        char [][] mas = new char [5][5];
        char [][] mas1 = new char[5][];

        int a = 64;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                a++;
                mas[i][j] = (char)a;
            }
        }

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.print(mas[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
