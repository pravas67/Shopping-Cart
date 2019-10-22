package com.heraizen.domain;

import java.util.List;

public interface ProductService {
	List<Products> getProducts();
	Products getProduct(String pid);
}
