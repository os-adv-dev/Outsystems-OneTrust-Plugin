import Foundation
import OTPublishersHeadlessSDK

extension AppDelegate : UIConfigurator{ 
    
    open override func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        
        OTPublishersHeadlessSDK.shared.uiConfigurator = self
        
        return super.application(application, didFinishLaunchingWithOptions: launchOptions);
    }
    
    public func shouldUseCustomUIConfig() -> Bool {
        return true;
    }
    
    public func customUIConfigFilePath() -> String? {
        let customPath = Bundle.main.path(forResource: getCustomConfigFileName(), ofType: "plist")
        return customPath
    }

    private func getCustomConfigFileName() -> String {
        var filename: String = "OTSDK-UIConfig-iOS"
        return filename
    }
}
