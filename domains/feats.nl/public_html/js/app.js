//Filename: app.js
define([
    'jQuery', 'underscore', 'backbone', 'controller/Router', 'webTicker'
], function ($, _, Backbone, router) {

    var App = Backbone.View.extend({
        fillContent: function (urlString, elem) {
            elem = elem === undefined ? "#Content" : elem;
            this.doAjax(urlString, function(data) {
                try {
                    var json = $.parseJSON(data);
                    $(elem).empty().html(json.get("404"));
                } catch (e) {
                    $(elem).empty().html(data);
                }
            });
        },

        doAjax: function (urlString, callback) {
            var result = "";
            $.ajax({
                url: urlString,
                cache: false,
                beforeSend: function (xhr) {
                    xhr.overrideMimeType("text/html");
                }
            }).done(function data(data, textStatus, xhr) {
                    callback(data);
                }).fail(function error() {
                    callback({"404" : "Unfortunately the information you're looking for cannot be retrieved..."});
                });
            return result;
        },

        toggle: function (elem, marginLeft) {
            if (elem.style.marginTop == "-100%") {
                this.diminish(elem);
            } else {
                this.enlarge(elem, marginLeft);
            }
        },

        enlarge: function (elem, marginLeft) {
            var anim = {
                height: "300%",
                position: "absolute",
                top: "10%",
                left: "10%",
                zIndex: "10000"
            };
            anim["marginLeft"] = marginLeft;
            $(elem).animate(anim, 1000);
        },

        diminish: function (elem) {
            $(elem).animate({
                position: "relative",
                top: "auto",
                left: "auto",
                height: "100%",
                marginLeft: "5px",
                marginTop: "0px",
                zIndex: "0"
            }, 1000);
        },

        render : function () {
            Backbone.history.start();
        },

        navigate : function(fragment, options) {
            router.navigate(fragment, options);
        }
    });
    return new App();
});