package org.example.service.impl;

import org.example.entity.Dept;
import org.example.mapper.DeptMapper;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    public Dept get(Integer deptNo) {
        return deptMapper.selectByPrimaryKey(deptNo);
    }

    @Override
    public List<Dept> selectAll() {
        return deptMapper.getAll();
    }
}
