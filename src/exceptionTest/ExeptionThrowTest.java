package exceptionTest;

public class ExeptionThrowTest {
    public static void divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("0으로 나누면 안돼요");
        }
        int c = a / b;
        System.out.println(c);
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        try {
            divide(a, b);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}