package org.forafox.repository;

import org.forafox.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {
    Optional<Film> findFilmByTitleName(String titleName);

    Optional<Film> findFilmByGenre(String genre);

    Optional<Film> findFilmByCountry(String country);

    Optional<Film> findFilmByProducer(String producer);
}
