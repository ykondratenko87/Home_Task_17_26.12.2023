import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

// Задача 1:
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату рождения (yyyy-MM-dd):");
        String inputDate = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(inputDate, DateTimeFormatter.ISO_DATE);
        LocalDate hundredYearsOldDate = birthDate.plusYears(100);
        System.out.println("Когда вам исполнится 100 лет: " + hundredYearsOldDate);

// Задача 2:
        int[] numbers = {5, -3, 0, 10, -7, 2, 8, -1};
        Predicate<Integer> isPositive = number -> number > 0;
        int[] positiveNumbers = filterNumbers(numbers, isPositive);
        System.out.println("Положительные числа: " + Arrays.toString(positiveNumbers));

// Задача 3:
        Function<String, Double> converter = (input) -> {
            String[] parts = input.split(" ");
            double amount = Double.parseDouble(parts[0]);
            String currency = parts[1];
            double convertedAmount = convertToDollars(amount, currency);
            return convertedAmount;
        };
        String input = "100 BYN";
        double result = converter.apply(input);
        System.out.println("Amount in dollars: " + result);


//Задача 4:
        String input1 = "100 BYN";
        convertAndPrint(input1, amount -> {
            double exchangeRate = 3.2;
            double amountInUSD = Double.parseDouble(amount) / exchangeRate;
            System.out.println("Amount in USD: " + amountInUSD);
        });


//Задача 5:
        Supplier<String> inputSupplier = () -> {
            System.out.print("Введите строку:");
            Scanner scanner1 = new Scanner(System.in);
            return scanner1.nextLine();
        };

        String reversedString = reverseString(inputSupplier);
        System.out.println("Строка задом наперед: " + reversedString);
    }

    private static int[] filterNumbers(int[] numbers, Predicate<Integer> predicate) {
        return Arrays.stream(numbers)
                .filter(predicate::test)
                .toArray();
    }

    private static double convertToDollars(double amount, String currency) {
        double exchangeRate = 3.2;
        return amount / exchangeRate;
    }

    public static void convertAndPrint(String input, Consumer<String> conversionConsumer) {
        String[] parts = input.split("\\s+");
        if (parts.length == 2) {
            conversionConsumer.accept(parts[0]);
        } else {
            System.out.println("Invalid input format");
        }
    }

    private static String reverseString(Supplier<String> inputSupplier) {
        String inputString = inputSupplier.get();
        StringBuilder reversed = new StringBuilder(inputString).reverse();
        return reversed.toString();
    }
}