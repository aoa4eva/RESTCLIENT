package me.afua.apitest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class EmbeddedPeople {
    private PersonList _embedded;

    public EmbeddedPeople() {
        _embedded = new PersonList();
    }

    public PersonList get_embedded() {
        return _embedded;
    }

    public void set_embedded(PersonList _embedded) {
        this._embedded = _embedded;
    }
}
