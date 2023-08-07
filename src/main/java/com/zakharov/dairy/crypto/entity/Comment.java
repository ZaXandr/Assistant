package com.zakharov.dairy.crypto.entity;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @SequenceGenerator(
            name ="comment_seq",
            sequenceName = "com_seq",
            allocationSize = 20
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "com_seq")
    private Long id;

    private String comment;

    //add images public List<Image> imgs; max 3 images max data content 6 mb per image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "owner_id",
            referencedColumnName = "user_id",
            nullable = false)
    private User owner;
}
