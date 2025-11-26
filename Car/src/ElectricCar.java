public class ElectricCar extends Car{

    public ElectricCar(String brand) {
        super(brand);
    }

    @Override
    public void startEngine() {
        System.out.println(brand + " (Electric): Powering electric motor silently...");
    }
}
