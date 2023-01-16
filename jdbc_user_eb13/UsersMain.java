package jdbc_user_eb13;
import java.util.Scanner;

public class UsersMain {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean repeat = true;

	    Users   users = new Users ();
		UsersCRUD  crud = new UsersCRUD();

		do {
			System.out.println(" 1.signUp \n 2.login \n 3.exit");
			System.out.println("enter your choice ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("enter the id");
				int id = scanner.nextInt();

				System.out.println("enter the username");
				String name = scanner.next();

				System.out.println("enter the email");
				String email = scanner.next();

				System.out.println("enter the password");
				String password = scanner.next();

				System.out.println("enter the address");
				String address = scanner.next();

				users.setId(id);
				users.setName(name);
				users.setEmail(email);
				users.setPassword(password);
				users.setAddress(address);

				crud.signupUser(users);
			}
				break;
			case 2: {
				do {
					System.out.println("Choose your option to login");
					System.out.println(" 1.Facebook \n 2.Instagram \n 3.Snapchat \n 4.Watsapp \n 5.Twitter");
					System.out.println("enter your choice ");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {
						System.out.println("enter the email");
						String email = scanner.next();

						System.out.println("enter the password");
						String password = scanner.next();

						users.setEmail(email);
						users.setPassword(password);

						boolean saved = crud.loginUser(users);

						if (saved == true) {
							System.out.println("logged in successfully");
							Users user = crud.getUsers(email);
							System.out.println(user.getFacebook_password());
							String faceBookpassword = users.getFacebook_password();
							if (faceBookpassword == null) {
								System.out.println("Facebook password " + user.getFacebook_password());
								System.out.println("Please update your Facebook password");
								String facebookPassword = scanner.next();
								crud.resetFacebookPassword(facebookPassword, email);
							} else {
								System.out.println("Please enter Facebook password");
								String facebookPassword = scanner.next();
								crud.resetFacebookPassword(facebookPassword, email);

							}
						}
					}

						break;

					case 2: {
						System.out.println("enter the email");
						String email = scanner.next();

						System.out.println("enter the password");
						String password = scanner.next();

						users.setEmail(email);
						users.setPassword(password);

						boolean saved1 = crud.loginUser(users);

						if (saved1 == true) {
							System.out.println("logged in successfully");
							Users user = crud.getUsers(email);
							System.out.println(user.getInstagram__password());
							String instapassword = users.getInstagram__password();
							if (instapassword == null) {
								System.out.println("Insta password " + user.getInstagram__password());
								System.out.println("Please update your Insta password");
								String instaPassword = scanner.next();
								crud.resetInstagramPassword(instaPassword, email);
							} else {
								System.out.println("Please enter Insta password");
								String instaPassword = scanner.next();
								crud.resetInstagramPassword(instaPassword, email);
							}
						}
					}
						break;
					case 3: {
						System.out.println("enter the email");
						String email = scanner.next();

						System.out.println("enter the password");
						String password = scanner.next();

						users.setEmail(email);
						users.setPassword(password);

						boolean saved2 = crud.loginUser(users);

						if (saved2 == true) {
							System.out.println("logged in successfully");
							Users user = crud.getUsers(email);
							System.out.println(user.getSnapchat_password());
							String snapchatpassword = users.getSnapchat_password();
							if (snapchatpassword == null) {
								System.out.println("Insta password " + user.getSnapchat_password());
								System.out.println("Please update your SnapChat password");
								String snapchatPassword = scanner.next();
								crud.resetSnapchatPassword(snapchatPassword, email);
							} else {
								System.out.println("Please enter snapchat password");
								String snapchatPassword = scanner.next();
								crud.resetSnapchatPassword(snapchatPassword, email);
							}
						}
					}
						break;
					case 4: {
						System.out.println("enter the email");
						String email = scanner.next();

						System.out.println("enter the password");
						String password = scanner.next();

						users.setEmail(email);
						users.setPassword(password);

						boolean saved2 = crud.loginUser(users);

						if (saved2 == true) {
							System.out.println("logged in successfully");
							Users user = crud.getUsers(email);
							System.out.println(user.getWhatsapp_password());
							String watsapppassword = users.getWhatsapp_password();
							if (watsapppassword == null) {
								System.out.println("Whatsapp password " + user.getWhatsapp_password());
								System.out.println("Please update your Whatsapp password");
								String watsappPassword = scanner.next();
								crud.resetWhatsappPassword(watsappPassword, email);
							} else {
								System.out.println("Please enter whatsapp password");
								String watsappPassword = scanner.next();
								crud.resetWhatsappPassword(watsappPassword, email);
							}
						}
					}
						break;
					case 5: {
						System.out.println("enter the email");
						String email = scanner.next();

						System.out.println("enter the password");
						String password = scanner.next();

						users.setEmail(email);
						users.setPassword(password);

						boolean saved2 = crud.loginUser(users);

						if (saved2 == true) {
							System.out.println("logged in successfully");
							Users user = crud.getUsers(email);
							System.out.println(user.getTwitter_password());
							String twiterpassword = users.getTwitter_password();
							if (twiterpassword == null) {
								System.out.println("twiter password " + user.getTwitter_password());
								System.out.println("Please update your twitter password");
								String twiterPassword = scanner.next();
								crud.resetTwitterPassword(twiterPassword, email);
							} else {
								System.out.println("Please enter whatsapp password");
								String twiterPassword = scanner.next();
								crud.resetTwitterPassword(twiterPassword, email);
							}
						}
					}
						break;
					}
				} while (repeat);
			}
			}
		} while (repeat);
	}

}