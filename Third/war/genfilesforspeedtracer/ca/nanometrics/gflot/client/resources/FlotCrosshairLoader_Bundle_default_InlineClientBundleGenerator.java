package ca.nanometrics.gflot.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class FlotCrosshairLoader_Bundle_default_InlineClientBundleGenerator implements ca.nanometrics.gflot.client.resources.FlotCrosshairLoader.Bundle {
  private static FlotCrosshairLoader_Bundle_default_InlineClientBundleGenerator _instance0 = new FlotCrosshairLoader_Bundle_default_InlineClientBundleGenerator();
  private void flotCrosshairInitializer() {
    flotCrosshair = new com.google.gwt.resources.client.TextResource() {
      // jar:file:/home/aivalis/workspace/Third/war/WEB-INF/lib/gflot-2.4.3.jar!/ca/nanometrics/gflot/client/resources/jquery.flot-0.7.crosshair.min.js
      public String getText() {
        return "(function(b){var a={crosshair:{mode:null,color:\"rgba(170, 0, 0, 0.80)\",lineWidth:1}};function c(h){var j={x:-1,y:-1,locked:false};h.setCrosshair=function e(l){if(!l){j.x=-1}else{var k=h.p2c(l);j.x=Math.max(0,Math.min(k.left,h.width()));j.y=Math.max(0,Math.min(k.top,h.height()))}h.triggerRedrawOverlay()};h.clearCrosshair=h.setCrosshair;h.lockCrosshair=function f(k){if(k){h.setCrosshair(k)}j.locked=true};h.unlockCrosshair=function g(){j.locked=false};function d(k){if(j.locked){return}if(j.x!=-1){j.x=-1;h.triggerRedrawOverlay()}}function i(k){if(j.locked){return}if(h.getSelection&&h.getSelection()){j.x=-1;return}var l=h.offset();j.x=Math.max(0,Math.min(k.pageX-l.left,h.width()));j.y=Math.max(0,Math.min(k.pageY-l.top,h.height()));h.triggerRedrawOverlay()}h.hooks.bindEvents.push(function(l,k){if(!l.getOptions().crosshair.mode){return}k.mouseout(d);k.mousemove(i)});h.hooks.drawOverlay.push(function(m,k){var n=m.getOptions().crosshair;if(!n.mode){return}var l=m.getPlotOffset();k.save();k.translate(l.left,l.top);if(j.x!=-1){k.strokeStyle=n.color;k.lineWidth=n.lineWidth;k.lineJoin=\"round\";k.beginPath();if(n.mode.indexOf(\"x\")!=-1){k.moveTo(j.x,0);k.lineTo(j.x,m.height())}if(n.mode.indexOf(\"y\")!=-1){k.moveTo(0,j.y);k.lineTo(m.width(),j.y)}k.stroke()}k.restore()});h.hooks.shutdown.push(function(l,k){k.unbind(\"mouseout\",d);k.unbind(\"mousemove\",i)})}b.plot.plugins.push({init:c,options:a,name:\"crosshair\",version:\"1.0\"})})(jQuery);";
      }
      public String getName() {
        return "flotCrosshair";
      }
    }
    ;
  }
  private static class flotCrosshairInitializer {
    static {
      _instance0.flotCrosshairInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return flotCrosshair;
    }
  }
  public com.google.gwt.resources.client.TextResource flotCrosshair() {
    return flotCrosshairInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource flotCrosshair;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      flotCrosshair(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("flotCrosshair", flotCrosshair());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'flotCrosshair': return this.@ca.nanometrics.gflot.client.resources.FlotCrosshairLoader.Bundle::flotCrosshair()();
    }
    return null;
  }-*/;
}
