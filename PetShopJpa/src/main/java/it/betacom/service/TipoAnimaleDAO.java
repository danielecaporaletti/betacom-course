package it.betacom.service;

import java.util.List;

import it.betacom.entity.TipoAnimale;

public interface TipoAnimaleDAO {
	
	void createTipoAnimale(TipoAnimale tipoAnimale);
	TipoAnimale readTipoAnimale(Long id);
	void updateTipoAnimale(Long id, TipoAnimale newTipoAnimale);
	void deleteTipoAnimale(Long id);
	List<TipoAnimale> readAllTipoAnimale();

}
