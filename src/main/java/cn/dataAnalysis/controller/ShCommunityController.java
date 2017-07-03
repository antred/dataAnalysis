package cn.dataAnalysis.controller;

import cn.dataAnalysis.model.SecondhandhouseNew;
import cn.dataAnalysis.model.ShCommunityInfo;
import cn.dataAnalysis.service.SecondhandhouseNewService;
import cn.dataAnalysis.service.ShCommunityInfoService;
import cn.dataAnalysis.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/7/3.
 */
@Controller
public class ShCommunityController {

    @Autowired
    private SecondhandhouseNewService secondhandhouseNewService;

    @Autowired
    private ShCommunityInfoService shCommunityInfoService;

    /**
     * 初始化挂牌房产所有的小区信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/queryCommunityInfo.do")
    public ModelAndView queryCommunityInfo(HttpServletRequest request,ModelAndView view) {
        Long beginTime = System.currentTimeMillis();
        /*首先获取所有的小区名信息*/
        List<String> nameListAll = new ArrayList<String>();
        nameListAll = secondhandhouseNewService.getAllCommunityName();
        /*获取小区信息表的信息*/
        Map<String, Object> params = new HashMap<String, Object>();
        List<ShCommunityInfo> shCommunityInfos = shCommunityInfoService.getByParams(params);
        if (null == shCommunityInfos) {
            return null;
        }
        List<String> nameListExist = new ArrayList<>();
        for (ShCommunityInfo shCommunityInfo : shCommunityInfos) {
            nameListExist.add(shCommunityInfo.getName());
        }
        /*批量对比两组数据的不同之处*/
        List<String> nameListInsert = ListUtils.compareStrList(nameListAll, nameListExist);
        for (String str : nameListInsert) {
            ShCommunityInfo shCommunityInfo = new ShCommunityInfo();
            shCommunityInfo.setName(str);
            shCommunityInfoService.insert(shCommunityInfo);
        }
        view.setViewName("index");
        Long endTime = System.currentTimeMillis();
        System.out.print("共处理数据："+ nameListInsert.size()+"条,使用时间："+(endTime-beginTime));
        return view;
    }


}
