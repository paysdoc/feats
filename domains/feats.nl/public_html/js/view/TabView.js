define(['jQuery', 'underscore', 'backbone'], function ($, _, Backbone) {

    var Tab = Backbone.View.extend({
        el: 'ul.tabs',

        initialize: function () {
            _.bindAll(this, 'render', 'renderContent', 'activateTab');
        },

        render: function (_class) {
            $('<li/>', {
                text: this.model.get("name"),
                click: this.renderContent
            }).addClass(_class).appendTo(this.el);
        },

        renderContent: function () {
            var theContent = this.model.get("content");
            if (theContent === undefined) {
                require('app').fillContent(this.model.get("urlString"), '#TabbedContent');
            } else {
                $('#TabbedContent').empty().html(theContent);
            }
            this.activateTab(this.model.get("name"));
        },

        activateTab: function (name) {
            _($(this.el).children()).each(function (element) {
                $(element).removeClass("active");
                if (name == $(element).text()) {
                    $(element).addClass("active");
                }
            });
        }
    });

    var TabbedView = Backbone.View.extend({
        el: $('#Content'),

        initialize: function () {
            _.bindAll(this, 'render', 'addTab');
        },

        render: function (tabs) {
            $(this.el).empty().append('<link rel="stylesheet" href="/css/tabbed.css" type="text/css"><div id="TabbedBox" class="tabbed_box"><div class="tabbed_area"><ul class="tabs"></ul><div id="TabbedContent" class="box"></div></div></div>');
            var self = this;
            _(tabs.models).each(function (item, index) {
                self.addTab(item, index);
            })
        },

        addTab: function (item, index) {
            var itemView = new Tab({
                model: item
            });
            if (index === 0) {
                itemView.render("tab active");
                itemView.renderContent();
            } else {
                itemView.render("tab");
            }
        }

    });

    return new TabbedView();
});