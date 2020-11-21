package us.group.api;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Boolean createTag(Tag tag);
    String avatarByName(String name);
}
