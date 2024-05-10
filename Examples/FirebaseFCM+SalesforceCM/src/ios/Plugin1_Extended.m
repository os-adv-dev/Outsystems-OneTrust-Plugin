/********* Plugin1_Extended.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>
#import "Plugin1+Plugin1_Extended.h"

@interface Plugin1_Extended : Plugin1 {
  // Member variables go here.
}

@end

@implementation Plugin1_Extended

- (void)coolMethod:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    NSString* echo = [command.arguments objectAtIndex:0];

    if (echo != nil && [echo length] > 0) {
        [self ShowAlert:echo];
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:echo];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }

    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
