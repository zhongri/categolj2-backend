define(function (require) {
    var Backbone = require('backbone');
    var $ = require('jquery');
    var _ = require('underscore');

    var EntriesView = require('../views/EntriesView');

    return Backbone.Router.extend({
        routes: {
            'entries': 'list'
        },
        initialize: function (opts) {
            this.adminView = opts.adminView;
            this.tabPanelView = this.adminView.createTabPanelView('entries');
        },
        list: function () {
            this.adminView.renderTab(this.tabPanelView, new EntriesView());
        }
    });
});