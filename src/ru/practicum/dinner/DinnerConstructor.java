package ru.practicum.dinner;
import java.util.HashMap;
import java.util.ArrayList;

public class DinnerConstructor {
            HashMap<String,ArrayList<String>> menuList;

            DinnerConstructor(){
                menuList = new HashMap<>();
            }

            void addNewDish(String dishType, String dishName){
                if (menuList.containsKey(dishType) == true) {
                    ArrayList<String> newMenu = menuList.get(dishType);
                    newMenu.add(dishName);
                    System.out.println("Добавлено новое блюдо: " + dishName);
                }else{
                    ArrayList<String> newMenu = new ArrayList<>();
                    newMenu.add(dishName);
                    menuList.put(dishType,newMenu);
                    System.out.println("Добавлен новый тип блюдо: " + dishType + " и новое блюдо: " + dishName);
                }
            }

            String generateDishCombo(int countVariant, ArrayList<String> listType) {
                String variant = "";

                return variant;
            }

            boolean checkType(String type){
                boolean result = false;
                if (menuList.containsKey(type) == true) {
                    result = true;
                }

                return result;
            }

}
