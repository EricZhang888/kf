checkLogin(init);

var s;
if ($(".LastPayTime").length) {
    var s, c = new Date($(".LastPayTime").data("time").replace(/-/g, "/"));
    $.ajax({
        type: "GET",
        cache: !1,
        dataType: "json",
        url: window.g_base.apibase + "/commUtil/getUTC0SysTime",//'/js/time.txt', //"/cgi/order/serve_time",
        success: function(t) {
            s = (c - new Date(t.now)) / 1e3,
            e(),
            setInterval(function() {
                e()
            }, 1e3)
        }
    })
}

function e() {
    if (s--,
    s <= 0)
        return void $(".LastPayTime").text("00:00");
    var e = Math.floor(s / 60)
      , t = Math.floor(s - 60 * e);
    $(".LastPayTime").text(e + ":" + (t < 10 ? "0" + t : t))
}