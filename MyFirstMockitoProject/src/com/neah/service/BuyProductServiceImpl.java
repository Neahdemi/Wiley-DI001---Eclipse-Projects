package com.neah.service;

import java.util.List;

import com.neah.bean.Stock;
import com.neah.dao.ProductDao;

import lombok.Getter;
import lombok.Setter;

public class BuyProductServiceImpl implements BuyProductService {

	@Getter
	@Setter
	private List<Stock> stocks;
	@Setter
	private ProductDao productDao;

	
	@Override
	public double getTotalPrice() {
		double totalPrice=0.0;
		for(Stock stock:stocks) {
			totalPrice=totalPrice+stock.getQuantity()*productDao.getPrice(stock);
		}
		return totalPrice;
	}

}