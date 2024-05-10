//
//  Plugin1.h
//  HelloCordova
//
//  Created by André Gonçalves on 20/09/2023.
//

#import <Cordova/CDV.h>

@interface Plugin1 : CDVPlugin {
  // Member variables go here.
}

- (void)coolMethod:(CDVInvokedUrlCommand*)command;
- (void)coolMethod2:(CDVInvokedUrlCommand*)command;
@end
