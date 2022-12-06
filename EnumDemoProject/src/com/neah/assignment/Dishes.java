package com.neah.assignment;

/*
 * What we need to do is create a dish enum, like chicken, fish, pizza or pasta or whatever.
 *  What characteristics: calories, vegetarian or non-veggie, how many calories the dish has, 
 *  the price of the dish. Return boolean type result to see whether it's high or low in calories.
 *   Greater than 600 calories is a high calorie dish. Function will be calorie check
 */

public enum Dishes {

    PIZZA(750, true, 15) {

        @Override
        public boolean calculateCalorie() {
            System.out.println("You chose pizza which has " + getCalories() + " calories, vegetarian" + isVegetarian() + " and costs " + getPrice() + " pounds"); 
            if (this.getCalories() > 600) {
                System.out.println("PIZZA IS HIGH CALORIE");
                return true;
            }
            System.out.println("PIZZA IS LOW CALORIE");
            return false;
        }

    }, PASTA(350, true, 18) {

        @Override
        public boolean calculateCalorie() {
            System.out.println("You chose pasta which has " + getCalories() + " calories, vegetarian" + isVegetarian() + " and costs " + getPrice() + " pounds"); 

            if (this.getCalories() > 600) {
                System.out.println("PASTA IS HIGH CALORIE");
                return true;
            }
            System.out.println("PASTA IS LOW CALORIE");
            return false;
        }

    }, FISH(400, false, 25) {
        @Override
        public boolean calculateCalorie() {
            System.out.println("You chose fish which has " + getCalories() + " calories, vegetarian" + isVegetarian() + " and costs " + getPrice() + " pounds"); 

            if (this.getCalories() > 600) {
                System.out.println("FISH IS HIGH CALORIE");
                return true;
            }
            System.out.println("FISH IS LOW CALORIE");
            return false;
        }
    };
	
	private int calories;
    private boolean isVegetarian;
    private double price;

    private Dishes(int calories, boolean isVegetarian, double price) {
        this.calories = calories;
        this.isVegetarian = isVegetarian;
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public double getPrice() {
        return price;
    }

    public abstract boolean calculateCalorie();

}




