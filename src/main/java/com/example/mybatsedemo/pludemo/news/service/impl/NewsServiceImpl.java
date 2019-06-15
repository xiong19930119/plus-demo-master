package com.example.mybatsedemo.pludemo.news.service.impl;

import com.example.mybatsedemo.pludemo.news.model.News;
import com.example.mybatsedemo.pludemo.news.dao.NewsMapper;
import com.example.mybatsedemo.pludemo.news.service.NewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 新闻信息表 服务实现类
 * </p>
 *
 * @author xpw
 * @since 2019-05-20
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

}
