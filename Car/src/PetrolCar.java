public class PetrolCar extends Car{
    public PetrolCar(String brand) {
        super(brand);
    }

    @Override
    public void startEngine() {
        System.out.println(brand + " (Pertrol): Igniting fuel engine...");
    }
}
