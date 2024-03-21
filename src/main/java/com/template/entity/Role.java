package com.template.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue
    private Integer roleId;
    private String roleDescription;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "userId")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;
}
