public class Main {
    public static void main(String[] args) {

        Car car1 = new PetrolCar("Toyota Camry");
        Car car2 = new ElectricCar("Tesla ModelS");

        car1.startEngine();
        car2.startEngine();
    }
}