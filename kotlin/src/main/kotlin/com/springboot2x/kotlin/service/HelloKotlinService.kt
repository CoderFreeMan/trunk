package com.springboot2x.kotlin.service

import org.springframework.stereotype.Service
import com.springboot2x.kotlin.entity.HelloKotlinEntity

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
@Service
class HelloKotlinService {

    fun sun(numa: Int, numb: Int): Int {
        var helloKotlinEntity = HelloKotlinEntity()
        helloKotlinEntity.id = 2
        helloKotlinEntity.name = "yangdj"
        println(helloKotlinEntity.toString())
        var numa = 2 + numb
        numa += numa
        return numa + numb
    }

}