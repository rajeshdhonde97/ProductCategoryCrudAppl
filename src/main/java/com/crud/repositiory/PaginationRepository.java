package com.crud.repositiory;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Product;

@Repository
public interface PaginationRepository extends PagingAndSortingRepository<Product, Serializable> {

}
