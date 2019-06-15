package com.example.mybatsedemo.pludemo.news.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.mybatsedemo.pludemo.base.BaseController;
import com.example.mybatsedemo.pludemo.news.model.News;

/**
 * <p>
 * 新闻信息表 前端控制器
 * </p>
 *
 * @author xpw
 * @since 2019-05-20
 */
@RestController
@RequestMapping("/news")
public class NewsController extends BaseController<News> {

}
