define(['jQuery', 'underscore', 'backbone', 'model/TDPModel', 'model/TabCollection', 'view/TabView', 'pubsub'], function ($, _, Backbone, TDPModel, TabCollection, TabView) {
    var TDPView = Backbone.View.extend({

        render: function () {
            var tdp = new TDPModel();
            $.subscribe('hasTDP', function(e, tabs){
                TabView.render(tabs);
                $('#TabbedContent').css('padding', '0');
                $('#TabbedContent').css('width', 'auto');
                $('#TabbedContent').css('overflow', 'hidden');
                $('#TabbedContent').css('clear', 'left');
                $.unsubscribe('hasTDP');
            })
        }
    });

    return new TDPView();
});
