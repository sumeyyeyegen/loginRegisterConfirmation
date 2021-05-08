package loginRegisterConfirmation.business.concretes;

import java.util.regex.Pattern;

import loginRegisterConfirmation.business.abstracts.UserService;
import loginRegisterConfirmation.core.GoogleManagerAdapter;
import loginRegisterConfirmation.core.GoogleService;
import loginRegisterConfirmation.dataAccess.abstracts.UserDao;
import loginRegisterConfirmation.entities.concretes.User;
import loginRegisterConfirmation.google.GoogleManager;

public class UserManager implements UserService {
	//Dependency Injection- Micro Service injection
	private UserDao userDao;
	private GoogleManagerAdapter googleManagerAdapter;
	
	//User Manager hibernate'ten haberdar degil. UserManager hibernate'in referansini tutabilen interface'ini kullaniyor.
	public UserManager(UserDao userDao,GoogleManagerAdapter googleManagerAdapter) {
		super();
		this.userDao = userDao;
		this.googleManagerAdapter = googleManagerAdapter;
	}
	
	public static final Pattern Email_Regex = 
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	@Override
	public void signUp(User user) {
		if(user.getPassword().length() >= 6 && 
		   Email_Regex.matcher(user.getEmail()).find() && 
		   user.getFirstName().length() >=2 && 
		   user.getLastName().length() >= 2 && !userDao.getControl(user.getEmail())) {
			System.out.println("Kayit islemi basarili. Email adresinizi dogrulamak icin lutfen " + user.getEmail() + " email adresinizi kontrol ediniz.");
			
			this.userDao.add(user);
			this.googleManagerAdapter.signUp("Basarili sekilde giris yapildi : " + user.getFirstName());
		}else {
			System.out.println("Kayit islemi gerceklestirilemedi. Lutfen bilgilerinizi kontrol ediniz.");
			return;
		}
	}

	@Override
	public void signIn(String email, String password) {
		for (User user : userDao.getUser()) {
			if(user.getEmail() == email && user.getPassword() == password) {
				System.out.println("Basarili bir sekilde giris yapildi.");
				return;
			}
		}
	}

}
