package org.example.service;

public interface StorageService {

    /**
     * 扣库存
     * @param productId 商品id
     * @param count 扣减数量
     * @return
     */
    int decrease(Long productId, Integer count);
}
