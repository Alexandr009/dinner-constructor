package ru.practicum.dinner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
public class DinnerConstructor {
            HashMap<String,ArrayList<String>> menuList;

            DinnerConstructor(){
                menuList = new HashMap<>();
            }

            void addNewDish(String dishType, String dishName){
                if (menuList.containsKey(dishType)) {
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

            HashMap generateDishCombo(int numberVariant, ArrayList<String> dishTypeList) {
                HashMap<String, ArrayList<String>> dischCombo = new HashMap<>();

                for (int i = 0; i < numberVariant; i++) {
                    ArrayList<String> listForCombo = new ArrayList<>();
                    for (String key:menuList.keySet()) {
                        if (dishTypeList.contains(key)) {
                            ArrayList<String> dishList = menuList.get(key);

                            Random rnd = new Random();
                            int number = rnd.nextInt(dishList.size());

                            String dischName = dishList.get(number);
                            listForCombo.add(dischName);
                        }
                    }
                    int numberCombo = i + 1;
                    dischCombo.put("Комбо " + numberCombo,listForCombo);
                }
                return dischCombo;
            }

            boolean checkType(String type){
                boolean result = false;
                if (menuList.containsKey(type)) {
                    result = true;
                }
                return result;
            }

}
