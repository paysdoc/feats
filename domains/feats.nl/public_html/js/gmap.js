define(['async!https://maps.googleapis.com/maps/api/js?key=AIzaSyBbqEBrrrT2xcFHGWTnkYPVU_SzEtXKH6w&sensor=true!callback'], function(){
    var gmap = function() {

        var init_map = function () {
            buildMap("Map", true);
        }

        var mapOnContent = function () {
            buildMap("ContentMap", true);
        }

        var buildMap = function (id, hybrid) {
            var ks_ll = new google.maps.LatLng(52.082251,4.315318);
            var mapOptions = {
                center: ks_ll,
                zoom: 8,
                disableDefaultUI:true,
                overviewMapControl:true,
                mapTypeId: hybrid ? google.maps.MapTypeId.HYBRID : google.maps.MapTypeId.ROADMAP
            };
            var theMap = new google.maps.Map(document.getElementById(id),
                mapOptions);

            setTimeout(function() {
                setMarker(theMap, ks_ll);
            }, 200);
        }

        var setMarker = function (theMap, ks_ll) {
            var marker = new google.maps.Marker({
                position: ks_ll,
                map: theMap,
                icon: '/img/feats_marker.png',
                shadow: '/img/feats_marker_shadow.png',
                clickable: true,
                title: 'Click to zoom',
                animation: google.maps.Animation.DROP
            });

            google.maps.event.addListener(marker, 'click', function() {
                theMap.setZoom(theMap.getZoom() + 4);
                theMap.setCenter(marker.getPosition());
            });
        }
    };
    return gmap;
});

