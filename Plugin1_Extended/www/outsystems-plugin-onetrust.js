var exec = require('cordova/exec');

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'Plugin1_Extended', 'coolMethod', [arg0]);
};

exports.coolMethodKotlin = function (arg0, success, error) {
    exec(success, error, 'Plugin1Kotlin_Extended', 'coolMethodKotlin', [arg0]);
};

