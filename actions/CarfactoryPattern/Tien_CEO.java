package CarfactoryPattern;

public class Tien_CEO {
	public static void main(String[] args) {
//		xem xe ford
		FordCar ford = new FordCar();
		ford.viewFordAddress();
		ford.viewCarVersion();
		
//		xem xe Honda
		HondaCar honda = new HondaCar();
		honda.viewHondaAddress();
		honda.viewCarVersion();
		
//		xem xe Huyndai
		
		HuyndaiCar huyndai = new HuyndaiCar();
		huyndai.viewHuyndaiAddress();
		huyndai.viewCarVersion();
		
		CarFactory_01 carFactory = new CarFactory_01();
		carFactory.viewCarVersion("Ford");
		carFactory.viewCarVersion("Huyndai");
		carFactory.viewCarVersion("Honda");
	}



}
