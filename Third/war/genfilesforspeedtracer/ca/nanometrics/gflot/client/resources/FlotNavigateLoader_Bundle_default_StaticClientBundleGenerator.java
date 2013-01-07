package ca.nanometrics.gflot.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class FlotNavigateLoader_Bundle_default_StaticClientBundleGenerator implements ca.nanometrics.gflot.client.resources.FlotNavigateLoader.Bundle {
  private static FlotNavigateLoader_Bundle_default_StaticClientBundleGenerator _instance0 = new FlotNavigateLoader_Bundle_default_StaticClientBundleGenerator();
  private void flotNavigateInitializer() {
    flotNavigate = new com.google.gwt.resources.client.TextResource() {
      // jar:file:/home/aivalis/workspace/Third/war/WEB-INF/lib/gflot-2.4.3.jar!/ca/nanometrics/gflot/client/resources/jquery.flot-0.7.navigate-modified.min.js
      public String getText() {
        return "(function(b){var a={xaxis:{zoomRange:null,panRange:null},zoom:{interactive:false,trigger:\"dblclick\",amount:1.5},pan:{interactive:false,cursor:\"move\",frameRate:20}};function c(o){function m(q,p){var r=o.offset();r.left=q.pageX-r.left;r.top=q.pageY-r.top;if(p){o.zoomOut({center:r})}else{o.zoom({center:r})}}function d(p,q){m(p,q<0);return false}var i=\"default\",g=0,e=0,n=null;function f(p){if(p.which!=1){return false}var q=o.getPlaceholder().css(\"cursor\");if(q){i=q}o.getPlaceholder().css(\"cursor\",o.getOptions().pan.cursor);g=p.pageX;e=p.pageY}function j(q){var p=o.getOptions().pan.frameRate;if(n||!p){return}n=setTimeout(function(){o.pan({left:g-q.pageX,top:e-q.pageY});g=q.pageX;e=q.pageY;n=null},1/p*1000)}function h(p){if(n){clearTimeout(n);n=null}o.getPlaceholder().css(\"cursor\",i);o.pan({left:g-p.pageX,top:e-p.pageY})}function l(q,p){var r=q.getOptions();if(r.zoom.interactive){p[r.zoom.trigger](m);p.mousewheel(d)}if(r.pan.interactive){p.bind(\"dragstart\",{distance:10},f);p.bind(\"drag\",j);p.bind(\"dragend\",h)}}o.zoomOut=function(p){if(!p){p={}}if(!p.amount){p.amount=o.getOptions().zoom.amount}p.amount=1/p.amount;o.zoom(p)};o.zoom=function(q){if(!q){q={}}var x=q.center,r=q.amount||o.getOptions().zoom.amount,p=o.width(),t=o.height();if(!x){x={left:p/2,top:t/2}}var s=x.left/p,v=x.top/t,u={x:{min:x.left-s*p/r,max:x.left+(1-s)*p/r},y:{min:x.top-v*t/r,max:x.top+(1-v)*t/r}};b.each(o.getAxes(),function(z,C){var D=C.options,B=u[C.direction].min,w=u[C.direction].max,E=D.zoomRange;if(E===false){return}B=C.c2p(B);w=C.c2p(w);if(B>w){var A=B;B=w;w=A}var y=w-B;if(E&&((E[0]!=null&&y<E[0])||(E[1]!=null&&y>E[1]))){return}D.min=B;D.max=w});o.setupGrid();o.draw();if(!q.preventEvent){o.getPlaceholder().trigger(\"plotzoom\",[o])}};o.pan=function(p){var q={x:+p.left,y:+p.top};if(isNaN(q.x)){q.x=0}if(isNaN(q.y)){q.y=0}b.each(o.getAxes(),function(s,u){var v=u.options,t,r,w=q[u.direction];t=u.c2p(u.p2c(u.min)+w),r=u.c2p(u.p2c(u.max)+w);var x=v.panRange;if(x===false){return}if(x){if(x[0]!=null&&x[0]>t){w=x[0]-t;t+=w;r+=w}if(x[1]!=null&&x[1]<r){w=x[1]-r;t+=w;r+=w}}v.min=t;v.max=r});o.setupGrid();o.draw();if(!p.preventEvent){o.getPlaceholder().trigger(\"plotpan\",[o])}};function k(q,p){p.unbind(q.getOptions().zoom.trigger,m);p.unbind(\"mousewheel\",d);p.unbind(\"dragstart\",f);p.unbind(\"drag\",j);p.unbind(\"dragend\",h);if(n){clearTimeout(n)}}o.hooks.bindEvents.push(l);o.hooks.shutdown.push(k)}b.plot.plugins.push({init:c,options:a,name:\"navigate\",version:\"1.3\"})})(jQuery);";
      }
      public String getName() {
        return "flotNavigate";
      }
    }
    ;
  }
  private static class flotNavigateInitializer {
    static {
      _instance0.flotNavigateInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return flotNavigate;
    }
  }
  public com.google.gwt.resources.client.TextResource flotNavigate() {
    return flotNavigateInitializer.get();
  }
  private void jQueryEventDragInitializer() {
    jQueryEventDrag = new com.google.gwt.resources.client.TextResource() {
      // jar:file:/home/aivalis/workspace/Third/war/WEB-INF/lib/gflot-2.4.3.jar!/ca/nanometrics/gflot/client/resources/jquery.event.drag-2.0-modified.min.js
      public String getText() {
        return "(function(d){d.fn.drag=function(i,e,h){var g=typeof i==\"string\"?i:\"\",f=d.isFunction(i)?i:d.isFunction(e)?e:null;if(g.indexOf(\"drag\")!==0){g=\"drag\"+g}h=(i==f?e:h)||{};return f?this.bind(g,h,f):this.trigger(g)};var b=d.event,a=b.special,c=a.drag={defaults:{which:1,distance:0,not:\":input\",handle:null,relative:false,drop:true,click:false},datakey:\"dragdata\",livekey:\"livedrag\",add:function(g){var f=d.data(this,c.datakey),e=g.data||{};f.related+=1;if(!f.live&&g.selector){f.live=true;b.add(this,\"draginit.\"+c.livekey,c.delegate)}d.each(c.defaults,function(h,i){if(e[h]!==undefined){f[h]=e[h]}})},remove:function(){d.data(this,c.datakey).related-=1},setup:function(){if(d.data(this,c.datakey)){return}var e=d.extend({related:0},c.defaults);d.data(this,c.datakey,e);b.add(this,\"mousedown\",c.init,e);if(this.attachEvent){this.attachEvent(\"ondragstart\",c.dontstart)}},teardown:function(){if(d.data(this,c.datakey).related){return}d.removeData(this,c.datakey);b.remove(this,\"mousedown\",c.init);b.remove(this,\"draginit\",c.delegate);c.textselect(true);if(this.detachEvent){this.detachEvent(\"ondragstart\",c.dontstart)}},init:function(g){var e=g.data,f;if(e.which>0&&g.which!=e.which){return}if(d(g.target).is(e.not)){return}if(e.handle&&!d(g.target).closest(e.handle,g.currentTarget).length){return}e.propagates=1;e.interactions=[c.interaction(this,e)];e.target=g.target;e.pageX=g.pageX;e.pageY=g.pageY;e.dragging=null;f=c.hijack(g,\"draginit\",e);if(!e.propagates){return}f=c.flatten(f);if(f&&f.length){e.interactions=[];d.each(f,function(){e.interactions.push(c.interaction(this,e))})}e.propagates=e.interactions.length;if(e.drop!==false&&a.drop){a.drop.handler(g,e)}c.textselect(false);b.add(document,\"mousemove mouseup\",c.handler,e);return false},interaction:function(f,e){return{drag:f,callback:new c.callback(),droppable:[],offset:d(f)[e.relative?\"position\":\"offset\"]()||{top:0,left:0}}},handler:function(f){var e=f.data;switch(f.type){case !e.dragging&&\"mousemove\":if(Math.pow(f.pageX-e.pageX,2)+Math.pow(f.pageY-e.pageY,2)<Math.pow(e.distance,2)){break}f.target=e.target;c.hijack(f,\"dragstart\",e);if(e.propagates){e.dragging=true}case\"mousemove\":if(e.dragging){c.hijack(f,\"drag\",e);if(e.propagates){if(e.drop!==false&&a.drop){a.drop.handler(f,e)}break}f.type=\"mouseup\"}case\"mouseup\":b.remove(document,\"mousemove mouseup\",c.handler);if(e.dragging){if(e.drop!==false&&a.drop){a.drop.handler(f,e)}c.hijack(f,\"dragend\",e)}c.textselect(true);if(e.click===false&&e.dragging){jQuery.event.triggered=\"click\";setTimeout(function(){jQuery.event.triggered=undefined},20);e.dragging=false}break}},delegate:function(k){var e=[],l,j=d.data(this,\"events\")||{},h,g,f;for(h in j){if(h.indexOf(\"drag\")!==0){continue}f=j[h];for(g=0;g<f.length;g++){l=d(k.target).closest(f[g].selector,k.currentTarget)[0];if(!l){continue}b.add(l,f[g].origType+\".\"+c.livekey,f[g].origHandler||f[g].handler,f[g].data);if(d.inArray(l,e)<0){e.push(l)}}}if(!e.length){return false}return d(e).bind(\"dragend.\"+c.livekey,function(){b.remove(this,\".\"+c.livekey)})},hijack:function(f,m,p,n,h){if(!p){return}var o={event:f.originalEvent,type:f.type},k=m.indexOf(\"drop\")?\"drag\":\"drop\",r,j=n||0,g,e,q,l=!isNaN(n)?n:p.interactions.length;f.type=m;f.originalEvent=null;p.results=[];do{if(g=p.interactions[j]){if(m!==\"dragend\"&&g.cancelled){continue}q=c.properties(f,p,g);g.results=[];d(h||g[k]||p.droppable).each(function(s,i){q.target=i;r=i?b.handle.call(i,f,q):null;if(r===false){if(k==\"drag\"){g.cancelled=true;p.propagates-=1}if(m==\"drop\"){g[k][s]=null}}else{if(m==\"dropinit\"){g.droppable.push(c.element(r)||i)}}if(m==\"dragstart\"){g.proxy=d(c.element(r)||g.drag)[0]}g.results.push(r);delete f.result;if(m!==\"dropinit\"){return r}});p.results[j]=c.flatten(g.results);if(m==\"dropinit\"){g.droppable=c.flatten(g.droppable)}if(m==\"dragstart\"&&!g.cancelled){q.update()}}}while(++j<l);f.type=o.type;f.originalEvent=o.event;return c.flatten(p.results)},properties:function(g,e,f){var h=f.callback;h.drag=f.drag;h.proxy=f.proxy||f.drag;h.startX=e.pageX;h.startY=e.pageY;h.deltaX=g.pageX-e.pageX;h.deltaY=g.pageY-e.pageY;h.originalX=f.offset.left;h.originalY=f.offset.top;h.offsetX=g.pageX-(e.pageX-h.originalX);h.offsetY=g.pageY-(e.pageY-h.originalY);h.drop=c.flatten((f.drop||[]).slice());h.available=c.flatten((f.droppable||[]).slice());return h},element:function(e){if(e&&(e.jquery||e.nodeType==1)){return e}},flatten:function(e){return d.map(e,function(f){return f&&f.jquery?d.makeArray(f):f&&f.length?c.flatten(f):f})},textselect:function(e){d(document)[e?\"unbind\":\"bind\"](\"selectstart\",c.dontstart).attr(\"unselectable\",e?\"off\":\"on\").css(\"MozUserSelect\",e?\"\":\"none\")},dontstart:function(){return false},callback:function(){}};c.callback.prototype={update:function(){if(a.drop&&this.available.length){d.each(this.available,function(e){a.drop.locate(this,e)})}}};a.draginit=a.dragstart=a.dragend=c})(jQuery);";
      }
      public String getName() {
        return "jQueryEventDrag";
      }
    }
    ;
  }
  private static class jQueryEventDragInitializer {
    static {
      _instance0.jQueryEventDragInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return jQueryEventDrag;
    }
  }
  public com.google.gwt.resources.client.TextResource jQueryEventDrag() {
    return jQueryEventDragInitializer.get();
  }
  private void jQueryMouseWheelInitializer() {
    jQueryMouseWheel = new com.google.gwt.resources.client.TextResource() {
      // jar:file:/home/aivalis/workspace/Third/war/WEB-INF/lib/gflot-2.4.3.jar!/ca/nanometrics/gflot/client/resources/jquery.mousewheel-3.0.6.min.js
      public String getText() {
        return "(function(a){function d(b){var c=b||window.event,d=[].slice.call(arguments,1),e=0,f=!0,g=0,h=0;return b=a.event.fix(c),b.type=\"mousewheel\",c.wheelDelta&&(e=c.wheelDelta/120),c.detail&&(e=-c.detail/3),h=e,c.axis!==undefined&&c.axis===c.HORIZONTAL_AXIS&&(h=0,g=-1*e),c.wheelDeltaY!==undefined&&(h=c.wheelDeltaY/120),c.wheelDeltaX!==undefined&&(g=-1*c.wheelDeltaX/120),d.unshift(b,e,g,h),(a.event.dispatch||a.event.handle).apply(this,d)}var b=[\"DOMMouseScroll\",\"mousewheel\"];if(a.event.fixHooks)for(var c=b.length;c;)a.event.fixHooks[b[--c]]=a.event.mouseHooks;a.event.special.mousewheel={setup:function(){if(this.addEventListener)for(var a=b.length;a;)this.addEventListener(b[--a],d,!1);else this.onmousewheel=d},teardown:function(){if(this.removeEventListener)for(var a=b.length;a;)this.removeEventListener(b[--a],d,!1);else this.onmousewheel=null}},a.fn.extend({mousewheel:function(a){return a?this.bind(\"mousewheel\",a):this.trigger(\"mousewheel\")},unmousewheel:function(a){return this.unbind(\"mousewheel\",a)}})})(jQuery)\n";
      }
      public String getName() {
        return "jQueryMouseWheel";
      }
    }
    ;
  }
  private static class jQueryMouseWheelInitializer {
    static {
      _instance0.jQueryMouseWheelInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return jQueryMouseWheel;
    }
  }
  public com.google.gwt.resources.client.TextResource jQueryMouseWheel() {
    return jQueryMouseWheelInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource flotNavigate;
  private static com.google.gwt.resources.client.TextResource jQueryEventDrag;
  private static com.google.gwt.resources.client.TextResource jQueryMouseWheel;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      flotNavigate(), 
      jQueryEventDrag(), 
      jQueryMouseWheel(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("flotNavigate", flotNavigate());
        resourceMap.put("jQueryEventDrag", jQueryEventDrag());
        resourceMap.put("jQueryMouseWheel", jQueryMouseWheel());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'flotNavigate': return this.@ca.nanometrics.gflot.client.resources.FlotNavigateLoader.Bundle::flotNavigate()();
      case 'jQueryEventDrag': return this.@ca.nanometrics.gflot.client.resources.FlotNavigateLoader.Bundle::jQueryEventDrag()();
      case 'jQueryMouseWheel': return this.@ca.nanometrics.gflot.client.resources.FlotNavigateLoader.Bundle::jQueryMouseWheel()();
    }
    return null;
  }-*/;
}
