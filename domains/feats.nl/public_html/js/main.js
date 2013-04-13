require.config({
    paths: {
        jQuery: 'lib/jquery-1.9.1.min',
        underscore: 'lib/underscore-min',
        backbone: 'lib/backbone-min',
        webTicker: 'lib/jquery.webticker',
        async: 'lib/async'
    },

    shim: {
        'webTicker': {
            deps: ['jQuery'],
            exports: 'webTicker'
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