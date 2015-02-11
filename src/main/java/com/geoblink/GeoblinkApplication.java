package com.geoblink;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.geoblink.beans.GeoblinkStoreBean;

@ComponentScan
@EnableAutoConfiguration
public class GeoblinkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication
				.run(GeoblinkApplication.class);

		List<GeoblinkStoreBean> result = context
				.getBean(JdbcTemplate.class)
				.query("select id, nameStore, city, longitude, latitude, telephone, sales FROM store",
						new RowMapper<GeoblinkStoreBean>() {
							public GeoblinkStoreBean mapRow(ResultSet rs,
									int row) throws SQLException {
								return new GeoblinkStoreBean(rs
										.getString("nameStore"), rs
										.getString("city"), rs
										.getString("longitude"), rs
										.getString("latitude"), rs
										.getString("telephone"), rs
										.getString("sales"));
							}
						});
		System.out.println("Number of Record:" + result.size());

	}
}
