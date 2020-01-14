package com.rachellima.codehero.events;

import com.rachellima.codehero.model.Hero;

import java.util.List;

public class HeroListEvent {
    private List<Hero> heroes;

    public HeroListEvent(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }
}
