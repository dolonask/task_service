package kg.megacom.task_service.services.impl;

import kg.megacom.task_service.models.User;
import kg.megacom.task_service.repositories.UserRepo;
import kg.megacom.task_service.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow();
    }
}
