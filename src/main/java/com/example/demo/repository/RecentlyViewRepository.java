package com.example.demo.repository;

import com.example.demo.model.RecentlyView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface RecentlyViewRepository extends CrudRepository<RecentlyView, Long> {

    @Query(value = "CALL save_recently_view(:user_id, :product_id);", nativeQuery = true)
    RecentlyView saveRecently(@Param("user_id") long id_user, @Param("product_id") long id_product);

}
