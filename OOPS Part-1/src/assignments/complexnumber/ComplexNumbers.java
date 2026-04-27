package assignments.complexnumber;

public class ComplexNumbers {
	private int real;
	private int imaginary;

	// Constructor → initialize values
	public ComplexNumbers(int real, int imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	// plus → modifies current object
	public void plus(ComplexNumbers c2) {
		this.real += c2.real;
		this.imaginary += c2.imaginary;
	}

	// multiply → (a+ib)(c+id)
	public void multiply(ComplexNumbers c2) {
		int temp = this.real;
		this.real = (this.real * c2.real) - (this.imaginary * c2.imaginary);
		this.imaginary = (temp * c2.imaginary) + (this.imaginary * c2.real);
	}

	public void print() {
		System.out.println(this.real + " + i" + this.imaginary);
	}
}