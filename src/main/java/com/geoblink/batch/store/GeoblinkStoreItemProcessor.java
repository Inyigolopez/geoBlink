package com.geoblink.batch.store;

import org.springframework.batch.item.ItemProcessor;

import com.geoblink.batch.store.GeoblinkStoreMarksheet;
import com.geoblink.beans.GeoblinkStoreBean;

public class GeoblinkStoreItemProcessor implements ItemProcessor<GeoblinkStoreBean, GeoblinkStoreMarksheet> {
	
	public GeoblinkStoreMarksheet process(final GeoblinkStoreBean store) throws Exception {
		GeoblinkStoreMarksheet marksheet = new GeoblinkStoreMarksheet(
				store.getNameStore(), store.getCity(), store.getLatitude(), store.getLongitude(), store.getTelephone(), store.getSales());
		return marksheet;
	}

}
