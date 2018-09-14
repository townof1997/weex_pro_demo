//
//  AppDelegate+Weex.m
//  BXProject
//
//  Created by Kalicy on 17/5/10.
//  Copyright © 2017年 Kalicy. All rights reserved.
//

#import "AppDelegate+Weex.h"
#import "BXWeexDefine.h"
#import "BXWXViewController.h"
#import "WXImgLoaderDefaultImpl.h"
#import "WXEventModule.h"
#import <WeexSDK/WeexSDK.h>

@implementation AppDelegate (Weex)

#pragma mark weex
+ (void)load {
    // init WeexSDK
    [WXSDKEngine initSDKEnvironment];
    
    [WXSDKEngine registerHandler:[WXImgLoaderDefaultImpl new] withProtocol:@protocol(WXImgLoaderProtocol)];
    [WXSDKEngine registerHandler:[WXEventModule new] withProtocol:@protocol(WXEventModuleProtocol)];
    
    [WXSDKEngine registerComponent:@"select" withClass:NSClassFromString(@"WXSelectComponent")];
    [WXSDKEngine registerModule:@"event" withClass:[WXEventModule class]];
    
#if !(TARGET_IPHONE_SIMULATOR)
    [self checkUpdate];
#endif
    
#ifdef DEBUG
    [WXDebugTool setDebug:YES];
    [WXLog setLogLevel:WXLogLevelLog];
    
#else
    [WXDebugTool setDebug:NO];
    [WXLog setLogLevel:WXLogLevelError];
#endif
}

#pragma mark weex
- (void)setupWeex
{
    // 注册拦截请求的NSURLProtocol
    NSURL *url = nil;
#if DEBUG
    //If you are debugging in device , please change the host to current IP of your computer.
    url = [NSURL URLWithString:HOME_URL];
#else
    url = [NSURL URLWithString:HOME_URL];
#endif
    
#ifdef UITEST
    url = [NSURL URLWithString:UITEST_HOME_URL];
#endif
    UINavigationController* nav = (UINavigationController*)[[UIApplication sharedApplication] delegate].window.rootViewController;
    BXWXViewController *viewController = (BXWXViewController*)nav.topViewController;
    [viewController setSourceURL:url];
}

@end
