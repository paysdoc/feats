var TabbedArea = Backbone.Model.extend({
    html : '<link rel="stylesheet" href="css/tabbed.css" type="text/css"><div id="TabbedBox" class="tabbed_box"><h4></h4><div class="tabbed_area"><ul class="tabs"></ul><div id="TabbedContent"></div></div></div>'
});

var Tab = Backbone.Model.extend({
    name: "dummy name",
    content: "dummy content"
});

var Tabs = Backbone.Collection.extend({
    model: Tab
});