package ute.udn.vn.quanlysp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ute.udn.vn.quanlysp.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {}