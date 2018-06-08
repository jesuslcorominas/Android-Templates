package com.jesuslcorominas.blank.data.database.objectbox.entity;

import io.objectbox.annotation.BaseEntity;
import io.objectbox.annotation.Id;

/**
 * @author Jesús López Corominas
 */
@BaseEntity
public abstract class AbstractBaseEntity implements Entity {

    @Id(assignable = true)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
