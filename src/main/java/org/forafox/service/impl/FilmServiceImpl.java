package org.forafox.service.impl;

import lombok.RequiredArgsConstructor;
import org.forafox.domain.Film;
import org.forafox.exception.ResourceNotFoundException;
import org.forafox.repository.FilmRepository;
import org.forafox.service.FilmService;
import org.forafox.web.dto.FilmDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;

    @Override
    public FilmDTO create(FilmDTO filmDTO) {
        var film = new Film();
        film.setTitleName(filmDTO.getTitleName());
        film.setGenre(filmDTO.getGenre());
        film.setCountry(filmDTO.getCountry());
        film.setProducer(filmDTO.getProducer());
        filmRepository.save(film);
        return filmDTO;
    }

    @Override
    public Film getById(Long id) {
        return filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Film not found"));
    }

    @Override
    public List<Film> getAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film getByTitleName(String titleName) {
        return filmRepository.findFilmByTitleName(titleName).orElseThrow(() -> new ResourceNotFoundException("Film not found"));
    }

    @Override
    public Film getByGenre(String genre) {
        return filmRepository.findFilmByGenre(genre).orElseThrow(() -> new ResourceNotFoundException("Film not found"));
    }

    @Override
    public Film getByCountry(String country) {
        return filmRepository.findFilmByCountry(country).orElseThrow(() -> new ResourceNotFoundException("Film not found"));
    }

    @Override
    public Film getByProducer(String producer) {
        return filmRepository.findFilmByProducer(producer).orElseThrow(() -> new ResourceNotFoundException("Film not found"));
    }
}
