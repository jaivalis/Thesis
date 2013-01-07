package ca.nanometrics.gflot.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class FlotImageLoader_Bundle_default_StaticClientBundleGenerator implements ca.nanometrics.gflot.client.resources.FlotImageLoader.Bundle {
  private static FlotImageLoader_Bundle_default_StaticClientBundleGenerator _instance0 = new FlotImageLoader_Bundle_default_StaticClientBundleGenerator();
  private void flotImageInitializer() {
    flotImage = new com.google.gwt.resources.client.TextResource() {
      // jar:file:/home/aivalis/workspace/Third/war/WEB-INF/lib/gflot-2.4.3.jar!/ca/nanometrics/gflot/client/resources/jquery.flot-0.7.image-modified.min.js
      public String getText() {
        return "(function(c){var a={series:{images:{show:false,alpha:1,anchor:\"corner\"}}};c.plot.image={};c.plot.image.loadDataImages=function(g,f,k){var j=[],h=[];var i=null!=f&&null!=f.series&&null!=f.series.images&&f.series.images.show;c.each(g,function(l,m){if((i&&(m.images!=null&&m.images.show!=null&&!m.images.show))||(!i&&(m.images==null||m.images.show==null||!m.images.show))){return}if(m.data){m=m.data}c.each(m,function(n,o){if(typeof o[0]==\"string\"){j.push(o[0]);h.push(o)}})});c.plot.image.load(j,function(l){c.each(h,function(n,o){var m=o[0];if(l[m]){o[0]=l[m]}});k()})};c.plot.image.load=function(h,i){var g=h.length,f={};if(g==0){i({})}c.each(h,function(k,j){var l=function(){--g;f[j]=this;if(g==0){i(f)}};c(\"<img />\").load(l).error(l).attr(\"src\",j)})};function d(q,o,l){var m=q.getPlotOffset();if(!l.images.show){return}var r=l.datapoints.points,n=l.datapoints.pointsize;for(var t=0;t<r.length;t+=n){var y=r[t],w=r[t+1],g=r[t+2],v=r[t+3],f=r[t+4],h=l.xaxis,u=l.yaxis,x;if(!y||y.width<=0||y.height<=0){continue}if(w>v){x=v;v=w;w=x}if(g>f){x=f;f=g;g=x}if(l.images.anchor==\"center\"){x=0.5*(v-w)/(y.width-1);w-=x;v+=x;x=0.5*(f-g)/(y.height-1);g-=x;f+=x}if(w==v||g==f||w>=h.max||v<=h.min||g>=u.max||f<=u.min){continue}var k=0,s=0,j=y.width,p=y.height;if(w<h.min){k+=(j-k)*(h.min-w)/(v-w);w=h.min}if(v>h.max){j+=(j-k)*(h.max-v)/(v-w);v=h.max}if(g<u.min){p+=(s-p)*(u.min-g)/(f-g);g=u.min}if(f>u.max){s+=(s-p)*(u.max-f)/(f-g);f=u.max}w=h.p2c(w);v=h.p2c(v);g=u.p2c(g);f=u.p2c(f);if(w>v){x=v;v=w;w=x}if(g>f){x=f;f=g;g=x}x=o.globalAlpha;o.globalAlpha*=l.images.alpha;o.drawImage(y,k,s,j-k,p-s,w+m.left,g+m.top,v-w,f-g);o.globalAlpha=x}}function b(i,f,g,h){if(!f.images.show){return}h.format=[{required:true},{x:true,number:true,required:true},{y:true,number:true,required:true},{x:true,number:true,required:true},{y:true,number:true,required:true}]}function e(f){f.hooks.processRawData.push(b);f.hooks.drawSeries.push(d)}c.plot.plugins.push({init:e,options:a,name:\"image\",version:\"1.1\"})})(jQuery);";
      }
      public String getName() {
        return "flotImage";
      }
    }
    ;
  }
  private static class flotImageInitializer {
    static {
      _instance0.flotImageInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return flotImage;
    }
  }
  public com.google.gwt.resources.client.TextResource flotImage() {
    return flotImageInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource flotImage;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      flotImage(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("flotImage", flotImage());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'flotImage': return this.@ca.nanometrics.gflot.client.resources.FlotImageLoader.Bundle::flotImage()();
    }
    return null;
  }-*/;
}
