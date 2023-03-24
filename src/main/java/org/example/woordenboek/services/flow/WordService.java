package org.example.woordenboek.services.flow;

import lombok.RequiredArgsConstructor;
import org.example.woordenboek.models.dto.*;
import org.example.woordenboek.models.entities.WordEntity;
import org.example.woordenboek.models.repositories.WordRepository;
import org.example.woordenboek.services.exceptions.WordNotFoundException;
import org.example.woordenboek.services.mappers.WordMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WordService {

    private final WordRepository wordRepository;
    private final WordMapper mapper;

    public List<WordEntity> findAllWords() {
        return wordRepository.findAll();
    }

    public WordEntity findWordById(FindWordById findWordById) {

        WordEntity wordEntity = new WordEntity();
        wordEntity.setId(findWordById.getId());

        Optional<WordEntity> optionalITWord =
                Optional.of(wordRepository.findAll().stream().filter(w -> w.getId().equals(wordEntity.getId()))
                        .findFirst()
                        .get());

        if (optionalITWord.isEmpty()) {
            throw new WordNotFoundException();
        }

        WordEntity found = optionalITWord.get();

        return found;
    }

    public void createWord(CreateWord req) {

        wordRepository.save(mapper.toEntity(req));

    }

    public void updateWord(UpdateWord req) {

        WordEntity wordEntity = mapper.toEntity(req);

        Optional<WordEntity> optionalWordEntity = wordRepository.findById(req.getId());
        if (optionalWordEntity.isEmpty()) {
            throw new WordNotFoundException();
        }

        WordEntity w = optionalWordEntity.get();

        w.setWord(wordEntity.getWord());
        w.setTranslation(wordEntity.getTranslation());

        wordRepository.flush();

    }

    public void deleteWord(DeleteWord req) {

        Optional<WordEntity> optionalWordEntity = wordRepository.findById(req.getId());
        if (optionalWordEntity.isEmpty()) {
            throw new WordNotFoundException();
        }

        wordRepository.deleteById(optionalWordEntity.get().getId());

    }

    public WordEntity findWordOrigOrTrans(FindWordByOriginalOrTranslation req) {

        WordEntity wordEntity = mapper.toEntity(req);
        WordEntity found = new WordEntity();

        Optional<WordEntity> wordByOriginal =
                Optional.of(wordRepository.findAll().stream()
                        .filter(w -> w.getWord().equals(wordEntity.getWord()))
                        .findFirst()
                        .get());
        if (wordByOriginal.isPresent()){
            found = wordByOriginal.get();
        }

        Optional<WordEntity> wordByTranslation =
                Optional.of(wordRepository.findAll().stream()
                        .filter(w -> w.getTranslation().equals(wordEntity.getTranslation()))
                        .findFirst()
                        .get());

        if (wordByTranslation.isPresent()){
            found = wordByTranslation.get();
        }

        return found;

    }


}
