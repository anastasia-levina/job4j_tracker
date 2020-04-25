package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (int index = 0; index < users.length; index++) {
            if (users[index].getUsername().equals(login)) {
                user = users[index];
                break;
            }
        }
        if (user == null) {
            throw new UserNotFoundException("This user does not exist");
        }
        return user;
    }

    public static boolean validate(User user) throws UserNotFoundException {
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("This user is not valid");
        } else if (!user.isValid()) {
            throw new UserNotFoundException("This user does not exist");
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Petr Arsentev", true)
            };
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            ui.printStackTrace();
        } catch (UserNotFoundException u) {
            u.printStackTrace();
        }
    }
}
