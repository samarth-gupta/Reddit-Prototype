package com.example.Reddit.controller;

import java.util.*;
import com.example.Reddit.model.Content;
import com.example.Reddit.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Content")
public class ContentController{

    private ContentRepository contentRepository;
    @Autowired(required = true)
    public ContentController(ContentRepository contentRepository){
        this.contentRepository = contentRepository;
    }

    @GetMapping
    public List<Content> getAllContent(){
        return this.contentRepository.findAll();
    }

    @PostMapping
    public Content createContent(@RequestBody Content content){
        return this.contentRepository.save(content);
    }

    @GetMapping("/test")
    public String test(){
        return "Hello World";
    }

}