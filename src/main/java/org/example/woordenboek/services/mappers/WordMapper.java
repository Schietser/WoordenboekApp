package org.example.woordenboek.services.mappers;

import org.example.woordenboek.models.dto.CreateWord;
import org.example.woordenboek.models.dto.FindWordByOriginalOrTranslation;
import org.example.woordenboek.models.dto.UpdateWord;
import org.example.woordenboek.models.entities.WordEntity;
import org.springframework.stereotype.Component;

@Component
public class WordMapper {

    public WordEntity toEntity(CreateWord req){

        WordEntity wordEntity = new WordEntity();
        wordEntity.setWord(req.getWord());
        wordEntity.setTranslation(req.getTranslation());

        return wordEntity;

    }

    public WordEntity toEntity(UpdateWord req){

        WordEntity wordEntity = new WordEntity();
        wordEntity.setWord(req.getWord());
        wordEntity.setTranslation(req.getTranslation());

        return wordEntity;

    }

    public WordEntity toEntity(FindWordByOriginalOrTranslation req){

        WordEntity wordEntity = new WordEntity();
        wordEntity.setWord(req.getWord());
        wordEntity.setTranslation(req.getTranslation());

        return wordEntity;

    }


}
