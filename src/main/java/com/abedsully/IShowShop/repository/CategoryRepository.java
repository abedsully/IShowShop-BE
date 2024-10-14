package com.abedsully.IShowShop.repository;

import com.abedsully.IShowShop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long > {
    Category findByName(String name);
}
