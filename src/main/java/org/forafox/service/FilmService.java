package org.forafox.service;

import org.forafox.domain.Film;
import org.forafox.web.dto.FilmDTO;

import java.util.List;

public interface FilmService {
    FilmDTO create(FilmDTO filmDTO);

    Film getById(Long id);

    List<Film> getAll();

    Film getByTitleName(String titleName);

    Film getByGenre(String genre);

    Film getByCountry(String country);

    Film getByProducer(String producer);
}
