package loginRegisterConfirmation.core;

import loginRegisterConfirmation.google.GoogleManager;

public class GoogleManagerAdapter implements GoogleService {

	@Override
	public void signUp(String message) {
		GoogleManager googleManager = new GoogleManager();
		googleManager.signUp(message);
	}
	
}
