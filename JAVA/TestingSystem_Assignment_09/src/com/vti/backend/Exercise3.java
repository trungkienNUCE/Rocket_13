package com.vti.backend;

import com.sun.xml.internal.ws.api.pipe.Engine;
import com.vti.entity.CPU;
import com.vti.entity.Car;

public class Exercise3 {

	public void question1() {
		CPU cpu01 = new CPU(10000);
		CPU.Processor pro1 = cpu01.new Processor(4, "Intel");
		CPU.Ram ram1 = cpu01.new Ram(16, "Kingston");
		
		System.out.println("Thong tin");
		System.out.println("Processor: " + pro1.getCache());
		System.out.println("RAM: " + ram1.getClockSpeed());
		
	}

	public void question2() {
		Car car1 = new Car("Mazda", "8WD");
		Car.Engine engine = car1.new Engine("Crysler");
		
		System.out.println("Thong tin Car: " + car1.toString());
		System.out.println("Dong co: " + engine.getEngineType());
	}
	
}
