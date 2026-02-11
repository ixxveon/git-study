package kr.co.studyProject.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.studyProject.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	boolean existsByUserNickname(String userNickname);
	boolean existsByEmail(String email);
	User findByEmail(String emaul);
}
