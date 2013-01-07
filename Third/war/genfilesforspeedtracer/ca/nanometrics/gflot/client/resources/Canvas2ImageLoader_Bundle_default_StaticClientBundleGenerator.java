package ca.nanometrics.gflot.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class Canvas2ImageLoader_Bundle_default_StaticClientBundleGenerator implements ca.nanometrics.gflot.client.resources.Canvas2ImageLoader.Bundle {
  private static Canvas2ImageLoader_Bundle_default_StaticClientBundleGenerator _instance0 = new Canvas2ImageLoader_Bundle_default_StaticClientBundleGenerator();
  private void base64Initializer() {
    base64 = new com.google.gwt.resources.client.TextResource() {
      // jar:file:/home/aivalis/workspace/Third/war/WEB-INF/lib/gflot-2.4.3.jar!/ca/nanometrics/gflot/client/resources/base64.min.js
      public String getText() {
        return "(function(){var a=\"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/\";var d=new Array(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,62,-1,-1,-1,63,52,53,54,55,56,57,58,59,60,61,-1,-1,-1,-1,-1,-1,-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,-1,-1,-1,-1,-1,-1,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,-1,-1,-1,-1,-1);function b(l){var g,j,e;var k,h,f;e=l.length;j=0;g=\"\";while(j<e){k=l.charCodeAt(j++)&255;if(j==e){g+=a.charAt(k>>2);g+=a.charAt((k&3)<<4);g+=\"==\";break}h=l.charCodeAt(j++);if(j==e){g+=a.charAt(k>>2);g+=a.charAt(((k&3)<<4)|((h&240)>>4));g+=a.charAt((h&15)<<2);g+=\"=\";break}f=l.charCodeAt(j++);g+=a.charAt(k>>2);g+=a.charAt(((k&3)<<4)|((h&240)>>4));g+=a.charAt(((h&15)<<2)|((f&192)>>6));g+=a.charAt(f&63)}return g}function c(m){var l,k,h,f;var j,e,g;e=m.length;j=0;g=\"\";while(j<e){do{l=d[m.charCodeAt(j++)&255]}while(j<e&&l==-1);if(l==-1){break}do{k=d[m.charCodeAt(j++)&255]}while(j<e&&k==-1);if(k==-1){break}g+=String.fromCharCode((l<<2)|((k&48)>>4));do{h=m.charCodeAt(j++)&255;if(h==61){return g}h=d[h]}while(j<e&&h==-1);if(h==-1){break}g+=String.fromCharCode(((k&15)<<4)|((h&60)>>2));do{f=m.charCodeAt(j++)&255;if(f==61){return g}f=d[f]}while(j<e&&f==-1);if(f==-1){break}g+=String.fromCharCode(((h&3)<<6)|f)}return g}if(!window.btoa){window.btoa=b}if(!window.atob){window.atob=c}})();";
      }
      public String getName() {
        return "base64";
      }
    }
    ;
  }
  private static class base64Initializer {
    static {
      _instance0.base64Initializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return base64;
    }
  }
  public com.google.gwt.resources.client.TextResource base64() {
    return base64Initializer.get();
  }
  private void canvasToImageInitializer() {
    canvasToImage = new com.google.gwt.resources.client.TextResource() {
      // jar:file:/home/aivalis/workspace/Third/war/WEB-INF/lib/gflot-2.4.3.jar!/ca/nanometrics/gflot/client/resources/canvas2image.min.js
      public String getText() {
        return "var Canvas2Image=(function(){var k=false;var h=document.createElement(\"canvas\");if(h.getContext(\"2d\")){k=true}if(!k){return{saveAsBMP:function(){},saveAsPNG:function(){},saveAsJPEG:function(){}}}var c=!!(h.getContext(\"2d\").getImageData);var d=!!(h.toDataURL);var a=!!(window.btoa);var e=\"image/octet-stream\";var m=function(n){var o=parseInt(n.width);var p=parseInt(n.height);return n.getContext(\"2d\").getImageData(0,0,o,p)};var f=function(p){var q=\"\";if(typeof p==\"string\"){q=p}else{var n=p;for(var o=0;o<n.length;o++){q+=String.fromCharCode(n[o])}}return btoa(q)};var j=function(B){var s=[];var E=B.width;var p=B.height;s.push(66);s.push(77);var z=E*p*3+54;s.push(z%256);z=Math.floor(z/256);s.push(z%256);z=Math.floor(z/256);s.push(z%256);z=Math.floor(z/256);s.push(z%256);s.push(0);s.push(0);s.push(0);s.push(0);s.push(54);s.push(0);s.push(0);s.push(0);var u=[];u.push(40);u.push(0);u.push(0);u.push(0);var w=E;u.push(w%256);w=Math.floor(w/256);u.push(w%256);w=Math.floor(w/256);u.push(w%256);w=Math.floor(w/256);u.push(w%256);var n=p;u.push(n%256);n=Math.floor(n/256);u.push(n%256);n=Math.floor(n/256);u.push(n%256);n=Math.floor(n/256);u.push(n%256);u.push(1);u.push(0);u.push(24);u.push(0);u.push(0);u.push(0);u.push(0);u.push(0);var o=E*p*3;u.push(o%256);o=Math.floor(o/256);u.push(o%256);o=Math.floor(o/256);u.push(o%256);o=Math.floor(o/256);u.push(o%256);for(var D=0;D<16;D++){u.push(0)}var A=(4-((E*3)%4))%4;var H=B.data;var q=\"\";var r=p;do{var F=E*(r-1)*4;var C=\"\";for(var t=0;t<E;t++){var G=4*t;C+=String.fromCharCode(H[F+G+2]);C+=String.fromCharCode(H[F+G+1]);C+=String.fromCharCode(H[F+G])}for(var I=0;I<A;I++){C+=String.fromCharCode(0)}q+=C}while(--r);var v=f(s.concat(u))+f(q);return v};var b=function(n){document.location.href=n};var i=function(o,n){return\"data:\"+n+\";base64,\"+o};var l=function(n){var o=document.createElement(\"img\");o.src=n;return o};var g=function(o,p,r){if(p&&r){var q=document.createElement(\"canvas\");q.width=p;q.height=r;q.style.width=p+\"px\";q.style.height=r+\"px\";var n=q.getContext(\"2d\");n.drawImage(o,0,0,o.width,o.height,0,0,p,r);return q}return o};return{saveAsPNG:function(o,n,p,s){if(!d){return false}var q=g(o,p,s);var r=q.toDataURL(\"image/png\");if(n){return l(r)}else{b(r.replace(\"image/png\",e))}return true},saveAsJPEG:function(o,n,p,t){if(!d){return false}var q=g(o,p,t);var s=\"image/jpeg\";var r=q.toDataURL(s);if(r.indexOf(s)!=5){return false}if(n){return l(r)}else{b(r.replace(s,e))}return true},saveAsBMP:function(p,o,q,s){if(!(c&&a)){return false}var r=g(p,q,s);var t=m(r);var n=j(t);if(o){return l(i(n,\"image/bmp\"))}else{b(i(n,e))}return true}}})();";
      }
      public String getName() {
        return "canvasToImage";
      }
    }
    ;
  }
  private static class canvasToImageInitializer {
    static {
      _instance0.canvasToImageInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return canvasToImage;
    }
  }
  public com.google.gwt.resources.client.TextResource canvasToImage() {
    return canvasToImageInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource base64;
  private static com.google.gwt.resources.client.TextResource canvasToImage;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      base64(), 
      canvasToImage(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("base64", base64());
        resourceMap.put("canvasToImage", canvasToImage());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'base64': return this.@ca.nanometrics.gflot.client.resources.Canvas2ImageLoader.Bundle::base64()();
      case 'canvasToImage': return this.@ca.nanometrics.gflot.client.resources.Canvas2ImageLoader.Bundle::canvasToImage()();
    }
    return null;
  }-*/;
}
