package org.example.woordenboek.presentation.controllers;

import lombok.RequiredArgsConstructor;
import org.example.woordenboek.models.dto.*;
import org.example.woordenboek.models.entities.WordEntity;
import org.example.woordenboek.services.flow.WordService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/itword")
public class WordController {

    private final WordService service;

    @PostMapping("/create")
    public void createWord(@RequestBody CreateWord req){
        service.createWord(req);
    }

    @GetMapping("/findAll")
    public List<WordEntity> findAll(){
        return service.findAllWords();
    }

    @GetMapping("/findById")
    public WordEntity findById(@RequestBody FindWordById req){

        return service.findWordById(req);
    }

    @PutMapping("/update")
    public void updateWord(@RequestBody UpdateWord req){
        service.updateWord(req);
    }

    @DeleteMapping("/delete")
    public void deleteWord(@RequestBody DeleteWord req){
        service.deleteWord(req);
    }

    @GetMapping("/findByWordOrTranslation")
    public WordEntity findByWordOrTranslation(@RequestBody FindWordByOriginalOrTranslation req){
        WordEntity wordEntity = service.findWordOrigOrTrans(req);
        return wordEntity;
    }


}
