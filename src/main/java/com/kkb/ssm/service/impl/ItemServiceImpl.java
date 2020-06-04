package com.kkb.ssm.service.impl;

import com.kkb.ssm.mapper.ItemMapper;
import com.kkb.ssm.po.Item;
import com.kkb.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Item queryItemById(Integer id) {
        return itemMapper.selectByPrimaryKey(id);
    }
}
