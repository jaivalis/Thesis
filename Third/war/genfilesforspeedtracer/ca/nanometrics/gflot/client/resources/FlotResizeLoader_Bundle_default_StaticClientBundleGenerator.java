package ca.nanometrics.gflot.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class FlotResizeLoader_Bundle_default_StaticClientBundleGenerator implements ca.nanometrics.gflot.client.resources.FlotResizeLoader.Bundle {
  private static FlotResizeLoader_Bundle_default_StaticClientBundleGenerator _instance0 = new FlotResizeLoader_Bundle_default_StaticClientBundleGenerator();
  private void flotResizeInitializer() {
    flotResize = new com.google.gwt.resources.client.TextResource() {
      // jar:file:/home/aivalis/workspace/Third/war/WEB-INF/lib/gflot-2.4.3.jar!/ca/nanometrics/gflot/client/resources/jquery.flot-0.7.resize.min.js
      public String getText() {
        return "(function(n,p,u){var w=n([]),s=n.resize=n.extend(n.resize,{}),o,l=\"setTimeout\",m=\"resize\",t=m+\"-special-event\",v=\"delay\",r=\"throttleWindow\";s[v]=250;s[r]=true;n.event.special[m]={setup:function(){if(!s[r]&&this[l]){return false}var a=n(this);w=w.add(a);n.data(this,t,{w:a.width(),h:a.height()});if(w.length===1){q()}},teardown:function(){if(!s[r]&&this[l]){return false}var a=n(this);w=w.not(a);a.removeData(t);if(!w.length){clearTimeout(o)}},add:function(b){if(!s[r]&&this[l]){return false}var c;function a(d,h,g){var f=n(this),e=n.data(this,t);e.w=h!==u?h:f.width();e.h=g!==u?g:f.height();c.apply(this,arguments)}if(n.isFunction(b)){c=b;return a}else{c=b.handler;b.handler=a}}};function q(){o=p[l](function(){w.each(function(){var d=n(this),a=d.width(),b=d.height(),c=n.data(this,t);if(a!==c.w||b!==c.h){d.trigger(m,[c.w=a,c.h=b])}});q()},s[v])}})(jQuery,this);(function(b){var a={};function c(f){function e(){var h=f.getPlaceholder();if(h.width()==0||h.height()==0){return}f.resize();f.setupGrid();f.draw()}function g(i,h){i.getPlaceholder().resize(e)}function d(i,h){i.getPlaceholder().unbind(\"resize\",e)}f.hooks.bindEvents.push(g);f.hooks.shutdown.push(d)}b.plot.plugins.push({init:c,options:a,name:\"resize\",version:\"1.0\"})})(jQuery);";
      }
      public String getName() {
        return "flotResize";
      }
    }
    ;
  }
  private static class flotResizeInitializer {
    static {
      _instance0.flotResizeInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return flotResize;
    }
  }
  public com.google.gwt.resources.client.TextResource flotResize() {
    return flotResizeInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource flotResize;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      flotResize(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("flotResize", flotResize());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'flotResize': return this.@ca.nanometrics.gflot.client.resources.FlotResizeLoader.Bundle::flotResize()();
    }
    return null;
  }-*/;
}
