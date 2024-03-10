package ru.practicum.dinner;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.addNewDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");

        ArrayList<String> dishTypeList = new ArrayList<>();
        boolean flag = true;

        while (flag) {
            String nextItem = scanner.nextLine();
            if (nextItem.isEmpty() == true){
                flag = false;
                break;
            }
                boolean check = dc.checkType(nextItem);
                if (check == true){
                    dishTypeList.add(nextItem);
                }else {
                    System.out.println("Извените, такого типы блюда нет в меню");
                }
            }

        // сгенерируйте комбинации блюд и выведите на экран
        HashMap<String,ArrayList<String>> newCombo = dc.generateDishCombo(numberOfCombos, dishTypeList);
        for (String item:newCombo.keySet()) {
            System.out.println(item);
            System.out.println(newCombo.get(item));
        }
    }
}
