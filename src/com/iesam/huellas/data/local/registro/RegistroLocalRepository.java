package com.iesam.huellas.data.local.registro;


import com.iesam.huellas.domain.RegistroRepository;
import com.iesam.huellas.domain.models.RegistroAdopcion;

import java.util.List;

public interface RegistroLocalRepository {
    public void save (RegistroAdopcion registroAdopcion);

    public RegistroAdopcion findById (String id);

    public List<RegistroAdopcion> findAll();

    public void delete (String id);
}
