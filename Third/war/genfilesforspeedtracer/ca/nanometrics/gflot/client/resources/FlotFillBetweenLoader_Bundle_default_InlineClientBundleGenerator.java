package ca.nanometrics.gflot.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class FlotFillBetweenLoader_Bundle_default_InlineClientBundleGenerator implements ca.nanometrics.gflot.client.resources.FlotFillBetweenLoader.Bundle {
  private static FlotFillBetweenLoader_Bundle_default_InlineClientBundleGenerator _instance0 = new FlotFillBetweenLoader_Bundle_default_InlineClientBundleGenerator();
  private void flotFillBetweenInitializer() {
    flotFillBetween = new com.google.gwt.resources.client.TextResource() {
      // jar:file:/home/aivalis/workspace/Third/war/WEB-INF/lib/gflot-2.4.3.jar!/ca/nanometrics/gflot/client/resources/jquery.flot-0.7.fillbetween.min.js
      public String getText() {
        return "(function(b){var a={series:{fillBetween:null}};function c(f){function d(j,h){var g;for(g=0;g<h.length;++g){if(h[g].id==j.fillBetween){return h[g]}}if(typeof j.fillBetween==\"number\"){g=j.fillBetween;if(g<0||g>=h.length){return null}return h[g]}return null}function e(B,u,g){if(u.fillBetween==null){return}var p=d(u,B.getData());if(!p){return}var y=g.pointsize,E=g.points,h=p.datapoints.pointsize,x=p.datapoints.points,r=[],w,v,k,G,F,q,t=u.lines.show,o=y>2&&g.format[2].y,n=t&&u.lines.steps,D=true,C=0,A=0,z;while(true){if(C>=E.length){break}z=r.length;if(E[C]==null){for(m=0;m<y;++m){r.push(E[C+m])}C+=y}else{if(A>=x.length){if(!t){for(m=0;m<y;++m){r.push(E[C+m])}}C+=y}else{if(x[A]==null){for(m=0;m<y;++m){r.push(null)}D=true;A+=h}else{w=E[C];v=E[C+1];G=x[A];F=x[A+1];q=0;if(w==G){for(m=0;m<y;++m){r.push(E[C+m])}q=F;C+=y;A+=h}else{if(w>G){if(t&&C>0&&E[C-y]!=null){k=v+(E[C-y+1]-v)*(G-w)/(E[C-y]-w);r.push(G);r.push(k);for(m=2;m<y;++m){r.push(E[C+m])}q=F}A+=h}else{if(D&&t){C+=y;continue}for(m=0;m<y;++m){r.push(E[C+m])}if(t&&A>0&&x[A-h]!=null){q=F+(x[A-h+1]-F)*(w-G)/(x[A-h]-G)}C+=y}}D=false;if(z!=r.length&&o){r[z+2]=q}}}}if(n&&z!=r.length&&z>0&&r[z]!=null&&r[z]!=r[z-y]&&r[z+1]!=r[z-y+1]){for(m=0;m<y;++m){r[z+y+m]=r[z+m]}r[z+1]=r[z-y+1]}}g.points=r}f.hooks.processDatapoints.push(e)}b.plot.plugins.push({init:c,options:a,name:\"fillbetween\",version:\"1.0\"})})(jQuery);";
      }
      public String getName() {
        return "flotFillBetween";
      }
    }
    ;
  }
  private static class flotFillBetweenInitializer {
    static {
      _instance0.flotFillBetweenInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return flotFillBetween;
    }
  }
  public com.google.gwt.resources.client.TextResource flotFillBetween() {
    return flotFillBetweenInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource flotFillBetween;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      flotFillBetween(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("flotFillBetween", flotFillBetween());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'flotFillBetween': return this.@ca.nanometrics.gflot.client.resources.FlotFillBetweenLoader.Bundle::flotFillBetween()();
    }
    return null;
  }-*/;
}