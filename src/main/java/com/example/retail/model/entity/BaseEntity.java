package com.example.retail.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.*;

/*Аннотация @MappedSuperclass позволяет включать класс и его jpa аннотации в производный класс,
 не делая базовый класс сущностью*/
@MappedSuperclass
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity implements Serializable
{
   /* LocalDateTime created;
    LocalDateTime updated;

    @Column(name = "created", updatable = false)
    public LocalDateTime getCreated() { return created; }
    public void setCreated(LocalDateTime created) { this.created = created; }

    @Column(name = "updated", insertable = false)
    public LocalDateTime getUpdated() { return updated; }
    public void setUpdated(LocalDateTime updated) { this.updated = updated; }

    @PrePersist
    public void toCreate() { setCreated(LocalDateTime.now()); }

    @PreUpdate
    public void toUpdate() { setUpdated(LocalDateTime.now()); }*/
}
