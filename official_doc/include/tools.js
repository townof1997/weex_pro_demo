exports.methods = {
    getParameterByName: function(name, url) {
        if (!url) url = window.location.href;
        name = name.replace(/[\[\]]/g, "\\$&");
        var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
            results = regex.exec(url);
        if (!results) return null;
        if (!results[2]) return '';
        return decodeURIComponent(results[2].replace(/\+/g, " "));
    },
    getIntParameterByName: function(name, url) {
        if (!url) url = window.location.href;
        name = name.replace(/[\[\]]/g, "\\$&");
        var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
            results = regex.exec(url);
        if (!results) return null;
        if (!results[2]) return '';
        return parseInt(decodeURIComponent(results[2].replace(/\+/g, " ")));
    },
    setNavBarHeight: function(vm) {
        vm.$getConfig(function(config) {
            var env = config.env;
            if (env.platform == 'iOS') {
                var scale = env.scale;
                var deviceWidth = env.deviceWidth / scale;
                vm.navBarHeight = 64.0 * 750.0 / deviceWidth;
            }
        }.bind(vm));
    },
    push: function(navigator, baseURL, eurl) {
        // var navigator = require('@weex-module/navigator');
        // var getBaseURL = baseUrl.getBaseURL;
        // var baseURL = getBaseURL(vm);
        var url;
        if (typeof window !== 'object') {
            url = baseURL + eurl;
            // console.log("url的值是:"+url);
        }
        var params = { 'url': url }
            // console.log('push url', url);
        navigator.push(params, function(e) {});
    },
    pop: function(navigator) {
        var params = {
            animated: 'false'
        };
        navigator.pop(params, function() {});
    },

    getPlatform: function() {
        var env = weex.config.env;
        if (env.platform == 'iOS') {
            return "ios";
        } else {
            return "android";
        }
    },
}