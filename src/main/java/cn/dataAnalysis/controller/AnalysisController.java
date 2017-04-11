package cn.dataAnalysis.controller;

import cn.dataAnalysis.enums.RegionShanghaiEnum;
import cn.dataAnalysis.model.DataCountByRegion;
import cn.dataAnalysis.model.SecondhandhouseNew;
import cn.dataAnalysis.model.SecondhandhouseOriginal;
import cn.dataAnalysis.model.ShanghaiMetroStationDetails;
import cn.dataAnalysis.service.DataCountByRegionService;
import cn.dataAnalysis.service.SecondhandhouseNewService;
import cn.dataAnalysis.service.SecondhandhouseOriginalService;
import cn.dataAnalysis.utils.DateUtils;
import cn.dataAnalysis.utils.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by admin on 2017/4/6.
 */
@Controller
public class AnalysisController {

    @Autowired
    private SecondhandhouseOriginalService secondhandhouseOriginalService;

    @Autowired
    private SecondhandhouseNewService secondhandhouseNewService;

    @Autowired
    private DataCountByRegionService dataCountByRegionService;




    /**
     * 批量分批插入处理后的房产信息(多线程)
     *
     */
    @RequestMapping("/insertSecondhandhouseNewMultithread")
    public void insertSecondhandhouseNew(HttpServletRequest request) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = df.parse("2017-02-16");
        Date endDate = df.parse("2017-02-17");
        Long beginTime = System.currentTimeMillis();
        List<SecondhandhouseOriginal> soList = secondhandhouseOriginalService.findByCaptureTime(beginDate, endDate);
        Long endTime = System.currentTimeMillis();
        System.out.println("————————————————————————————————————————这是分割线————————————————————————————————————————");
        System.out.println("共处理"+soList.size()+"条数据，使用时间为"+(beginTime-endTime));
    }


    /**
     * 根据区域处理数据信息
     * @param view
     * @return
     * @throws ParseException
     */
    @RequestMapping("/analysisShanghaiDataByRegion")
    @Transactional
    public ModelAndView analysisShanghaiDataByRegion(ModelAndView view) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = df.parse("2017-03-31");
        Date endDate = df.parse("2017-04-03");
        Long beginTime = System.currentTimeMillis();
        Long countList = 0l;
        //遍历生成所有区域的空对象
        List<SecondhandhouseNew> secondhandhouseNewList = new ArrayList<SecondhandhouseNew>();
        for(RegionShanghaiEnum regionShanghaiEnum: RegionShanghaiEnum.values()){
            DataCountByRegion dataCountByRegion = new DataCountByRegion();
            dataCountByRegion.setRegionCode(regionShanghaiEnum.getCode());
            dataCountByRegion.setRegionName(regionShanghaiEnum.getDesc());
            //查询单一区域数据信息
            secondhandhouseNewList = secondhandhouseNewService.findByRegionNameAndDate(beginDate,endDate,regionShanghaiEnum.getDesc());
            Double totalPriceAmount = 0.0;
            Double averagePriceAmount = 0.0;
            Long attentionNumAmount = 0l;
            Long number = 0l;
            if(secondhandhouseNewList.size() > 0){
                for(SecondhandhouseNew secondhandhouseNew: secondhandhouseNewList){
                    totalPriceAmount = MathUtil.add(totalPriceAmount, secondhandhouseNew.getTotalPrice());
                    averagePriceAmount = MathUtil.add(averagePriceAmount,secondhandhouseNew.getAveragePrice());
                    attentionNumAmount = attentionNumAmount + secondhandhouseNew.getAttentionNumber();
                    countList += 1;
                    number += 1;
                }
                dataCountByRegion.setAverageTotalPrice(totalPriceAmount / secondhandhouseNewList.size());
                dataCountByRegion.setAveragePerPrice(averagePriceAmount / secondhandhouseNewList.size());
                dataCountByRegion.setAttentionNumber(attentionNumAmount / secondhandhouseNewList.size());
                dataCountByRegion.setNumber(number);
                dataCountByRegion.setCaptureTime(DateUtils.addDay(beginDate, 1));
                dataCountByRegionService.save(dataCountByRegion);
            }
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("————————————————————————————————————————这是分割线————————————————————————————————————————");
        System.out.println("共处理"+countList+"条数据，使用时间为"+(beginTime-endTime));
        view.setViewName("index");
        return view;
    }

    @RequestMapping("/dealStation")
    @Transactional
    public void dealStation() throws ParseException{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = df.parse("2017-03-31");
        Date endDate = df.parse("2017-04-03");
        Long beginTime = System.currentTimeMillis();
        Long countList = 0l;
        List<SecondhandhouseNew> secondhandhouseNewList = secondhandhouseNewService.getByDate(beginDate, endDate);
        //地铁站点集合
        //List<ShanghaiMetroStationDetails> shanghaiMetroStationDetailses = new ArrayList<ShanghaiMetroStationDetails>();
        String stationName = null;
        //获取所有数据的 交通信息坐标
        List<String> trafficLocationList = new ArrayList<String>();
        String trafficLocation = null;
        Map<String,String> stationMapInsert = new HashMap<>();
        String[] stationNames = new String[]{};
        for(SecondhandhouseNew secondhandhouseNew : secondhandhouseNewList){
            //获取每条数据的交通信息
            //判断信息的有无
            if( null != secondhandhouseNew.getTrafficLocation()){
                trafficLocation = secondhandhouseNew.getTrafficLocation();
                //遍历地铁站点集合，并且去重
                stationName = this.splitTrafficLocation(trafficLocation);
                //将该stationMap，与stationMapList 中的元素对比，并且生成新的stationMap，存入与stationMapList中
                if(!stationMapInsert.containsKey(stationName)){
//                    stationMapInsert.put(stationName)
                }
            }
        }
    }

    /**
     * 拆解交通信息
     * @param trafficLocation
     * @return
     */
    public String splitTrafficLocation(String trafficLocation){
        List<String> stationInfo = new ArrayList<>();
        //距离8号线成山路站531米
        String stationName = trafficLocation.substring(
                trafficLocation.indexOf("线"),trafficLocation.indexOf("站")
        );
        return stationName;
    }

}
