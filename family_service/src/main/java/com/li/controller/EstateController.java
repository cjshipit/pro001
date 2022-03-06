package com.li.controller;

import com.li.bean.*;
import com.li.returnJson.ReturnObject;
import com.li.service.EstateService;
import com.li.vo.CellMessage;
import com.li.vo.UnitMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: Li
 * @Version: 1.0
 */
@Controller
public class EstateController {
    @Autowired
    private EstateService estateService;
    @ResponseBody //用json返回给前端 而不是再调用 当然你也可以自己转化字符串
    @RequestMapping("/estate/selectCompany")
    public Object selectCompany(){
        System.out.println("selectCompany");
        List<TblCompany> companies = estateService.selectCompany();
        return new ReturnObject(companies);
    }

    @ResponseBody
    @RequestMapping("/estate/insertEstate")
    public Object insertEstate(FcEstate fcEstate){
        System.out.println(fcEstate);
        System.out.println("insert estate");
        Integer result = estateService.insertEstate(fcEstate);
        if (result == 0){
            return new ReturnObject("0","房产编码已经存在");
        }else{
            return new ReturnObject("1","插入房产成功");
        }
    }

    /**
     * 此处应该完成的是楼宇的查询功能，
     * 因此再辨析的时候需要进行插入且返回插入的数据
     * @param buildingNumber
     * @param estateCode
     * @return
     */
    @ResponseBody
    @RequestMapping("/estate/selectBuilding")
    public Object selectBuilding(Integer buildingNumber,String estateCode){
        System.out.println("select building");
        List<FcBuilding> fcBuildings = estateService.selectBuilding(buildingNumber, estateCode);
        System.out.println(fcBuildings);
        return new ReturnObject(fcBuildings);
    }
    @ResponseBody
    @RequestMapping("/estate/updateBuilding")
    public Object updateBuilding(FcBuilding fcBuilding){
        System.out.println("update building");
        Integer result = estateService.updateBuilding(fcBuilding);
        if(result == 1){
            return new ReturnObject("更新楼宇成功");
        }else{
            return new ReturnObject("更新楼宇失败");
        }
    }
    @ResponseBody
    @RequestMapping("/estate/selectUnit")
    public Object selectUnit(@RequestBody UnitMessage[] unitMessages){
        System.out.println("estate selectUnit");
        List<FcUnit> allUnit = new ArrayList<>();
        for (UnitMessage unitMessage : unitMessages) {
            allUnit.addAll(estateService.selectUnit(unitMessage));
        }
        return  new ReturnObject(allUnit);
    }
    @ResponseBody
    @RequestMapping("/estate/updateUnit")
    public Object updateUnit(FcUnit fcUnit){
        Integer result = estateService.updateUnit(fcUnit);
        if(result ==1 ){
            return new ReturnObject("更新单元成功");
        }else{
            return new ReturnObject("更新单元失败");
        }
    }
    @ResponseBody
    @RequestMapping("/estate/insertCell")
    public Object insertCell(@RequestBody CellMessage[] cellMessages){
        System.out.println("insert cell");
        List<FcCell> fcCells = estateService.insertCell(cellMessages);
        return new ReturnObject(fcCells);
    }

    @RequestMapping("/estate/selectBuildingByEstate")
    public Object selectBuildingByEstate(String estateCode){
        System.out.println("estate:" + estateCode);
        List<FcBuilding> fcBuildings = estateService.selectBuildingByEstate(estateCode);
        System.out.println("---------------------");
        System.out.println(fcBuildings);
        return new ReturnObject(fcBuildings);
    }
    @ResponseBody
    @RequestMapping("/estate/selectUnitByBuildingCode")
    public Object selectUintByBuildingCode(String buildingCode){
        System.out.println("select unit");
        List<FcUnit> fcUnits = estateService.selectUnitByBuildingCode(buildingCode);
        System.out.println(fcUnits.size());
        return new ReturnObject(fcUnits);
    }
    @ResponseBody
    @RequestMapping("/estate/selectCell")
    public Object selectCell(String unitCode){
        System.out.println("select cell");
        List<FcCell> fcCells = estateService.selectCell(unitCode);
        System.out.println("-----------------");
        System.out.println(fcCells.size());
        return new ReturnObject(fcCells);

    }
    @ResponseBody
    @RequestMapping("/estate/selectEstate")
    public Object selectEstate(String company){
        System.out.println("estate company");
        List<FcEstate> fcEstates = estateService.selectEstate(company);
        return new ReturnObject(fcEstates);
    }

}
