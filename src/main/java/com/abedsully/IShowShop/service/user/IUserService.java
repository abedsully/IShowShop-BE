package com.abedsully.IShowShop.service.user;

import com.abedsully.IShowShop.dto.UserDto;
import com.abedsully.IShowShop.model.User;
import com.abedsully.IShowShop.request.CreateUserRequest;
import com.abedsully.IShowShop.request.UpdateUserRequest;

public interface IUserService {
    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UpdateUserRequest request, Long userId);

    void deleteUser(Long userId);

    UserDto convertUserToDTO(User user);
}
