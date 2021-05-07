package loginRegisterConfirmation.business.concretes;

import java.util.regex.Pattern;

import loginRegisterConfirmation.business.abstracts.UserService;
import loginRegisterConfirmation.dataAccess.abstracts.UserDao;
import loginRegisterConfirmation.entities.concretes.User;

public class UserManager implements UserService {
	private UserDao userDao;
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	public static final Pattern Email_Regex = 
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	@Override
	public void signUp(User user) {
		if(user.getPassword().length() >= 6 && 
		   Email_Regex.matcher(user.getEmail()).find() && 
		   user.getFirstName().length() >=2 && 
		   user.getLastName().length() >= 2) {
			System.out.println("Kayit islemi basarili. Email adresinizi dogrulamak icin lutfen " + user.getEmail() + " email adresinizi kontrol ediniz.");
			
			this.userDao.add(user);
		}
		else {
			System.out.println("Kayit islemi gerceklestirilemedi. Lutfen bilgilerinizi kontrol ediniz.");
			return;
		}
	}

	@Override
	public void signIn(String email, String password) {
		
	}

}
