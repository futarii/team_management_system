package com.yanshedui.backendcommon.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanshedui.backendcommon.entity.vo.PageVO;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PageVOUtil<T, E> {

    public static <T> PageVO<T> getPageVO(Page<T> page) {
        PageVO<T> pageVO = new PageVO<>();
        pageVO.setRecords(page.getRecords());
        pageVO.setCurrentPage(page.getCurrent());
        pageVO.setPageSize(page.getSize());
        pageVO.setPageNum(page.getPages());
        pageVO.setTotal(page.getTotal());

        return pageVO;
    }

    public static <T, E> PageVO<E> getPageVOByDataVO(Page<T> page, Class<E> dataVOClass) {
        List<E> dataList = page.getRecords().stream()
                .map(data -> {
                    E dataVO = null;
                    try {
                        dataVO = dataVOClass.getDeclaredConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                             NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                    BeanUtils.copyProperties(data, dataVO);
                    return dataVO;
                })
                .toList();

        PageVO<E> pageVO = new PageVO<>();
        pageVO.setRecords(dataList);
        pageVO.setCurrentPage(page.getCurrent());
        pageVO.setPageSize(page.getSize());
        pageVO.setPageNum(page.getPages());
        pageVO.setTotal(page.getTotal());

        return pageVO;
    }

}
