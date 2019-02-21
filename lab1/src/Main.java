
public class Main {
    /**
     * @param args - args
     */
    public static void main(String[] args) {
        System.out.println("Starting project");


        // 2

        byte v_byte = 120;
        short v_short = 129;
        char v_char = 'a';
        int v_int = 65999;
        long v_long = 429496729;
        float v_float = 0.1f;
        double v_double = 0.3333333333333333;
        boolean v_bool = true;
        System.out.println("This is a byte: " + v_byte);
        System.out.println("This is a short: " + v_short);
        System.out.println("This is a char: " + v_char);
        System.out.println("This is a int: " + v_int);
        System.out.println("This is a long: " + v_long);
        System.out.println("This is a float: " + v_float);
        System.out.println("This is a double: " + v_double);
        System.out.println("This is a boolean: " + v_bool);


        // 3
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.print(i);
        }
        System.out.println(" ");

        long begin = new java.util.Date().getTime();
        for (int i = 0; i < 100000000; i++) {
        }
        long end = new java.util.Date().getTime();
        System.out.println("int: " + (end - begin));

        begin = new java.util.Date().getTime();
        for (long i = 0; i < 100000000; i++) {
        }
        end = new java.util.Date().getTime();
        System.out.println("long: " + (end - begin));


        // 5-1
        int[] arr = {12, 43, 12, -65, 778, 123, 32, 76};
        System.out.println(arrayMax(arr));


        // 5-2

        int[][] arr2d = new int[3][3];
        for (int i = 0; i < arr2d.length; i++) {
            for (int j = 0; j < arr2d[i].length; j++) {
                arr2d[i][j] = (int) (Math.random() * 10);
            }
        }
        print2dArray(arr2d);
        translateArray(arr2d);
        print2dArray(arr2d);
    }

    public static int arrayMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr)
            if (max < i) max = i;

        return max;
    }

    public static void translateArray(int[][] arr) {
        System.out.println("translate");
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr[i].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    public static void print2dArray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
    }


}
