package lk.chopsticks.app.ejb.remote;

import jakarta.ejb.Remote;
import lk.chopsticks.app.core.model.User;

@Remote
public interface UserService {
    User getUserById(int id);
    User getUserByEmail(String email);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);

}
