function mvpproject(){var L='',mb='" for "gwt:onLoadErrorFn"',kb='" for "gwt:onPropertyErrorFn"',X='"><\/script>',Z='#',Fb='.cache.html',_='/',Nb='<script defer="defer">mvpproject.onInjectionDone(\'mvpproject\')<\/script>',W='<script id="',hb='=',$='?',jb='Bad handler "',Mb='DOMContentLoaded',Eb="GWT module 'mvpproject' needs to be (re)compiled, please run a compile or use the Compile/Browse button in hosted mode",Y='SCRIPT',V='__gwt_marker_mvpproject',ab='base',P='begin',O='bootstrap',cb='clear.cache.gif',gb='content',U='end',yb='gecko',zb='gecko1_8',Q='gwt.codesvr=',R='gwt.hosted=',S='gwt.hybrid',Gb='gwt/standard/standard.css',lb='gwt:onLoadErrorFn',ib='gwt:onPropertyErrorFn',fb='gwt:property',Lb='head',Cb='hosted.html?mvpproject',Kb='href',xb='ie6',wb='ie8',nb='iframe',bb='img',ob="javascript:''",Hb='link',Bb='loadExternalRefs',db='meta',qb='moduleRequested',T='moduleStartup',vb='msie',M='mvpproject',eb='name',sb='opera',pb='position:absolute;width:0;height:0;border:none',Ib='rel',ub='safari',Db='selectingPermutation',N='startup',Jb='stylesheet',Ab='unknown',rb='user.agent',tb='webkit';var k=window,l=document,m=k.__gwtStatsEvent?function(a){return k.__gwtStatsEvent(a)}:null,n,o,p,q=L,r={},s=[],t=[],u=[],v,w;m&&m({moduleName:M,subSystem:N,evtGroup:O,millis:(new Date).getTime(),type:P});if(!k.__gwt_stylesLoaded){k.__gwt_stylesLoaded={}}if(!k.__gwt_scriptsLoaded){k.__gwt_scriptsLoaded={}}function x(){var b=false;try{var c=k.location.search;return (c.indexOf(Q)!=-1||(c.indexOf(R)!=-1||k.external&&k.external.gwtOnLoad))&&c.indexOf(S)==-1}catch(a){}x=function(){return b};return b}
function y(){if(n&&o){var b=l.getElementById(M);var c=b.contentWindow;if(x()){c.__gwt_getProperty=function(a){return E(a)}}mvpproject=null;c.gwtOnLoad(v,M,q);m&&m({moduleName:M,subSystem:N,evtGroup:T,millis:(new Date).getTime(),type:U})}}
function z(){var e,f=V,g;l.write(W+f+X);g=l.getElementById(f);e=g&&g.previousSibling;while(e&&e.tagName!=Y){e=e.previousSibling}function h(a){var b=a.lastIndexOf(Z);if(b==-1){b=a.length}var c=a.indexOf($);if(c==-1){c=a.length}var d=a.lastIndexOf(_,Math.min(c,b));return d>=0?a.substring(0,d+1):L}
;if(e&&e.src){q=h(e.src)}if(q==L){var i=l.getElementsByTagName(ab);if(i.length>0){q=i[i.length-1].href}else{q=h(l.location.href)}}else if(q.match(/^\w+:\/\//)){}else{var j=l.createElement(bb);j.src=q+cb;q=h(j.src)}if(g){g.parentNode.removeChild(g)}}
function A(){var b=document.getElementsByTagName(db);for(var c=0,d=b.length;c<d;++c){var e=b[c],f=e.getAttribute(eb),g;if(f){if(f==fb){g=e.getAttribute(gb);if(g){var h,i=g.indexOf(hb);if(i>=0){f=g.substring(0,i);h=g.substring(i+1)}else{f=g;h=L}r[f]=h}}else if(f==ib){g=e.getAttribute(gb);if(g){try{w=eval(g)}catch(a){alert(jb+g+kb)}}}else if(f==lb){g=e.getAttribute(gb);if(g){try{v=eval(g)}catch(a){alert(jb+g+mb)}}}}}}
function E(a){var b=t[a](),c=s[a];if(b in c){return b}var d=[];for(var e in c){d[c[e]]=e}if(w){w(a,d,b)}throw null}
var F;function G(){if(!F){F=true;var a=l.createElement(nb);a.src=ob;a.id=M;a.style.cssText=pb;a.tabIndex=-1;l.body.appendChild(a);m&&m({moduleName:M,subSystem:N,evtGroup:T,millis:(new Date).getTime(),type:qb});a.contentWindow.location.replace(q+I)}}
t[rb]=function(){var b=navigator.userAgent.toLowerCase();var c=function(a){return parseInt(a[1])*1000+parseInt(a[2])};if(b.indexOf(sb)!=-1){return sb}else if(b.indexOf(tb)!=-1){return ub}else if(b.indexOf(vb)!=-1){if(document.documentMode>=8){return wb}else{var d=/msie ([0-9]+)\.([0-9]+)/.exec(b);if(d&&d.length==3){var e=c(d);if(e>=6000){return xb}}}}else if(b.indexOf(yb)!=-1){var d=/rv:([0-9]+)\.([0-9]+)/.exec(b);if(d&&d.length==3){if(c(d)>=1008)return zb}return yb}return Ab};s[rb]={gecko:0,gecko1_8:1,ie6:2,ie8:3,opera:4,safari:5};mvpproject.onScriptLoad=function(){if(F){o=true;y()}};mvpproject.onInjectionDone=function(){n=true;m&&m({moduleName:M,subSystem:N,evtGroup:Bb,millis:(new Date).getTime(),type:U});y()};z();var H;var I;if(x()){if(k.external&&(k.external.initModule&&k.external.initModule(M))){k.location.reload();return}I=Cb;H=L}A();m&&m({moduleName:M,subSystem:N,evtGroup:O,millis:(new Date).getTime(),type:Db});if(!x()){try{alert(Eb);return;I=H+Fb}catch(a){return}}var J;function K(){if(!p){p=true;if(!__gwt_stylesLoaded[Gb]){var a=l.createElement(Hb);__gwt_stylesLoaded[Gb]=a;a.setAttribute(Ib,Jb);a.setAttribute(Kb,q+Gb);l.getElementsByTagName(Lb)[0].appendChild(a)}y();if(l.removeEventListener){l.removeEventListener(Mb,K,false)}if(J){clearInterval(J)}}}
if(l.addEventListener){l.addEventListener(Mb,function(){G();K()},false)}var J=setInterval(function(){if(/loaded|complete/.test(l.readyState)){G();K()}},50);m&&m({moduleName:M,subSystem:N,evtGroup:O,millis:(new Date).getTime(),type:U});m&&m({moduleName:M,subSystem:N,evtGroup:Bb,millis:(new Date).getTime(),type:P});l.write(Nb)}
mvpproject();