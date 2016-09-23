// JavaScript Document

//正则表达式工具
 var RegExpClass = {
        isEmail: function(e) {
            var t = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
            return !!t.test(e)
        },
        isPhone: function(e) {
            var t = /\d{11}/;
            return !!t.test(e)
        },
        isNickName: function(e) {
            if (e.length > 10 || 0 == e.length)
                return !1;
            var t = /^([\u4E00-\u9FFF]*[\w]*)+$/;
            return !!t.test(e)
        },
        isPassword: function(e) {
            return !(e.length > 18 || e.length < 6)
        }
    };

 
 
try{ document.domain = 'bohosi.com';}catch(e){}
            window.g_base = {"sitebase":"http://192.168.1.103","apibase":"http://192.168.1.103/api"}