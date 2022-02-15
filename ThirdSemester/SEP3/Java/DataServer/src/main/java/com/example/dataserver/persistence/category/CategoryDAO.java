package com.example.dataserver.persistence.category;

import com.example.dataserver.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Interface for CRUD operations of Product Category object
 */
public interface CategoryDAO
{
  /**
   * Method for creating product category
   * @param category category to create
   * @return future asynchronous result with created Category
   */
  Future<Category> addProductCategory(Category category);

  /**
   * Method for getting all paged categories
   * @param pageable settings for page request
   * @return page representation of categories
   */
  Future<Page<Category>> getAllCategories(Pageable pageable);

  /**
   * Method for editing product category
   * @param category category to edit
   * @return edited category
   */
  Future<Category> editProductCategory(Category category);

  /**
   * Method for deleting product category
   * @param id id of category to be deleted
   */
  void deleteProductCategory(int id);
}
