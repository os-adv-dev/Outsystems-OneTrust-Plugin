var fs = require('fs');
var path = require('path');

module.exports = function(context) {

    var ConfigParser = require('cordova-common').ConfigParser;
    var config = new ConfigParser('config.xml');
    
    // Get the value of your preference from config.xml
    var fontPreference = config.getPreference('CustomFontFile');
    var appName = config.name();

    if (fontPreference) {
        // Split the fontPreference by comma (or any other delimiter if needed)
        var fonts = fontPreference.split(',');

        // Modify this path according to your project structure
        var plistFilePath = path.join(context.opts.projectRoot, 'platforms', 'ios', appName, appName + '-Info.plist');

        fs.readFile(plistFilePath, 'utf8', function (err, data) {
            if (err) {
                throw new Error('Unable to find Info.plist: ' + err);
            }

            var fontTags = '';
            fonts.forEach(function (font) {
                fontTags += '<string>' + font.trim() + '</string>\n';
            });

            // Check if UIAppFonts key exists
            if (data.includes('<key>UIAppFonts</key>')) {
                // If it exists, append font tags to the existing array
                var pattern = /<key>UIAppFonts<\/key>\s*<array>([\s\S]*?)<\/array>/;
                data = data.replace(pattern, function (match, p1) {
                    return '<key>UIAppFonts</key>\n<array>\n' + fontTags + p1 + '</array>';
                });
            } else {
                // If it doesn't exist, create a new UIAppFonts key with font tags
                var insertionPoint = data.lastIndexOf('</dict>');
                if (insertionPoint !== -1) {
                    data = data.slice(0, insertionPoint) + '<key>UIAppFonts</key>\n<array>\n' + fontTags + '</array>\n' + data.slice(insertionPoint);
                }
            }

            // Write back to the Info.plist file
            fs.writeFile(plistFilePath, data, 'utf8', function (err) {
                if (err) {
                    throw new Error('Unable to write Info.plist: ' + err);
                }
            });
        });
    }
};