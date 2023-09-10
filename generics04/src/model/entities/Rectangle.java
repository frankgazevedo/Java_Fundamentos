package model.entities;

public class Rectangle implements Shape {

	private Double width;
	private Double height;

	public Rectangle() {
	}

	public Rectangle(Double width, Double height) {
		super();
		this.width = width;
		this.height = height;
	}

	public Double getWight() {
		return width;
	}

	public void setWight(Double wight) {
		this.width = wight;
	}

	public Double getHeigth() {
		return height;
	}

	public void setHeigth(Double heigth) {
		this.height = heigth;
	}

	@Override
	public double area() {
		return width * height;
	}

}