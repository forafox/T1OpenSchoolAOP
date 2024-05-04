package org.forafox.web.controller;

import lombok.RequiredArgsConstructor;
import org.forafox.mapper.FilmMapper;
import org.forafox.service.FilmService;
import org.forafox.web.dto.FilmDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/film")
public class FilmController {
    private final FilmService filmService;
    private final FilmMapper filmMapper;

    @PostMapping("")
    public FilmDTO createFilm(
            @RequestBody FilmDTO filmDTO
    ) {
        return filmService.create(filmDTO);
    }

    @GetMapping("")
    public List<FilmDTO> getAllFilms(
    ) {
        return filmMapper.toDtoList(filmService.getAll());
    }

    @GetMapping("{id}")
    public FilmDTO getFilmByTitleName(
            @PathVariable Long id
    ) {
        return filmMapper.toDto(filmService.getById(id));
    }


    @GetMapping("{titleName}")
    public FilmDTO getFilmByTitleName(
            @PathVariable String titleName
    ) {
        return filmMapper.toDto(filmService.getByTitleName(titleName));
    }

    @GetMapping("{genre}")
    public FilmDTO getFilmByGenre(
            @PathVariable String genre
    ) {
        return filmMapper.toDto(filmService.getByGenre(genre));
    }

    @GetMapping("{country}")
    public FilmDTO getFilmByCountry(
            @PathVariable String country
    ) {
        return filmMapper.toDto(filmService.getByCountry(country));
    }

    @GetMapping("{producer}")
    public FilmDTO getFilmByProducer(
            @PathVariable String producer
    ) {
        return filmMapper.toDto(filmService.getByProducer(producer));
    }
}
