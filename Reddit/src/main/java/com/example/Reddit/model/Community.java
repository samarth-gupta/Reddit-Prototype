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

    public Community(String title, Date createdAt, String description, Long upvotes, List<User> communityUsers, List<Content> communityPosts) {
        this.title = title;
        CreatedAt = createdAt;
        Description = description;
        this.upvotes = upvotes;
        this.communityUsers = communityUsers;
        this.communityPosts = communityPosts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Long getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Long upvotes) {
        this.upvotes = upvotes;
    }

    public List<User> getCommunityUsers() {
        return communityUsers;
    }

    public void setCommunityUsers(List<User> communityUsers) {
        this.communityUsers = communityUsers;
    }

    public List<Content> getCommunityPosts() {
        return communityPosts;
    }

    public void setCommunityPosts(List<Content> communityPosts) {
        this.communityPosts = communityPosts;
    }
}
