package cn.dataAnalysis.service;


import cn.dataAnalysis.model.ShanghaiMetroStationDetails;

import java.util.List;

/**
 * Created by admin on 2017/4/6.
 */
public interface ShanghaiMetroStationDetailsService {

    ShanghaiMetroStationDetails save(ShanghaiMetroStationDetails shanghaiMetroStationDetails);

    List<ShanghaiMetroStationDetails> findAll();

}
