package com.javarush.dao;

import com.javarush.entity.Feature;
import com.javarush.entity.Film;
import org.hibernate.SessionFactory;

public class FilmDao extends GenericDao<Film> {
    public FilmDao(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }
}
