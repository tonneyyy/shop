package com.hxzy.service.impl;

import com.hxzy.common.vo.ResponseMessage;
import com.hxzy.entity.GoodsType;
import com.hxzy.mapper.GoodsTypeMapper;
import com.hxzy.service.GoodsTypeService;

import com.hxzy.vo.TreeGoodsTypeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean deleteByPrimaryKey(Integer type_id) {
        return this.goodsTypeMapper.deleteByPrimaryKey(type_id)>0;
    }


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean insert(GoodsType record) {
        return this.goodsTypeMapper.insert(record)>0;
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public GoodsType selectByPrimaryKey(Integer type_id) {
        return this.goodsTypeMapper.selectByPrimaryKey(type_id);
    }


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateByPrimaryKeySelective(GoodsType record) {
        return this.goodsTypeMapper.updateByPrimaryKeySelective(record)>0;
    }


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateByPrimaryKey(GoodsType record) {
        return this.goodsTypeMapper.updateByPrimaryKey(record)>0;
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ResponseMessage searchAll() {
        List<GoodsType> dbGoodsTypes = this.goodsTypeMapper.searchAll();
        List<TreeGoodsTypeVO> allTree = new ArrayList<>();

        dbGoodsTypes.stream().filter(p-> p.getParentId()==null || p.getParentId()==0 ).forEach(p->{
            TreeGoodsTypeVO treeGoodsVO = new TreeGoodsTypeVO();
            //一级节点
            treeGoodsVO.setLevel(1);

            BeanUtils.copyProperties(p,treeGoodsVO);

            getChildren(dbGoodsTypes, treeGoodsVO);

            allTree.add(treeGoodsVO);
        });
        return ResponseMessage.success("ok",allTree);
    }

    private void getChildren(List<GoodsType> dbGoodsTypes, TreeGoodsTypeVO treeGoodsVO) {
        List<TreeGoodsTypeVO> childrenList = new ArrayList<>();
        dbGoodsTypes.stream().filter(z->z.getParentId()==treeGoodsVO.getId()).forEach(c->{
            TreeGoodsTypeVO child = new TreeGoodsTypeVO();
            //以下级
            child.setLevel(treeGoodsVO.getLevel()+1);

            BeanUtils.copyProperties(c,child);

            getChildren( dbGoodsTypes,child);

            childrenList.add(child);

        });
        if(childrenList.size()>0){
            treeGoodsVO.setChildren(childrenList);
        }
    }
}
