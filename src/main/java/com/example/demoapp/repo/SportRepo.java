


package com.example.demoapp.repo;

import com.example.demoapp.model.Sport;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by TheoNicolae on 04/08/2018.
 */
public interface SportRepo extends CrudRepository<Sport, Long> {
}
