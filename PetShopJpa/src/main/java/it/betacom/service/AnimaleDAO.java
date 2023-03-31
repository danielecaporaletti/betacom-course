package it.betacom.service;

import java.util.List;

import it.betacom.entity.Animale;

public interface AnimaleDAO {
	
    void createAnimale(Animale animale);
    Animale readAnimale(Long matricola);
    void updateAnimale(Long matricola, Animale updatedAnimale);
    void deleteAnimale(Long matricola);
    List<Animale> readAllAnimali();
    
}
