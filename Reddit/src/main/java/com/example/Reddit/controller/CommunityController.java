package com.example.Reddit.controller;

import com.example.Reddit.model.Community;
import com.example.Reddit.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/community")
public class CommunityController {

    @Autowired
    private CommunityRepository communityRepository;

    // get all
    @GetMapping
    public List<Community> getAllCommunities(){
        return this.communityRepository.findAll();
    }

    // get by id
    @GetMapping("/{id}")
    public Community getCommunityById(@PathVariable(value = "id") Long communityId){
        return this.communityRepository.findById(communityId)
                .orElseThrow( () -> new RuntimeException("User not found with id : "+communityId));
    }

    @PostMapping
    public Community createCommunity(@RequestBody Community community){
        return this.communityRepository.save(community);
    }

    @GetMapping("/test")
    public String test(){
        return "Community api endpoint works!";
    }

}
