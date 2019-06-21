/**
 * Level 1 , lesson 7
 * @author Maluy Yaroslav
 * @version data 21.06.19
 */
class Homework_7 {
//1. Расширить задачу про котов и тарелки с едой
    public static void main(String[] args) {
        //5. Создать массив котов и тарелку с едой,
        // попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
        Cat[] cat = new Cat[5];
        cat[0] = new Cat("Barsik",10);
        cat[1] = new Cat("Kyzya",7);
        cat[2] = new Cat("Pushok",8);
        cat[3] = new Cat("Filya",9);
        cat[4] = new Cat("Lyntik",12);
        Plate plate = new Plate(2);
        for (Cat catEat : cat) {
            catEat.eat(plate);
            System.out.println(catEat);
            System.out.println(plate);
            plate.addFood(10);
        }
    }
}

class Cat {
    //3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
    //Если коту удалось покушать (хватило еды), сытость = true
    private String name;
    private int appetite;
    private boolean satiety;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", сытость: " + satiety;
    }
//2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
// (например, в миске 10 еды, а кот пытается покушать 15-20)
    void eat(Plate plate) {
        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            satiety = true;
        }
    }
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "PLATE: " + food;
    }

    void decreaseFood(int appetite) {
        if (food >= appetite) {
            food -= appetite;
        }
    }

    int getFood() {
        return food;
    }
//6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
    void addFood(int food) {
        this.food += food;
    }
}

