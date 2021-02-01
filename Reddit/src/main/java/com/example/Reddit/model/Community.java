package com.example.Reddit.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Community")
public class Community {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "Title")
    private String title;

    @CreationTimestamp
    private Date CreatedAt;

    @Column(name = "Description")
    private String Description;

    @Column(name = "upvotes")
    private Long upvotes;

    @ManyToMany
    @JoinTable(
            name = "user_community",
            joinColumns = @JoinColumn(name = "community_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> communityUsers;

    @OneToMany(mappedBy = "community", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Content> communityPosts;

    public Community() {
    }
}
