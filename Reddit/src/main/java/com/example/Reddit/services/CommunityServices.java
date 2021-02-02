package com.example.Reddit.services;

import com.example.Reddit.model.Community;
import com.example.Reddit.model.User;
import com.example.Reddit.repository.CommunityRepository;
import com.example.Reddit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CommunityServices {

    @Autowired
    private CommunityRepository communityRepository;

    @Autowired
    private UserRepository userRepository;

    public String followCommunity(Long userId,Long communityId){

        Community community = this.communityRepository.findById(communityId)
                .orElseThrow( () -> new RuntimeException("User not found with id : "+communityId));

        User user = this.userRepository.findById(userId)
                .orElseThrow( () -> new RuntimeException("User not found with id : "+userId));

        community.getCommunityUsers().add(user);
        user.getUserCommunities().add(community);

        return "Following Community Successful";

    }

    public String Upvote(Long communityId){

        Community community = this.communityRepository.findById(communityId)
                .orElseThrow( () -> new RuntimeException("User not found with id : "+communityId));

        community.setUpvotes(community.getUpvotes()+1);

        return "Upvoting Successful";

    }

    public String Downvote(Long communityId){

        Community community = this.communityRepository.findById(communityId)
                .orElseThrow( () -> new RuntimeException("User not found with id : "+communityId));

        community.setUpvotes(Math.max(0,community.getUpvotes()-1));

        return "Downvoting Successful";

    }

    public List<Community> TopCommunities(int count){

        List<Community> list = this.communityRepository.findAll();

        Collections.sort(list, new Comparator<Community>() {
            public int compare(Community c1, Community c2) {
                return c1.getUpvotes()>c2.getUpvotes() ? -1 : 1;
            }});

        List<Community>  resultList = null;

        for(int i=0;i<count && i<list.size();i++){
            resultList.add(list.get(i));
        }

        return resultList;

    }


}