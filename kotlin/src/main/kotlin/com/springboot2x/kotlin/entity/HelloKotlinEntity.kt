package com.springboot2x.kotlin.entity

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
class HelloKotlinEntity {

    var id: Int = 1

    var name: String = "ydj"

    override fun toString(): String {
        return "HelloKotlinEntity(id=$id, name='$name')"
    }

}