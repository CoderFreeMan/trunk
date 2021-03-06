package com.springboot2x.kotlin.controller

import com.springboot2x.kotlin.service.HelloKotlinService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.stereotype.Service

/**
 
 <p> Date             : 2018/12/7 </p >
 <p> Module             : </p >
 <p> Description             : </p >
 <p> Remark             : </p >
 @author yangdj
 @version 1.0
 <p>--------------------------------------------------------------</p >
 <p>修改历史</p >
 <p>    序号    日期    修改人    修改原因    </p >
 <p>    1                           </p >
 */
@RestController
@RequestMapping(value = "/kotlin")
class HelloKotlinController {

    @Autowired
    lateinit var helloKotlinService: HelloKotlinService

    @RequestMapping(value = "helloKotlin")
    fun helloKotlin(): Int {
        return helloKotlinService.sun(1, 1)
    }

}