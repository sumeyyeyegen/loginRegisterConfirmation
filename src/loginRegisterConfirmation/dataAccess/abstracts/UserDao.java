package loginRegisterConfirmation.dataAccess.abstracts;

import java.util.List;

import loginRegisterConfirmation.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void delete(User user);
	boolean getControl(String email);
	List<User> getUser();
}
