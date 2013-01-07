package ca.nanometrics.gflot.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class FlotAxisLabelsLoader_Bundle_default_StaticClientBundleGenerator implements ca.nanometrics.gflot.client.resources.FlotAxisLabelsLoader.Bundle {
  private static FlotAxisLabelsLoader_Bundle_default_StaticClientBundleGenerator _instance0 = new FlotAxisLabelsLoader_Bundle_default_StaticClientBundleGenerator();
  private void flotAxisLabelsInitializer() {
    flotAxisLabels = new com.google.gwt.resources.client.TextResource() {
      // jar:file:/home/aivalis/workspace/Third/war/WEB-INF/lib/gflot-2.4.3.jar!/ca/nanometrics/gflot/client/resources/jquery.flot.axislabels-20120404.min.js
      public String getText() {
        return "(function(d){var k={};function e(){return !!document.createElement(\"canvas\").getContext}function f(){if(!e()){return false}var m=document.createElement(\"canvas\");var l=m.getContext(\"2d\");return typeof l.fillText==\"function\"}function i(){var l=document.createElement(\"div\");return typeof l.style.MozTransition!=\"undefined\"||typeof l.style.OTransition!=\"undefined\"||typeof l.style.webkitTransition!=\"undefined\"||typeof l.style.transition!=\"undefined\"}function c(p,l,o,n,m){this.axisName=p;this.position=l;this.padding=o;this.plot=n;this.opts=m;this.width=0;this.height=0}b.prototype=new c();b.prototype.constructor=b;function b(p,l,o,n,m){c.prototype.constructor.call(this,p,l,o,n,m)}b.prototype.calculateSize=function(){if(!this.opts.axisLabelFontSizePixels){this.opts.axisLabelFontSizePixels=14}if(!this.opts.axisLabelFontFamily){this.opts.axisLabelFontFamily=\"sans-serif\"}var m=this.opts.axisLabelFontSizePixels+this.padding;var l=this.opts.axisLabelFontSizePixels+this.padding;if(this.position==\"left\"||this.position==\"right\"){this.width=this.opts.axisLabelFontSizePixels+this.padding;this.height=0}else{this.width=0;this.height=this.opts.axisLabelFontSizePixels+this.padding}};b.prototype.draw=function(p){var n=this.plot.getCanvas().getContext(\"2d\");n.save();n.font=this.opts.axisLabelFontSizePixels+\"px \"+this.opts.axisLabelFontFamily;var o=n.measureText(this.opts.axisLabel).width;var m=this.opts.axisLabelFontSizePixels;var l,r,q=0;if(this.position==\"top\"){l=p.left+p.width/2-o/2;r=p.top+m*0.72}else{if(this.position==\"bottom\"){l=p.left+p.width/2-o/2;r=p.top+p.height-m*0.72}else{if(this.position==\"left\"){l=p.left+m*0.72;r=p.height/2+p.top+o/2;q=-Math.PI/2}else{if(this.position==\"right\"){l=p.left+p.width-m*0.72;r=p.height/2+p.top-o/2;q=Math.PI/2}}}}n.translate(l,r);n.rotate(q);n.fillText(this.opts.axisLabel,0,0);n.restore()};h.prototype=new c();h.prototype.constructor=h;function h(p,l,o,n,m){c.prototype.constructor.call(this,p,l,o,n,m)}h.prototype.calculateSize=function(){var l=d('<div class=\"axisLabels\" style=\"position:absolute;\">'+this.opts.axisLabel+\"</div>\");this.plot.getPlaceholder().append(l);this.labelWidth=l.outerWidth(true);this.labelHeight=l.outerHeight(true);l.remove();this.width=this.height=0;if(this.position==\"left\"||this.position==\"right\"){this.width=this.labelWidth+this.padding}else{this.height=this.labelHeight+this.padding}};h.prototype.draw=function(m){this.plot.getPlaceholder().find(\"#\"+this.axisName+\"Label\").remove();var l=d('<div id=\"'+this.axisName+'Label\" \" class=\"axisLabels\" style=\"position:absolute;\">'+this.opts.axisLabel+\"</div>\");this.plot.getPlaceholder().append(l);if(this.position==\"top\"){l.css(\"left\",m.left+m.width/2-this.labelWidth/2+\"px\");l.css(\"top\",m.top+\"px\")}else{if(this.position==\"bottom\"){l.css(\"left\",m.left+m.width/2-this.labelWidth/2+\"px\");l.css(\"top\",m.top+m.height-this.labelHeight+\"px\")}else{if(this.position==\"left\"){l.css(\"top\",m.top+m.height/2-this.labelHeight/2+\"px\");l.css(\"left\",m.left+\"px\")}else{if(this.position==\"right\"){l.css(\"top\",m.top+m.height/2-this.labelHeight/2+\"px\");l.css(\"left\",m.left+m.width-this.labelWidth+\"px\")}}}}};g.prototype=new h();g.prototype.constructor=g;function g(p,l,o,n,m){h.prototype.constructor.call(this,p,l,o,n,m)}g.prototype.calculateSize=function(){h.prototype.calculateSize.call(this);this.width=this.height=0;if(this.position==\"left\"||this.position==\"right\"){this.width=this.labelHeight+this.padding}else{this.height=this.labelHeight+this.padding}};g.prototype.transforms=function(n,r,q){var o={\"-moz-transform\":\"\",\"-webkit-transform\":\"\",\"-o-transform\":\"\",\"-ms-transform\":\"\"};if(r!=0||q!=0){var l=\" translate(\"+r+\"px, \"+q+\"px)\";o[\"-moz-transform\"]+=l;o[\"-webkit-transform\"]+=l;o[\"-o-transform\"]+=l;o[\"-ms-transform\"]+=l}if(n!=0){var t=n/90;var p=\" rotate(\"+n+\"deg)\";o[\"-moz-transform\"]+=p;o[\"-webkit-transform\"]+=p;o[\"-o-transform\"]+=p;o[\"-ms-transform\"]+=p}var u=\"top: 0; left: 0; \";for(var m in o){if(o[m]){u+=m+\":\"+o[m]+\";\"}}u+=\";\";return u};g.prototype.calculateOffsets=function(m){var l={x:0,y:0,degrees:0};if(this.position==\"bottom\"){l.x=m.left+m.width/2-this.labelWidth/2;l.y=m.top+m.height-this.labelHeight}else{if(this.position==\"top\"){l.x=m.left+m.width/2-this.labelWidth/2;l.y=m.top}else{if(this.position==\"left\"){l.degrees=-90;l.x=m.left-this.labelWidth/2+this.labelHeight/2;l.y=m.height/2+m.top}else{if(this.position==\"right\"){l.degrees=90;l.x=m.left+m.width-this.labelWidth/2-this.labelHeight/2;l.y=m.height/2+m.top}}}}return l};g.prototype.draw=function(n){this.plot.getPlaceholder().find(\".\"+this.axisName+\"Label\").remove();var m=this.calculateOffsets(n);var l=d('<div class=\"axisLabels '+this.axisName+'Label\" style=\"position:absolute; '+this.transforms(m.degrees,m.x,m.y)+'\">'+this.opts.axisLabel+\"</div>\");this.plot.getPlaceholder().append(l)};a.prototype=new g();a.prototype.constructor=a;function a(p,l,o,n,m){g.prototype.constructor.call(this,p,l,o,n,m);this.requiresResize=false}a.prototype.transforms=function(o,l,p){var n=\"\";if(o!=0){var m=o/90;while(m<0){m+=4}n+=\" filter: progid:DXImageTransform.Microsoft.BasicImage(rotation=\"+m+\"); \";this.requiresResize=(this.position==\"right\")}if(l!=0){n+=\"left: \"+l+\"px; \"}if(p!=0){n+=\"top: \"+p+\"px; \"}return n};a.prototype.calculateOffsets=function(m){var l=g.prototype.calculateOffsets.call(this,m);if(this.position==\"top\"){l.y=m.top+1}else{if(this.position==\"left\"){l.x=m.left;l.y=m.height/2+m.top-this.labelWidth/2}else{if(this.position==\"right\"){l.x=m.left+m.width-this.labelHeight;l.y=m.height/2+m.top-this.labelWidth/2}}}return l};a.prototype.draw=function(m){g.prototype.draw.call(this,m);if(this.requiresResize){var l=this.plot.getPlaceholder().find(\".\"+this.axisName+\"Label\");l.css(\"width\",this.labelWidth);l.css(\"height\",this.labelHeight)}};function j(o){var m=false;var l={};var p={left:0,right:0,top:0,bottom:0};var n=2;o.hooks.draw.push(function(r,q){if(!m){d.each(r.getAxes(),function(y,u){var v=u.options||r.getOptions()[y];if(!v||!v.axisLabel){return}var w=null;if(!v.axisLabelUseHtml&&navigator.appName==\"Microsoft Internet Explorer\"){var s=navigator.userAgent;var t=new RegExp(\"MSIE ([0-9]{1,}[.0-9]{0,})\");if(t.exec(s)!=null){rv=parseFloat(RegExp.$1)}if(rv>=9&&!v.axisLabelUseCanvas&&!v.axisLabelUseHtml){w=g}else{if(!v.axisLabelUseCanvas&&!v.axisLabelUseHtml){w=a}else{if(v.axisLabelUseCanvas){w=b}else{w=h}}}}else{if(v.axisLabelUseHtml||(!i()&&!f())&&!v.axisLabelUseCanvas){w=h}else{if(v.axisLabelUseCanvas||!i()){w=b}else{w=g}}}var x=v.axisLabelPadding===undefined?n:v.axisLabelPadding;l[y]=new w(y,u.position,x,r,v);l[y].calculateSize();u.labelHeight+=l[y].height;u.labelWidth+=l[y].width;v.labelHeight=u.labelHeight;v.labelWidth=u.labelWidth});m=true;r.setupGrid();r.draw()}else{d.each(r.getAxes(),function(u,s){var t=s.options||r.getOptions()[u];if(!t||!t.axisLabel){return}l[u].draw(s.box)})}})}d.plot.plugins.push({init:j,options:k,name:\"axisLabels\",version:\"2.0b0\"})})(jQuery);";
      }
      public String getName() {
        return "flotAxisLabels";
      }
    }
    ;
  }
  private static class flotAxisLabelsInitializer {
    static {
      _instance0.flotAxisLabelsInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return flotAxisLabels;
    }
  }
  public com.google.gwt.resources.client.TextResource flotAxisLabels() {
    return flotAxisLabelsInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource flotAxisLabels;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      flotAxisLabels(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("flotAxisLabels", flotAxisLabels());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'flotAxisLabels': return this.@ca.nanometrics.gflot.client.resources.FlotAxisLabelsLoader.Bundle::flotAxisLabels()();
    }
    return null;
  }-*/;
}