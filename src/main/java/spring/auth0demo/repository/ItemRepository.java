package spring.auth0demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.auth0demo.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
