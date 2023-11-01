package ims.dev.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ims.dev.entity.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>{

}
