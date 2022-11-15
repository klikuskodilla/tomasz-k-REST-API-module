package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/trello")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TrelloController {

    private final TrelloClient trelloClient;

    @GetMapping("boards")
    public void getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.stream().filter(x -> {
            try {
                return x.getClass().getDeclaredField("name").toString().contains("name")
                        && x.getClass().getDeclaredField("id").toString().contains("id")
                        && x.getName().contains("Kodilla");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                return false;
            }
        }).forEach(x -> System.out.println(x.getId() + " " + x.getName()));
    }
}
