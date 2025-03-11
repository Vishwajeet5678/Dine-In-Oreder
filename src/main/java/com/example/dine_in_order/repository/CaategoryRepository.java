package com.example.dine_in_order.repository;

import com.example.dine_in_order.model.Category;
import com.example.dine_in_order.model.FoodItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CaategoryRepository extends JpaRepository<Category,String> {


//    @Query("SELECT DISTINCT f FROM FoodItem f INNER JOIN f.category c WHERE c.category = :category1 and c.category =:category2")
//    List<FoodItem> findFoodItemByCategory(@Param Category category1,@Param Category category2);

    @Query("""
        SELECT f FROM FoodItems f 
        WHERE :categoryCount = (
            SELECT COUNT(DISTINCT c.category) 
            FROM f.categories c 
            WHERE c.category IN :categories
        )
    """)
    List<FoodItems> findFoodItemsByAllCategories(@Param("categories") List<String> categories,
                                                @Param("categoryCount") long categoryCount);

}
