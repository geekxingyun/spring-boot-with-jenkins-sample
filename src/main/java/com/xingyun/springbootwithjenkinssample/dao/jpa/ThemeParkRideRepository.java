package com.xingyun.springbootwithjenkinssample.dao.jpa;

import com.xingyun.springbootwithjenkinssample.entity.ThemeParkRide;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qing-feng.zhao
 */
@Repository
public interface ThemeParkRideRepository extends CrudRepository<ThemeParkRide, Long> {
    List<ThemeParkRide> findByName(String name);
}
