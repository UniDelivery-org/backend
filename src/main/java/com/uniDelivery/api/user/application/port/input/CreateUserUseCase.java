package com.uniDelivery.api.user.application.port.input;

import com.uniDelivery.api.user.domain.model.User;

public interface CreateUserUseCase {
    User createUser(User user);
}
