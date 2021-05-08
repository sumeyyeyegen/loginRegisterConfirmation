package loginRegisterConfirmation;

import java.util.Scanner;

import loginRegisterConfirmation.business.concretes.UserManager;
import loginRegisterConfirmation.core.GoogleManagerAdapter;
import loginRegisterConfirmation.dataAccess.concretes.HibernateUserDao;
import loginRegisterConfirmation.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		UserManager userManager = new UserManager(new HibernateUserDao(),new GoogleManagerAdapter());
		
		userManager.signUp(new User(1,"Sumeyye","Yegen","sumeyyeyegen746@gmail.com","123456"));
		userManager.signUp(new User(2,"Atil","Aydin","atil@gmail.com","1235555"));
		userManager.signUp(new User(3,"Gece","Aydin","gece@gmail.com","1234533333"));
		userManager.signUp(new User(4,"Bihter","Aydin","bihter@gmail.com","12345678"));
		
		
		System.out.print("Email: ");
		String email=scanner.nextLine();
		System.out.print("Sifre : ");
		String password=scanner.nextLine();
		userManager.signIn(email, password);	
		
		GoogleManagerAdapter gAdaptor = new GoogleManagerAdapter();
		gAdaptor.signUp(email);
	}

}
