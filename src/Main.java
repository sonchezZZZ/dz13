import java.util.Random;

public class Main {
    public static void main(String[] args) throws DivideByZeroException {
//    first task
        try {
            checkString("Apple", "Phone");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
//        second task
        int computation = 0;
        int secondNumber = 0;
        Random random = new Random();
        int[] mass = new int[10];
        try {
            for (int i = 0; i < 9; i++) {
                mass[i] = random.nextInt(100);
            }
            secondNumber = mass[random.nextInt(50)];
            computation = mass[random.nextInt(50)] / secondNumber;
            System.out.println("first try: " + computation);

        } catch (ArithmeticException ex) {
            try {
                if (ex.getMessage().equals("/ by zero")) {
                    throw new DivideByZeroException("Деление на 0");
                } else {
                    System.out.println("ArithmeticException");
                    computation = mass[random.nextInt(5)] / mass[random.nextInt(5)];
                    System.out.println("second try: " + computation);
                }
            } catch (ArithmeticException exception) {
                System.out.println("ArithmeticException 2");
                computation = mass[random.nextInt(5)] / mass[random.nextInt(5)];
                System.out.println("third try: " + computation);
            }

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Index out of bound");
            computation = mass[random.nextInt(mass.length)] / mass[random.nextInt(mass.length)];
            System.out.println("second try: " + computation);
        }
    }

    //    method for first task
    public static void checkString(String firstLine, String secondLine) throws Exception {
        char firstChar = firstLine.charAt(firstLine.length() - 1);
        char secondChar = secondLine.charAt(secondLine.length() - 1);
        if (firstChar == secondChar) {
            String messageForException = "Exception for " + firstChar + " " + secondChar;
            throw new IllegalArgumentException(messageForException);
        }
    }

}
