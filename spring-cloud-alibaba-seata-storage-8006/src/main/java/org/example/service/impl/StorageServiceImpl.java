package org.example.service.impl;

import lombok.extern.log4j.Log4j2;
import org.example.entity.Storage;
import org.example.mapper.StorageMapper;
import org.example.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Log4j2
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public int decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");

        log.info("------->storage-service 开始查询商品是否存在");
        Storage storage = storageMapper.selectByProductId(productId);

        if (storage != null && storage.getResidue() >= count) {
            storage.setUsed(storage.getUsed() + count);
            storage.setResidue(storage.getTotal() - storage.getUsed());
            int decrease = storageMapper.decrease(storage);
            log.info("------->storage-service 扣减库存成功");
            return decrease;
        }else {
            log.info("------->storage-service 库存不足，开始回滚！");
            throw new RuntimeException("库存不足，扣减库存失败！");
        }
    }

}
