define(['jQuery', 'underscore', 'backbone', 'model/HospitalityModel', 'model/TabCollection', 'view/TabView', 'pubsub'], function ($, _, Backbone, HospitalityModel, TabCollection, TabView) {
    var HospitalityView = Backbone.View.extend({

        render: function () {
            var hospitality = new HospitalityModel();
            $.subscribe('hasHospitality', function(e, tabs){
                TabView.render(tabs);
                $.unsubscribe('hasHospitality');
            })
        }
    });

    return new HospitalityView();
});
