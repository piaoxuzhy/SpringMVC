package com.kkb.ssm.controller;

import com.kkb.ssm.po.Item;
import com.kkb.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("item")
public class ItemController {
    //@Autowired //应该尽量避免使用变量方式注入
    private ItemService itemService;

    //强制依赖的话就用构造器方式
    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    //选择依赖的话就用set方法注入
    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping("{id}")
    @ResponseBody
    public Item queryItemById(@PathVariable Integer id) {
        System.out.println("-------------------start----------------");
        Item item = itemService.queryItemById(id);
        System.out.println(item.toString());
        return item;
    }
}
