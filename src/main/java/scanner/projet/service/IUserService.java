package scanner.projet.service;

import scanner.projet.model.bo.User;

import java.util.Collection;

public interface IUserService {
    public User saveUser(User a);
    public User updateUser(User a);
    public void deleteUser(Long id);
    public User getUserAc(Long id);
    public Collection<User> listUsers();
}
