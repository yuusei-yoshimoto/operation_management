package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.entity.Car;

@Mapper
public interface CarMapper {
	public List<Car> findAll(@Param("id") Integer id, @Param("name") String name, @Param("passengers") Integer passengers);

	public void insert(Car car);

	public Car findById(Integer id);
	public void update(Car car);

	public void deleteById(Integer id);

}
