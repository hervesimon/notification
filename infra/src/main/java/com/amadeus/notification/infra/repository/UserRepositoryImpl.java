package com.amadeus.notification.infra.repository;

import org.springframework.stereotype.Repository;

import com.amadeus.notification.domain.model.UserCredential;
import com.amadeus.notification.domain.repository.UserRepository;
import com.amadeus.notification.infra.db.dao.UserRepositoryDao;
import com.amadeus.notification.infra.mapper.InfraNotificationMapper;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryDao userRepositoryDao;

    public UserRepositoryImpl(UserRepositoryDao userRepositoryDao) {
        this.userRepositoryDao = userRepositoryDao;
    }

    @Override
    public UserCredential findByUsername(String userName) {
        return InfraNotificationMapper.INSTANCE.map(userRepositoryDao.findByUsername(userName));
    }
}
