package ca.nanometrics.gflot.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class FlotSymbolLoader_Bundle_default_StaticClientBundleGenerator implements ca.nanometrics.gflot.client.resources.FlotSymbolLoader.Bundle {
  private static FlotSymbolLoader_Bundle_default_StaticClientBundleGenerator _instance0 = new FlotSymbolLoader_Bundle_default_StaticClientBundleGenerator();
  private void flotSymbolInitializer() {
    flotSymbol = new com.google.gwt.resources.client.TextResource() {
      // jar:file:/home/aivalis/workspace/Third/war/WEB-INF/lib/gflot-2.4.3.jar!/ca/nanometrics/gflot/client/resources/jquery.flot-0.7.symbol.min.js
      public String getText() {
        return "(function(b){function a(h,e,g){var d={square:function(k,j,n,i,m){var l=i*Math.sqrt(Math.PI)/2;k.rect(j-l,n-l,l+l,l+l)},diamond:function(k,j,n,i,m){var l=i*Math.sqrt(Math.PI/2);k.moveTo(j-l,n);k.lineTo(j,n-l);k.lineTo(j+l,n);k.lineTo(j,n+l);k.lineTo(j-l,n)},triangle:function(l,k,o,j,n){var m=j*Math.sqrt(2*Math.PI/Math.sin(Math.PI/3));var i=m*Math.sin(Math.PI/3);l.moveTo(k-m/2,o+i/2);l.lineTo(k+m/2,o+i/2);if(!n){l.lineTo(k,o-i/2);l.lineTo(k-m/2,o+i/2)}},cross:function(k,j,n,i,m){var l=i*Math.sqrt(Math.PI)/2;k.moveTo(j-l,n-l);k.lineTo(j+l,n+l);k.moveTo(j-l,n+l);k.lineTo(j+l,n-l)}};var f=e.points.symbol;if(d[f]){e.points.symbol=d[f]}}function c(d){d.hooks.processDatapoints.push(a)}b.plot.plugins.push({init:c,name:\"symbols\",version:\"1.0\"})})(jQuery);";
      }
      public String getName() {
        return "flotSymbol";
      }
    }
    ;
  }
  private static class flotSymbolInitializer {
    static {
      _instance0.flotSymbolInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return flotSymbol;
    }
  }
  public com.google.gwt.resources.client.TextResource flotSymbol() {
    return flotSymbolInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource flotSymbol;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      flotSymbol(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("flotSymbol", flotSymbol());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'flotSymbol': return this.@ca.nanometrics.gflot.client.resources.FlotSymbolLoader.Bundle::flotSymbol()();
    }
    return null;
  }-*/;
}
