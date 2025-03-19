package com.companydu.crud_mini_project.service;

import com.companydu.crud_mini_project.entity.GoodsDto;
import com.companydu.crud_mini_project.repository.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    private final GoodsDao goodsDao;

    public GoodsService(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    // 상품 생성
    public int insertGoods(GoodsDto goodsDto) {
        return goodsDao.insertGoods(goodsDto);
    }

    // 모든 상품 조회
    public List<GoodsDto> selectAllGoods() {
        return goodsDao.selectAllGoods();
    }

    // 개별 상품 조회
    public GoodsDto selectGoods(int good_no) {
        return goodsDao.selectGoods(good_no);
    }

    // 상품 삭제
    public int deleteGoods(int good_no) {
        return goodsDao.deleteGoods(good_no);
    }
}
