package com.example.demo.controller;

import com.example.demo.model.WarhammerCharacter;
import com.example.demo.service.CharacterService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<WarhammerCharacter> getAllCharacters() {
        List<WarhammerCharacter> characters = characterService.getAllCharacters();
        System.out.println("Getter called");
        return characters;
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarhammerCharacter> getCharacterById(@PathVariable Long id) {
        return characterService.getCharacterById(id)
                .map(character -> new ResponseEntity<>(character, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<WarhammerCharacter> addCharacter(@RequestBody WarhammerCharacter warhammerCharacter) {
        WarhammerCharacter newCharacter = characterService.addCharacter(warhammerCharacter);
        return new ResponseEntity<>(newCharacter, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) {
        if (characterService.getCharacterById(id).isPresent()) {
            characterService.deleteCharacter(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}