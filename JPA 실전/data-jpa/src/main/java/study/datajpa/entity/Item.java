package study.datajpa.entity;

import lombok.Getter;
import org.springframework.data.domain.Persistable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Item implements Persistable<String> {

    @Id @GeneratedValue
    private String id;

    @Override
    public boolean isNew() {
        return false;
    }
}
