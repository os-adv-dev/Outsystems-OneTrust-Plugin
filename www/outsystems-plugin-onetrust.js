var exec = require("cordova/exec");

exports.onCreate = function (arg0, success, error) {
	exec(success, error, "OutsystemsPluginOneTrust", "onCreate", [arg0]);
};
