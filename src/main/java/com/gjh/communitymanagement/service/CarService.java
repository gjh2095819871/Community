package com.gjh.communitymanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.domain.Car;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆表 服务类
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
public interface CarService extends IService<Car> {

    IPage<Car> search(Map searchMap);

    Boolean add(Car car);

    Boolean update(Car car);

    Car findById(int id);

    int deleteById(int id);

    int deleteAll(List list);
}
