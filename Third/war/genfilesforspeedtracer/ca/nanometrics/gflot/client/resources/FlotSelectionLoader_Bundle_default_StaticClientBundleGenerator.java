package ca.nanometrics.gflot.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class FlotSelectionLoader_Bundle_default_StaticClientBundleGenerator implements ca.nanometrics.gflot.client.resources.FlotSelectionLoader.Bundle {
  private static FlotSelectionLoader_Bundle_default_StaticClientBundleGenerator _instance0 = new FlotSelectionLoader_Bundle_default_StaticClientBundleGenerator();
  private void flotSelectionInitializer() {
    flotSelection = new com.google.gwt.resources.client.TextResource() {
      // jar:file:/home/aivalis/workspace/Third/war/WEB-INF/lib/gflot-2.4.3.jar!/ca/nanometrics/gflot/client/resources/jquery.flot-0.7.selection.min.js
      public String getText() {
        return "(function(a){function b(k){var p={first:{x:-1,y:-1},second:{x:-1,y:-1},show:false,active:false};var m={};var r=null;function e(s){if(p.active){l(s);k.getPlaceholder().trigger(\"plotselecting\",[g()])}}function n(s){if(s.which!=1){return}document.body.focus();if(document.onselectstart!==undefined&&m.onselectstart==null){m.onselectstart=document.onselectstart;document.onselectstart=function(){return false}}if(document.ondrag!==undefined&&m.ondrag==null){m.ondrag=document.ondrag;document.ondrag=function(){return false}}d(p.first,s);p.active=true;r=function(t){j(t)};a(document).one(\"mouseup\",r)}function j(s){r=null;if(document.onselectstart!==undefined){document.onselectstart=m.onselectstart}if(document.ondrag!==undefined){document.ondrag=m.ondrag}p.active=false;l(s);if(f()){i()}else{k.getPlaceholder().trigger(\"plotunselected\",[]);k.getPlaceholder().trigger(\"plotselecting\",[null])}return false}function g(){if(!f()){return null}var u={},t=p.first,s=p.second;a.each(k.getAxes(),function(v,w){if(w.used){var y=w.c2p(t[w.direction]),x=w.c2p(s[w.direction]);u[v]={from:Math.min(y,x),to:Math.max(y,x)}}});return u}function i(){var s=g();k.getPlaceholder().trigger(\"plotselected\",[s]);if(s.xaxis&&s.yaxis){k.getPlaceholder().trigger(\"selected\",[{x1:s.xaxis.from,y1:s.yaxis.from,x2:s.xaxis.to,y2:s.yaxis.to}])}}function h(t,u,s){return u<t?t:(u>s?s:u)}function d(w,t){var v=k.getOptions();var u=k.getPlaceholder().offset();var s=k.getPlotOffset();w.x=h(0,t.pageX-u.left-s.left,k.width());w.y=h(0,t.pageY-u.top-s.top,k.height());if(v.selection.mode==\"y\"){w.x=w==p.first?0:k.width()}if(v.selection.mode==\"x\"){w.y=w==p.first?0:k.height()}}function l(s){if(s.pageX==null){return}d(p.second,s);if(f()){p.show=true;k.triggerRedrawOverlay()}else{q(true)}}function q(s){if(p.show){p.show=false;k.triggerRedrawOverlay();if(!s){k.getPlaceholder().trigger(\"plotunselected\",[])}}}function c(s,w){var t,y,z,A,x=k.getAxes();for(var u in x){t=x[u];if(t.direction==w){A=w+t.n+\"axis\";if(!s[A]&&t.n==1){A=w+\"axis\"}if(s[A]){y=s[A].from;z=s[A].to;break}}}if(!s[A]){t=w==\"x\"?k.getXAxes()[0]:k.getYAxes()[0];y=s[w+\"1\"];z=s[w+\"2\"]}if(y!=null&&z!=null&&y>z){var v=y;y=z;z=v}return{from:y,to:z,axis:t}}function o(t,s){var v,u,w=k.getOptions();if(w.selection.mode==\"y\"){p.first.x=0;p.second.x=k.width()}else{u=c(t,\"x\");p.first.x=u.axis.p2c(u.from);p.second.x=u.axis.p2c(u.to)}if(w.selection.mode==\"x\"){p.first.y=0;p.second.y=k.height()}else{u=c(t,\"y\");p.first.y=u.axis.p2c(u.from);p.second.y=u.axis.p2c(u.to)}p.show=true;k.triggerRedrawOverlay();if(!s&&f()){i()}}function f(){var s=5;return Math.abs(p.second.x-p.first.x)>=s&&Math.abs(p.second.y-p.first.y)>=s}k.clearSelection=q;k.setSelection=o;k.getSelection=g;k.hooks.bindEvents.push(function(t,s){var u=t.getOptions();if(u.selection.mode!=null){s.mousemove(e);s.mousedown(n)}});k.hooks.drawOverlay.push(function(v,D){if(p.show&&f()){var t=v.getPlotOffset();var s=v.getOptions();D.save();D.translate(t.left,t.top);var z=a.color.parse(s.selection.color);D.strokeStyle=z.scale(\"a\",0.8).toString();D.lineWidth=1;D.lineJoin=\"round\";D.fillStyle=z.scale(\"a\",0.4).toString();var B=Math.min(p.first.x,p.second.x),A=Math.min(p.first.y,p.second.y),C=Math.abs(p.second.x-p.first.x),u=Math.abs(p.second.y-p.first.y);D.fillRect(B,A,C,u);D.strokeRect(B,A,C,u);D.restore()}});k.hooks.shutdown.push(function(t,s){s.unbind(\"mousemove\",e);s.unbind(\"mousedown\",n);if(r){a(document).unbind(\"mouseup\",r)}})}a.plot.plugins.push({init:b,options:{selection:{mode:null,color:\"#e8cfac\"}},name:\"selection\",version:\"1.1\"})})(jQuery);";
      }
      public String getName() {
        return "flotSelection";
      }
    }
    ;
  }
  private static class flotSelectionInitializer {
    static {
      _instance0.flotSelectionInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return flotSelection;
    }
  }
  public com.google.gwt.resources.client.TextResource flotSelection() {
    return flotSelectionInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource flotSelection;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      flotSelection(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("flotSelection", flotSelection());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'flotSelection': return this.@ca.nanometrics.gflot.client.resources.FlotSelectionLoader.Bundle::flotSelection()();
    }
    return null;
  }-*/;
}