define(['backbone', 'gmap'], function (Backbone, gmap) {
    var Router = Backbone.Router.extend({

        routes: {
            "groups" : "groups", //#groups
            "hp": "hp",    // #hp
            "map": "map", // #map
            "contestants": "contestants", //#contestants
            "tickets": "tickets", // #tickets
            "*defaultRoute" : "defaultRoute" //#
        },

        defaultRoute: function(defaultRoute) {
            require('app').fillContent('home.html');
        },

        groups: function() {
            require('app').fillContent('stage_management_docs.html');
        },

        hp: function() {
            require(['view/HospitalityView', 'view/TabView', 'model/TabCollection'], function (hospitalityView, tabView, tabCollection){hospitalityView.render(tabView, tabCollection);});
        },

        map: function() {
            $('#Content').empty().html('<div id="ContentMap"></div>');
            gmap.mapOnContent();
        },

        contestants: function() {
            $('#Content').empty().html('<h2>This year\'s Contestants are</h2>').append($('#webticker').clone());
        },

        tickets: function() {
            require('app').fillContent('tickets.html');
        }

    });
    return new Router();
});