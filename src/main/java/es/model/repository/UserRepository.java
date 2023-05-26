package es.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

import es.model.domain.AppUser;

public interface UserRepository
    extends JpaRepository<AppUser, String>, JpaSpecificationExecutor<AppUser> {

  Optional<AppUser> findById(String pk);

  void deleteById(String id);
  
  Optional<AppUser> findByFirebaseToken(String token);

  Page<AppUser> findByIdIn(List<String> pk, Pageable pageable);
}
