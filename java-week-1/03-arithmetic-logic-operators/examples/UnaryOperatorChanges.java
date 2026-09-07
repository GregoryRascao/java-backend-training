public class UnaryOperatorChanges {

    public static void main(String[] args) {
        int x = 10;
        System.out.println(++x); // 11 (pre-increment)
        System.out.println(x);
        System.out.println(x--); // 11 then becomes 10
        System.out.println(x);

        System.out.println(-x);

        System.out.println(x);
    }
}
