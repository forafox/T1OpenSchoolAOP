package org.forafox.service.impl;

import lombok.RequiredArgsConstructor;
import org.forafox.domain.Film;
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
        return null;
    }

    @Override
    public Film findById(Long id) {
        return filmRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film findByTitleName(String titleName) {
        return filmRepository.findFilmByTitleName(titleName).orElseThrow();
    }

    @Override
    public Film findByGenre(String genre) {
        return filmRepository.findFilmByGenre(genre).orElseThrow();
    }

    @Override
    public Film findByCountry(String country) {
        return filmRepository.findFilmByCountry(country).orElseThrow();
    }

    @Override
    public Film findByProducer(String producer) {
        return filmRepository.findFilmByProducer(producer).orElseThrow();
    }
}
