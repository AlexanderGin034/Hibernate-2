package com.javarush.dao;

import com.javarush.entity.Actor;
import org.hibernate.SessionFactory;

public class ActorDao extends GenericDao<Actor> {
    public ActorDao(SessionFactory sessionFactory) {
        super(Actor.class, sessionFactory);
    }
}
