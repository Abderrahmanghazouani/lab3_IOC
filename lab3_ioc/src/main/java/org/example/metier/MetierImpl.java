package org.example.metier;

import org.example.dao.IDao;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    private final IDao dao;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        return dao.getValue() * 2.0;
    }
}