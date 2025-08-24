import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {


    static int recursive(int[] arr, int l, int h, int target) {
        if (l > h)
            return -1;
        int mid = (l + h) / 2;
        if (arr[mid] == target)
            return mid;
        if (target < arr[mid])
            return recursive(arr, l, mid - 1, target);
        else
            return recursive(arr, mid + 1, h, target);
    }

    public static void main(String[] args) throws IOException {

        /**********Binary Search recursively***************/
        int[] bs = {1,2,3,4,5,6,7,9};
        int low = 0;
        int high = bs.length-1;
        System.out.println(recursive(bs, low, high, 7));

        int[] arr = {1,2,9,7,3,4,4};
        System.out.println(Arrays.stream(arr).boxed().max(Integer::compareTo).orElseGet(()-> null));
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.summarizingInt(no->no)));
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toCollection(()->new TreeSet<>())));


        int c = 25;
        System.out.println(c << 2);  //left shift = add 0's at the end
        System.out.println(c >> 2); // right shift = delete the last

        String str = "hello world for java programmer";
        char[] charArray = str.toCharArray();
        System.out.print(Stream.of(charArray).map((word) -> new StringBuilder(Arrays.toString(word)).reverse()).collect(Collectors.joining(" ")));




        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        int line = Integer.parseInt(br.readLine());
        br.close();
//        Scanner sc = new Scanner(System.in);
//        int line = sc.nextInt();
        for (int i = 0; i <= line; i++) {
            i *=5;
            System.out.println(i + " *" + " 5 " + " = " +i*5);
        }
    }
}