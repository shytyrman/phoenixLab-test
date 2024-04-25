package com.example.phoenixlabtest.controller.news;

import com.example.phoenixlabtest.dto.news.CreateNewRequest;
import com.example.phoenixlabtest.model.New;
import com.example.phoenixlabtest.repository.NewRepository;
import com.example.phoenixlabtest.service.news.NewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/news")
@AllArgsConstructor
public class NewsController {

    private final NewRepository newRepository;
    private final NewService newService;

    @GetMapping
    public ResponseEntity<?> getNews() {

        List<New> result = newRepository.findAll();

        return ResponseEntity.status(HttpStatus.FOUND).body(result);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> createNews(@RequestBody CreateNewRequest createNewRequest) {

        try {
            if (createNewRequest.header().isEmpty()) {
                throw new IllegalStateException("Header can't be empty!");
            }
            if (createNewRequest.text().isEmpty()) {
                throw new IllegalStateException("Text can't be empty!");
            }
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }

        New newInstance = new New();
        newInstance.setHeader(createNewRequest.header());
        newInstance.setText(createNewRequest.text());

        newService.create(newInstance);

        return ResponseEntity.status(HttpStatus.CREATED).body(newInstance);
    }
}
