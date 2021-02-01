package com.example.Reddit.model;

import org.hibernate.annotations.Parent;

import javax.persistence.*;

@Entity
@Table(name = "Content")
public class Content{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "parentId")
    private Long parentId;

    @Column(name = "contentBody")
    private String contentBody;

    @Column(name = "imageURL")
    private String imageURL;

    @Column(name = "Reactions")
    private String reactions;

    @Column(name = "upvotes")
    private Long upvotes;

    @Column(name = "downvotes")
    private Long downvotes;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name = "community_id", nullable = false)
    private Community community;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Content() {
    }
}
