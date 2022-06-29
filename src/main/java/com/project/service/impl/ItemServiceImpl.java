package com.project.service.impl;

import com.project.bean.Item;
import com.project.mapper.ItemMapper;
import com.project.service.ItemService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {

}
