package ca.nanometrics.gflot.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class FlotThresholdLoader_Bundle_default_InlineClientBundleGenerator implements ca.nanometrics.gflot.client.resources.FlotThresholdLoader.Bundle {
  private static FlotThresholdLoader_Bundle_default_InlineClientBundleGenerator _instance0 = new FlotThresholdLoader_Bundle_default_InlineClientBundleGenerator();
  private void flotThresholdInitializer() {
    flotThreshold = new com.google.gwt.resources.client.TextResource() {
      // jar:file:/home/aivalis/workspace/Third/war/WEB-INF/lib/gflot-2.4.3.jar!/ca/nanometrics/gflot/client/resources/jquery.flot-0.7.threshold.min.js
      public String getText() {
        return "(function(B){var A={series:{threshold:null}};function C(D){function E(L,S,M){if(!S.threshold){return }var F=M.pointsize,I,O,N,G,K,H=B.extend({},S);H.datapoints={points:[],pointsize:F};H.label=null;H.color=S.threshold.color;H.threshold=null;H.originSeries=S;H.data=[];var P=S.threshold.below,Q=M.points,R=S.lines.show;threspoints=[];newpoints=[];for(I=0;I<Q.length;I+=F){O=Q[I];N=Q[I+1];K=G;if(N<P){G=threspoints}else{G=newpoints}if(R&&K!=G&&O!=null&&I>0&&Q[I-F]!=null){var J=(O-Q[I-F])/(N-Q[I-F+1])*(P-N)+O;K.push(J);K.push(P);for(m=2;m<F;++m){K.push(Q[I+m])}G.push(null);G.push(null);for(m=2;m<F;++m){G.push(Q[I+m])}G.push(J);G.push(P);for(m=2;m<F;++m){G.push(Q[I+m])}}G.push(O);G.push(N)}M.points=newpoints;H.datapoints.points=threspoints;if(H.datapoints.points.length>0){L.getData().push(H)}}D.hooks.processDatapoints.push(E)}B.plot.plugins.push({init:C,options:A,name:\"threshold\",version:\"1.0\"})})(jQuery);";
      }
      public String getName() {
        return "flotThreshold";
      }
    }
    ;
  }
  private static class flotThresholdInitializer {
    static {
      _instance0.flotThresholdInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return flotThreshold;
    }
  }
  public com.google.gwt.resources.client.TextResource flotThreshold() {
    return flotThresholdInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource flotThreshold;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      flotThreshold(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("flotThreshold", flotThreshold());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'flotThreshold': return this.@ca.nanometrics.gflot.client.resources.FlotThresholdLoader.Bundle::flotThreshold()();
    }
    return null;
  }-*/;
}
