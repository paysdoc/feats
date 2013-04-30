require.config({
    paths: {
        jQuery: 'lib/jquery-1.9.1.min',
        underscore: 'lib/underscore-min',
        backbone: 'lib/backbone-min',
        webTicker: 'lib/jquery.webticker',
        async: 'lib/async',
        pubsub: 'lib/jquery.ba-tinypubsub.min'
    },

    shim: {
        'webTicker': {
            deps: ['jQuery'],
            exports: 'webTicker'
        },
        'pubsub': {
            deps: ['jQuery'],
            exports: 'pubsub'
        },
        'backbone': {
            deps: ['underscore', 'jQuery'],
            exports: 'Backbone'
        },
        'underscore': {
            exports: '_'
        },
        'jQuery': {
            exports: '$'
        }
    }
});

require([
    'app', 'gmap'
], function(app, gmap){
    window.gmap = gmap;
    app.initialise();
});