package com.Licofer.springbootinit.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.Licofer.springbootinit.model.entity.Picture;

/**
 * 图片服务
 *
 * @author <a href="https://github.com/Licofer">Li Congfa</a>
 * @from Licofer
 */
public interface PictureService {

    Page<Picture> searchPicture(String searchText, long pageNum, long pageSize);
}
