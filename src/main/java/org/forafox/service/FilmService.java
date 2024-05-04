package org.forafox.service;

import org.forafox.domain.Film;
import org.forafox.web.dto.FilmDTO;

import java.util.List;

public interface FilmService {
    FilmDTO create(FilmDTO filmDTO);

    Film findById(Long id);

    List<Film> findAll();

    Film findByTitleName(String titleName);

    Film findByGenre(String genre);

    Film findByCountry(String country);

    Film findByProducer(String producer);
}
