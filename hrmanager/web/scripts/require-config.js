require.config({

    paths : {
        'text': 'scripts/lib/require/text',
        'jquery' : 'scripts/lib/jquery/jquery-1.8.1',
        'jquery.form' : 'scripts/lib/jquery/jquery.form',
        'jquery.jcrop' : 'scripts/lib/jquery/jcrop/js/jquery.Jcrop',
        'jquery.jcrop-canvas': 'scripts/lib/jquery/jcrop/js/jquery.jcrop-canvas',
        'backbone' : 'scripts/lib/backbone/backbone',
        'backbone.syphon' : 'scripts/lib/backbone/backbone.syphon',
        'bootstrap' : 'scripts/lib/bootstrap/js/bootstrap',
        'bootstrap-datepicker' : 'scripts/lib/bootstrap/js/bootstrap-datepicker',
        'underscore' : 'scripts/lib/underscore/underscore',
        'two-column-view' : 'scripts/framework/two-column/view/main',
        'confirm-view' : 'scripts/framework/confirm/view/main',
        'modules-path' : 'modules'
    },

    shim: {
        'jquery.form': {
            deps: ['jquery']
        },
        'bootstrap': {
            deps: ['jquery']
        },
        'bootstrap-datepicker': {
            deps: ['bootstrap', 'jquery']
        },
        backbone: {
            deps: ['underscore', 'jquery'],
            exports: 'Backbone'
        },
        'backbone.syphon' : {
            deps: ['backbone'],
            exports: 'BackboneSyphon'
        },
        jquery: {
            exports: '$'
        },
        underscore: {
            exports: '_'
        }
    }
});