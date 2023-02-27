package com.tutorial.Common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String email;
    private String password;
    private String displayName;
    private String picture;
    private Date addDate;
    private Date updateDate;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<MessageEntity> messages = new ArrayList<>();

}
