package com.Licofer.springbootinit.controller;

import com.Licofer.springbootinit.common.BaseResponse;
import com.Licofer.springbootinit.common.ResultUtils;
import com.Licofer.springbootinit.manager.SearchFacade;
import com.Licofer.springbootinit.model.dto.search.SearchRequest;
import com.Licofer.springbootinit.model.vo.SearchVO;
import com.Licofer.springbootinit.service.PictureService;
import com.Licofer.springbootinit.service.PostService;
import com.Licofer.springbootinit.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 图片接口
 */
@RestController
@RequestMapping("/search")
@Slf4j
public class SearchController {

    @Resource
    private UserService userService;

    @Resource
    private PostService postService;

    @Resource
    private PictureService pictureService;

    @Resource
    private SearchFacade searchFacade;

    @PostMapping("/all")
    public BaseResponse<SearchVO> searchAll(@RequestBody SearchRequest searchRequest, HttpServletRequest request) {
        return ResultUtils.success(searchFacade.searchAll(searchRequest, request));
    }
}
