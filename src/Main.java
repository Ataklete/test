import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr = {1,2,3,4};
        Integer[] rapperArr = new Integer[arr.length];
        for (int i =0; i<arr.length;  i++) {
            rapperArr[i] = arr[i];
        }
        System.out.println(Arrays.stream(rapperArr).max(Integer::compareTo).orElseGet(()-> null));
        System.out.println(Arrays.stream(rapperArr).collect(Collectors.summarizingInt(no->no)));
        System.out.println(Arrays.stream(rapperArr).collect(Collectors.toCollection(()->new TreeSet<>())));

                System.out.println("Enter a number");
//        InputStreamReader reader = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(reader);
//        int line = Integer.parseInt(br.readLine());
//        br.close();
//        Scanner sc = new Scanner(System.in);
//        int line = sc.nextInt();
//        for (int i = 0; i <= line; i++) {
//            i *=5;
//            System.out.println(i + " *" + " 5 " + " = " +i*5);
//        }
    }
}