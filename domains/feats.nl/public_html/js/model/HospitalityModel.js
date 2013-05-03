define(['jquery', 'backbone', 'model/TabCollection', 'app', 'pubsub'], function($, Backbone, TabCollection, app){
    return Backbone.Model.extend({
        initialize: function() {
            var self = this;
            app.doAjax('/js/template/hp.json', function(data){
                var json = $.parseJSON(data);
                self.tabs = new TabCollection([
                    {name:'General',content: json.general},
                    {name:'Running Order',content: json.running_order},
                    {name:'Fringe',content: json.fringe},
                    /*{name:'Where is FEATS?',content: json.where},*/
                    {name:'Refreshments',content: json.food_and_drink},
                    /*{name:'Accommodation',content: json.accommodation},*/
                    {name:'Excursions',content: json.planned_excursions},
                    {name:'What to do?',content: json.what_to_do},
                    {name:'Hospitality Pack',content: json.hospitality_docs}
                ]);
                $.publish("hasHospitality", self.tabs);
            });
        }
    })
});