package loginRegisterConfirmation;

import loginRegisterConfirmation.business.concretes.UserManager;
import loginRegisterConfirmation.dataAccess.concretes.HibernateUserDao;
import loginRegisterConfirmation.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user = new User();
		user.setFirstName("sum");
		user.setLastName("yeg");
		user.setEmail("sumeyyeyegen@gmail.com");
		user.setPassword("123456");
		UserManager userManager = new UserManager(new HibernateUserDao());
		userManager.signUp(user);
	}

}
