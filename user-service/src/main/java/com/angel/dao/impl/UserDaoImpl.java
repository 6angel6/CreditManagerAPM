package com.angel.dao.impl;

import com.angel.dao.UserDao;
import com.angel.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserDaoImpl implements UserDao<Long, User> {

	private final SessionFactory sessionFactory;

	@Override
	public void delete(User user) {
		sessionFactory.getCurrentSession().remove(user);

	}

	@Override
	public void save(User entity, Long id) {
		Session session = sessionFactory.getCurrentSession();
		User userToBeUpdated = session.get(User.class, id);

		userToBeUpdated.setAddress(entity.getAddress());
		userToBeUpdated.setEmploymentInfo(entity.getEmploymentInfo());
		userToBeUpdated.setLastName(entity.getLastName());
		userToBeUpdated.setFirstName(entity.getFirstName());
		userToBeUpdated.setMiddleName(entity.getMiddleName());
		userToBeUpdated.setPhoneNumber(entity.getPhoneNumber());
	}

	@Override
	public Optional<User> findById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		List<User> resultList = session.createQuery("SELECT p FROM User p where id=:id", User.class)
				.setParameter("id", id)
				.getResultList();
		return Optional.ofNullable(resultList.isEmpty() ? null : resultList.get(0));
	}


	@Override
	public List<User> findAll( ) {
		Session session = sessionFactory.getCurrentSession();
		log.info("users found dao ");
		return session.createQuery("SELECT u FROM User u", User.class)
				.getResultList();

	}

	@Override
	public User create(User entity) {
		Session session = sessionFactory.getCurrentSession();
		session.save(entity);
		return entity;
	}

}
