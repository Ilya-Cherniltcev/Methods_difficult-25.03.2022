package skyPro;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("---------------- Задание 5 ---------------- ");
        String fullName = "Ivanov Ivan Ivanovich";
        String[] fNameArray = separateFIO(fullName);
        String firstName = fNameArray[0];
        String middleName = fNameArray[1];
        String lastName = fNameArray[2];
        System.out.println("Имя сотрудника — " + firstName);
        System.out.println("Фамилия сотрудника — " + lastName);
        System.out.println("Отчество сотрудника — " + middleName);

        System.out.println("---------------- Задание 6 ---------------- ");
        fullName = "ivanov ivan ivanovich";
        char[] fioArray = fullName.toCharArray();
        fioArray[0] = Character.toUpperCase(fioArray[0]);
        for (int i = 1; i < fioArray.length; i++) {
            if (fioArray[i] == ' ') {
                fioArray[i+1] = Character.toUpperCase(fioArray[i+1]);
            }
        }
        fullName = new String(fioArray); // обратное преобразование массива символов в строку
        System.out.println("Верное написание Ф. И. О. сотрудника с заглавных букв — " + fullName);

        System.out.println("---------------- Задание 7 ---------------- ");
        String str1 = "135";
        String str2 = "246";
        StringBuilder sumString = new StringBuilder(str1 + str2);
        int f = 0;
        for (int i = 0; i < str1.length(); i++) {
            sumString.setCharAt(f, str1.charAt(i));
            f++;
            sumString.setCharAt(f, str2.charAt(i));
            f++;
         }
        System.out.println("Данные строки — " + sumString);

        System.out.println("---------------- Задание 8 ---------------- ");
        String doubleCharsString = "aabccddefgghiijjkk";
        StringBuilder resultString = new StringBuilder();
        for (int i = 1; i < doubleCharsString.length(); i++) {
            if (doubleCharsString.charAt(i) == doubleCharsString.charAt(i-1)){
                resultString.append(doubleCharsString.charAt(i));
            }
        }
        System.out.println(resultString);
        System.out.println();

// ================================   ЗАДАНИЕ 6 (урок по методам)  =================================================
        System.out.println("################ Задание 6 (урок по методам) ################ ");
// генерируем массив
        int[] expenses = generateRandomArray();
        System.out.println(Arrays.toString(expenses));
// вызываем  основной метод, считающий средние траты за месяц
        double middleExpenses = calculateMiddleExpenses(expenses);
        System.out.printf("Средние траты в месяц составили: %.2f\n", middleExpenses);
    }

    // *************************   МЕТОДЫ  (урок по СТРОКАМ)  ***********************************************
// *********    метод, дробящий ФИО на составляющие ***************
    public static String[] separateFIO(String fio) {
        String [] arrayFIO = new String[3];
        int firstIndexSpace = fio.indexOf(' ');
        int secondIndexSpace = fio.lastIndexOf(' ');
        arrayFIO[2] = fio.substring(0, firstIndexSpace); // фамилия
        arrayFIO[0] = fio.substring(firstIndexSpace+1, secondIndexSpace); // имя
        arrayFIO[1] = fio.substring(secondIndexSpace + 1, fio.length()); // отчество
        return arrayFIO;

    }



// *************************   МЕТОДЫ  (урок по методам)  ***********************************************
// *********   основной метод, считающий средние траты за месяц ***************
    public static double calculateMiddleExpenses(int [] expenses) {
        int sum = calcSum(expenses);
        double midExp = (double) sum / expenses.length;
        return midExp;
    }

// *********    метод, считающий сумму всех затрат  за месяц ***************
    public static int calcSum(int [] expenses) {
        int s = 0;
        for (int i = 0; i < expenses.length; i++) {
            s += expenses[i];
        }
        return s;
    }

// *********    метод генерирующий массив со случайными числами ***************
    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
}
