import java.text.DecimalFormat;
import java.util.Scanner;

public class Deposit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int depositType = scanner.nextInt();

        double balance = new Deposit().calculateBalance(depositType, amount, period);
        DecimalFormat df = new DecimalFormat("#,###.##");
        System.out.printf("Результат вклада: %d за %d лет превратятся в %s%n", amount, period, df.format(balance));
    }

    double calculateComplexPercent(double amount, double yearRate, int years) {
        return round(amount * Math.pow((1 + yearRate / 12), 12 * years), 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int years) {
        return round(amount + amount * yearRate * years, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    double calculateBalance(int depositType, double amount, int period) {
        if (depositType == 1) {
            return calculateSimplePercent(amount, 0.06, period);
        }
        return calculateComplexPercent(amount, 0.06, period);
    }
}