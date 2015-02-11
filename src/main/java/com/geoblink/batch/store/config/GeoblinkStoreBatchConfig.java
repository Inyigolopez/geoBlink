package com.geoblink.batch.store.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.geoblink.batch.store.GeoblinkStoreItemProcessor;
import com.geoblink.batch.store.GeoblinkStoreMarksheet;
import com.geoblink.beans.GeoblinkStoreBean;

@Configuration
@EnableBatchProcessing
public class GeoblinkStoreBatchConfig {

	@Bean
	public ItemReader<GeoblinkStoreBean> reader() {
		FlatFileItemReader<GeoblinkStoreBean> reader = new FlatFileItemReader<GeoblinkStoreBean>();
		reader.setResource(new ClassPathResource("csv/Z_sample.csv"));
		reader.setLineMapper(new DefaultLineMapper<GeoblinkStoreBean>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer(",") {
					{
						setNames(new String[] {"id", "nameStore", "city", "longitude", "latitude", "telephone", "sales" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<GeoblinkStoreBean>() {
					{
						setTargetType(GeoblinkStoreBean.class);
					}
				});
			}
		});
		return reader;
	}

	@Bean
	public ItemWriter<GeoblinkStoreMarksheet> writer(DataSource dataSource) {
		JdbcBatchItemWriter<GeoblinkStoreMarksheet> writer = new JdbcBatchItemWriter<GeoblinkStoreMarksheet>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<GeoblinkStoreMarksheet>());
		writer.setSql("INSERT INTO store( nameStore, city, longitude, latitude, telephone, sales) VALUES ( :nameStore, :city, :longitude, :latitude, :telephone, :sales)");
		writer.setDataSource(dataSource);
		return writer;
	}

	@Bean
	public ItemProcessor<GeoblinkStoreBean, GeoblinkStoreMarksheet> processor() {
		return new GeoblinkStoreItemProcessor();
	}

	@Bean
	public Job createMarkSheet(JobBuilderFactory jobs, Step step) {
		return jobs.get("createMarkSheet").flow(step).end().build();
	}

	@Bean
	public Step step(StepBuilderFactory stepBuilderFactory,
			ItemReader<GeoblinkStoreBean> reader, ItemWriter<GeoblinkStoreMarksheet> writer,
			ItemProcessor<GeoblinkStoreBean, GeoblinkStoreMarksheet> processor) {
		return stepBuilderFactory.get("step")
				.<GeoblinkStoreBean, GeoblinkStoreMarksheet> chunk(5)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/analytics");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		return dataSource;
	}

}
