var exec = require('cordova/exec');

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'Plugin1', 'coolMethod', [arg0]);
};

exports.coolMethod2 = function (arg0, success, error) {
    exec(success, error, 'Plugin1', 'coolMethod2', [arg0]);
};

exports.coolMethodKotlin = function (arg0, success, error) {
    exec(success, error, 'Plugin1Kotlin', 'coolMethodKotlin', [arg0]);
};

exports.coolMethod2Kotlin = function (arg0, success, error) {
    exec(success, error, 'Plugin1Kotlin', 'coolMethod2Kotlin', [arg0]);
};
