


package com.example.demoapp.repo;

import com.example.demoapp.model.AdminUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by TheoNicolae on 04/08/2018.
 */
public interface AdminUserRepo extends CrudRepository<AdminUser, Long> {
}
