define(['jquery', 'backbone', 'model/TabCollection', 'app', 'pubsub'], function($, Backbone, TabCollection, app){
    return Backbone.Model.extend({
        initialize: function() {
            var self = this;
            app.doAjax('/js/template/tdp.json', function(data){
                var json = $.parseJSON(data);
                self.tabs = new TabCollection([
                    {name:'Arrival',content: json.arrival},
                    {name:'More soon',content: json.more},
                    {name:'Technical Data Pack',content: json.tdp}
                ]);
                $.publish("hasTDP", self.tabs);
            });
        }
    })
});