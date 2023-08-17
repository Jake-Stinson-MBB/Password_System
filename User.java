
public class User {
	 	private String userName; 
		private String firstPassword; 
		private String fullName; 
		private String email;
		private String phoneNumber;
		private String dateOfBirth;
		private String question1;
		private String answer1;
		private String question2;
		private String answer2;
		private String question3;
		private String answer3;
		private String pickedPicture;
	//Constructor
	User(String userName, String firstPassword, String fullName, String email, String phoneNumber, String dateOfBirth,
			String question1, String answer1, String question2, String answer2, String question3, String answer3, String pickedPicture) {
		this.userName = userName;
		this.firstPassword = firstPassword;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.question1 = question1;
		this.answer1 = answer1;
		this.question2 = question2;
		this.answer2 = answer2;
		this.question3 = question3;
		this.answer3 = answer3;
		this.pickedPicture = pickedPicture;
	}
	
	// Accsessor methods
	public String getUserName() { 
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getFirstPassword() {
		return firstPassword;
	}

	public void setFirstPassword(String firstPassword) {
		this.firstPassword = firstPassword;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}
	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getQuestion2() {
		return question1;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}
	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}
	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	
	
	public String toString() {
		return "Username: " + userName + " " + "Password: " + firstPassword + " " + "Full name: " + fullName + "" + "Email: " + email + " " + "Phone Number: " + phoneNumber + " ";
	}
	public boolean isStrongPassword(String password) {
		boolean isStrong = false;
		isStrong = password.length()>7;
		//Add more strength tests
		return isStrong;
	}
}
