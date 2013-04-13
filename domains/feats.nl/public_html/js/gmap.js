define(function(){
    return {
        init_map: function() {
            this.buildMap("Map", true);
        },

        mapOnContent: function() {
            this.buildMap("ContentMap", true);
        },

        buildMap: function (id, hybrid) {
            var ks_ll = new google.maps.LatLng(52.082251,4.315318);
            var that = this;
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
                that.setMarker(theMap, ks_ll);
            }, 200);
        },

        setMarker: function (theMap, ks_ll) {
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
});

