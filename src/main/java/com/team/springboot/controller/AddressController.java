package com.team.springboot.controller;

import com.team.springboot.pojo.Address;
import com.team.springboot.pojo.BaseResponse;
import com.team.springboot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AddressController {
    @Autowired
    AddressService addressService;

    @RequestMapping("/addressUpdate")
    @ResponseBody
    public BaseResponse addressUpdate(@RequestBody Address a, HttpSession session){
        BaseResponse<Integer> baseResponse = new BaseResponse<Integer>();
        String a_Account = (String) session.getAttribute("u_Account");
        a.setA_Account(a_Account);

        if(a.getA_Address1().equals(a.getA_Address2()) || a.getA_Address1().equals(a.getA_Address3())
                || a.getA_Address1().equals(a.getA_Address4()) || a.getA_Address2().equals(a.getA_Address3())
                || a.getA_Address2().equals(a.getA_Address4()) || a.getA_Address3().equals(a.getA_Address4())){
            baseResponse.setCode(500);
            baseResponse.setMsg("保存失败！收货地址相同");
            return baseResponse;
        }

        addressService.updateAddressByAccount(a);

        baseResponse.setCode(200);
        baseResponse.setMsg("保存成功");
        return baseResponse;
    }
}
