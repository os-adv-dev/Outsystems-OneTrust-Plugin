var exec = require('cordova/exec');

exports.getToken = function (success, error) {
    exec(success, error, 'FirebaseFCM_SalesforceCM', 'getToken');
};

exports.coolMethodKotlin = function (arg0, success, error) {
    exec(success, error, 'Plugin1Kotlin_Extended', 'coolMethodKotlin', [arg0]);
};

