define(["backbone", "underscore"], function(Backbone, _) {

    return Backbone.Collection.extend({

        initialize : function(models) {
            var self = this;
            _(models).each(function(item) {
                self.add(item);
            })
        }
    });

});