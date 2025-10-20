package com.example.apps;
import java.util.ArrayList;

public class PlanetaController {
    PlanetaDAO planetaDao;

  public PlanetaController() {
      planetaDao = new PlanetaDAO();
  }
    public ArrayList<Planeta> getPlanetas(){
        return planetaDao.getPlanetas();
    }

    public ArrayList<String> getNomePlanetas(){
        ArrayList<String> nomes = new ArrayList<String>();
        for (Planeta planeta : planetaDao.getPlanetas()){
            nomes.add(planeta.nome);
        }
        return nomes;
    }

}