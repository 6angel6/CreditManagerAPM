package com.angel.dao;



import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface UserDao<K extends Serializable,E extends BaseEntity<K>> {

	E create(E entity);

	void delete(E user);

	void save(E entity, Long id);

	Optional<E> findById(K id);

	List<E> findAll();

}
