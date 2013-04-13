//Filename: app.js
define([
    'jQuery', 'webTicker'
], function ($) {
    return {
        doAjax: function (urlString) {
            $.ajax({
                url: urlString,
                cache: false,
                beforeSend: function (xhr) {
                    xhr.overrideMimeType("text/html");
                }
            }).done(function data(data, textStatus, xhr) {
                    $("#Content").empty().html(data);
                }).fail(function error() {
                    $("#Content").empty().html("404 : Unfortunately the information you're looking for cannot be retrieved...");
                });
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

        loadScript: function () {
            this.doAjax('js/temp/home.html');

            var script = document.createElement("script");
            script.type = "text/javascript";
            script.src = "https://maps.googleapis.com/maps/api/js?key=AIzaSyBbqEBrrrT2xcFHGWTnkYPVU_SzEtXKH6w&sensor=true&callback=gmap.init_map";
            document.body.appendChild(script);

            $('#webticker').webTicker();
        },

        initialise : function () {
            document.onload = this.loadScript();
        }
    }
});