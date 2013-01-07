package ca.nanometrics.gflot.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class FlotMultipleBarsLoader_Bundle_default_StaticClientBundleGenerator implements ca.nanometrics.gflot.client.resources.FlotMultipleBarsLoader.Bundle {
  private static FlotMultipleBarsLoader_Bundle_default_StaticClientBundleGenerator _instance0 = new FlotMultipleBarsLoader_Bundle_default_StaticClientBundleGenerator();
  private void flotMultipleBarsInitializer() {
    flotMultipleBars = new com.google.gwt.resources.client.TextResource() {
      // jar:file:/home/aivalis/workspace/Third/war/WEB-INF/lib/gflot-2.4.3.jar!/ca/nanometrics/gflot/client/resources/jquery.flot.multiplebars-0.1.min.js
      public String getText() {
        return "(function(b){function c(h){var d=false;var f=[];var e=0;function j(n,k,l,m){if(k.bars.show){f.push(k)}}function i(q,o,p){if(o.bars.show&&o.bars.barLeft==undefined){if(e==0){for(var m=0;m<f.length;m++){e+=f[m].bars.barWidth}}var n=0;for(var l=0;l<f.length;l++){s=f[l];if(s==o){break}n+=s.bars.barWidth}o.bars.barLeft=n-(e/2)}}function g(l,k){if(k.multiplebars){d=k.multiplebars;f=[];e=0;l.hooks.processRawData.push(j);l.hooks.processDatapoints.push(i)}}h.hooks.processOptions.push(g)}var a={multiplebars:false};b.plot.plugins.push({init:c,options:a,name:\"multiplebars\",version:\"0.1\"})})(jQuery);";
      }
      public String getName() {
        return "flotMultipleBars";
      }
    }
    ;
  }
  private static class flotMultipleBarsInitializer {
    static {
      _instance0.flotMultipleBarsInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return flotMultipleBars;
    }
  }
  public com.google.gwt.resources.client.TextResource flotMultipleBars() {
    return flotMultipleBarsInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource flotMultipleBars;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      flotMultipleBars(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("flotMultipleBars", flotMultipleBars());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'flotMultipleBars': return this.@ca.nanometrics.gflot.client.resources.FlotMultipleBarsLoader.Bundle::flotMultipleBars()();
    }
    return null;
  }-*/;
}
