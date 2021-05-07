package loginRegisterConfirmation.dataAccess.abstracts;

import loginRegisterConfirmation.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void login(String email,String password);
}
