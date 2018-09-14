# Weex

A framework for building Mobile cross-platform UI.

Support Android 4.1 (API 16) and iOS 7.0+.

## 第0步：安装Node.js

* `sudo npm install -g n`, 安装n模块
* `n latest`, (如果要指定6.0+ `sudo n 6.*`)

## 第1步：安装weex-toolkit

* `npm install -g weex-toolkit`

## 第2步：下载Weex源码

* `git clone https://github.com/KalicyZhou/weex-example.git`

## 第3步：运行Weex源码

* Under project root
    * `npm install`, 安装此项目依赖，如果此项目已经安装过，package.json也没有更新过，可以不用再执行
    * `./start`，第一运行调用此命令进行打包js bundle。如果js已经打包过且没有更新，可直接运行`npm run serve`。
    
### HTML5

* Visit http://127.0.0.1:12580/ or http://[your local ip]:12580/ in Safari

### iOS

* Prerequisites
    * Install [iOS Environment](https://developer.apple.com/library/ios/documentation/IDEs/Conceptual/AppStoreDistributionTutorial/Setup/Setup.html)
    * Install [CocoaPods](https://guides.cocoapods.org/using/getting-started.html)
* Run playground
    * `cd ios/playground`
    * `pod install`
    * Open `WeexDemo.xcworkspace` in Xcode
    * Click <img src="http://img1.tbcdn.cn/L1/461/1/5470b677a2f2eaaecf412cc55eeae062dbc275f9" height="16" > (`Run` button) or use default shortcut `cmd + r` in Xcode
    * If you want to run the demo on your device, don't need to modify `CURRENT_IP` manually. ~~In `DemoDefine.h`(you can search this file by Xcode default shortcut `cmd + shift + o`), modify `CURRENT_IP` to your local IP~~
* [Add an example](./examples/README.md#add-an-example)

### Android

* Prerequisites
  * Install [Android Environment](http://developer.android.com/training/basics/firstapp/index.html)
* Run playground, In Android Studio
    * Open `android/playground`
    * In `app/java/com.alibaba.weex/IndexActivity`, modify `CURRENT_IP` to your local IP
    * Click <img src="http://gtms04.alicdn.com/tps/i4/TB1wCcqMpXXXXakXpXX3G7tGXXX-34-44.png" height="16" > (`Run` button)
* [Add an example](./examples/README.md#add-an-example)

 #### issue
 * 请不要使用sudo进行安装，关于npm 取消sudo进行全局模块的安装你可以使用下面的命令：
    ``` bash
    sudo chmod 777 /usr/local/lib/node_modules
    ```
    
   * [消除mac下npm全局安装使用sudo命令](http://www.jackpu.com/xiao-chu-macxia-npmquan-ju-an-zhuang-shi-yong-sudoming-ling/)
   
 * Error:permission denied.Please apply the write premission to the directory: "/Users/yourUserName"
   * 如果遇见了上诉问题，你可以运行 `sudo chmod 777 ~` or `mkdir ~/.xtoolkit&chmod 777 .xtoolkit` 来解决

 * Android Studio continues to get a Unsupported major.minor version 52.0
   * Check your SDK location in Android Studio:
   * File->Project Structure->SDK Location
   * Set JDK location: /Applications/Android Studio.app/Contents/jre/jdk/Contents/Home

