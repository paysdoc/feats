define(['jQuery', 'underscore', 'backbone'], function ($, _, Backbone) {
    var Hospitality = Backbone.View.extend({

        render: function (tabView, TabCollection) {
            tabView.render(new TabCollection([
                {name:'General',urlString:'/js/temp/hp/general.html'},
                {name:'Running Order',urlString:'/js/temp/hp/running_order.html'},
                {name:'Fringe',urlString:'/js/temp/hp/fringe.html'},
                /*{name:'Where is FEATS?',urlString:'/js/temp/hp/where.html'},*/
                {name:'Refreshments',urlString:'/js/temp/hp/food_and_drink.html'},
                /*{name:'Accommodation',urlString:'/js/temp/hp/accommodation.html'},*/
                {name:'Excursions',urlString:'/js/temp/hp/planned_excursions.html'},
                {name:'What to do?',urlString:'/js/temp/hp/what_to_do.html'},
                {name:'Hospitality Pack',urlString:'/js/temp/hp/hospitality_docs.html'}
            ]));
        }
    });

    return new Hospitality();
});
