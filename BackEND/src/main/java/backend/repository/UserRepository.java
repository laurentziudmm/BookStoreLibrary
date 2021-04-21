package backend.repository;

import backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, BigInteger> {

    @Query("select u from User u inner join Address a on " +
            "u.address = a.id where a.emailAddress like :email")
    Optional<User> findUserByEmailAddress(String email);

    @Query("select u from User u inner join Address a on " +
            "u.address = a.id where a.emailAddress like :email " +
            "and u.password like :password")
    Optional<User> findUserByEmailAddressAndPassword(String email, String password);
}
