package com.javarush.dao;

import com.javarush.entity.Film;
import com.javarush.entity.FilmText;
import org.hibernate.SessionFactory;

public class FilmTextDau extends GenericDao<FilmText> {
    public FilmTextDau(SessionFactory sessionFactory) {
        super(FilmText.class, sessionFactory);
    }
}
