package inheritance.abstractclass;

/*
 * Abstract class can contain
 * + abstract methods
 * + non-abstract methods
 * */
public abstract class EmailService {
	abstract void login();
	
	void loginWith2Step() {
		System.out.println("EmailService --> loginWith2Step");
	}
}
