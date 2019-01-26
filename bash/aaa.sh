#!/bin/sh
#使用系统环境变量
source /etc/profile

LANG=zh_CN.utf-8
#这是android中的versonName， 我们用版本号来填充
version=$1
#andorid配置文件中的版本号，新版本必须比旧版本高
versionCode=$2
buildAll=$3
apps=$4
WORKSPACE=$5
withoutApps=$6
mainCustomizedDomain=$7
MINSDKVERSION=$8
CROSSWALKVERSION=$9
CPUARCH_ARM=${10}
CPUARCH_X86=${11}

echo ${apps}
function build_customize_apk(){
	echo 4
	appName=$1

    echo "====================Start build ${appName}===================="
    echo "kill all the gradle process"
    threadId=$(ps aux | grep -e gradle | grep -v grep | awk '{print $2}');
	if [ "${threadId}" == "0" ] || [ "${threadId}" == "" ]; then
    	echo "gradle process is not exist.";
	else
    	echo "${threadId} will be killed.";
    	kill -9 $threadId;
	fi
    cd ${WORKSPACE}/dajia
    #从配置文件中取所需参数的值
	configPath=${WORKSPACE}/../dajia_checkout_source/customizeApps/${appName}/android
    customConfigPath=$configPath/customization.config
	app_name=`sed '/^app_name=/!d;s/.*=//' $customConfigPath`
	app_type=`sed '/^app_type=/!d;s/.*=//' $customConfigPath`
	package=`sed '/^package=/!d;s/.*=//' $customConfigPath`

	#将自定义的包名转换成目录格式
    if [ "${appName}" = !"088信义嘉庭" ]; then
	  echo "将自定义的包名转换成目录格式"
       subdir=`echo $package | sed 's/\./\//g'`
       echo $subdir
	fi


    customizedDomain=`sed '/^customizedDomain=/!d;s/.*=//' $customConfigPath`
	bak_path=${configPath}/custormApp
	sed -i "/app.type/capp.type=${app_type}" ${WORKSPACE}/dajia/dajia/src/main/assets/configfile.properties
	#更改定制域名
    if [[ ${mainCustomizedDomain} != "" ]]; then
    	if [ ${appName} = "083鼎捷" ]; then
        sed -i "/mobile.host=/cmobile.host=${mainCustomizedDomain}"  ${WORKSPACE}/dajia/dajia/src/main/assets/configfile.properties
        else
        sed -i "/mobile.host=/cmobile.host=${mainCustomizedDomain}/dajia_mobile"  ${WORKSPACE}/dajia/dajia/src/main/assets/configfile.properties
        fi
    elif  [[ ${mainCustomizedDomain} = "" ]] && [[ ${customizedDomain} != "" ]]; then
    	sed -i "/mobile.host=/cmobile.host=${customizedDomain}/dajia_mobile"  ${WORKSPACE}/dajia/dajia/src/main/assets/configfile.properties
    else
    	sed -i "/mobile.host=/cmobile.host=https://m.dajiashequ.com/dajia_mobile"  ${WORKSPACE}/dajia/dajia/src/main/assets/configfile.properties
    fi

    #把录音背景音乐删掉
    if [[ -f ${WORKSPACE}/dajia/dajia/src/main/res/raw/bgm1.mp3 ]]; then
    	cd  ${WORKSPACE}/dajia/dajia/src/main/res/raw/
        rm -rf bgm1.mp3 bgm2.mp3 bgm3.mp3 bgm4.mp3 bgm5.mp3 bgm6.mp3 bgm7.mp3
    fi

    #把视频删掉
    if [[  -f ${WORKSPACE}/dajia/dajia/src/main/res/raw/media.mp4 ]]; then
    	cd  ${WORKSPACE}/dajia/dajia/src/main/res/raw/
        rm -rf media.mp4
    fi

    #拷贝素材到其他目录做备份
    cd ${WORKSPACE}
    if [[ ! -d ${WORKSPACE}/picture_backup ]];then
    	mkdir picture_backup
    fi
    cp -rf ${WORKSPACE}/dajia/dajia/src/main/res/drawable-hdpi ${WORKSPACE}/picture_backup
    cp -rf ${WORKSPACE}/dajia/dajia/src/main/res/drawable-xhdpi ${WORKSPACE}/picture_backup

    #移除掉下拉图片
    if [[ -f ${WORKSPACE}/dajia/dajia/src/main/res/drawable-hdpi/xlistview_header_bg.png ]];then
    	rm -rf ${WORKSPACE}/dajia/dajia/src/main/res/drawable-hdpi/xlistview_header_bg.png
    fi
    \cp -f ${configPath}/customization.xml ${WORKSPACE}/dajia/dajia/src/main/res/values
    #替换图片
    \cp -f ${configPath}/logo/drawable-hdpi/* ${WORKSPACE}/dajia/dajia/src/main/res/drawable-hdpi
    \cp -f ${configPath}/logo/drawable-xhdpi/* ${WORKSPACE}/dajia/dajia/src/main/res/drawable-xhdpi
    #如果是父母社区（静等花开），就把录音背景音乐替换掉
    if [ "${appName}" = "020父爱基金" ]; then
    	\cp -rf ${configPath}/raw/*  ${WORKSPACE}/dajia/dajia/src/main/res/raw/
    fi

    #如果是菲灵中国（望子），就把视频加进去
    if [ "${appName}" = "049菲灵中国" ]; then
    	\cp -rf ${configPath}/raw/*  ${WORKSPACE}/dajia/dajia/src/main/res/raw/
    fi

    #如果是袋鼠管家，需要把换社区换成换小区
    if [ "${appName}" = "041袋鼠管家" ]; then
    	find ${WORKSPACE}/dajia/dajia/src/main/res/values -name 'strings.xml' -print0 | xargs -0 perl -pi -e 's/换社区/换小区/g'
    fi

	#如果是师生桥，需要把换社区换成找老师
    if [ "${appName}" = "060师生桥" ]; then
    	find ${WORKSPACE}/dajia/dajia/src/main/res/values -name 'strings.xml' -print0 | xargs -0 perl -pi -e 's/换社区/找老师/g'
    fi

    #如果是金通内务（金通盟），替换customization_kekai.xml文件
    if [ "${appName}" = "069金通内务" ]; then
    	\cp -rf ${configPath}/customization_kekai.xml ${WORKSPACE}/dajia/dajia/src/main/res/values/customization_kekai.xml
    fi
    #如果是信义嘉庭，将收藏替换成关注并替换打包签名文件
    if [ "${appName}" = "088信义嘉庭" ]; then
	    sed -i 's/收藏/关注/g' `grep 收藏 -rl ${WORKSPACE}/dajia/dajia/`
    fi
	#如果是阳光E居或者信义，替换dajiakey文件
	if [[ "${appName}" = "132阳光E居" ]] || [[ "${appName}" = "088信义嘉庭" ]] || [[ "${appName}" = "166好生活" ]]; then
	sed -i '100,$d' ${configPath}/build.gradle
	sed -n '100,500p'  ${WORKSPACE}/dajia/dajia/build.gradle >> ${configPath}/build.gradle
	\cp -rf ${configPath}/build.gradle ${WORKSPACE}/dajia/dajia/build.gradle
    fi


    #更改包名
    cd ${WORKSPACE}/dajia/dajia/
	find . -name 'gradle.properties' -print0 | xargs -0 perl -pi -e "s/com.dajia.view.test/${package}/g"
	find . -name '*.java' -print0 | xargs -0 perl -pi -e "s/com.dajia.view.test/${package}/g"
	find . -name '*.xml' -print0 | xargs -0 perl -pi -e "s/com.dajia.view.test/${package}/g"
    find . -name 'WXEntryActivity.java' -print0 | xargs -0 perl -pi -e "s/com.dajia.view.wxapi/${package}.wxapi/g"

    #更改XWalk版本
    #最小SDK版本crosswalk19对应14 crosswalk22对应16
    echo "********MINSDKVERSION=${MINSDKVERSION}"
    if [[ ${MINSDKVERSION} != "" ]]; then
    	sed -i "s/MINSDKVERSION=.*/MINSDKVERSION=${MINSDKVERSION}/g" ${WORKSPACE}/dajia/dajia/gradle.properties
    fi
	#CrossWalk版本配置 19版本：19.49.514.5 22版本：22.52.561.4
    echo "********CROSSWALKVERSION=${CROSSWALKVERSION}"
    if [[ ${CROSSWALKVERSION} != "" ]]; then
    	sed -i "s/CROSSWALKVERSION=.*/CROSSWALKVERSION=${CROSSWALKVERSION}/g" ${WORKSPACE}/dajia/dajia/gradle.properties
    fi
	#客户端适配设备CPU架构(armeabi-v7a或者x86)
    echo "********CPUARCH_ARM=${CPUARCH_ARM}"
    if [[ ${CPUARCH_ARM} != "" ]]; then
      sed -i "s/CPUARCH_ARM=.*/CPUARCH_ARM=${CPUARCH_ARM}/g" ${WORKSPACE}/dajia/dajia/gradle.properties
    else
      sed -i "s/CPUARCH_ARM=.*/CPUARCH_ARM=/g" ${WORKSPACE}/dajia/dajia/gradle.properties
    fi
    echo "********CPUARCH_X86=${CPUARCH_X86}"
    if [[ ${CPUARCH_X86} != "" ]]; then
     sed -i "s/CPUARCH_X86=.*/CPUARCH_X86=${CPUARCH_X86}/g" ${WORKSPACE}/dajia/dajia/gradle.properties
    else
     sed -i "s/CPUARCH_X86=.*/CPUARCH_X86=/g" ${WORKSPACE}/dajia/dajia/gradle.properties
    fi


    #更改版本号
    sed -i "s/android:versionName=\".*\"/android:versionName=\"${version}\"/g" ${WORKSPACE}/dajia/dajia/src/main/AndroidManifest.xml
	#更改version code
	sed -i "s/android:versionCode=\".*\"/android:versionCode=\"${versionCode}\"/g" ${WORKSPACE}/dajia/dajia/src/main/AndroidManifest.xml
	#更改buildversion
    sed -i "s/name=\"buildVersion\">1/name=\"buildVersion\">${BUILD_NUMBER}/g" ${WORKSPACE}/dajia/dajia/src/main/res/values/customization.xml
	#更改版本号
    sed -i "s/android:name=\"BUGLY_APP_VERSION\" android:value=\".*\"/android:name=\"BUGLY_APP_VERSION\" android:value=\"${version}\"/g" ${WORKSPACE}/dajia/dajia/src/main/AndroidManifest.xml

	cd ${WORKSPACE}/dajia/dajia
	if [[ "${app_name}" != "test" ]] || [[ "${app_name}" != "088信义嘉庭" ]]; then
	    mv -f src/main/java/com/dajia/view/test src/main/java/com/dajia/view/${app_name}
	else
		if [ "${app_name}" = "088信义嘉庭" ]; then
	       mkdir -p src/main/java/$subdir && mv -f src/main/java/com/dajia/view/test/* "$_"
		fi
    fi

	#exit 1
	gradle clean assembleRelease

	#if [[ -d ${WORKSPACE}/dajia/svnInfo ]]; then
    #	rm -rf ${WORKSPACE}/dajia/svnInfo
    #fi
    #备份被更改的配置文件
	cd ${WORKSPACE}/dajia
    touch svnInfo;
    echo "############################" >> svnInfo
    echo "jenkins_buildnumber: ${BUILD_NUMBER}" >> svnInfo
    echo "branch: ${SVN_URL_1}" >> svnInfo
    echo "branch version: ${SVN_REVISION_1}" >> svnInfo
	echo "package name: ${package}" >> svnInfo

	zip -r ${appName}.zip svnInfo;
	zip -r ${appName}.zip dajia/src/main/AndroidManifest.xml;
	zip -r ${appName}.zip dajia/src/main/res/values/strings.xml;
	zip -r ${appName}.zip dajia/gradle.properties;
	zip -r ${appName}.zip dajia/src/main/res/values/customization.xml;
    zip -r ${appName}.zip dajia/src/main/assets/configfile.properties;

    #将构建的包和被更改的配置文件上传到249机器上
    if [[ "${appName}" = "001抢先版" ]] || [[ "${appName}" = "001抢先定制版" ]] || [[ "${appName}" = "005市场版" ]]; then
    	workspaceApkFile=${WORKSPACE}/dajia/dajia/build/outputs/apk/dajia_${version}.apk
    else
    	workspaceApkFile=${WORKSPACE}/dajia/dajia/build/outputs/apk/${app_name}_${version}.apk
    fi

    cd ${WORKSPACE}/dajia/dajia/build/outputs/apk
    mkdir -p ${version}/Android/${appName}/ConfigFile
    mv ${WORKSPACE}/dajia/dajia/build/outputs/apk/dajia-release.apk ${workspaceApkFile}
	mv ${workspaceApkFile} ${WORKSPACE}/dajia/dajia/build/outputs/apk/${version}/Android/${appName}/
    cd ${WORKSPACE}/dajia
    mv *.zip ${WORKSPACE}/dajia/dajia/build/outputs/apk/${version}/Android/${appName}/ConfigFile/
	scp -P22345 -r ${WORKSPACE}/dajia/dajia/build/outputs/apk/${version} root@192.168.1.249:/dajia-apps/

    #还原被更改的文件
    cd ${WORKSPACE}/dajia/dajia
    if [ "${app_name}" != "test" ]; then
    	mv -f src/main/java/com/dajia/view/${app_name} src/main/java/com/dajia/view/test
    fi
    cd ${WORKSPACE}/dajia/dajia
	find . -name 'gradle.properties' -print0 | xargs -0 perl -pi -e "s/${package}/com.dajia.view.test/g"
	find . -name '*.java' -print0 | xargs -0 perl -pi -e "s/${package}/com.dajia.view.test/g"
	find . -name '*.xml' -print0 | xargs -0 perl -pi -e "s/${package}/com.dajia.view.test/g"
    find . -name 'WXEntryActivity.java' -print0 | xargs -0 perl -pi -e "s/${package}.wxapi/com.dajia.view.wxapi/g"

    #还原素材文件
    cp -rf ${WORKSPACE}/picture_backup/drawable-hdpi/* ${WORKSPACE}/dajia/dajia/src/main/res/drawable-hdpi
    cp -rf ${WORKSPACE}/picture_backup/drawable-xhdpi/* ${WORKSPACE}/dajia/dajia/src/main/res/drawable-xhdpi

    #如果是父母社区（静等花开），就把录音背景音乐删掉
    if [ "${appName}" = "020父爱基金" ]; then

    	cd  ${WORKSPACE}/dajia/dajia/src/main/res/raw/
        rm -rf bgm1.mp3 bgm2.mp3 bgm3.mp3 bgm4.mp3 bgm5.mp3 bgm6.mp3 bgm7.mp3
    fi

    #如果是菲灵中国（望子），就把视频加进去
    if [ "${appName}" = "049望子" ]; then
    	cd  ${WORKSPACE}/dajia/dajia/src/main/res/raw/
        rm -rf media.mp4
    fi

	#如果是袋鼠管家，需要把换社区换成换小区
    if [ "${appName}" = "041袋鼠管家" ]; then
    	find ${WORKSPACE}/dajia/dajia/src/main/res/values -name 'strings.xml' -print0 | xargs -0 perl -pi -e 's/换小区/换社区/g'
    fi

	#如果是师生桥，需要把换社区换成找老师
    if [ "${appName}" = "060师生桥" ]; then
    	find ${WORKSPACE}/dajia/dajia/src/main/res/values -name 'strings.xml' -print0 | xargs -0 perl -pi -e 's/找老师/换社区/g'
    fi
    echo "kill all the gradle process"
    threadId=$(ps aux | grep -e gradle | grep -v grep | awk '{print $2}');
	if [ "${threadId}" == "0" ] || [ "${threadId}" == "" ]; then
    	echo "${threadId} is not exist.";
	else
    	echo "${threadId} will be killed.";
    	kill -9 $threadId;
	fi
}

function multi_build_customize_apks(){
#apps=$1
#buildAll=$2

declare -a firstArray
declare -a lastArray
declare -a withoutArray
declare -i i=0
declare -i j=0
declare -i z=0
#获取要构建的apk的文件夹的名称
echo 3
if [[ ${apps} != "" ]]; then
	customPath=${WORKSPACE}/../dajia_checkout_source/customizeApps
	cd ${customPath}
    for file in 0*
    do
    	echo ${file}
    	flag=false
        for app in ${apps[*]}
        do
            echo ${app}
        	if [[ ${file} =~ ${app} ]]; then
            	firstArray[$i]=${file}
                i=`expr $i + 1`
                flag=true
                break
            fi
        done
        if [ ${flag} == false ]; then
        	lastArray[$j]=${file}
            j=`expr $j + 1`
        fi
    done
else
	cd ${customPath}
	for file in 0*
    do
    	lastArray[$j]=${file}
        j=`expr $j + 1`
    done
fi
#获取不需要构建的文件夹的名称
if [[ ${withoutApps} != "" ]]; then
	cd ${customPath}
    for file in [0-3]*
    do
    	flag=false
        for app in ${withoutApps[*]}
        do
        	if [[ ${file} =~ ${app} ]]; then
            	withoutArray[$i]=${file}
                i=`expr $i + 1`
                flag=true
                break
            fi
        done
    done
fi
#构建apk
if [[ "${buildAll}" = "true" ]] && [[ ${apps} != "" ]]; then
   	for app in ${firstArray[*]}
  	do
    	if [[ ${withoutArray[*]} =~ "${app}" ]]; then
    		continue
    	else
    		if [[ -f ${customPath}/${app}/android/customization.xml ]]; then
    			build_customize_apk $app
    		fi
    	fi
    done
    for app in ${lastArray[*]}
  	do
    	if [[ ${withoutArray[*]} =~ "${app}" ]]; then
    		continue
    	else
    		if [[ -f ${customPath}/${app}/android/customization.xml ]]; then
    			build_customize_apk $app
    		fi
    	fi
    done
elif [[ "${buildAll}" = "true" ]] && [[ ${apps} = "" ]]; then
	for app in ${lastArray[*]}
    do
    	if [[ ${withoutArray[*]} =~ "${app}" ]]; then
    		continue
    	else
    		if [[ -f ${customPath}/${app}/android/customization.xml ]]; then
    			build_customize_apk $app
    		fi
    	fi
    done
elif [[ "${buildAll}" = "false" ]] && [[ ${apps} != "" ]]; then
echo 1
echo ${firstArray[*]}
	for app in ${firstArray[*]}
    do
    	if [[ ${withoutArray[*]} =~ "${app}" ]]; then
        	echo 12
    		continue
    	else
        echo 2
    		if [[ -f ${customPath}/${app}/android/customization.xml ]]; then
	            echo 3
    			build_customize_apk $app
    		fi
    	fi
    done
else
echo "don't need to build"
fi

}

multi_build_customize_apks