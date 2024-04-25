package com.example.phoenixlabtest.service.news;

import com.example.phoenixlabtest.model.New;
import com.example.phoenixlabtest.repository.NewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class BasicNewService implements NewService{

    private final NewRepository newRepository;
    @Override
    public void create(New newInstance) {
        newInstance.setCreatedAt(LocalDateTime.now());
        newRepository.save(newInstance);
    }
}
