package loginRegisterConfirmation.dataAccess.concretes;

import loginRegisterConfirmation.dataAccess.abstracts.UserDao;
import loginRegisterConfirmation.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public void add(User user) {
		System.out.println("Kullanici hibernate ile eklendi. ");
	}

	@Override
	public void login(String email, String password) {
		
	}
	
}
