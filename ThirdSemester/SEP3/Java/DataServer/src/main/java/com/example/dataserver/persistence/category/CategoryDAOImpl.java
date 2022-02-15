package com.example.dataserver.persistence.category;

import com.example.dataserver.models.Category;
import com.example.dataserver.persistence.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;

import java.util.concurrent.Future;

@Repository
@EnableAsync
public class CategoryDAOImpl implements CategoryDAO
{
  private final ProductCategoryRepository repository;

  @Autowired
  public CategoryDAOImpl(ProductCategoryRepository repository)
  {
    this.repository = repository;
  }

  @Async
  @Override
  public Future<Category> addProductCategory(Category category)
  {
    return new AsyncResult<>(repository.save(category));
  }

  @Async
  @Override
  public Future<Page<Category>> getAllCategories(Pageable pageable)
  {
    return new AsyncResult<>(repository.findAll(pageable));
  }

  @Async
  @Override
  public Future<Category> editProductCategory(Category category)
  {
    return new AsyncResult<>(repository.save(category));
  }

  @Async
  @Override
  public void deleteProductCategory(int id)
  {
    repository.deleteById(id);
  }
}
