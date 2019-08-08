package com.crow.service;

import com.alibaba.fastjson.JSONObject;
import com.crow.entity.custom.PersonalColumnInfoCustom;
import com.crow.result.ColumnsInfoResult;
import com.crow.result.CommonResult;
import com.crow.result.NewsDetailResult;
import com.crow.result.NewsListResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by wangyq1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsServiceTest {
    @Autowired
    NewsService newsService;

    /**获取用户列表单元测试**/
    @Test
    public void testGetNewsListByCloumn(){
        int start=2;
        int limit=5;
        String token="public-1232213123";
        CommonResult<List<NewsListResult>> commonResults=newsService.getNewsListByCloumn(1,start,limit);
        System.out.println("OK");
    }

    /**获取单个用户登录详情页测试**/
    @Test
    public void testGetSingleNewById(){
        NewsDetailResult results=newsService.getSingleNewById("2");
        String label=results.getLabel();
        String title=results.getTitle();
        String newsId=results.getNewsId();
        String source=results.getSource();
        Date newsDate=results.getNewsDate();
        String mainImage=results.getMainImage();
        System.out.println("OK");
    }

    /**测试获取现有的所有栏目的列表**/
    @Test
    public void testGetALLColums(){
        ColumnsInfoResult result= newsService.getAllColumns();
        System.out.println(JSONObject.toJSONString(result));
    }

    /**测试获取用户个人收藏的栏目**/
    @Test
    public void testGetPersonalColumns(){
        ColumnsInfoResult<PersonalColumnInfoCustom> result=newsService.getPersonalColums("3XSZ");
        System.out.println(JSONObject.toJSONString(result));
    }
}
