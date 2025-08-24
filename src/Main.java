public class Main {
    // Pass-by-value: doesn't affect original 'a'
    static void foo1(int a) {
        ++a;
        System.out.println("--------------" +a);
    }
    // Simulating pass-by-reference using a wrapper class
    static void foo2(Integer a) {
        ++a.value;
    }
    // Simulating pointer behavior (same as reference in Java)
    static void foo3(Integer a) {
        ++a.value;
    }
    // Wrapper class to hold an int
    static class Integer {
        int value;
        Integer(int value) {
            this.value = value;
        }
        Byte c = 1;
        int b = 0;
        Long d = 1L;
    }

    public static void main(String[] args) {
        Integer a = new Integer(1);

        foo1(a.value); // No change
        System.out.println(a.value); // Output: 1

        foo2(a); // Modifies a.value
        System.out.println(a.value); // Output: 2

        foo3(a); // Modifies a.value again
        System.out.println(a.value); // Output: 3


    }
}