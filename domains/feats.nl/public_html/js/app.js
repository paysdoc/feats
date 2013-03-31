//Filename: app.js
define([
    'jQuery'
], function () {
    var app = function ($) {
        var doAjax = function (urlString) {
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
        };

        var toggle = function (elem, marginLeft) {
            if (elem.style.marginTop == "-100%") {
                diminish(elem);
            } else {
                enlarge(elem, marginLeft);
            }
        };

        var enlarge = function (elem, marginLeft) {
            var anim = {
                height: "300%",
                position: "absolute",
                top: "10%",
                left: "10%",
                zIndex: "10000"
            };
            anim["marginLeft"] = marginLeft;
            $(elem).animate(anim, 1000);
        };

        var diminish = function (elem) {
            $(elem).animate({
                position: "relative",
                top: "auto",
                left: "auto",
                height: "100%",
                marginLeft: "5px",
                marginTop: "0px",
                zIndex: "0"
            }, 1000);
        };

        var loadScript = function () {
            doAjax('js/temp/home.html');

            var script = document.createElement("script");
            script.type = "text/javascript";
            script.src = "https://maps.googleapis.com/maps/api/js?key=AIzaSyBbqEBrrrT2xcFHGWTnkYPVU_SzEtXKH6w&sensor=true";
            document.body.appendChild(script);

            $('#webticker').webTicker();
        }

        function initialise() {
            document.onload = loadScript();
        }

        return new app();
    }
});