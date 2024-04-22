package com.Licofer.springbootinit.controller;

import com.Licofer.springbootinit.common.BaseResponse;
import com.Licofer.springbootinit.common.ErrorCode;
import com.Licofer.springbootinit.common.ResultUtils;
import com.Licofer.springbootinit.exception.ThrowUtils;
import com.Licofer.springbootinit.model.dto.picture.PictureQueryRequest;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.Licofer.springbootinit.model.entity.Picture;
import com.Licofer.springbootinit.service.PictureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 图片接口
 *
 * @author <a href="https://github.com/Licofer">Li Congfa</a>
 * @from Licofer
 */
@RestController
@RequestMapping("/picture")
@Slf4j
public class PictureController {

    @Resource
    private PictureService pictureService;

    /**
     * 分页获取列表（封装类）
     *
     * @param pictureQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/list/page/vo")
    public BaseResponse<Page<Picture>> listPictureByPage(@RequestBody PictureQueryRequest pictureQueryRequest,
                                                         HttpServletRequest request) {
        long current = pictureQueryRequest.getCurrent();
        long size = pictureQueryRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        String searchText = pictureQueryRequest.getSearchText();
        Page<Picture> picturePage = pictureService.searchPicture(searchText, current, size);
        return ResultUtils.success(picturePage);
    }

}
