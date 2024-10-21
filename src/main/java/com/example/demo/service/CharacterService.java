package com.example.demo.service;

import com.example.demo.model.WarhammerCharacter;
import com.example.demo.repository.WarhammerCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class CharacterService {

    private final WarhammerCharacterRepository characterRepository;

    @Autowired
    public CharacterService(WarhammerCharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<WarhammerCharacter> getAllCharacters() {
        return characterRepository.findAll();
    }

    public Optional<WarhammerCharacter> getCharacterById(Long id) {
        return characterRepository.findById(id);
    }
    

    public WarhammerCharacter addCharacter(WarhammerCharacter warhammerCharacter) {
        return characterRepository.save(warhammerCharacter);
    }

    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }
}