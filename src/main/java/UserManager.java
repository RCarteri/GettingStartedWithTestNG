import java.util.ArrayList;
import java.util.Collection;

public class UserManager {
    private Collection<String> userStorage;

    public UserManager() {
        this.userStorage = new ArrayList<>();
    }

    public boolean addUser(String userEmail) throws DuplicateUserException{
        for (String s : userStorage) {
            if (s.equals(userEmail)) {
                throw new DuplicateUserException("User already exists");
            }
        }
        return userStorage.add(userEmail);
    }

    public String getUser(String userEmail) {
        for (String s : userStorage) {
            if (s.equals(userEmail))
                return s;
        }
        return null;
    }
}
