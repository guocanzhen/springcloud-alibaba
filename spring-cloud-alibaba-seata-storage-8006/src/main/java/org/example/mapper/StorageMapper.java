package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Storage;

@Mapper
public interface StorageMapper {

    Storage selectByProductId(Long productId);

    int decrease(Storage record);

}
