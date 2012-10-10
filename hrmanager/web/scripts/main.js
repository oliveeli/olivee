/**
 * Author: 李军
 * Date: 12-10-10
 * Time: 上午10:14
 *
 */
require.config({

    paths : {
        'text': 'lib/require/text',
        'jquery' : 'lib/jquery/jquery-1.8.1',
        'backbone' : 'lib/backbone/backbone',
        'backbone.syphon' : 'lib/backbone/backbone.syphon',
        'bootstrap' : 'lib/bootstrap/js/bootstrap',
        'underscore' : 'lib/underscore/underscore',
        'two-column-view' : 'framework/two-column/view/main',
        'confirm-view' : 'framework/confirm/view/main',
        'modules-path' : '../modules'
    },

    shim: {
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

require([ 'jquery', 'app'], function($, App) {
    $(function(){
        App.initialize();
    });
});