package com.heraizen.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ProductServiceImpl implements ProductService {
obj;
	List<Products> products;
	@Override
	public List<Products> getProducts() {
		products= (List<Products>) Stream.of(
				new Products("oneplus 7pro",49999,"123"),
				new Products("pixel 4",64000,"110"),
				new Products("galaxy fold",164000,"1212"),
				new Products("galaxy 10",74000,"654"),
				new Products("redimi note 8 pro",16000,"9878"),
				new Products("realme xt",17000,"789"),
				new Products("vivo v17",29999,"183"),
				new Products("oppo reno2",29999,"623")
				).collect(Collectors.toList());
		return products;
	}

	@Override
	public Products getProduct(String pid) {
		return products.stream().filter(e->e.getPid().equals(pid)).findFirst().get();
	}

}
