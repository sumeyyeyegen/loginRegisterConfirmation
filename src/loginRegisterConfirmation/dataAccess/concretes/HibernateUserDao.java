package loginRegisterConfirmation.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import loginRegisterConfirmation.dataAccess.abstracts.UserDao;
import loginRegisterConfirmation.entities.concretes.User;

public class HibernateUserDao implements UserDao {
	
	List <User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("Kullanici hibernate ile eklendi. ");
	}

	@Override
	public void delete(User user) {
		user = users.remove(user.getId());
		System.out.println(user.getFirstName() + " isimli kullanici silindi.");
	}

	@Override
	public boolean getControl(String email) {
		for(User user:users) {
			if(user.getEmail().equals(email)) {
				return true;
			}
		}return false;
	}

	@Override
	public List<User> getUser() {
		return users;
	}
	
}
