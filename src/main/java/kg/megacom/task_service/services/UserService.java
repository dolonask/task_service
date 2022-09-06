package kg.megacom.task_service.services;

import kg.megacom.task_service.models.User;

public interface UserService {
    User save(User user);

    User findById(Long id);
}
